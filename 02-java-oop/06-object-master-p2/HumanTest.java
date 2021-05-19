public class HumanTest {
    public static void main(String[] args) {
        Human h = new Human(100);
        Human u = new Human(100);

        Samurai samurai1 = new Samurai(200);
        Samurai samurai2 = new Samurai(200);
        Samurai samurai3 = new Samurai(200);
        Ninja ninja1 = new Ninja(100);
        Wizard wizard1 = new Wizard(50);

        h.setStrength(15);
        h.setIntelligence(15);
        h.setStealth(3);

        u.setStrength(8);
        u.setIntelligence(2);
        u.setStealth(0);

        h.attack(u);
        Samurai.howMany();

        samurai1.deathBlow(wizard1);
        samurai2.meditate();

        wizard1.fireball(samurai3);
        wizard1.heal(ninja1);


        ninja1.steal(wizard1);
        ninja1.runAway();
    }
}
