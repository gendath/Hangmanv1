package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class HangMan {
    private int currentState;
    private final ArrayList<String> boardStates = new ArrayList<>();
    private final ArrayList<String> words = new ArrayList<>();
    private final ArrayList<Character> guesses = new ArrayList<>();
    private String currentWord="";

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public static void playAgain(){

    }
    public String getNewWord(){
        int index = (int) (Math.random()*words.size()-1);
        return words.get(index);
    }
    public int printBoard(int state){



        if(state>=0 && state<boardStates.size()){
            System.out.println("");
            System.out.println("");

            System.out.println(boardStates.get(state));
            if(state==6){
                return 1;
            }
            for(char c:currentWord.toCharArray()){
                if(guesses.contains(c)){
                    System.out.print(" " + c + " ");
                }else{
                    System.out.print(" _ ");
                }
            }
            System.out.print("\n");
            System.out.print("Make Your Guess-->");
            return 1;
        }else{
            return -1;
        }


    }
    public void startGame() {
        System.out.println("Welcome to the culturally inappropriate game where we");
        System.out.println("hang a man if his spelling skills aren't up to snuff!");
        System.out.println("**********************HANGMAN************************");
        boolean playing=true;
        int state = 0;
        setCurrentWord(getNewWord());
        while(playing){
            printBoard(state++);
            if(state==7){
                break;
            }


        }

    }


    public String getCurrentWord() {
        return currentWord;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public ArrayList<String> getBoardStates() {
        return boardStates;
    }

    public HangMan() {
        currentState = 0;

        //0
        boardStates.add(" ========\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "________________\n");
        //1
        boardStates.add(" ========\n" +
                        "   0    |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "________________\n");
        //2
        boardStates.add(" ========\n" +
                         "   0    |\n" +
                         "   |    |\n" +
                         "   |    |\n" +
                         "        |\n" +
                         "________________\n");

        //3
        boardStates.add(" ========\n" +
                         "   0    |\n" +
                         " --|    |\n" +
                         "   |    |\n" +
                         "        |\n" +
                         "________________\n");

        //4
        boardStates.add(" ========\n" +
                         "   0    |\n" +
                         " --|--  |\n" +
                         "   |    |\n" +
                         "        |\n" +
                         "________________\n");

        //5
        boardStates.add(" ========\n" +
                         "   0    |\n" +
                         " --|--  |\n" +
                         "   |    |\n" +
                         "  |     |\n" +
                         "________________\n");

        //6
        boardStates.add(" ========\n" +
                         "   0    |\n" +
                         " --|--  |\n" +
                         "   |    |\n" +
                         "  | |   |\n" +
                         "________________\n"+
                "OH NO! YOU LOOOOSSSSEEEEEE!!!!");

        //add words to array
        words.add("cat");
        words.add("dog");
        words.add("llama");
        words.add("audio");
        words.add("curio");
        words.add("psionic");
        words.add("lame");


    }


}
