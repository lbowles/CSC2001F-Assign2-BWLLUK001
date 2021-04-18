// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   public BinaryTree ()
   {
      root = null;
   }
   
   public int getHeight ()
   {
      return getHeight (root);
   }   
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++; 
      if (node == null){
         return -1;
      }
      else {
         TestAVL.opCount++; 
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
      }
   }
   
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++; 
      if (node == null) {
         return 0;
      }
      else { 
         TestAVL.opCount++; 
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
      }
   }
   
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++; 
      if (node != null)
      {  
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++; 
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   public void inOrder ()
   {
      inOrder (root);
   }
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

   public void levelOrder ()
   {
      TestAVL.opCount++; 
      if (root == null) {
         return;
      }
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      TestAVL.opCount++; 
      while ((node = q.getNext ()) != null)
      {  
         TestAVL.opCount++;
         visit (node);
         TestAVL.opCount++; 
         if (node.getLeft () != null) {
            q.enQueue (node.getLeft ());
            }
         TestAVL.opCount++; 
         if (node.getRight () != null) {
            q.enQueue (node.getRight ());
            }
      }
   }
}
