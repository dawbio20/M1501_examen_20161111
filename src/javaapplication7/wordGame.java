/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Random;

/**
 * Esta clase contiene la estructura principal del juego.
 * Guarda la palabra a adivinar, mantiene el número de intentos, aciertos y el límite permitido de intentos.
 * @author Manu Molina Marín
 * @version 1.0
 */
public class wordGame {
    
    //COMENTARI VOSTRE
    //Se definen las variables que van a mantener el programa.
    //Palabra que acertar, número de intentos, aciertos y límite permitido de intentos.
    
    String[] paraules={};
    int count, encerts, intentLimit;

    public wordGame(String[] word) {
        this.paraules = word;
        this.count = 0;
        this.encerts = 0;
        this.intentLimit = 10;
    }

    public String[] getParaules() {
        return paraules;
    }

    public int getCount() {
        return count;
    }

    public int getEncerts() {
        return encerts;
    }

    public int getIntentLimit() {
        return intentLimit;
    }
    
        
    public void setParaules(String[] paraules) {
        this.paraules = paraules;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setEncerts(int encerts) {
        this.encerts = encerts;
    }

    public void setIntentLimit(int intentLimit) {
        this.intentLimit = intentLimit;
    }

    
    /**
    * Selecciona una palabra mediante random de la lista de palabras de la clase
    * @param void
    * @return String la palabra selecciona al azar
    */
    public String getWord() {
        //COMENTARI VOSTRE
        Random rnd = new Random();
        int endevina=(int)(rnd.nextDouble()*this.paraules.length);

        //COMENTARI VOSTRE
        String paraula=this.paraules[endevina];
        
        return paraula;
    }
    
    /**
    * Inicializa la palabra ocultando todos los caracteres con guiones bajos
    * @param String la palabra a ocultar
    * @return String la palabra con los caracteres ocultos
    */
    public char[] initHiddenWord(String paraula) {
        //Creo l'array de caràcters que mostraran les encertades
        char lletres[]=new char[paraula.length()];
        for(int i=0;i<paraula.length();i++){
            lletres[i] ='_';
        }
        return lletres;
    }
    
    /**
    * Devuelve la posición del caracter en la palabra
    * @param String la palabra con la que se está jugando
    * @param char el caracter que se está buscando
    * @return int posición del caracter en la palabra
    */
    public int getPosCharacterInWord(String paraula, char c) {       
        
        //COMENTARI VOSTRE
        //Se busca la posición del caracter en la palabra actual del juego
        int pos = paraula.indexOf(c);
        
        return pos;
    }
   
}
