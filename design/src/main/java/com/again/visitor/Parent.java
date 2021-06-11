package com.again.visitor;

/**
 * 家长
 */
public class Parent implements Vistior{

    @Override
    public void visit(Teacher teacher) {
        System.out.printf("老师信息 姓名 %s 班级 %s 级别 %s",teacher.name,teacher.clazz,teacher.identity);
    }

    @Override
    public void visit(Student student) {
        System.out.printf("学生信息 姓名 %s 班级 %s 排名 %s ",student.name,student.clazz,student.ranking());
    }
}
