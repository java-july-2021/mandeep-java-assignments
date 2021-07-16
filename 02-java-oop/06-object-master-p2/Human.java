public class Human {
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;

    public void attack(Human otherHuman){
        otherHuman.health -= this.strength;
        System.out.println("this human attacked another human "+ this.strength + " The other human now has a health of "+ otherHuman.health);
    }
}
