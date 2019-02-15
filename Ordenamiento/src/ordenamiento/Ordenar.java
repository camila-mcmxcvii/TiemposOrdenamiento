package ordenamiento;

public class Ordenar {
    public static int[] shellsort(int[] vector) {
        int size = vector.length;
        for (int grap = size / 2; grap > 0; grap /= 2) {
            for (int i = grap; i < size; i++) {
                int temp = vector[i];
                int j;
                for (j = i; j >= grap && vector[j - grap] > temp; j -= grap) {
                    vector[j] = vector[j - grap];
                }
                vector[j] = temp;
            }
        }
        return vector;
    }

    public static int[] quicksort(int[] vector) {
        return vector;
    }

    public static int[] radixSort(int[] vector) {
        return vector;
    }

    public static int[] bucketSort(int[] vector) {
        return vector;
    }

    public static int[] mergeShort(int[] vector) {
        return vector;
    }
}
