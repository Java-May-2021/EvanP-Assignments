public class Human {
    protected int strength = 3;
    protected int intelligence = 3;
    protected int stealth = 3;
    protected int health = 100;

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;        
    }
    public void setStealth(int stealth) {
        this.stealth = stealth;        
    }

    public int getStrength() {
        return this.strength;
    }
    public int getIntelligence() {
        return this.intelligence;
    }
    public int getStealth() {
        return this.stealth;
    }

    public Human(int health) {
        this.health = health;        
    }
    
    public void attack(Human target) {
        target.health -= this.strength;
        System.out.println("Ouch that hurt me! " + " Loses " + this.strength + " Health");
    }
}
