import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class hangman {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String wordToFind = "magic";
        char[] wordFound = new char[wordToFind.length()];
        ArrayList<String> missed = new ArrayList<>();

        for (int i = 0; i < wordFound.length; i++){
            wordFound[i] = '_';
        }
        int highScore = 0;
        int wrong = 0;
        int maxErr = 6;
        int playerScore = maxErr - wrong;
        String rematch = "";
        //Main loop for game.
            while(wrong < maxErr || rematch.equalsIgnoreCase("yes")){
                System.out.println("Guess a letter: ");
                String guess = input.next();
                if(guess.length() > 1){
                    guess = guess.substring(0,1);
                }
                if(!missed.contains(guess) && wordToFind.contains(guess)){
                        int index = wordToFind.indexOf(guess);

                        //If statement to a correct char to correct index in slot.
                        if(index >= 0){
                            wordFound[index] = guess.charAt(0);
                            index = wordToFind.indexOf(guess, index +1);
                        }
                    else {
                        wrong++;
                    }
                    missed.add(guess);
                }
                StringBuilder makeWord = new StringBuilder();
                for(int i = 0; i < wordFound.length; i++){
                    makeWord.append(wordFound[i]);

                    if(i < wordFound.length -1){
                        makeWord.append(" ");
                    }
                }
                System.out.println(makeWord.toString());

                if(wordToFind.contentEquals(new String(wordFound))){
                    System.out.println("You win!!");
                    System.out.println("Would you like to play again? (yes/no)");
                    input.nextLine();
                    rematch = input.nextLine();
                    if (rematch.equalsIgnoreCase("yes")){
                        wrong = 0;
                        missed.clear();
                        for (int i = 0; i < wordFound.length; i++){
                            wordFound[i] = '_';
                        }
                    }
                    else
                    break;
                }
                else {
                    System.out.println(hangman(wrong));
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
                    for (int i = 0; i < wordFound.length; i++){
                        wordFound[i] = '_';
                    }
                }

            }
            System.out.println("Game Over. Thanks for playing!");

    }
    public static String hangman(int tries){
        if(tries == 1){
            return "HANGMAN: Head.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "     |\n" +
                    "     |\n" +
                    "   ===";
        }
        if(tries == 2){
            return "HANGMAN: Body.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "  |  |\n" +
                    "     |\n" +
                    "   ===";
        }
        if(tries == 3){
            return "HANGMAN: Right leg.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "  |  |\n" +
                    "   | |\n" +
                    "   ===";
        }
        if(tries == 4){
            return "HANGMAN: Left leg.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "  |  |\n" +
                    " | | |\n" +
                    "   ===";
        }
        if(tries == 5){
            return "HANGMAN: Right arm.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "  | -|\n" +
                    " | | |\n" +
                    "   ===";
        }
        if(tries == 6){
            return "HANGMAN: Left arm.\n" +
                    "+---+\n" +
                    "  O  |\n" +
                    "- | -|\n" +
                    " | | |\n" +
                    "   ===\n" +
                    "Game Over.";
        }
        return "";
    }

}
