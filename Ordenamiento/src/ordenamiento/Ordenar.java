package ordenamiento;

public class Ordenar {
    public final static int MAX_VALUE = 9999;

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

    public static int[] quicksort(int[] vector, int izq, int der) {
        int pivote = vector[izq];
        int izquierdo = izq;
        int derecho = der;
        int aux;

        while (izquierdo < derecho) {
            while (vector[izquierdo] <= pivote && izquierdo < derecho) izquierdo++;
            while (vector[derecho] > pivote) derecho--;
            if (izquierdo < derecho) {
                aux = vector[izquierdo];
                vector[izquierdo] = vector[derecho];
                vector[derecho] = aux;
            }
        }
        vector[izq] = vector[derecho];
        vector[derecho] = pivote;
        if (izq < derecho - 1)
            quicksort(vector, izq, derecho - 1);
        if (derecho + 1 < der)
            quicksort(vector, derecho + 1, der);
        return vector;
    }

    public static int[] radixSort(int[] vector) {
        int x, j, i;
        for (x = Integer.SIZE - 1; x > 0; x--) {
            int auxiliar[] = new int[vector.length];
            j = 0;
            for (i = 0; i < vector.length; i++) {
                boolean mover = vector[i] << x >= 0;
                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = vector[i];
                    j++;
                } else {
                    vector[i - j] = vector[i];
                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = vector[i - j];
            }
            vector = auxiliar;
        }
        System.out.println("El Vector Ordenado con radixSort: ");
        return vector;
    }


    public static int[] bucketSort(int[] vector) {
        int [] bucket=new int[MAX_VALUE];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<vector.length; i++) {
            bucket[vector[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                vector[outPos++]=i;
            }
        }
        return vector;
    }

    public static int[] mergeShort(int[] vector) {
        sort(vector, 0, vector.length - 1);
        return vector;
    }

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
