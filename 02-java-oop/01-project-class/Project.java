public class Project{
    private String name;
    private String description;
    private double cost = 0;

    public String elevatorpitch(){
        return this.name + " "+ this.cost +": "+ this.description;
    }
    //Overload the constructor method.
    public Project() {
        this.name = "Give me a name.";
        this.description = "Give me a description.";
    }

    public Project(String name) {
        this.name = name;
        this.description = "Give me a description.";

    }

    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
    // getters and setters.
    public String getName(){
        return this.name;
    }

    public String getDecription(){
        return this.description;
    }

    public double getCost(){
        return this.cost;
    }

    public String setName(String name){
        this.name = name;
    }

    public String setDecription(String description) {
        this.description= description;
    }

    public double setCost(double cost){
        this.cost = cost;
    }


}