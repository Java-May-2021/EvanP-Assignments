public class GiantBat extends Mammal{
    
    public GiantBat(int energy){
        energyLevel = energy;
    }
    public void fly() {
        energyLevel -= 50;
        System.out.println("Did you hear that? I think the bat just took off!" + this.energyLevel);
    }
    public void eatHumans() {
        energyLevel += 25;
        System.out.println("So... well nevermind." + this.energyLevel);
    }
    public void attackTown() {
        energyLevel -= 100;
        System.out.println("(Screams) THE WHOLE TOWN IS ON FIRE!!!" + this.energyLevel);
    }
}
