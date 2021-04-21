// ** Author : Luke Bowles BWLLUK001
// ** Created : 16 April 2020
// ** Reading and proforming operation from AVL data structor. 
import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 


public class AccessAVLApp  {

  // Declaring Varibles 
  public static int startRange = 0 ; 
  public static int endRange = 4999 ;

  // Decaring array for text line items (for getting random ids for testing)
  public static String[] listArr = new String[5000]; 
  
  // Decaring AVL for text line items
  static public AVLTree<String> avl = new AVLTree<String> (); 
  
  // Prints all line items from AVL ordered 
  static void printAllStudents () {
    avl.treeOrder ();
  }
  
  // Prints student name found with thier student ID
  static void printStudent(String studentID) {
  if (avl.find(studentID) != null ){
      System.out.println(avl.find(studentID).data.toString().substring(10));
      } else {
      System.out.println("Access denied!");
      }
  }
  
  // Returns a random student ID for Testing
  static public String getRanID(int pos) {
      return listArr[pos] ; 
  }
  
  // Reset AVL
  public static void resetAVL() {
    for (int c = startRange ; c <= endRange ; c=c+1) {
      avl.delete(listArr[c]) ; 
    }
  }
  
  

  public static void main (String args[]) {
    // Read the file     
    int i = 0 ; 
    try {
      File oklist = new File("oklist.txt");
      Scanner myInput = new Scanner(oklist);
      while (myInput.hasNextLine()){
      String data = myInput.nextLine();
         if (i >= startRange  && i <= endRange ) {
            avl.insert(data) ;   // Adding file lines to AVL
            listArr[i] = data ; // Adding file lines to array 
         }
         i++ ;
      }
      myInput.close();
    } catch (FileNotFoundException e) {
      System.out.println("Reading File Failed.");
      e.printStackTrace();
    }
  } 
}