import java.util.Scanner;

public class Project2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        //Welcome message.
        System.out.println(message());

        //Takes in users name.
        String username = input.nextLine();
        //Displays message back with users name included.
        System.out.println(name(username));

        int count = 0;
        int tries = 6;
        String rematch;


        do {
            int magicNum = randomNum();
            //System.out.println(magicNum);
            int guess = -1;


            while (guess != magicNum) {
                count++;
                guess = input.nextInt();
                if (count == tries){
                    System.out.println("You are out of try's. :(");
                    break;
                }
                if (guess > magicNum) {
                    System.out.println("Your guess is too high. Take a guess.");

                } else if (guess < magicNum) {
                    System.out.println("Your guess is too low. Take a guess.");
                }

                else
                    System.out.println("Good job," + username + "! You guessed the number in " + count + " try's!");
            }

            System.out.println("Play again? (y / n)");
            input.nextLine();
            rematch = input.nextLine();
            count = 0;

        }while (rematch.equals("y"));
        System.out.println("Game over.");


        // }
    }
    public static String message(){
        String message = "Hello! What is your name?";
        return message;
    }
    public static String name(String name){
        String response = "Well, " + name +", I am thinking of a number between 1 and 20. Take a guess.";
        return response;
    }
    public static int randomNum() {
        int random = (int) Math.floor(Math.random() * 20 + 1);
        return random;
    }
}
