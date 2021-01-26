/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.math.BigInteger;
import javax.swing.JOptionPane;


/**
 *
 * @author torre
 */
public class Prueba1 {
/** en el arreglo alfabeto por cada elemento correspode el valor conforme su indice, es decir,
 * indice 0 =S, indice 1 =U, indice 2 =T, indice 3 =P, asi sucesivamente.
 */
   static String []alfabeto = {"S","U","T","P","A","G","M","E","L","C"};
    
    public static String diccionario(String  numeroEntrada){
        String CadenaSalida = "";
        String []numero = numeroEntrada.split("");
        
        for(int i =0; i<numero.length ;  i++){
            /*primero traemos el valor del array "numero"(solo un digito), lo convertimos en  int,
            finalmente traemos el valor del int a alfabeto **/
             CadenaSalida+=alfabeto[Integer.parseInt(numero[i])];
        }
        return CadenaSalida;
    }
    
    

    
    public static void main(String[] args) {
        
      String num ="";
      int cantidadDigitos=0;
      try{
        do{
         num = JOptionPane.showInputDialog("numero");
         cantidadDigitos=num.length();
       }while((num==null)&&(cantidadDigitos <1) && (cantidadDigitos>9));
      }catch(NumberFormatException e){
       num = JOptionPane.showInputDialog("Ingrese numero de 10 digitos");
       }
        //System.out.println(diccionario(num));
    }
    
    
}
