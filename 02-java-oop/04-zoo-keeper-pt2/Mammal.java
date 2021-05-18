public class Mammal {
    protected int energyLevel;
    public int displayEnergy() {
        System.out.println("This Bat has " + energyLevel + " energy left in the tank");
        return energyLevel;
    }    
}
