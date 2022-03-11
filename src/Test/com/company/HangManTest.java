package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HangManTest {
    private HangMan hangman = new HangMan();
    private final PrintStream standardOut=System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {

        hangman.setCurrentWord("aardvark");
        hangman.setCurrentState(0);
        System.setOut(new PrintStream(outputStreamCaptor));
    }



    @Test
    void getNewWord() {
        String oldWord = hangman.getCurrentWord();
        hangman.getNewWord();
        assertNotEquals(oldWord,hangman.getCurrentWord(),"getNewWord() failed");
    }

    @Test
    void printBoard() {
        hangman.printBoard(0);
        String expected = String.join(System.lineSeparator(),
                " ========\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "________________\n",
                        " _  _  _  _  _  _  _  _ \nMake Your Guess-->"
        ).trim();

        String actual  =outputStreamCaptor.toString().trim();
        assertEquals(expected,actual,"printBoard() failed");
    }


    @Test
    void setCurrentWord() {
        hangman.setCurrentWord("apple");
        assertEquals("apple",hangman.getCurrentWord(),"setCurrentWord() failed");
    }
    @Test
    void getCurrentState() {
        assertEquals(0,hangman.getCurrentState(),"getCurrentState() failed");
    }

    @Test
    void setCurrentState() {
        hangman.setCurrentState(5);
        assertEquals(5,hangman.getCurrentState(),"setCurrentState() failed");
    }


    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

}