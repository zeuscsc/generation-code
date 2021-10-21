package com.zeuschiu.collections.oop.ex3;

import java.util.Collections;
import java.util.HashSet;

public class SchoolSystem {
    public static class Student{
        String firstName;
        String lastName;
        int registration;
        int grade;
        int year;
        public void printFullName(){
            System.out.println(firstName+" "+lastName);
        }

        public boolean isApproved(){
            return grade>=60;
//            if(grade>=60)
//                return true;
//            else
//                return false;
        }

        public int changeYearIfApproved(){
            if(isApproved()){
                year++;
                System.out.println("Congratulations");
            }
            return year;
        }
        @Override
        public String toString(){
            return firstName+" "+lastName;
        }
    }
    public static class Students extends HashSet<Student> {
        @Override
        public String toString(){
            String output="";
            for(Student s:this){
                output=output.concat(s.toString()+"|");
            }
            return output;
        }
    }
    public static class Course{
        public String courseName;
        public String professorName;
        public Students students=new Students();
//        public ArrayList<Student> students=new ArrayList<Student>();
        public void enroll(Student student){
            students.add(student);
        }
        public void enroll(Student[] students){
//            for(Student s:students)this.students.add(s);
            Collections.addAll(this.students, students);
        }

        public void unEnroll(Student student){
            students.remove(student);
        }

        public int countStudents(){
            return students.size();
        }

        public int bestGrade(){
            int max=Integer.MIN_VALUE;//[-1,-2,-3]
            for(Student s:students){
                if(s.grade>max)
                    max=s.grade;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Course course=new Course();
        course.courseName="Java Programming";
        course.professorName="Zeus Chiu";
        Student terence=new Student();
        terence.firstName="Terence";
        terence.lastName="Terence";
        terence.grade=(int)(Math.random()*100.0);
        Student ken=new Student();
        ken.firstName="Ken";
        ken.lastName="Ken";
        ken.grade=(int)(Math.random()*100.0);
        Student kumud=new Student();
        kumud.firstName="Kumud";
        kumud.lastName="Kumud";
        kumud.grade=(int)(Math.random()*100.0);
        Student[] students={terence,ken,kumud};
        course.enroll(students);
        System.out.println(course.students);
    }
}
