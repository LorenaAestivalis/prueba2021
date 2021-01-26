/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import java.io.FileReader;
import java.io.FileWriter;

public class Prueba4 {
    /*Este metodo solo especifica los dias que tendra el mes, por lo cual solo devolvera un num**/
    public static int numDiasDelMes(int mes) {
        int axio = 2021;
        int numDias = 0;

        switch (mes) {
            /**dias que solo tienen 31 dias*/
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDias = 31;
                break;
            /**dias que solo tienen 30 dias*/
            case 4:
            case 6:
            case 9:
            case 11:
                numDias = 30;
                break;
            /**En este caso es cuando tenemos al año viciesto*/
            case 2:
                if ((axio % 4 == 0) && (axio % 100 != 0) || (axio % 400 == 0)) {
                    numDias = 29;
                } else {
                    numDias = 28;
                }
                break;
        }

        return numDias;
    }

    public static void escribirMes(int mes, char diaSemanaDelDiaUno) {
        String dias = "LMXJVSD";
        int numDiasMes = numDiasDelMes(mes);
        int pos = dias.indexOf(Character.toUpperCase(diaSemanaDelDiaUno));
            //5
        if (pos != -1) {
            try {
                /* aqui defenimos el archivo**/
                FileWriter fw = new FileWriter("mes" + mes + ".txt");

                fw.write("L   M   X   J   V   S   D\r\n");
                /**rellenamos los espacios  hasta que comienza el primer dia del mes*/
                for (int i = 0; i < pos * 4; i++) {
                    fw.write(" ");
                }
                /**Escribimos los dias*/
                for (int i = 1; i <= numDiasMes; i++) {

                    if (i < 10) {
                        fw.write(i + "   ");
                    } else {
                        fw.write(i + "  ");
                    }
                    /*aqui nosotros saltamos a la siguiente semana, es decir comenzamos al L**/
                    pos++;
                    if (pos > 6) {
                        fw.write("\r\n");
                        pos = 0;
                    }
                }

                fw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    /*este metodo simplemente lee el arhvo que previamente se creo**/
    public static void Calendario(int mes) {
        try {
            FileReader fr = new FileReader("mes" + mes + ".txt");
            int i = fr.read();

            while (i != -1) {
                System.out.print((char) i);
                i = fr.read();
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        escribirMes(3, 'm');
        Calendario(9);
    }
}
