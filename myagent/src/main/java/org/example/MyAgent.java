package org.example;

import java.lang.instrument.*;
import java.security.ProtectionDomain;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * d:\java\bin\java -javaagent:myagent-1.0-SNAPSHOT.jar
 * -cp .;d:\***\asm-7.3.1.jar;d:\asm-tree-7.3.1.jar HelloWorld
 */
public class MyAgent {

    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("premain");
        instrumentation.addTransformer(new MyTransformer());
    }

/*    static class MyTransformer implements ClassFileTransformer{
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.printf("Loaded %s: 0x%X%X%X%X\n", className,
                    classfileBuffer[0], classfileBuffer[1], classfileBuffer[2], classfileBuffer[3]);
            return null;
        }
    }*/
/*    static class MyTransformer implements ClassFileTransformer{
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassReader cr = new ClassReader(classfileBuffer);
        ClassNode classNode = new ClassNode(ASM7);
        cr.accept(classNode,
                ClassReader.SKIP_FRAMES);
        for (MethodNode methodNode:classNode.methods){
            if("main".equals(methodNode.name)){
                InsnList instrumentation = new InsnList();
                instrumentation.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
                instrumentation.add(new LdcInsnNode("Hello, Instrumentation!"));
                instrumentation .add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
            }
        }

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
        classNode.accept(cw);

        return cw.toByteArray();
    }
}*/
    //d:\java\bin\java -javaagent:myagent-1.0-SNAPSHOT.jar -cp .;d:\***\asm-7.3.1.jar;d:\asm-tree-7.3.1.jar HelloWorld
    static class MyTransformer implements ClassFileTransformer{
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        if(className.startsWith("java") ||
            className.startsWith("javax") ||
            className.startsWith("jdk") ||
            className.startsWith("sun") ||
            className.startsWith("com/sun") ||
            className.startsWith("org/example")){
            System.out.println("skip----------");
            return null;
        }

        ClassReader cr = new ClassReader(classfileBuffer);
        ClassNode classNode = new ClassNode(ASM7);
        cr.accept(classNode,ClassReader.SKIP_FRAMES);

        for (MethodNode methodNode:classNode.methods){
            for (AbstractInsnNode node:methodNode.instructions.toArray()){
                if(node.getOpcode() == NEW){
                    TypeInsnNode typeInsnNode = (TypeInsnNode)node;
                    InsnList instrumentation = new InsnList();
                    instrumentation.add(new LdcInsnNode(Type.getObjectType(typeInsnNode.desc)));
                    instrumentation.add(new MethodInsnNode(INVOKESTATIC, "org/example/MyProfiler", "fireAllocationEvent", "(Ljava/lang/Class;)V", false));
                    methodNode.instructions.insert(node, instrumentation);
                }
            }
        }
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
        classNode.accept(cw);
        return cw.toByteArray();
    }
}

}
