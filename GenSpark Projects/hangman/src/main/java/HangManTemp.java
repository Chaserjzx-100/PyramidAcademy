import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangManTemp {
    private int highScore;
    private int wrong;
    private int maxErr;
    private int playerScore;
    private String rematch;
    private String magicWord;
    private String firstName;
    private String lastName;
    private char[] placeholder;
    private ArrayList<String> missed;

    public HangManTemp(){
        highScore = 0;
        wrong = 0;
        maxErr = 6;
        playerScore = 0;
        rematch = "";
        magicWord = "";
        firstName = "";
        lastName = "";
        missed = new ArrayList<>();
    }
    public HangManTemp(int pScore, String retry, String word, String first, String last){
        playerScore = pScore;
        rematch = retry;
        magicWord = word;
        firstName = first;
        lastName = last;
    }

    public void startGame(){
        maxErr = 0;
        missed.clear();
        placeholder = new char[magicWord.length()];
        for (int i = 0; i < placeholder.length; i++){
            placeholder[i] = '_';
        }
    }
    public void playGame() throws IOException {
        Scanner input = new Scanner(System.in);
        while(wrong < maxErr || rematch.equalsIgnoreCase("yes")){
            System.out.println("Guess a letter: ");
            String guess = input.next();
            if(guess.length() > 1){
                guess = guess.substring(0,1);
            }
            //Check whether the guess is already in the
            if(!missed.contains(guess)){
                if (magicWord.contains(guess)) {
                    int index = magicWord.indexOf(guess);
                    //If statement to a correct char to correct index in slot.
                    if (index >= 0) {
                        placeholder[index] = guess.charAt(0);
                        index = magicWord.indexOf(guess, index + 1);
                    }
                }
                else {
                    wrong++;
                }
                missed.add(guess);
            }
            StringBuilder makeWord = new StringBuilder();
            for(int i = 0; i < placeholder.length; i++){
                makeWord.append(placeholder[i]);

                if(i < placeholder.length -1){
                    makeWord.append(" ");
                }
            }
            System.out.println(makeWord);
            //If the correct word is guessed!
            if(magicWord.contentEquals(new String(placeholder))){
                playerScore = maxErr-wrong;
                System.out.println("You win!!" + "You scored: " + playerScore);
                if (playerScore > highScore){
                    highScore = playerScore;
                    System.out.println("Congratulations, you set the new High Score!");
                }
                System.out.println("Would you like to play again? (yes/no)");
                input.nextLine();
                rematch = input.nextLine();
                if (rematch.equalsIgnoreCase("yes")){
                    wrong = 0;
                    missed.clear();
                    for (int i = 0; i < placeholder.length; i++){
                        placeholder[i] = '_';
                    }
                }
                else
                    break;
            }
            else {
//                System.out.println(hangman(wrong));
                System.out.println("Try again. You have " + (maxErr-wrong) + " tries left");
            }
            if(maxErr == wrong){
                System.out.println("You are out of guesses.");
                System.out.println("Would you like to play again? (yes/no)");
                input.nextLine();
                rematch = input.nextLine();
                if (rematch.equalsIgnoreCase("no")){
                    break;
                }
                /*Reset variables if a new game is started.*/
                wrong = 0;
                missed.clear();
                for (int i = 0; i < placeholder.length; i++){
                    placeholder[i] = '_';
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/leadboard.text",true));
        writer.write(first + " " + last + ": " + playerScore);
        writer.newLine();
        writer.close();
        System.out.println("Game Over. Thanks for playing!");

    }
}
