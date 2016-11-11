/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javaapplication7.wordGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manu Molina Marín
 * @version 1.0
 */
public class wordGameTest {
    
    public wordGameTest() {
    }
      

    /*
    @Test 
    The Test annotation tells JUnit that the public void method to which it is attached can be run 
    as a test case.
    
    @Before
    Several tests need similar objects created before they can run. 
    Annotating a public void method with @Before causes that method to be run before each Test method.
    
    @After
    If you allocate external resources in a Before method, you need to release them after the test runs. 
    Annotating a public void method with @After causes that method to be run after the Test method.
    
    @BeforeClass
    Annotating a public static void method with @BeforeClass causes it to be run once before any of the test 
    methods in the class.
    
    @AfterClass
    This will perform the method after all tests have finished. 
    This can be used to perform clean-up activities.
    
    @Ignore
    The Ignore annotation is used to ignore the test and that test will not be executed.
    */
    
    /**
    * Comprobamos que se selecciona una de las palabras del array introducido
    */
    @Test
    public void testGetWord() {
        
        String[] wordsToPlay = {"ATOM","MOLECULA","BIO", "PERL"};
        wordGame testGame = new wordGame(wordsToPlay);
        String randomWord = testGame.getWord();
        boolean valid = false;
        
        for (int i = 0; i < wordsToPlay.length; i++) {
            if (randomWord == wordsToPlay[i]) valid = true;
        }
        
        assertEquals(valid, true);
    }
    
    /**
    * Comprobamos si todas las letras de la palabra se han ocultado correctamente    
    */
    @Test
    public void testInitHiddenWord() {
        
        String[] wordsToPlay = {"ATOM"};
        wordGame testGame = new wordGame(wordsToPlay);
        boolean valid = true; 
        char[] hWord = testGame.initHiddenWord(testGame.getWord());
        for(int i=0;i<hWord.length;i++){
           if (hWord[i] != '_') valid = false;
        }        
        assertEquals(valid, true);
    }
    
    /**
    * Comprobamos si el caracter se encuentra en la palabra del juego
    */
    @Test
    public void testGetPosCharacterInWord() {
        
        String[] wordsToPlay = {"MOLECULA"};
        wordGame testGame = new wordGame(wordsToPlay);
        int pos = testGame.getPosCharacterInWord(wordsToPlay[0], 'L');

        assertNotEquals(pos, -1);
    }
    
    
    
}
