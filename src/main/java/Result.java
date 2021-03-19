import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {

    public static List<Integer>gradingStudents(List<Integer> grades) throws Exception{
        final int maxAmoutOfGrades = 60;
        final int minAmoutOfGrades = 1;
        final int maxGrade = 100;
        final int minGrade = 0;
        final int passLimit = 40;
        final int roundLimit = 3;
        final int roundAtMultiplesOf = 5;

        List<Integer> resultGrades = new ArrayList<Integer>();

        if (grades == null){
            throw new NullPointerException("grades is null");
        }

        if(grades.get(0) != grades.size()-1){
            throw new Exception("Array size doesn't match.");
        }

        if (grades.get(0) > maxAmoutOfGrades || grades.size()-1 > maxAmoutOfGrades || grades.get(0) < minAmoutOfGrades || grades.size()-1 < minAmoutOfGrades){
            throw new Exception("Array size out of range");
        }

        for(int i = 0; i < grades.size(); i++){
            if (grades.get(i) > maxGrade || grades.get(i) < minGrade){
                throw new Exception("Grade value out of range");
            }
        }

        //Functionality
        for (int i = 1; i < grades.size(); i++){
            if(grades.get(i)%roundAtMultiplesOf >= roundAtMultiplesOf - roundLimit + 1 && grades.get(i) > passLimit - roundLimit){
                resultGrades.add(grades.get(i) + (roundAtMultiplesOf - grades.get(i)%roundAtMultiplesOf));
            }else {
                resultGrades.add(grades.get(i));
            }
        }

        return resultGrades;
    }
}
