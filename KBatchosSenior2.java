// NAME             :   Kayleigh Batchos
// GROUP            :   APCS
// LAST MODIFIED    :   4 JUNE 2018
// PROBLEM ID       :   Trees 2008 Senior
// DESCRIPTION      :   Program that takes a string and
//                  :   puts it into a binary tree and
//                  :   prints it in reverse row order
// SOURCES/HELPERS  :   Mr. H., Paul Balko, Thomas Outinen

import java.util.Scanner;

public class KBatchosSenior2 
{
	public static void main(String[] args)
	{
		//Signature
		System.out.println("Kayleigh Batchos\nAPCS\nSenior 2008\n\n");
		
		String input, output = "";
		char side;
		int num;
		String[] bro = new String[3];
		Scanner scan = new Scanner(System.in);

		for(int k = 0; k < 5; k++)
		{
			//Reseting the new tree
			BSTree tree = new BSTree();
			
			//Gathering input
			System.out.print("Enter a string:  ");
			input = scan.nextLine();
			bro = input.split(", ");

			for(int p = 0; p < bro[0].length(); p++)
			{
				tree.add(Character.valueOf(bro[0].charAt(p)));
			}
			System.out.print((k+1) + ". ");
			tree.reverseRowOrder();
			System.out.print("\n\n");
		}
	}
}
class TreeNode
{
	private Object value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode (Object initValue, TreeNode initLeft, TreeNode initRight)
	{
		value = initValue;
		left = initLeft;
		right = initRight;
	}
	public Object getValue()
	{
		return value;
	}
	public TreeNode getLeft()
	{
		return left;
	}
	public TreeNode getRight()
	{
		return right;
	}
	public void setValue(Object newValue)
	{
		value = newValue;
	}
	public void setLeft(TreeNode newLeft)
	{
		left = newLeft;
	}
	public void setRight(TreeNode newRight)
	{
		right = newRight;
	}
}
class BSTNode extends TreeNode
{
	//-----------------------------------------------------------------
	//  Initializes this node.
	//-----------------------------------------------------------------
	public BSTNode (Comparable data)
	{
		super (data, null, null);
	}
}
class BSTree
{
	public BSTNode root;

	//-----------------------------------------------------------------
	//  Sets up an empty binary search tree.
	//-----------------------------------------------------------------
	public BSTree ()
	{
		root = null;
	}

	//-----------------------------------------------------------------
	//  Adds an element to the tree in its proper place.
	//-----------------------------------------------------------------
	public void add (Comparable obj)
	{
		BSTNode newNode = new BSTNode(obj);

		// If this is the first node to be added, make it the root.
		if (root == null)
			root = newNode;
		else
			addNode (root, newNode);
	}
	private void addNode (BSTNode current, BSTNode newNode)
	{
		if ( ((Comparable)(newNode.getValue())).compareTo (current.getValue()) <= 0 )
		{
			if (current.getLeft() == null)
				current.setLeft(newNode);
			else
				addNode ((BSTNode)current.getLeft(), newNode);
		}
		else
		{
			if (current.getRight() == null)
				current.setRight(newNode);
			else
				addNode ((BSTNode)current.getRight(), newNode);
		}
	}
	
	//The reverse row order method
	public void reverseRowOrder()
	{
		int h = treeDepth(root);
		for(int i = h; i >=1; i--)
		{
			printLevel(root, i);
		}
	}
	
	//Prints the level of the tree
	public void printLevel(TreeNode node, int level)
	{
		if(node == null)
			return;
		if(level ==1)
			System.out.print(node.getValue());
		else if(level > 1)
		{
			printLevel(node.getLeft(), level-1);
			printLevel(node.getRight(), level-1);
		}
	}
	
	//Calculates the depth
	public int treeDepth(TreeNode cur)
	{
		if(cur == null)
			return 0;

		int lDepth = treeDepth(cur.getLeft());
		int rDepth = treeDepth(cur.getRight());
		if(lDepth > rDepth)
			return(lDepth + 1);
		else
			return(rDepth + 1);
	}
}
