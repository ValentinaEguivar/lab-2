package grades;

import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Double> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }
    public void addGrade(Double grade) {
        grades.add(grade);
    }
    public Double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        Double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    public Integer countPassingGrades() {
        Integer count = 0;
        for (Double grade : grades) {
            if (grade >= 50.0) {
                count++;
            }
        }
        return count;
    }
    public boolean removeGradeByValue(Double grade) {
        return grades.remove(grade);
    }
    public boolean removeGradeByIndex(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
            return true;
        }
        return false;
    }
    public void printGrades() {
        if (grades.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            System.out.println("Lista de notas actual:");
            for (int i = 0; i < grades.size(); i++) {
                System.out.println("Posición " + i + ": " + grades.get(i));
            }
        }
    }
}
