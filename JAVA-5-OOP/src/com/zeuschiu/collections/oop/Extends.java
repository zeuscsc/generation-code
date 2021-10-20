package com.zeuschiu.collections.oop;

import java.util.ArrayList;

class Student{
    public int i;
    public boolean b;
    public char c;
    public Integer id;

    @Override
    public boolean equals(Object student){
        return true;
    }
}
class Students extends ArrayList<Student>{
    private static Integer latestId=0;

    @Override
    public boolean add(Student student){
        latestId++;
        student.id=latestId;
//        return true;
        return super.add(student);
    }
}
class ExcellentStudents extends Students{
    public Integer rank;
}
public class Extends {
    public static void main(String[] args) {
        Student ken=new Student();
        Student terence=new Student();
        Student mahabir=new Student();
        Students students=new Students();
        boolean b1=ken.equals(terence);
        students.add(ken);
        students.add(terence);
        students.add(mahabir);
        students.remove(0);
        students.clone();
        ExcellentStudents excellentStudents=new ExcellentStudents();
        excellentStudents.remove(0);
    }
}
