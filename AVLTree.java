// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int height ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {  
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {  
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      TestAVL.opCount++;
      if (balanceFactor (p) == 2)
      {
      TestAVL.opCount++;
         if (balanceFactor (p.right) < 0) {
            p.right = rotateRight (p.right);
            }
         return rotateLeft (p);
      }
      TestAVL.opCount++;
      if (balanceFactor (p) == -2)
      {
      TestAVL.opCount++;
         if (balanceFactor (p.left) > 0) {
            p.left = rotateLeft (p.left);
            }
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;
      TestAVL.opCount++; 
      if (node == null) {
         return new BinaryTreeNode<dataType> (d, null, null);
         }
      if (d.compareTo (node.data) <= 0) {
         node.left = insert (d, node.left);
         }
      else {
         TestAVL.opCount++; 
         node.right = insert (d, node.right);
         }
      return balance (node);
   }
   
   public void delete ( dataType d )
   {  
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;
      if (node == null) return null ;
      TestAVL.opCount++;
      if (d.compareTo (node.data) < 0) { 
         node.left = delete (d, node.left);
      }   
      else if (d.compareTo (node.data) > 0) {
         TestAVL.opCount++; 
         node.right = delete (d, node.right);
      } 
      else
      {
         TestAVL.opCount++; 
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         TestAVL.opCount++;
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
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;
      if (node.left != null) { 
         return findMin (node.left);
         }
      else {
         TestAVL.opCount++; 
         return node;
         }
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      TestAVL.opCount++;
      if (node.left == null) {
         return node.right;
         }
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode<dataType> find ( dataType d )
   {
      TestAVL.opCount++;
      if (root == null) {
         return null;
         }
      else {
         TestAVL.opCount++; 
         return find (d, root);
         }
   }
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
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      TestAVL.opCount++;
      if (node != null) 
      {
         TestAVL.opCount++;
         for ( int i=0; i<level; i++ )
         System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

