/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

/**
 *
 * @author torre
 */
public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void obtener(int num) {
        boolean bandera = false;
        for (int a = 1; a < 999 && !bandera; a++) {
            for (int b = 1; b < 999 && !bandera; b++) {
                for (int c = 1; c < 999 && !bandera; c++) {
                    if (a + b + c == num) {
                        /**
                         * aqui valido si realmente los valores cumplen con la formula
                         */
                        if (a * a + b * b == c * c) {
                            System.out.println("Valores de la tripleta: \n  a= " + a + "b= " + b + "c= " + c);
                            bandera = true;
                        }
                    }
                }
            }
        }
        if (!bandera) {
            System.out.println("Lo siento, no encontramos una tripleta con la sumade esevalor.");
        }

    }

    public static void main(String[] args) {

        /**aqui podemos cambiar el valor en caso de buscaruna diferente tripelta.**/
        obtener(1000);
    }

}
