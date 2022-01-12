import java.util.Scanner;

public class Project1 {
    public static void main(String [] args ) {
        System.out.println(message());
        Scanner input = new Scanner(System.in);
        int choice;
        try {
            choice = input.nextInt();
            while(choice > 2 || choice < 1){
                System.out.println("Enter 1 or 2 please!");
                choice = input.nextInt();
            }

        } catch (Exception e){
             throw new NumberFormatException("Caught Exception: Enter valid integer");
        }

        if (choice == 1){
            System.out.println(cave1());
        }
        if (choice == 2){
            System.out.println(cave2());
        }
    }
    public static String message(){
        String message = "You are in a land full of dragons. In front of you, you see two caves." +
                " In one cave, the dragon is friendly and will share his treasure with you. The other dragon" +
                "is greedy and hungry and will eat you on sight. Which cave will you go into? 1 or 2?";
        return message;
    }
    public static String cave1(){
        String choice1 = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you!" +
                " He opens his jaws and... Sets you ablaze with his fire!!";
        return choice1;
    }
    public static String cave2(){
        String choice2 = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you!" +
                " He opens his jaws and... Asks you if you would like to stay for dinner. Congratulations, you got lucky!";
        return choice2;
    }
}
