package u5reg;



public class Procesos {

    public static void Radix(int arreglo[]) {

        System.out.println("***** ARREGLO NO ORDENADO *****");
        System.out.print("[");
        for (int k = 0; k < arreglo.length; k++) {
            System.out.print(arreglo[k] + ", ");
        }
        System.out.println("]");

        int i, j, x;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int aux[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mov = arreglo[i] << x >= 0;
                if (x == 0 ? !mov : mov) {
                    aux[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];
                }
            }
            for (i = j; i < aux.length; i++) {
                aux[i] = arreglo[i - j];
            }
            arreglo = aux;
        }

        System.out.println("***** ARREGLO ORDENADO POR RADIX *****");
        System.out.print("[");
        for (int k = 0; k < arreglo.length; k++) {
            System.out.print(arreglo[k] + ", ");
        }
        System.out.println("]\n");

    }

    public static void shell(int arreglo[]) {

        System.out.println("***** ARREGLO NO ORDENADO *****");
        System.out.print("[");
        for (int k = 0; k < arreglo.length; k++) {
            System.out.print(arreglo[k] + ", ");
        }
        System.out.println("]");

        int i, j, k, aux, salto;
        salto = arreglo.length / 2;
        while (salto > 0) {
            for (i = salto; i < arreglo.length; i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (arreglo[j] > arreglo[k]) {
                        aux = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = aux;
                        j -= salto;
                    } else {
                        break;
                    }
                }
            }
            salto /= 2;
        }

        System.out.println("***** ARREGLO ORDENADO POR SHELLSORT*****");
        System.out.print("[");
        for (int l = 0; l < arreglo.length; l++) {
            System.out.print(arreglo[l] + ", ");
        }
        System.out.println("]\n");
    }

    public static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }

    private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];

        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else {
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
        }

    }

    public static void burbuja(int[] arreglo) {
        System.out.println("***** ARREGLO NO ORDENADO *****");
        System.out.print("[");
        for (int k = 0; k < arreglo.length; k++) {
            System.out.print(arreglo[k] + ", ");
        }
        System.out.println("]");

        int i, j, aux;
        for (i = 0; i < arreglo.length - 1; i++) {
            for (j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j + 1] < arreglo[j]) {
                    aux = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }

        System.out.println("***** ARREGLO ORDENADO POR BURBUJA*****");
        System.out.print("[");
        for (int l = 0; l < arreglo.length; l++) {
            System.out.print(arreglo[l] + ", ");
        }
        System.out.println("]\n");
    }
}
