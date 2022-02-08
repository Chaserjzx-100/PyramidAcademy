import java.util.Scanner;

public class main {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String choice = "";
        char [][] gameMap = createMap();
        System.out.println();
        System.out.println("Press key 'q' to quit game.");
        System.out.println(gameMap.);
    }
    public static void intro(Human player1){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Humans vs Goblins!");
        System.out.println("Please enter a username:");
        player1.setName(input.next());
        System.out.println("Welcome " + player1.getName() + ", get ready to play!");
        System.out.println();
    }
    public static void displayMap(Land map){
        System.out.println("Controls: (n)-Up | (s)-Down | (e)-Right | (w)-Left ");
        System.out.println();

    }
    public static void combat(Human player1, Goblin goblin){

    }
    public static char [][] createMap(){
        char [][] map = new  char[7][7];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                map[i][j] = new Cell().getSpot();
            }
        }
        return map;
    }
}
