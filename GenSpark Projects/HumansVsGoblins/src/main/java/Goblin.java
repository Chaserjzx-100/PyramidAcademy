public class Goblin {
    private int health;
    private int strength;
    public char goblin;

    public Goblin(){
        health = 100;
        strength = (int)Math.floor(Math.random()*25)+1;
        goblin = '\uE814';
    }
    public Goblin(int energy, int strength1) {
        health = energy;
        strength = strength1;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int userHealth){
        this.health = userHealth;
    }
    public int getStrength(){
        return this.strength;
    }
    public void setStrength(int userStrength){
        this.strength = userStrength;
    }
    public char getGoblin(){
        return goblin;
    }
        public String attack(Object person){
            var human = (Human) person;
            human.setHealth(human.getHealth() - this.strength);
            if (human.getHealth() <=0){
                return "Goblin has killed " + human.getName();
            } else
                return "Goblin attacked " + human.getName() + ", " + human.getHealth() + " health left.";
        }
    @Override
    public String toString(){
        return   "Goblin health: " + this.getHealth()
                +"\nGoblin strength: " + strength;
    }
}
