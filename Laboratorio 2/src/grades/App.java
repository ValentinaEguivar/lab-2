package grades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU :D ---");
            System.out.println("1. Agregar una nota");
            System.out.println("2. Ver la nota promedio");
            System.out.println("3. Ver el número de aprobados");
            System.out.println("4. Eliminar una nota");
            System.out.println("5. Salir del programa");
            System.out.print("Seleccione una opción <3: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.nextLine(); // Limpiar el buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la nota: ");
                    try {
                        double grade = scanner.nextDouble();
                        gradeManager.addGrade(grade);
                        System.out.println("Nota agregada.");
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar un número para la nota.");
                        scanner.nextLine(); // Limpiar el buffer
                    }
                    break;

                case 2:
                    System.out.println("Promedio de notas: " + gradeManager.calculateAverage());
                    break;

                case 3:
                    System.out.println("Número de aprobados: " + gradeManager.countPassingGrades());
                    break;

                case 4:
                    // Desafío adicional: Eliminar nota por valor o posición
                    System.out.println("\n1. Eliminar por valor");
                    System.out.println("2. Eliminar por posición (índice)");
                    System.out.print("Elija como eliminar nota: ");
                    
                    try {
                        int subChoice = scanner.nextInt();
                        if (subChoice == 1) {
                            System.out.print("Ingrese el valor de la nota para eliminar: ");
                            double val = scanner.nextDouble();
                            if (gradeManager.removeGradeByValue(val)) {
                                System.out.println("Nota eliminada con éxito ^v^.");
                            } else {
                                System.out.println("No se encontró esa nota.");
                            }
                        } else if (subChoice == 2) {
                            gradeManager.printGrades();
                            System.out.print("Ingrese la posición o el índice a eliminar: ");
                            int idx = scanner.nextInt();
                            if (gradeManager.removeGradeByIndex(idx)) {
                                System.out.println("Nota eliminada.");
                            } else {
                                System.out.println("Posición inválida.");
                            }
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Entrada no válida.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa... Adiós ^v^");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}