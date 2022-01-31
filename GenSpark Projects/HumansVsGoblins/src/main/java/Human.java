public class Human {
    private String name;
    private int health;
    private int strength;

    public Human(){
        name = "player1";
        health = 100;
        strength = 10;
    }
    public Human(String name, int energy, int strength1){
        name = name;
        health = energy;
        strength = strength1;
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
    @Override
    public String toString(){
        return "Human name: " + name
                +"\nHuman health: " + health
                +"\nHuman strength: " + strength;
    }
}
