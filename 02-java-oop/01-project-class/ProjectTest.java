import java.util.ArrayList;

public class ProjectTest {
    public static void main(String[] args) {
        Project project1 = new Project();
        Project project2 = new Project("New gaming laptop");
        Project project3 = new Project("Gaming laptop", "Gigabyte");
        
        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());

    }
}
