import java.util.HashMap;

public class Student
{
    private String ID;
    private HashMap<String, String> assignments = new HashMap<String, String>();
    private String subtotal;

    public Student()
    {

    }

    public void addAssignments(String assignmentName, String value)
    {
        assignments.put(assignmentName, value);

    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setSubtotal(String subtotal)
    {
        this.subtotal = subtotal;
    }

    public void setAssignmentsGrades(String name, String grade)
    {
        assignments.replace(name, grade);
    }

    public String getID()
    {
        return ID;
    }

    public String getSubtotal()
    {
        return subtotal;
    }

    public String getGrades(String name)
    {
        return assignments.get(name);
    }

    public void printList()
    {
        System.out.println("Assignment Name: " + ID);
        System.out.println("PP1: " + assignments.get("PP1"));
        System.out.println("PP2: " + assignments.get("PP2"));
        System.out.println("PP3: " + assignments.get("PP3"));
        System.out.println("PP4: " + assignments.get("PP4"));
        System.out.println("PP5: " + assignments.get("PP5"));
        System.out.println("PP6: " + assignments.get("PP6"));
        System.out.println("L1: " + assignments.get("L1"));
        System.out.println("L2: " + assignments.get("L2"));
        System.out.println("L3: " + assignments.get("L3"));
        System.out.println("L4: " + assignments.get("L4"));
        System.out.println("M1: " + assignments.get("M1"));
        System.out.println("M2: " + assignments.get("M2"));
        System.out.println("Subtotal: " + subtotal);
        System.out.println();
    }

    public int hashMapSize()
    {
        return assignments.size();
    }

    public HashMap<String, String> getAssignments()
    {
        return assignments;
    }

}
