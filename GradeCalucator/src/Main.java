import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
	    Scanner readFile = new Scanner(new File("TY9_Grades.csv"));
	    ArrayList<Student> studentList = new ArrayList<>();
	    String header = readFile.nextLine();  //Takes in the header
	    String description = readFile.nextLine();  //Takes in the point description

	    String[] title = description.split(","); //This stores the description of each assignments

        int lineCount = 0; //this is to avoid counting the average

        while(readFile.hasNextLine() && lineCount < 37) //as long as we have lines and we don't reach the average
        {
            int count = 0; //this helps us avoid the student id and subtotal
            String line = readFile.nextLine(); //read line
            line = line.replaceAll(",", " "); //break them into seperate words
            Student student = new Student(); //create a student class
            Scanner lineRead = new Scanner(line); //using a scanner to read the line
            while(lineRead.hasNext()) //as long as the line has word to read
            {
                String word = lineRead.next(); //read word
                if(count == 0)
                {                                  //if it is at the first index of the line,
                    word = word.substring(4, 8);   //I know it is an ID so I set the word to ID
                    student.setID(word);
                }else if(count == 13){
                    student.setSubtotal(word);  //IF it is 13, I know it is the last index, so that will be the subtotal
                }else if(count > 0 && count < 13){
                    student.addAssignments(title[count], word); //as long it is between 0 and 13, i know they are assignment grades
                }                                               //The assignment grades are held in a hashmap
                count++;
            }

            studentList.add(student); //add each student to an arrayList
            lineCount++;
        }

	    Scanner keyboard = new Scanner(System.in);
	    quicksort(studentList, 0, studentList.size() - 1); //sort the list ABC by ID
        System.out.println("What is your ID");
        String input = keyboard.next();
	    Student student =  binarySearch(studentList, input);

        student.printList();

        gradeCaluculator(student, title, keyboard);
        keyboard.close();
    }

    public static Student binarySearch(ArrayList<Student> studentList, String assignmentName)
    {
        int left = 0;
        int right = studentList.size() - 1;
        Student student = null;
        while(left <= right)
        {
            int mid = left + ((right - left) / 2);
            if(studentList.get(mid).getID().equalsIgnoreCase(assignmentName))
            {
                student = studentList.get(mid);
                return student;
            }else if(assignmentName.compareToIgnoreCase(studentList.get(mid).getID()) < 0)
            {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return student;
    }


    public static void gradeCaluculator(Student student, String[] title, Scanner keyboard)
    {
        System.out.println("Your current subtotal is: " + student.getSubtotal() + "\n");
        int innerCounter = 2;

        if(student.getSubtotal().equalsIgnoreCase("54"))
        {
            System.out.println("You are doing pretty good!!");
        }
            for(int i = 0; i < student.hashMapSize(); i++)
            {
                if(innerCounter < 13)
                {
                    if(student.getGrades(title[innerCounter]).equalsIgnoreCase("0"))
                    {
                        System.out.println("Assignment: " + title[innerCounter] + " is missing!");
                    }
                    innerCounter++;
                }
            }
            System.out.println();
            double currentSum = Double.parseDouble(student.getSubtotal());
            System.out.println("!!!!Remember!!!!");
            System.out.println("Practice problem is worth 2 points");
            System.out.println("Lab is worth 6 points");
            System.out.println("Midterm is worth 10 points");
            System.out.println("Final is worth 20 points");
            System.out.println("Assignment Listing: ");
            System.out.print("PP1 | PP2 | PP3 | PP4 | PP5 | PP5 | L1 | L2 | L3 | L4 | L5 | L6 | L7 | M1 | M2 | Final\n");
            boolean done = false;
            while(!done)
            {
                System.out.println("What is the assignment name?");

                String input = keyboard.next();
                String assignmentName = input;
                    System.out.println("Enter a number");
                    input = keyboard.next();
                    currentSum += Double.parseDouble(input);
                    System.out.println(assignmentName + "'s grade is now: " + input);


                System.out.println("Are you done? Yes or No" );
                input = keyboard.next();
                if(input.equalsIgnoreCase("Yes"))
                {
                    done = true;
                }else{
                    done = false;
                }
            }

            if((currentSum >= 97) && (currentSum <= 100)){
                System.out.println("A+");
            }
            else if((currentSum >= 93) && (currentSum <= 96)){
                System.out.println("A");
            }
            else if((currentSum >= 90) && (currentSum <= 92)){
                System.out.println("A-");
            }
            else if((currentSum >= 87) && (currentSum <= 89)){
                System.out.println("B+");
            }
            else if((currentSum >= 83) && (currentSum <= 86)){
                System.out.println("B");
            }
            else if((currentSum >= 80) && (currentSum <= 82)){
                System.out.println("B-");
            }
            else if((currentSum >= 77) && (currentSum <= 79)){
                System.out.println("C+");
            }
            else if((currentSum >= 73) && (currentSum <= 76)){
                System.out.println("C");
            }
            else if((currentSum >= 70) && (currentSum <= 72)){
                System.out.println("C-");
            }
            else if((currentSum >= 67) && (currentSum <= 69)){
                System.out.println("D+");
            }
            else if((currentSum >= 65) && (currentSum <= 66)){
                System.out.println("D");
            }
            else{
                System.out.println("F");
            }
        }


    public static void quicksort(ArrayList<Student> b, int low, int high) {
        int i = low, j = high;

        String pivot = b.get(low + (high - low) / 2).getID();

        while (i <= j)
        {
            while (b.get(i).getID().compareToIgnoreCase(pivot) < 0)
            {
                i++;
            }

            while (b.get(j).getID().compareToIgnoreCase(pivot) > 0)
            {
                j--;
            }

            if (i <= j)
            {
                swap(b, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(b, low, j);
        }

        if (i < high) {
            quicksort(b, i, high);
        }


    }

    public static void swap(ArrayList<Student> b, int i, int j)
    {
        Student temp = b.get(i);
        b.set(i, b.get(j));
        b.set(j, temp);
    }


}
