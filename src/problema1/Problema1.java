/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    public static String quitarLetrasRepetidas(String mensaje) throws ParseException {

        int letrasRepetidas = 1;

        while (letrasRepetidas > 0) {
            char c1, c2;
            letrasRepetidas = 0;
            int noLetras = mensaje.length();
            for (int i = 0; i < noLetras; i++) {
                if ((i + 1) != noLetras) {
                    c1 = mensaje.charAt(i);
                    c2 = mensaje.charAt(i + 1);
                    if (c1 == c2) {
                        letrasRepetidas = letrasRepetidas + 1;
                    }
                }
            }
            if (letrasRepetidas > 0) {
                mensaje = mensaje.replaceAll("(.)\\1", "$1");
                //  System.out.println(mensaje);
            }
        }

        return mensaje;

    }

    public static void main(String[] args) throws ParseException {
   
        String archivoEntrada = "entrada.txt";
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(archivoEntrada));

            String linea1 = br.readLine();
            String linea2 = br.readLine();
            String linea3 = br.readLine();
            String linea4 = br.readLine();

            /*
             * System.out.println("" + linea1); System.out.println("" + linea2);
             * System.out.println("" + linea3); System.out.println("" + linea4);
             */

            String[] numeros = linea1.split(" ");

            int m1 = Integer.parseInt(numeros[0]);
            int m2 = Integer.parseInt(numeros[1]);
            int n = Integer.parseInt(numeros[2]);

            //   System.out.println(m1 + "," + m2 + "," + n);

            String mensajeSinRepetidas = quitarLetrasRepetidas(linea4);

            //  System.out.println(mensajeSinRepetidas);        

            FileWriter archivoSalida = null;
            PrintWriter pw = null;
            try {
                archivoSalida = new FileWriter("salida.txt");
                pw = new PrintWriter(archivoSalida);

                int resultado = mensajeSinRepetidas.indexOf(linea2);
                if (resultado == -1) {
                    System.out.println("NO");
                    pw.println("NO");
                } else {
                    System.out.println("SI");
                    pw.println("SI");
                }

                int resultado2 = mensajeSinRepetidas.indexOf(linea3);
                if (resultado2 == -1) {
                    System.out.println("NO");
                     pw.println("NO");
                } else {
                    System.out.println("SI");
                    pw.println("SI");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != archivoSalida) {
                        archivoSalida.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error de lectura de archivo");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de archivo");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar de archivo");
                System.out.println(e.getMessage());
            }
        }

    }
}
