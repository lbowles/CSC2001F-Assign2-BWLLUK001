/**
* Hussein's Binary Tree
*
* @author Hussein Suleman
*/
public class BinaryTree<dataType>
{
   /**
    * Declare Binary Tree Node. 
    */
   BinaryTreeNode<dataType> root;
   
   /**
    * Sets Binary Tree root to null
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Gets the height of the tree. 
    *
    * @return height of tree.
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   
   /** 
    *  Gets the height from the inputted Binary Tree node.
    *
    * @param node  Binary Tree Node with specified datatype. 
    *
    * @return int  Height of the tree.
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
        
      if (node == null){
         return -1;
      }
      else {
           
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
      }
   }
   
   
   /** 
    * Gets the size of the Binary Tree.
    *
    * @return int size of Binary Tree.
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   
   /** 
    * Calculates the size of the inputted Binary Tree node. 
    *
    * @param node Binary Tree node with specified datatype.
    *
    * @return int size of the Binary Tree node. 
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
        
      if (node == null) {
         return 0;
      }
      else { 
           
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
      }
   }
   
   
   /** 
    * Prints out the data in the tree. 
    *
    * @param node  Binary Tree node with specified datatype.
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   /**
    * Sets tree in pre order. 
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   
   /** 
    * Peparing for ordering on tree
    *
    * @param node  Binary Tree node with specified datatype.
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
        
      if (node != null)
      {  
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   /**
    * Sets tree in post order. 
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   
   /** 
    * Ording after preOrdering of tree. 
    *
    * @param node Binary Tree node with specified datatype.
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
        
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   
   /**
    * Sets tree in order. 
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /** 
    * Ordering of left and right nodes
    *
    * @param node Binary Tree node with specified datatype.
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;  
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   /** 
    * Re orders the Binary tree.
    */
   public void levelOrder ()
   {
        
      if (root == null) {
         return;
      }
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
        
      while ((node = q.getNext ()) != null)
      {  
          
         visit (node);

         if (node.getLeft () != null) {
             
            q.enQueue (node.getLeft ());
            }
         
         if (node.getRight () != null) {
              
            q.enQueue (node.getRight ());
            }
      }
   }
}
