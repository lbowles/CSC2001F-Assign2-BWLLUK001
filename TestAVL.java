// Generates a test comparison between the Array and BST

import java.util.Scanner;
import java.util.Random ;

public class TestAVL  {
  
  public static int lower = 0 ; 
  public static int upper = 5000 ; 
  public static String input = "";
  public static int opCount = 0 ; 
  
  // Generates a given sized range for the data sets with a random starting point
  static public void setFileRange (int dataSize) { 
    Random rand = new Random() ; 
    lower = rand.nextInt(5000-dataSize);
    upper = lower + dataSize - 1; 
    int testID = (int)Math.floor(Math.random()*(upper-lower+1)+lower);
    AccessAVLApp.startRange = lower ; 
    AccessAVLApp.endRange = upper ; 
  }
  
  // Gets randomly picked student ID (in the range) for testing from AccessAVLApp
  static public String fetchRanID() {
    int testID = (int)Math.floor(Math.random()*(upper-lower+1)+lower);
    return AccessAVLApp.getRanID(testID) ; 
  }

  public static void main (String args[]) {
    int testnum = 1 ; 
    // Setting up for testing
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter the size of the dataset to generate a test.");
    int idata = Integer.parseInt(userInput.nextLine());
    setFileRange(idata);
    AccessAVLApp.main(null);
    System.out.println(" ");
    
    while (1>0) {
    
       opCount = 0 ;
       AccessAVLApp.printAllStudents();
       System.out.println(" "); 
       System.out.println("TEST "+testnum+":");
       System.out.println("Dataset size = "+idata+", Range = ["+lower+"-"+upper+"]" );
       
       //Testing print all students
       System.out.println("Print all :") ; 
       System.out.println("- AccessAVLApp = " + opCount); 
       
       //Testing finding a student name
       opCount = 0 ; 
       input = fetchRanID() ;
       System.out.println("Finding ["+input+"] :") ;
       AccessAVLApp.printStudent(input);
       System.out.println("- AccessAVLApp = "+opCount); 

       //Testing finding a student with invalid search
       opCount = 0 ; 
       System.out.println("Finding with invalid [xyzabc012] :") ;
       AccessAVLApp.printStudent("xyzabc012");
       System.out.println("- AccessAVLApp = "+ opCount); 
       System.out.println(" ") ; 
       
       // Reseting for next test
       AccessAVLApp.resetAVL() ;
       AccessAVLApp.printAllStudents();
       testnum++;
       opCount=0 ; 
       System.out.println("Enter the size of the dataset ");
       idata = Integer.parseInt(userInput.nextLine());
       setFileRange(idata);
       AccessAVLApp.main(null);
    } 
  }
}