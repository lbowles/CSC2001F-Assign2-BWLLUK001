/**
 * Hussein's AVL Tree 
 * reference: kukuruku.co/post/avl-trees/
 *
 * @author Hussein Suleman
 */
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
    * Gets the height of the Binary Tree node. 
    *
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return int  The Hieght of the tree or -1 if empty.
    */
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
    * Finds the amount between the right and left node height. 
    *
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return int  Difference between the right node and left node.
    */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {  
      return height (node.right) - height (node.left);
   }
   
   /**
    * Sets the node height to one bigger than the largest node. 
    *
    * @param node  BinaryTreeNode with specified datatype.
    */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {  
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
    * Rotates a brach right. 
    *
    * @param p  BinaryTreeNode with specified datatype.
    *
    * @return  The newly rotated right node.
    */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   /**
    * Rotates a brach left. 
    *
    * @param q  BinaryTreeNode with specified datatype.
    *
    * @return  The newly rotated left node.
    */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
    * Balances the Binary Tree. 
    *
    * @param p  BinaryTreeNode with specified datatype.
    *
    * @return  The newly balanced Binary Tree.
    */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
       
      if (balanceFactor (p) == 2)
      {
       
         if (balanceFactor (p.right) < 0) {
            p.right = rotateRight (p.right);
            }
         return rotateLeft (p);
      }
       
      if (balanceFactor (p) == -2)
      {
       
         if (balanceFactor (p.left) > 0) {
            p.left = rotateLeft (p.left);
            }
         return rotateRight (p);
      }
      return p;
   }
   
   /**
    * Adds an inputed item into the tree. 
    *
    * @param d  Inputed datatype.
    */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**
    * Inserts an inputed item into the left or right branch of the tree. 
    *
    * @param d  Inputed datatype.
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return  The balanced tree with the item inserted. 
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
       
      TestAVL.opCount++;  
      if (node == null) {
         return new BinaryTreeNode<dataType> (d, null, null);
         }
      TestAVL.opCount++;
      if (d.compareTo (node.data) <= 0) {
      
         node.left = insert (d, node.left);
         }
      else {
         TestAVL.opCount++;
         node.right = insert (d, node.right);
         }
      return balance (node);
   }
   
   /**
    * Deletes an item from the tree. 
    *
    * @param d  Inputed datatype.
    */
   public void delete ( dataType d )
   {  
      root = delete (d, root);
   } 
   /**
    * Deletes an inputed item from the left or right branch of the tree. 
    *
    * @param d  Inputed datatype.
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return  The balanced tree with the item removed. 
    */  
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
       
      if (node == null) return null ;
       
      if (d.compareTo (node.data) < 0) { 
         node.left = delete (d, node.left);
      }   
      else if (d.compareTo (node.data) > 0) {
           
         node.right = delete (d, node.right);
      } 
      else
      {
           
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
          
         if (r == null) { 
            return q;
         }
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   /**
    * Finds the last node 
    *
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return  The tree. 
    */  
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
       
      if (node.left != null) { 
         return findMin (node.left);
         }
      else {
           
         return node;
         }
   }
   
   /**
    * Removed the minimum node from the tree.
    *
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return  Balanced tree with the minimum node removed. 
    */  
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
       
      if (node.left == null) {
         return node.right;
         }
      node.left = removeMin (node.left);
      return balance (node);
   }
   
   /**
    * Finds an item in the tree.
    *
    * @param d  Specified datatype.
    *
    * @return  The found item. 
    */ 
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null) {
         return null;
         }
      else { 
         return find (d, root);
         }
   }
   /**
    * Finds if an item is in the tree.
    *
    * @param d  Specified datatype.
    * @param node  BinaryTreeNode with specified datatype.
    *
    * @return  The corresponding item in the tree. 
    */ 
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++; 
      if (d.compareTo (node.data) == 0) {
         return node;
         }
      else if (d.compareTo (node.data) < 0) {
         TestAVL.opCount++; 
         return (node.left == null) ? null : find (d, node.left); 
         }
      else {
         TestAVL.opCount++; 
         return (node.right == null) ? null : find (d, node.right); 
         }
   }
   
   /**
    * Reorders the tree. 
    */ 
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /**
    * Reorders all the items in the tree at a given level.
    *
    * @param level  The level at which it must be ordered. 
    * @param node  BinaryTreeNode with specified datatype.
    */ 
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
       
      if (node != null) 
      {
          
         for ( int i=0; i<level; i++ )
         System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

