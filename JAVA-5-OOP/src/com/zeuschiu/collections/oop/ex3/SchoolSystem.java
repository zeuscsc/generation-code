package com.zeuschiu.collections.oop.ex3;

import java.util.*;

public class SchoolSystem {
    public static class Student{
        String firstName;
        String lastName;
        int registration;
        int grade;
        int year;
        public void printFullName(){
            System.out.println(firstName+" "+lastName+" ");
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
            return firstName+" "+lastName+" "+grade;
        }
    }
    public static class Students extends HashSet<Student> {
        public static class SortByGrade implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                return o2.grade-o1.grade;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
            public static class QuickSort{
                public static void sort(ArrayList<Student> students){
                    sort(students,0,students.size()-1);
                }
                public static void sort(ArrayList<Student> students,int low, int high){
                    if(low<high){
                        int pivot= partition(students,low,high);
                        sort(students,low,pivot-1);
                        sort(students,pivot+1,high);
                    }
                }
                public static int partition(ArrayList<Student> students, int low, int high){
                    int pivot=students.get(high).grade;
                    int i=low-1;
                    for(int j=low;j<=high;j++){
                        if(students.get(j).grade>pivot){
                            i++;
                            swap(students,i,j);
                        }
                    }
                    swap(students,i+1,high);
                    return i+1;
                }
                public static void swap(ArrayList<Student> students, int i,int j){
                    Student temp=students.get(i);
                    students.set(i,students.get(j));
                    students.set(j,temp);
                }

            }
        }
        @Override
        public String toString(){
            String output="";
            for(Student s:this){
                output=output.concat(s.toString()+"|");
            }
            return output;
        }
        public ArrayList<Student> toArrayList(){
            ArrayList<Student> students=new ArrayList<Student>();
            for(Student s:this){
                students.add(s);
            }
            return students;
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

        public double averageGrade(){
            int total=0;
            for (Student s:students){
                total+=s.grade;
            }
            return (double)total/(double) students.size();
        }
        public ArrayList<Student> getRank(){
            ArrayList<Student> students=this.students.toArrayList();//O(n)
//            Collections.sort(students,new Students.SortByGrade());//Trim Sort O(n*log(n))
            Students.SortByGrade.QuickSort.sort(students);//Quick Sort O(n*log(n))
            return students;
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
        System.out.println(course.averageGrade());
        System.out.println(course.getRank());
    }
}
