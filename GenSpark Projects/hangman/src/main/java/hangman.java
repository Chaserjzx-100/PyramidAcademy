import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

public class hangman {
    public static void main(String [] args) throws IOException {
//        HangManTemp game = new HangManTemp();
//        game.startGame();
        Scanner input = new Scanner(System.in);
        //Getting user information.
        System.out.println("Please enter your first name:");
        String first = input.nextLine();
        System.out.println("Now last name:");
        String last = input.nextLine();

        intro(first,last);
        String magicWord = "magic";
        char[] wordFound = new char[magicWord.length()];
        ArrayList<String> missed = new ArrayList<>();

        for (int i = 0; i < wordFound.length; i++){
            wordFound[i] = '_';
        }
        int wrong = 0;
        int maxErr = 6;
        int playerScore = 0;
        String rematch = "";
        //Main loop for game.
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
                            wordFound[index] = guess.charAt(0);
                        }
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
                System.out.println(makeWord);
                //If the correct word is guessed!
                if(magicWord.contentEquals(new String(wordFound))){
                    playerScore = maxErr-wrong;
                    System.out.println("You win!!" + "You scored: " + playerScore);
                    if (playerScore > currHighScore()){
                        System.out.println("Congratulations, you set the new High Score!");
                    }
                    if (playerScore == currHighScore()){
                        System.out.println("Nice, you tied with the High Score!");
                    }
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
            buffer(first,last,playerScore);
            System.out.println("Game Over. Thanks for playing!");
    }
    public static void intro(String first, String last){
        System.out.println("Thank you "+ first + " " + last + " let's play hangman!");
    }
    public static void buffer(String first, String last, int playerScore) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/leadboard.text",true));
        writer.write(first + " " + last + ": " + playerScore);
        writer.newLine();
        writer.close();
    }
    public static int currHighScore() throws IOException{
        String fileName = "src/main/resources/leadboard.text";
        Path path = Paths.get(fileName);
        Scanner read = new Scanner(path);
        List<Integer> getMax = new ArrayList();
        while (read.hasNextLine()){
            String line = read.nextLine();
            char num = line.charAt(line.length()-1);
            String value = String.valueOf(num);
            int number = Integer.parseInt(value);
            getMax.add(number);
        }
        int largest = Collections.max(getMax);
//        if(score > largest)
//            largest = score;
//        else
//            return largest;
        return largest;
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
