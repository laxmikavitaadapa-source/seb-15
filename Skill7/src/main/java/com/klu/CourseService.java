package com.klu;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course updateCourse(int id, Course updated) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updated.getTitle());
                c.setDuration(updated.getDuration());
                c.setFee(updated.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        return courseList.stream()
                .filter(c -> c.getTitle().equalsIgnoreCase(title))
                .toList();
    }
}