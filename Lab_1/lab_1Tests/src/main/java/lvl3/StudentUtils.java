package lvl3;

import java.util.LinkedList;

public class StudentUtils {
    public static void printStudents(LinkedList<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
