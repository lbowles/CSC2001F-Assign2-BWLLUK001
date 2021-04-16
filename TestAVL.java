// Generates a test of the AVL by running the inputed incremental data set size 10 times

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
    // Setting up for testing
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter the increment size of the dataset to generate a test.");
    int ibaseData = Integer.parseInt(userInput.nextLine());
    int idata = ibaseData ; 
    setFileRange(idata);
    AccessAVLApp.main(null);
    System.out.println(" ");
    
    int[] arrAll = new int[10] ; 
    int[] arrFind = new int[10] ;
    int[] arrFindInv = new int[10] ;
    String[] arrRanges = new String[10] ; 
    
    System.out.println(lower +"  " +upper) ; 
    for (int i=0;i<10;i++) {
       
       //Recording Range 
       arrRanges[i] = "["+lower+"-"+upper+"]" ; 
       
       opCount = 0 ;
       //Testing print all students
       AccessAVLApp.printAllStudents(); 
       arrAll[i] = opCount;
       
       //Testing finding a student name
       opCount = 0 ; 
       input = fetchRanID() ;
       AccessAVLApp.printStudent(input);
       arrFind[i] = opCount;

       //Testing finding a student with invalid search
       opCount = 0 ; 
       AccessAVLApp.printStudent("xyzabc012");
       arrFindInv[i] = opCount;
       
       // Reseting for next test
       AccessAVLApp.resetAVL() ;
       opCount=0 ; 
       idata = idata+ibaseData ; 
       setFileRange(idata);
       AccessAVLApp.main(null);
    } 
    
    System.out.println(" "); 
    System.out.println("TEST RESULTS");
    System.out.println(" "); 
    
    //Print Ranges
    System.out.println("Data Set Ranges :");
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print(arrRanges[i]); 
      } else {
         System.out.print(arrRanges[i]+", "); 
      }
    }
    
    //Print all results
    System.out.println(" "); 
    System.out.println(" "); 
    System.out.println("Print All Results:") ;
    int imin = 10000 ; 
    int imax = 0 ;
    double davg = 0 ;
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print(arrAll[i]); 
      } else {
         System.out.print(arrAll[i] +", ");
      } 
      if (arrAll[i] < imin) {
         imin = arrAll[i];
      } 
      if (arrAll[i] > imax) {
         imax = arrAll[i];
      } 
      davg = davg + arrAll[i] ;         
    } 
    davg = davg/10 ;
    System.out.println(" "); 
    System.out.println("Min = "+imin+", Max = "+imax+", Avg = "+davg); 
    imin = 10000 ;
    imax = 0 ;
    davg = 0 ; 
    

    //Print finding a student name 
    System.out.println(" "); 
    System.out.println("Finding Student Name With Random ID Results") ;
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print(arrFind[i]); 
      } else {
         System.out.print(arrFind[i] +", ");
      } 
      if (arrAll[i] < imin) {
         imin = arrFind[i];
      } 
      if (arrAll[i] > imax) {
         imax = arrFind[i];
      } 
      davg = davg + arrFind[i] ;     
    }
    davg = davg/10 ;
    System.out.println(" "); 
    System.out.println("Min = "+imin+", Max = "+imax+", Avg = "+davg); 
    imin = 10000 ;
    imax = 0 ;
    davg = 0 ; 

    //Print finding a student with invalid search
    System.out.println(" ");
     System.out.println("Finding Student Name With Invalid ID Results :") ;
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print(arrFindInv[i]); 
      } else {
         System.out.print(arrFindInv[i] +", ");
      }
      if (arrAll[i] < imin) {
         imin = arrFindInv[i];
      } 
      if (arrAll[i] > imax) {
         imax = arrFindInv[i];
      } 
      davg = davg + arrFindInv[i] ;     
    }
    davg = davg/10 ;
    System.out.println(" "); 
    System.out.println("Min = "+imin+", Max = "+imax+", Avg = "+davg); 
    
  }
}