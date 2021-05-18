public class HumanTest {
    public static void main(String[] args) {
        Human player1 = new Human(100);
        Human player2 = new Human(100);

        player1.setStrength(15);
        player1.setIntelligence(15);
        player1.setStealth(3);

        player2.setStrength(8);
        player2.setIntelligence(2);
        player2.setStealth(0);

        player1.attack(player2);
    }
}
