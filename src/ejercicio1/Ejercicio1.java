/*

 */
package ejercicio1;

import java.awt.HeadlessException;
import java.io.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class Ejercicio1 {

    /**Nombre Jimmy Milla Martinez
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lista = "";
        int nNumero = 0;
        String n;
        int mayor = 0;
        int menor = 9999;
        double promedio = 0;
        int suma = 0;
        boolean repetir = true;
        int x;

        while (repetir) {

            try {
                n = JOptionPane.showInputDialog(null, "Ingrese el Numero de estudiantes");
                if (n == null) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    System.exit(0);
                }
                nNumero = Integer.parseInt(n);

                repetir = false;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dato incorrecto\nVuelva a ingresar el dato");

            }
        }
        int[] edades = new int[nNumero];
        String[] nombres = new String[nNumero];
        int[] multiplos = new int[nNumero];
        int nMultiploAcumulador = 0;
        boolean volver = true;
        String auxi;
        while (volver) {

            try {

                for (int i = 0; i < edades.length; i++) {

                    auxi = JOptionPane.showInputDialog(null, "Ingrese la Edad del Estudiante " + (i + 1));
                    if (auxi == null) {

                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                        System.exit(0);
                    }

                    edades[i] = Integer.parseInt(auxi);

                    nombres[i] = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante " + (i + 1));
                    if (nombres[i] == null) {
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                        System.exit(0);
                    }

                    if (edades[i] > mayor) {
                        mayor = edades[i];
                    }

                    if (edades[i] <= menor) {
                        menor = edades[i];
                    }

                    suma = suma + edades[i];
                    if (EsMultiploDeSiete(edades[i])) {
                        multiplos[nMultiploAcumulador] = edades[i];
                        nMultiploAcumulador++;
                    }

                }
                volver = false;

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dato incorrecto\nVuelva a ingresar el dato");
            }

        }
        promedio = suma / nNumero;

        // impresion de Mensaje.
        lista = lista + "La Lista de Nombres de los estudiantes :\n";
        int aux;
        for (int i = 0; i < nNumero; i++) {
            lista += nombres[i] + "\n";
            for (int j = 1; j < nNumero; j++) {
                if (edades[j - 1] < edades[j]) {
                    aux = edades[j - 1];
                    edades[j - 1] = edades[j];
                    edades[j] = aux;

                }

            }
        }
        lista += "La edad mayor es: " + mayor + "\nLa edad menor es: " + menor + "\n Las edades ordanadas de mayor a menor es:\n ";

        for (int i = 0; i < nNumero; i++) {
            lista += edades[i] + "\n";

        }
        lista += "Las edades multiplos de 7 son: \n";
        for (int i = 0; i < multiplos.length; i++) {
            if (multiplos[i] != 0) {
                lista += multiplos[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, lista);

    }

    public static boolean EsMultiploDeSiete(int p_numero) {
        boolean bvalor_retorno = false;

        if (p_numero == 0) {
            bvalor_retorno = false;
        }

        if (p_numero % 7 == 0) {
            bvalor_retorno = true;
        }
        return bvalor_retorno;
    }
}
