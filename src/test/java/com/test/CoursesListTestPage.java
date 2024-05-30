package com.test;

import com.Base.TestBase;
import com.pom.CousesListPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class CoursesListTestPage extends TestBase {

    private CousesListPage.CourseManager courseManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setup method from TestBase
        courseManager = new CousesListPage.CourseManager();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddCourse() {
        CousesListPage.Course course = new CousesListPage.Course("CS101", "Intro to Computer Science");
        courseManager.addCourse(course);

        List<CousesListPage.Course> courses = getCourses();
        Assert.assertEquals(courses.size(), 1);
        Assert.assertEquals(courses.get(0).getCourseId(), "CS101");
        Assert.assertEquals(courses.get(0).getCourseName(), "Intro to Computer Science");
        Assert.assertTrue(outContent.toString().contains("Course added: Course{courseId='CS101', courseName='Intro to Computer Science'}"));
    }

    @Test
    public void testRemoveCourse() {
        CousesListPage.Course course1 = new CousesListPage.Course("CS101", "Intro to Computer Science");
        CousesListPage.Course course2 = new CousesListPage.Course("CS102", "Data Structures");

        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        courseManager.removeCourse("CS101");

        List<CousesListPage.Course> courses = getCourses();
        Assert.assertEquals(courses.size(), 1);
        Assert.assertEquals(courses.get(0).getCourseId(), "CS102");
        Assert.assertEquals(courses.get(0).getCourseName(), "Data Structures");
        Assert.assertTrue(outContent.toString().contains("Course removed: CS101"));
    }

    @Test
    public void testListCourses() {
        CousesListPage.Course course1 = new CousesListPage.Course("CS101", "Intro to Computer Science");
        CousesListPage.Course course2 = new CousesListPage.Course("CS102", "Data Structures");

        courseManager.addCourse(course1);
        courseManager.addCourse(course2);

        outContent.reset();
        courseManager.listCourses();
        String expectedOutput = "Course{courseId='CS101', courseName='Intro to Computer Science'}" + System.lineSeparator() +
                                "Course{courseId='CS102', courseName='Data Structures'}" + System.lineSeparator();
        Assert.assertEquals(outContent.toString(), expectedOutput);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown(); // Call the teardown method from TestBase
        System.setOut(originalOut);
    }

    // Helper method to access the private courses list via reflection
    @SuppressWarnings("unchecked")
    private List<CousesListPage.Course> getCourses() {
        try {
            java.lang.reflect.Field field = courseManager.getClass().getDeclaredField("courses");
            field.setAccessible(true);
            return (List<CousesListPage.Course>) field.get(courseManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
