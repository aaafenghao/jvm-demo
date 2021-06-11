package com.again.visitor;

/**
 * 校长
 */
public class Principal implements Vistior{

    @Override
    public void visit(Teacher teacher) {
        System.out.printf("老师信息 姓名 %s 班级 %s 升学率 %s",teacher.name,teacher.clazz,teacher.entranceRaio());


    }

    @Override
    public void visit(Student student) {
        System.out.printf("学生信息 姓名 %s 班级 %s ",student.name,student.clazz);
    }
}
