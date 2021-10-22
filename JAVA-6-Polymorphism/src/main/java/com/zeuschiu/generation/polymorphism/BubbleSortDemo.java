package com.zeuschiu.generation.polymorphism;

import java.util.ArrayList;

class Bubble{
    interface Compare<T> {
        boolean isSmaller(T a,T b);
    }
    public static <T> void swap(ArrayList<T> list,int i,int j){
        T temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    public static <T> void sort(ArrayList<T> list,Compare compare){
        int n=list.size();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(compare.isSmaller(list.get(i),list.get(j))){
                    swap(list,i,j);
                }
            }
        }
    }
}

class Student{
    int grade;
    public Student(int grade){
        this.grade=grade;
    }
}
class StudentCompare implements Bubble.Compare<Student>{
    @Override
    public boolean isSmaller(Student a, Student b) {
        return a.grade<b.grade;
    }
}

public class BubbleSortDemo {
    public static void main(String[] args){
        ArrayList<Student> students =new ArrayList<>();
        students.add(new Student(1));
        students.add(new Student(2));
        students.add(new Student(3));
        students.add(new Student(4));
        students.add(new Student(5));
        Bubble.sort(students,new StudentCompare());

    }
}
