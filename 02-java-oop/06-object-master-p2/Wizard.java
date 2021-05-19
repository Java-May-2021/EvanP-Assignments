public class Wizard extends Human {
    public Wizard(int health) {
        super(health);
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human target) {
        target.health += this.intelligence;
        System.out.println("You have been healed by my hand!" + "+" + this.intelligence);
    }
    public void fireball(Human target) {
        target.health -= (this.intelligence * 3);
        System.out.println("Fireball!!!" + "Lose" + this.intelligence + "Health");
    }
    
}
