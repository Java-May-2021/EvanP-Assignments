public class Mammal {
    protected int energyLevel;

    public int displayEnergy() {
        System.out.println("This gorilla has " + energyLevel + " energy left in the tank");
        return energyLevel;
    }
}
