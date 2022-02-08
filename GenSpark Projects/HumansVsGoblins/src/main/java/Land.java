public class Land {
    private Cell cell;
    private Human player;
    private Goblin enemy;
    private Character [][] map;
    private int row;
    private int col;
    private char heart;
    public Land(){
        row = 5;
        col = 5;
        heart = '\uEB51';
        player = new Human();
        enemy = new Goblin();
        cell = new Cell();
        map = new Character[row][col];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                    map[i][j] = new Cell().getSpot();
            }
        }
    }
    public void  getMap(Character [][] map){
        for (int i = 0; i < map.length; i++){
           map[0][0] = this.player.getAvatar();
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = this.cell.getSpot();
            }
        }
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[row].length; col++){
                System.out.print(map[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
