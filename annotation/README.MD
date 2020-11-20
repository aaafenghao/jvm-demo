编译过程
    源文件解析成抽象语法树
    调用已注册的注解处理器
    生成字节码
package foo; // PackageElementclass
Foo { // TypeElement
int a; // VariableElement
static int b; // VariableElement
Foo () {} // ExecutableElement
void setA ( // ExecutableElement
int newA // VariableElement ) {}}

process方法参数:
    注解处理器所能处理的注解类型
    当前轮生成的抽象语法树


注解处理器:
    可以对现有的源码做验证
    可以修改现有的源码
    可以生成新的源码文件
