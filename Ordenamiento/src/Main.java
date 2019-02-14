import ordenamiento.Ordenar;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        int[] vector = generateVectorRamdon(9999);
        String menu = "" +
                "Ingrese una opción:\n" +
                "0.Salir\n" +
                "1.Generar Nuevo Vector\n" +
                "2.Ordenar por Shellsort\n" +
                "3.Ordenar por quicksort\n" +
                "";
        int option;
        LocalDateTime after;
        boolean flag = true;
        showVector(vector);
        do {
            option = getOption(menu, "MENU");
            switch (option) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    int size = getOption("Ingrese el tamaño del vector", "Ingrese");
                    vector = generateVectorRamdon(size);
                    showVector(vector);
                    break;
                case 2:
                    after = LocalDateTime.now();
                    showVector(vector);
                    vector = Ordenar.shellsort(vector);
                    showTime(after);
                    break;
                case 3:
                    after = LocalDateTime.now();
                    showVector(vector);
                    vector = Ordenar.quicksort(vector);
                    showTime(after);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, String.format("Opción %d%n no valida\nIntente de nuevo", option), "Opción no valida", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (flag);

        System.out.println("Hello World!");
    }

    private static void showTime(LocalDateTime after) {
        JOptionPane.showMessageDialog(null, after.until(LocalDateTime.now(), ChronoUnit.MICROS), "Duración en microsegundos", JOptionPane.DEFAULT_OPTION);
    }

    private static void showVector(int[] vector) {
        JOptionPane.showMessageDialog(null, vector.toString(), "Vector", JOptionPane.DEFAULT_OPTION);
    }

    private static int getOption(String message, String title) {
        int option;
        do {
            try {
                String ingresado = JOptionPane.showInputDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
                option = Integer.parseInt(ingresado);
                break;
            } catch (NullPointerException e) {
                option = 0;
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero", "Valor no valido", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        return option;
    }

    private static int[] generateVectorRamdon(int size) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = (int) Math.random() * (1 - Integer.MAX_VALUE) + Integer.MAX_VALUE;
        }
        return vector;
    }
}
