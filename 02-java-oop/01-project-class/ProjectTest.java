public class ProjectTest {

    public static void main(String[] args){
        Project project1 = new Project();
        System.out.println(project1.getName());
        System.out.println(project1.getDecription());
        System.out.println(project1.getCost());
        System.out.println(project1.elevatorpitch());
    
        Project project2 = new Project("Tea");
        System.out.println(project2.getName());
        System.out.println(project2.getDecription());
        System.out.println(project2.getCost());
        System.out.println(project2.elevatorpitch());

        Project project3 = new Project("Tea","I like black Tea.",2.00);
        System.out.println(project3.getName());
        System.out.println(project3.getDecription());
        System.out.println(project3.getCost());
        System.out.println(project3.elevatorpitch());

        
    }
}
