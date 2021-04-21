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
    System.out.println(" ");
    
    int[] arrInsert = new int[10] ; 
    int[] arrInsertS = new int[10] ; 
    int[] arrFind = new int[10] ;
    int[] arrFindInv = new int[10] ;
    String[] arrRanges = new String[10] ; 
    
    System.out.println(lower +"  " +upper) ; 
    for (int i=0;i<10;i++) {
    
       //Recording Range 
       arrRanges[i] = "["+lower+"-"+upper+"]" ; 
       
       //Testing Insert
       opCount = 0 ;
       setFileRange(idata);
       AccessAVLApp.main(null);
       arrInsert[i] = opCount;
       
       //Testing Insert Single Item
       opCount= 0 ; 
       AccessAVLApp.avl.insert("PWOOLU001 Olun Powell") ; 
       arrInsertS[i] = opCount;
        
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
       idata = idata+ibaseData ;
       AccessAVLApp.resetAVL() ; 
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
    
    //Inserting All results
    System.out.println(" "); 
    System.out.println(" "); 
    System.out.println("Insert All Results:") ;
    int imin = 10000 ; 
    int imax = 0 ;
    double davg = 0 ;
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print( arrInsert[i]); 
      } else {
         System.out.print( arrInsert[i] +", ");
      } 
      if ( arrInsert[i] < imin) {
         imin =  arrInsert[i];
      } 
      if ( arrInsert[i] > imax) {
         imax =  arrInsert[i];
      } 
      davg = davg +  arrInsert[i] ;         
    } 
    davg = davg/10 ;
    System.out.println(" "); 
    System.out.println("Min = "+imin+", Max = "+imax+", Avg = "+davg); 
    imin = 10000 ;
    imax = 0 ;
    davg = 0 ; 
    
    //Inserting one item
    System.out.println(" "); 
    System.out.println("Insert One Item Results:") ;
    for(int i=0;i<10;i++){
      if (i==9) {
         System.out.print( arrInsertS[i]); 
      } else {
         System.out.print( arrInsertS[i] +", ");
      } 
      if ( arrInsertS[i] < imin) {
         imin =  arrInsertS[i];
      } 
      if ( arrInsertS[i] > imax) {
         imax =  arrInsertS[i];
      } 
      davg = davg +  arrInsertS[i] ;         
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
      if ( arrFind[i] < imin) {
         imin = arrFind[i];
      } 
      if ( arrFind[i] > imax) {
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
      if ( arrFindInv[i] < imin) {
         imin = arrFindInv[i];
      } 
      if ( arrFindInv[i] > imax) {
         imax = arrFindInv[i];
      } 
      davg = davg + arrFindInv[i] ;     
    }
    davg = davg/10 ;
    System.out.println(" "); 
    System.out.println("Min = "+imin+", Max = "+imax+", Avg = "+davg); 
    
  }
}