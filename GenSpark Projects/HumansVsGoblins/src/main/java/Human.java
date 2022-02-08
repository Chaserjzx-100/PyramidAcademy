public class Human {
    private String name;
    private int health;
    private int strength;
    private char player;

    public Human(){
        name = "player1";
        health = 100;
        strength = 10;
        player = '';
    }
    public Human(String name1, int energy, int strength1){
        name = name1;
        health = energy;
        strength = strength1;
    }
    public char getAvatar(){
        return player;
    }
    public String getName() {
        return name;
    }
    public void setName(String username) {
        this.name = username;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStrength(){
        return this.strength;
    }
    public void setStrength(int userStrength){
        this.strength = userStrength;
    }
    public void fightGoblin(){

    }
    public void move(char[][] map, String move){
        if (move == "n"){
            up(map, new Human().getAvatar());
        } else if (move == "s"){
            down(map, new Human().getAvatar());
        } else if (move == "e"){
            left(map, new Human().getAvatar());
        } else if (move == "w"){
            right(map, new Human().getAvatar());
        } else
            System.out.println("Invalid move. Choose between 'n' 's' 'e' 'w'");
    }
    public void up(char[][] map, char player) {

        int row = 0;
        int col = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    row = i;
                    col = j;
                }
            }
        }
        if (row - 1 < 0) {
            System.out.println("Must stay within the map!");
        } else {
            if (map[row - 1][col] == new Goblin().getGoblin()) {

                System.out.println("Battle!");
                combat();
                playerStatus();
            }
            map[row--][col] = player;
//            main.displayMap(map);
        }
    }
    public void down(char[][] map, char player){
        int row = 0;
        int col = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    row = i;
                    col = j;
                }
            }
        }
        if (row - 1 < 0) {
            System.out.println("Must stay within the map!");
        } else {
            if (map[row+1][col] == new Goblin().getGoblin()) {

                System.out.println("Battle!");
                combat();
                playerStatus();
            }
            map[row++][col] = player;
//            main.displayMap(map);
        }
    }
    public void left(char[][] map, char player){
        int row = 0;
        int col = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    row = i;
                    col = j;
                }
            }
        }
        if (row - 1 < 0) {
            System.out.println("Must stay within the map!");
        } else {
            if (map[row][col-1] == new Goblin().getGoblin()) {

                System.out.println("Battle!");
                combat();
                playerStatus();
            }
            map[row][col--] = player;
//            main.displayMap(map);
        }
    }
    public void right(char[][] map, char player){int row = 0;
        int col = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    row = i;
                    col = j;
                }
            }
        }
        if (row - 1 < 0) {
            System.out.println("Must stay within the map!");
        } else {
            if (map[row][col+1] == new Goblin().getGoblin()) {

                System.out.println("Battle!");
                combat();
                playerStatus();
            }
            map[row][col++] = player;
//            main.displayMap(map);
        }}
    public void combat(){
       if (this.health == 5){

       }
    }
    public void playerStatus(){
        System.out.println(this.toString());
        if (this.health <= 0){
            System.out.println("Uh oh, you have taken too much damage and lost.");
        }
    }
    @Override
    public String toString(){
        return "Human name: " + name
                +"\nHuman health: " + health
                +"\nHuman strength: " + strength;
    }
}
