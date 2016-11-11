
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Manu Molina Marín
 * @version 1.0
 */
public class JavaApplication7 {
    
    /**Metodo principal que pide letras al usuario con el fin de adivinar una palabra seleccionada dentro de una lista predefinida en la clase wordGame.
     * La aplicación no finaliza hasta que no se llega al límite de intentos o se acierta la palabra.     
     */
    public static void main(String[] args) {
           
    //COMENTARI VOSTRE
    //se definen las variables que se van a usar en el programa
    String[] wordsToPlay = {"ATOM","MOLECULA","BIO", "PERL"};    
    wordGame wGame = new wordGame(wordsToPlay);
    int limit  = wGame.getIntentLimit();
    
    String resposta, llegit="";
    boolean valid;    
    int pos, countTemp = 0, encertsTemp = 0;
    char c;
    
    Scanner lector = new Scanner (System.in);
    
    /**
    * Iniciamos un bucle que finaliza únicamente cuando:
    * se finaliza el juego en una palabra y se pide acabar con el juego completo
    */
    do{
         
            String paraula = wGame.getWord();                     
            
            System.out.println("La paraula que has d'encertar té "+paraula.length()+" lletres");

            char lletres[] = wGame.initHiddenWord(paraula);
            
            //COMENTARI VOSTRE         
            /**
             * Iniciamos un bucle que finaliza únicamente cuando:
             * se ha alcanzado el límite de intentos
             * se ha acertado la palabra completa
             */
            do{
                valid=false;
                
                //COMENTARI VOSTRE
                /**
                 * se solicita al usuario una letra y se comprueba si pertenece a la lista
                 * de caracteres válidos y no está vacio.
                 * Mientras no lo sea seguirá solicitandolo
                 */ 
                do{
                    System.out.println ("Si us plau, Escriu una lletra valida");
                    llegit=lector.nextLine().toUpperCase();
                    if(llegit.matches("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]")) valid=true;
                }while(valid == false || llegit.isEmpty() || llegit==null);
              
                //COMENTARI VOSTRE
                /**
                 * se convierte el texto introducido por el usuario en mayusculas
                 * y nos quedamos con la primera letra únicamente
                 */ 
                c=llegit.toUpperCase().charAt(0);
        
                pos = wGame.getPosCharacterInWord(paraula, c);
              
                //COMENTARI VOSTRE
                //Se comprueba si no se ha encontrado (pos = -1) el caracter en la palabra actual del juego
                if (pos == -1) {
                   countTemp = wGame.getCount();
                   countTemp++;
                   wGame.setCount(countTemp);
                   System.out.println("Aquesta lletra no es troba dins de la paraula. Ara et queden "+ (limit-countTemp)+ " intents");
                   //COMENTARI VOSTRE
                   //Si se ha llegado al límite de intentos se notifica al usuario
                   if(countTemp == limit) System.out.println("Has esgotat tots els intents");
                } else {
                        
                    for(int i=0;i<lletres.length;i++){
                        if(paraula.charAt(i) == c){                               
                            lletres[i] =c;
                            encertsTemp +=1;
                        }
                        System.out.print(lletres[i]+" ");                           
                    }
                    System.out.println("Molt bé!!! Torna a intentar-ho");
                  
                    if(encertsTemp == paraula.length()){
                        System.out.println("Has acabat encertant la paraula. Felicitats!!!!");
                        countTemp = limit;
                    }
               }

            }while(countTemp != limit);
        
        System.out.println("Vols continuar?(S/N)");
        resposta=lector.nextLine().toUpperCase();
       }while(resposta.equals("S"));
    
   } 
}
