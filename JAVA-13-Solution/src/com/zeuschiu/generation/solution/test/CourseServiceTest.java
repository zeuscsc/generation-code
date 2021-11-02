package com.zeuschiu.generation.solution.test;

import com.zeuschiu.generation.solution.model.Course;
import com.zeuschiu.generation.solution.model.Module;
import com.zeuschiu.generation.solution.model.Student;
import com.zeuschiu.generation.solution.service.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseServiceTest {
    CourseService courseService=new CourseService();

    @Before
    public void setup(){

    }

    @Test
    public void testIfACourseIsThere(){
        Assert.assertNotNull(courseService.getCourse("INTRO-CS-1"));
    }

    @Test
    public void ifYouCanRegisterACourseAndTheCourseIsReallyThere(){
        Module module = new Module( "ELVISH", "Introduction to ELVISH",
                "Introductory module for the writing lord of the ring elvish" );
        Course course=new Course( "ELVISH-1", "Introduction to ELVISH", 9, module ) ;
        courseService.registerCourse(course);
        Assert.assertEquals(courseService.getCourse("ELVISH-1"), course);
    }

    @Test
    public void enrollStudentAndSeeIfStudentIsAdded() throws ParseException {
        DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
        Date data=formatter.parse("19881/1/1");
        Student student=new Student("1","Zeus","zeus@tecky.io",data);
        courseService.enrollStudent("INTRO-CS-1",student);
        Assert.assertEquals(courseService.getEnrolledStudents("INTRO-CS-1").get(0),
                student);
    }
}
