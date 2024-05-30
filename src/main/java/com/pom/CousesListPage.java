package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

import java.util.ArrayList;
import java.util.List;

public class CousesListPage extends TestBase {

    public static class Course {
        private String courseId;
        private String courseName;

        public Course(String courseId, String courseName) {
            this.courseId = courseId;
            this.courseName = courseName;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "courseId='" + courseId + '\'' +
                    ", courseName='" + courseName + '\'' +
                    '}';
        }
    }

    public static class CourseManager {
        private List<Course> courses;

        public CourseManager() {
            courses = new ArrayList<>();
        }

        public void addCourse(Course course) {
            courses.add(course);
            System.out.println("Course added: " + course);
        }

        public void removeCourse(String courseId) {
            courses.removeIf(course -> course.getCourseId().equals(courseId));
            System.out.println("Course removed: " + courseId);
        }

        public void listCourses() {
            if (courses.isEmpty()) {
                System.out.println("No courses available.");
            } else {
                for (Course course : courses) {
                    System.out.println(course);
                }
            }
        }
    }

    // Example elements using @FindBy, assuming you have some web elements
    @FindBy(id = "courseIdInput")
    private WebElement courseIdInput;

    @FindBy(id = "courseNameInput")
    private WebElement courseNameInput;

    @FindBy(id = "addCourseButton")
    private WebElement addCourseButton;

    public CousesListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Example method to add a course through the UI
    public void addCourse(String courseId, String courseName) {
        courseIdInput.sendKeys(courseId);
        courseNameInput.sendKeys(courseName);
        addCourseButton.click();
    }
}
