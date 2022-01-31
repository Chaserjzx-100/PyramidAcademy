public class Land {
    public Object [][] map;
    public int num;

    public Land(){
        map = new Object [10][10];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                    map[i][j] = new Object();
            }
        }
    }
}
