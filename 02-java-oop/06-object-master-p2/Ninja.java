public class Ninja extends Human {
    public Ninja(int health) {
        super(health);
        this.stealth = 10;
    }
    
    public void steal(Human stolen) {
        stolen.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("What was once yours..." + this.health + "Is now mine...");
        
    }
    public void runAway() {
        this.health -= 10;
        System.out.println("The ninja has fled" + " Losing " + this.health + " Health");
        
    }
    
}
