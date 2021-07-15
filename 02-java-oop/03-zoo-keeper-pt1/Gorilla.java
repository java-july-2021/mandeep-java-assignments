public class Gorilla extends Mammal{

    public Gorilla(int energyLevel){
        super(energyLevel);
    }
    public void throwSomething(){
        System.out.println("Gorilla has throw something.");
        this.energyLevel-=5;

    }

    public void eatBananas(){
        System.out.println("Gorilla ate a banana.");
        this.energyLevel+=10;

    }

    public void climb(){
        System.out.println("Gorilla has climbed a tree.");
        this.energyLevel-=10;
    }
}
