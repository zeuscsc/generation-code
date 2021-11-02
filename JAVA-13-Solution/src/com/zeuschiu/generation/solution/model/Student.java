package com.zeuschiu.generation.solution.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    private final Map<Course, Double> coursesGrade=new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        courses.add(course);
        registerApprovedCourse(course);
    }

    public void setGrade(String courseID,Double grade){
        Course course=approvedCourses.get(courseID);
        if(course!=null)
            coursesGrade.put(course,grade);
        else
            throw new RuntimeException("Course not enrolled");
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        return approvedCourses.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method
        return null;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        List<Course> courses=new ArrayList<>();
        for(Course course : approvedCourses.values()){
            courses.add(course);
        }
        return courses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
