import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BST<E extends Comparable <E>> {
	    //create the root
		protected TreeNode <E> root;
		
		//define or control the size
		protected int size = 0;
		
		//create default BST with empty brackets bcs
		public BST () {
			
		              }
		//create a BST from an array of objects
		public BST (E[] objects) {
	    
		for (int i =0; i < objects.length; i++)
		insert (objects [i] );
		                         }
        
		public boolean search (E e) {
		TreeNode<E> current = root ;
			
		while ( current != null ) {
		if (e.compareTo(current.element) < 0) {
				current = current.left;
				                                      }
			else if (e.compareTo(current.element) > 0) {
			current = current.right;
				                                           }
			else 
			return true;
			                         }
			return false;
		                            }
		//below method is to insert e in BST and return true if it's inserted successfully
		public boolean insert (E e)    {
					
		if ( root == null )
		root = createNewNode (e);
					
			else                         {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while ( current !=null)
			if (e.compareTo(current.element) < 0) {
			parent = current ;
			current = current.left;
							                                       }
			else if (e.compareTo(current.element) > 0) {
			parent = current;
			current = current.right;
							                                            }
		    else
			return false;
						
		//to create new nodes and attach them to parents
		if (e.compareTo(parent.element) < 0) //link to parent
		parent.left = createNewNode (e);
		else
		parent.right = createNewNode(e);
					}
		size++;    //add new level                                        
		return true; //if e successfully inserted
					                                               }
						
		protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<> (e);
		                                         }			
				
		//creating the inorder traversal from the root
		public void inorder ()  {
		inorder(root);
		                         }
		//inorder from subtree
		protected void inorder(TreeNode<E> root)  {
			if ( root ==null)
			return;
			inorder(root.left);
			System.out.print(root.element + " " );
			inorder(root.right);
		                                           }
		//postorder traversal from root
		public void postorder () {
		postorder(root);
		                         }
					
		//postorder from subtree
		protected void postorder(TreeNode<E> root) {
			if (root == null ) 
			return;
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.element + " ");
						
		                                            }
		//preorder traversal from root
		public void preorder() {
		preorder(root);
						
		                        }
		//preorder from subtree
		protected void preorder(TreeNode<E> root)  {
			if ( root ==null)
			return;
			System.out.print(root.element + " ");
			preorder(root.left);
			preorder(root.right);
		                                             }
		//children class to store the data
		public static class TreeNode<E extends Comparable <E>> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode <E> right;
						
		public TreeNode(E e) {
		element = e;
		                      }
					
		                                             			}
		public static void main(String[] args) throws IOException {
							
		BST<String> tree = new BST<>();
		// To Open the file
		FileInputStream fstream = new FileInputStream("C:\\Users\\User\\Desktop\\data.txt");
		//to read the file
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//to read File Line by Line
		while ((strLine = br.readLine()) != null)   {
		// calling insert method
		tree.insert(strLine);
		       
		                                            }

		//Close the file which i open
		br.close();		     
		//Traverse Tree
		System.out.print("Pre-order traversal  : ");
		tree.preorder();
		System.out.print("\nIn-order traversal   : ");
		tree.inorder();
		System.out.print("\nPost-order traversal : ");
		tree.postorder();				
	                                                                   }
					                        }