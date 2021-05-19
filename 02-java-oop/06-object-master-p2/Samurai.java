public class Samurai extends Human {
    protected int health = 200;
    public static int numOfSamurai = 0;

    public Samurai(int health){
        super(health);
        this.health = 200;
        numOfSamurai ++;
    }

    public void deathBlow(Human target) {
        target.health = 0;
        this.health -= (this.health/2);
        System.out.println("That was a deathblow!" + "Minus " + this.health);        
    }
    public void meditate() {
        this.health += (this.health/2);
        System.out.println("You have been healed by " + this.health);
    }
    public static int howMany() {
        System.out.println("We have " + numOfSamurai + " In the world");
        return Samurai.numOfSamurai;
        
    }
}
