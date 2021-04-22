/**
* Hussein's Binary Tree Node
*
* @author Hussein Suleman
*/


public class BinaryTreeNode<dataType>
{  
   /**
    * Datatype for Binary Tree node. 
    */
   dataType data;
   /**
    * Left Binary Tree Node. 
    */
   BinaryTreeNode<dataType> left;
   /**
    * Right Binary Tree Node.
    */
   BinaryTreeNode<dataType> right;
   /**
    * height of Binary Tree node 
    */
   int height;
   
   /**
    * Binary Tree Node. 
    *
    * @param d  datatype. 
    * @param l  Left Binary Tree node with specified datatype. 
    * @param r  Right Binary Tree node with specified datatype. 
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**
    * Gets left branch of the Binary Tree node. 
    *
    * @return  the left node.
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Gets left branch of the Binary Tree node. 
    *
    * @return  the right node.
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
