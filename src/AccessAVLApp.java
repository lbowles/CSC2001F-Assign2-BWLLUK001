import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 

/**
* The AccessAVLApp program generates a test to find number operations to performe tasks 
* by the AVL Trees running over the inputed incremental data set size 10 times.
* 
* @author Luke Bowles
* @version 1.4
*/
public class AccessAVLApp  {

  /**
  * Lower bound of data set.
  */
  public static int startRange = 0 ; 
  /**
  * Upper bound of data set.
  */
  public static int endRange = 4999 ;

  /**
  * Decaring AVL Tree to store line items from the text file.
  */
  static public AVLTree<String> avl = new AVLTree<String> (); 
  
  /**
  * Stored inputted line items from the text file used for
  * testing AVLTree. 
  */
  public static String[] listArr = new String[5000]; 
  
  /**
  * Prints out the content in the AVL Tree.
  */
  static void printAllStudents () {
    avl.treeOrder ();
  }
  
  /**
  * Prints out the student name coresponding to an inputted student ID.
  *
  * @param studentID  The students ID.
  */
  static void printStudent(String studentID) {
  if (avl.find(studentID) != null ){
      System.out.println(avl.find(studentID).data.toString().substring(10));
      } else {
      System.out.println("Access denied!");
      }
  }
  
  /**
  * Fetches student ID from listArr at the inputted array index.
  *
  * @param pos  The index of an item in listArr. 
  *  
  * @return  Student ID 
  */
  static public String getRanID(int pos) {
      return listArr[pos] ; 
  }
  
  /**
  * Deletes all items in the AVL Tree
  *
  */
  public static void resetAVL() {
    for (int c = startRange ; c <= endRange ; c=c+1) {
      avl.delete(listArr[c]) ; 
    }
  }
  
  /**
  * Read the text file and insert the items into the AVL Tree
  *
  * @param args  main arguments.
  */
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