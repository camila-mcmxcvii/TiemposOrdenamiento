import ordenamiento.Ordenar;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        int[] vector = generateVectorRamdon(Ordenar.MAX_VALUE);
        int[] respuesta;
        String menu = "" +
                "Ingrese una opción:\n" +
                "0.Salir\n" +
                "1.Generar nuevo vector\n" +
                "2.Ordenar por shellsort\n" +
                "3.Ordenar por quicksort\n" +
                "4.Ordenar por radixSort\n" +
                "5.Ordenar por bucketSort\n" +
                "6.Ordenar por mergeShort\n" +
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
                    showVector(vector);
                    after = LocalDateTime.now();
                    respuesta = Ordenar.shellsort(vector);
                    showTime(after);
                    showVector(respuesta);
                    break;
                case 3:
                    showVector(vector);
                    after = LocalDateTime.now();
                    respuesta = Ordenar.quicksort(vector, 0, vector.length - 1);
                    showTime(after);
                    showVector(respuesta);
                    break;
                case 4:
                    showVector(vector);
                    after = LocalDateTime.now();
                    respuesta = Ordenar.radixSort(vector);
                    showTime(after);
                    showVector(respuesta);
                    break;
                case 5:
                    showVector(vector);
                    after = LocalDateTime.now();
                    respuesta = Ordenar.bucketSort(vector);
                    showTime(after);
                    showVector(respuesta);
                    break;
                case 6:
                    showVector(vector);
                    after = LocalDateTime.now();
                    respuesta = Ordenar.mergeShort(vector);
                    showTime(after);
                    showVector(respuesta);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, String.format("Opción %d no valida\nIntente de nuevo", option), "Opción no valida", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (flag);
    }

    private static void showTime(LocalDateTime after) {
        JOptionPane.showMessageDialog(null, after.until(LocalDateTime.now(), ChronoUnit.MICROS), "Duración en microsegundos", JOptionPane.DEFAULT_OPTION);
    }

    private static void showVector(int[] vector) {
        String view = "Vector:\n";
        int size =  vector.length;
        for (int i = 0; i < size; i += 3) {
            view += vector[i] + "   " + vector[i + 1] + "    " + vector[i + 2] + "\n";
        }
        view += "...";
        showLongTextMessageInDialog(view);
    }

    private static int getOption(String message, String title) {
        int option;
        do {
            try {
                String ingresado = JOptionPane.showInputDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
                option = Integer.parseInt(ingresado);
                if (Ordenar.MAX_VALUE < option) {
                    JOptionPane.showMessageDialog(null, String.format("Debe ingresar un número inferior a %d", Ordenar.MAX_VALUE), "Valor no valido", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch (Exception e) {
                if ("null".equals(e.getMessage())) {
                    option = 0;
                    break;
                }
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero", "Valor no valido", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        return option;
    }

    private static int[] generateVectorRamdon(int size) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = (int) (Math.random() * (Ordenar.MAX_VALUE - 1)) + 1;
        }
        return vector;
    }

    public static void showLongTextMessageInDialog(String longMessage) {
        JTextArea textArea = new JTextArea(16, 20);
        textArea.setText(longMessage);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
