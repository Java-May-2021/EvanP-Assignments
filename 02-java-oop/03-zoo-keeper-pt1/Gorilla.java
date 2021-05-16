public class Gorilla extends Mammal{

    public Gorilla(int energy) {
        energyLevel = energy;        
    }
    public void throwSomething() {
        energyLevel -= 5;
        System.out.println("What the heck! That gorilla threw something! That's going to cost him about: " + this.energyLevel + " energy");
        
    }
    public void eatBananas() {
        energyLevel += 10;
        System.out.println("Our gorilla loves his bananas!" + "Which restores his energy by: " + this.energyLevel);
    }
    public void climb() {
        energyLevel -= 10;
        System.out.println("There he goes climbing a tree again!" + "That's going to cost him: " + this.energyLevel);
    }
    
}
