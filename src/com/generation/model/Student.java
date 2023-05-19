package com.generation.model;

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

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        // new code
        if (isAttendingCourse(course.getCode()) == false) {
            courses.add(course);
            System.out.println("Student with ID: " + this.getId() + " enrolled successfully to " + course.getCode());
        } else {
            System.out.println("Double-enrollment attempt");
        }
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }


    public boolean isAttendingCourse( String courseCode )
    {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                System.out.println("Student already enrolled in course!");
                return true;
            }
        }
        return false;
    }


    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
