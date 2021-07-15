public class Bat extends Mammal {
    public Bat(int energyLevel){
        super(energyLevel);
    }

    public void fly(){
        System.out.println("Hey i m Bat");
        this.energyLevel-=50;
    }

    public void eatHumans(){
        System.out.println("Eating a human");
        this.energyLevel+=25;
    }

    public void attackTown(){
        System.out.println("Attacking a Town");
        this.energyLevel-=100;
    }
}
