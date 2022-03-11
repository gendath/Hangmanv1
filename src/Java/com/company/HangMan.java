package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {
    private final Scanner scanner = new Scanner(System.in);
    private int currentState;
    private final ArrayList<String> boardStates = new ArrayList<>();
    private final ArrayList<String> words = new ArrayList<>();
    private final ArrayList<Character> guesses = new ArrayList<>();
    private String currentWord="";
    private boolean gameOver =false;



    public  void playAgain(){
        System.out.print("\nPlay Again? (y or n)-->");
        try{
            String input = scanner.nextLine().toLowerCase();
            if(input.equals("y")){
                startGame();
            }else if(input.equals("n")){
                System.out.println("GOODBYE!");
            }else{
                throw new Exception("Please select either y or n");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            playAgain();
        }


    }
    public void getNewWord(){
        int index = (int) (Math.random()*words.size()-1);
        setCurrentWord(words.get(index));
    }
    public int printBoard(int state){
        boolean hasWon=true;
        if(state>=0 && state<boardStates.size()){
            System.out.println();
            System.out.println();

            System.out.println(boardStates.get(state));
            if(state==6){
                gameOver=true;
                return 1;
            }
            for(char c:currentWord.toLowerCase().toCharArray()){
                if(guesses.contains(c)){
                    System.out.print(" " + c + " ");
                }else{
                    System.out.print(" _ ");

                    hasWon=false;
                }
            }
            if(!hasWon){
                System.out.print("\n");
                System.out.print("Make Your Guess-->");
            }else{
                System.out.println();
                System.out.println("You Win!!!");
                gameOver =true;
            }

            return 1;
        }else{
            return -1;
        }


    }
    public char getGuess(){
        try{
            String input = scanner.nextLine().toLowerCase();
            if(input.length() != 1){
                throw new Exception("Invalid Entry, please enter a letter");
            }

            char guess = input.charAt(0);

            if(!Character.isLetter(guess)){
                throw new Exception("Invalid Entry, please enter a letter");
            }

            if(guesses.contains(guess)){
                throw new Exception("You've already guessed '"+ guess +"'" );
            }

            if(!currentWord.contains(String.valueOf(guess))){
                currentState++;
            }
            return guess;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.print("Make Your Guess-->");
            return getGuess();
        }

    }
    public void startGame() {
        System.out.println("Welcome to the culturally inappropriate game where we");
        System.out.println("hang a man if his spelling skills aren't up to snuff!");
        System.out.println("**********************HANGMAN************************");
        setCurrentState(0);
        getNewWord();
        gameOver=false;
        while(true){
            printBoard(getCurrentState());

            if(gameOver){
                break;
            }else{
                guesses.add(getGuess());
            }



        }

    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
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
