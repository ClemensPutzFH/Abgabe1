import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @DisplayName("#1 first value of array too high")
    @Test
    void testGradingStudents_firstValueOfArrayTooHigh(){
        List<Integer> grades = Arrays.asList(50,38,53,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#2 first value of array too low")
    @Test
    void testGradingStudents_firstValueOfArrayTooLow(){
        List<Integer> grades = Arrays.asList(2,38,53,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#3 grades is null")
    @Test
    void testGradingStudents_gradesIsNull(){
        List<Integer> grades = null;
        assertThrows( NullPointerException.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#4 grades size out of range / too big")
    @Test
    void testGradingStudents_gradesSizeTooBig(){
        List<Integer> grades = new ArrayList<Integer>();
        for (int i = 0; i < 61; i++){
            grades.add(5);
        }
        grades.add(0,61);
        assertThrows(Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#5 first value of array out of Range / too High")
    @Test
    void testGradingStudents_firstValueOfArrayOutOfRangeTooHigh(){
        List<Integer> grades = Arrays.asList(100,38,53,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#6 first value of array out of Range / too Low")
    @Test
    void testGradingStudents_firstValueOfArrayOutOfRangeTooLow(){
        List<Integer> grades = Arrays.asList(0,38,53,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#7 grade out of range / too high")
    @Test
    void testGradingStudents_gradeOutOfRangeTooHigh(){
        List<Integer> grades = Arrays.asList(3,38,150,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#8 grade out of range / too low")
    @Test
    void testGradingStudents_gradeOutOfRangeTooLow(){
        List<Integer> grades = Arrays.asList(3,38,-150,33);
        assertThrows( Exception.class,()-> Result.gradingStudents(grades));
    }

    @DisplayName("#9 test basic functionality/ rounding difference 2")
    @Test
    void testGradingStudents_basicFunction2() {
        List<Integer> grades = Arrays.asList(4,73,67,38,33);
        List<Integer> actual = null;
        List<Integer> expected = Arrays.asList(75,67,40,33);
        try {
          actual =  Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Method throws Exception");
        }
        assertEquals(expected, actual);

    }

    @DisplayName("#10 test basic functionality/ rounding difference 1")
    @Test
    void testGradingStudents_basicFunction1() {
        List<Integer> grades = Arrays.asList(4,73,67,39,33);
        List<Integer> actual = null;
        List<Integer> expected = Arrays.asList(75,67,40,33);
        try {
            actual =  Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Method throws Exception");
        }
        assertEquals(expected, actual);
    }

    @DisplayName("#10 High grades should not exceed 100")
    @Test
    void testGradingStudents_highGradesNotExceed100() {
        List<Integer> grades = Arrays.asList(4,97,98,99,100);
        List<Integer> actual = null;
        List<Integer> expected = Arrays.asList(97,100,100,100);
        try {
            actual =  Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Method throws Exception");
        }
        assertEquals(expected, actual);
    }

    @DisplayName("#11 low grades should be rounded if >37")
    @Test
    void testGradingStudents_testLowEndRounding() {
        List<Integer> grades = Arrays.asList(5,36,37,38,39,40);
        List<Integer> actual = null;
        List<Integer> expected = Arrays.asList(36,37,40,40,40);
        try {
            actual =  Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Method throws Exception");
        }
        assertEquals(expected, actual);
    }

    @DisplayName("#12 first value match with array size")
    @Test
    void testGradingStudents_firstValueMatchWithArraySize(){
        List<Integer> grades = Arrays.asList(3,38,53,33);
        try {
            Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("No Exception should be thrown");
        }
    }

    @DisplayName("#13 grades size in range")
    @Test
    void testGradingStudents_gradesSizeInRange(){
        List<Integer> grades = new ArrayList<Integer>();
        for (int i = 0; i < 60; i++){
            grades.add(5);
        }
        grades.add(0,60);
        try {
            Result.gradingStudents(grades);
        } catch (Exception e) {
            e.printStackTrace();
            fail("No Exception should be thrown");
        }
    }
}
