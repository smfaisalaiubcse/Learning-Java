package StreamExample;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamClassTask {
    public static void main(String[] args) {
        // Task 1: Generate a stream of 10 random numbers and print only the odd numbers
        new Random().ints(10, 1, 100)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        // a. Print all courses individually
        System.out.println("\nAll Courses:");
        courses.forEach(System.out::println);

        // b. Print courses containing the word "Spring"
        System.out.println("\nCourses containing 'Spring':");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        // c. Print courses whose name has at least 4 letters
        System.out.println("\nCourses with at least 4 letters:");
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        // d. Sort the courses alphabetically and print
        System.out.println("\nSorted Courses:");
        courses.stream()
                .sorted()
                .forEach(System.out::println);
    }
}