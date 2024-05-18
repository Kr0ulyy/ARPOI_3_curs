package lvl3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void testPrintStudents_Positive() {
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));
        students.add(new Student("Charlie", 1));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        StudentUtils.printStudents(students, 2);
        String expectedOutput = "Bob"+"\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testUnion_Positive() {
        Student s1= new Student("Alice", 1);
        Student s2 = new Student("Bob", 2);
        Student s3 = new Student("Charlie", 3);
        LinkedList<Student> set1 = new LinkedList<>();
        set1.add(s1);
        set1.add(s2);
        LinkedList<Student> set2 = new LinkedList<>();
        set2.add(s3);
        set2.add(s2);
        Set<Student> expected = new HashSet<>();
        expected.add(s3);
        expected.add(s2);
        expected.add(s1);

        Set<Student> unionResult = SetUtils.union(set1, set2);

        assertEquals(expected, unionResult);
    }
    @Test
    void testIntersect_Positive() {
        Student s1= new Student("Alice", 1);
        Student s2 = new Student("Bob", 2);
        Student s3 = new Student("Charlie", 1);
        LinkedList<Student> set1 = new LinkedList<>();
        set1.add(s1);
        set1.add(s2);

        LinkedList<Student> set2 = new LinkedList<>();
        set2.add(s2);
        set2.add(s3);
        Set<Student> expected = new HashSet<>();
        expected.add(s2);

        Set<Student> intersectResult = SetUtils.intersect(set1, set2);

        assertEquals (expected, intersectResult);
    }
}

