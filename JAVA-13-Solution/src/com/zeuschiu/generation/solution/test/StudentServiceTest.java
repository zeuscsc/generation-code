package com.zeuschiu.generation.solution.test;

import com.zeuschiu.generation.solution.model.Student;
import com.zeuschiu.generation.solution.service.CourseService;
import com.zeuschiu.generation.solution.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentServiceTest {
    public StudentService studentService;
    public CourseService courseService;

    @Before
    public void setup(){
        studentService=new StudentService();
        courseService=new CourseService();
    }

    @Test
    public void subscribeStudent() throws ParseException {
        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date data=formatter.parse("19881/1/1");
        Student student=new Student("1","Zeus","zeus@tecky.io",data);
        studentService.subscribeStudent(student);
        Assert.assertEquals(studentService.findStudent("1"),student);
    }
    @Test
    public void isSubscribed() throws ParseException {
        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date data=formatter.parse("19881/1/1");
        Student student=new Student("1","Zeus","zeus@tecky.io",data);
        studentService.subscribeStudent(student);
        Assert.assertTrue(studentService.isSubscribed("1"));
    }
    @Test
    public void enrollToCourse() throws ParseException {
        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date data=formatter.parse("19881/1/1");
        Student student=new Student("1","Zeus","zeus@tecky.io",data);
        studentService.subscribeStudent(student);
        studentService.enrollToCourse("1",
                courseService.getCourse("INTRO-CS-1"));
        courseService.enrollStudent("INTRO-CS-1",student);
        Assert.assertEquals(studentService.findStudent("1"),
                courseService.getEnrolledStudents("INTRO-CS-1").get(0));
    }
}
