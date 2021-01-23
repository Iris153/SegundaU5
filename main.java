package u5reg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class U5Reg {

    public static void main(String[] args) {
        
       int[] arreglo = LeerTxt();

        Scanner leer = new Scanner(System.in);
        int opc = 0;

        while (opc != 5) {
            System.out.println("***** BIENVENIDO AL ORDENAMIENTO DE LISTAS *****");
            System.out.println("[1] ORDENAMIENTO METODO BURBUJA");
            System.out.println("[2] ORDENAMIENTO METODO QUIKSORT");
            System.out.println("[3] ORDENAMIENTO METODO SHELLSORT");
            System.out.println("[4] ORDENAMIENTO METODO RADIX");
            System.out.println("[5] SALIR");
            System.err.print("Ingrese una opcion > ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    Procesos.burbuja(arreglo);
                    break;
                case 2:
                    System.out.println("***** ARREGLO NO ORDENADO *****");
                    System.out.print("[");
                    for (int k = 0; k < arreglo.length; k++) {
                        System.out.print(arreglo[k] + ", ");
                    }
                    System.out.println("]");

                    Procesos.quicksort(arreglo, 0, arreglo.length - 1);

                    System.out.println("***** ARREGLO ORDENADO POR QUIKSORT *****");
                    System.out.print("[");
                    for (int k = 0; k < arreglo.length; k++) {
                        System.out.print(arreglo[k] + ", ");
                    }
                    System.out.println("]\n");
                    break;
                case 3:
                    Procesos.shell(arreglo);
                    break;
                case 4:
                    Procesos.Radix(arreglo);
                    break;
                case 5:
                    System.out.println("USTED HA SALIDO");
                    System.exit(0);
                    break;
                default:
                    System.err.println("OPCION NO VALIDA");
                    break;
            }
        }

    }

    private static int[] LeerTxt() {

        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;

        int arreglo[] = null;

        try {
            archivo = new File("C:\\Users\\irisv\\Desktop\\Regula5.txt"); // Ruta desde donde se lee el txt
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            String linea;
            String delimiter = ","; //Separador dentro del txt.

            while (((linea = br.readLine()) != null)) {

                String a[] = linea.split(delimiter);
                arreglo = new int[a.length];

                for (int l = 0; l < a.length; l++) {
                    arreglo[l] = Integer.parseInt(a[l]);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return arreglo;
    }

    
}

