// NAME             :   Kayleigh Batchos
// GROUP            :   APCS
// LAST MODIFIED    :   4 JUNE 2018
// PROBLEM ID       :   Trees 2005 Senior
// DESCRIPTION      :   Program that takes a string and
//                  :   puts it into a binary tree
//                  :   and calculates depth, leafs, ipl and epl.
//                  :   if they are equal.
// SOURCES/HELPERS  :   Mr. H., Paul Balko, Thomas Outinen
import java.util.Scanner;

public class KBatchosSenior1 
{
	public static void main(String[] args)
	{
		//Signature
		System.out.println("Kayleigh Batchos\nAPCS\nSenior 2005\n\n");
		
		//Declaring variables
		String input;
		char side;
		int leafs, depth, ext, ipl, epl;
		String[] bro = new String[3];
		Scanner scan = new Scanner(System.in);
		BSTree tree = new BSTree();
		
		//Gathering input
		System.out.print("Enter a string:  ");
		input = scan.next();
		bro = input.split(",");
		System.out.print("\n");

		//Reading it in to the tree
		for(int p = 0; p < bro[0].length(); p++)
		{
			tree.add(Character.valueOf(bro[0].charAt(p)));
		}

		//Outputting
		depth = tree.treeDepth() - 1; 
		System.out.println("Depth = " + depth);
		leafs = tree.leafNodes();
		System.out.println("Leaf nodes = " + leafs);
		ext = tree.extNodes();
		System.out.println("External nodes = " + ext);
		ipl = tree.IPL();
		System.out.println("Internal path length = " + ipl);
		epl = ipl + (2*bro[0].length());
		System.out.println("External path length = " + epl);
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
	public int extNodes;

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

	//-----------------------------------------------------------------
	//  Recursive procedure that adds a node to the binary search
	//  tree.
	//-----------------------------------------------------------------
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

	//Returns a string representing the tree
	public String inOrder()
	{
		return inOrder(root);
	}

	//Returns a string representing the subtree rooted at the given node
	private String inOrder (TreeNode current)
	{
		String str = "";

		if (current.getLeft() != null)
			str += inOrder(current.getLeft()) + "\n";

		str += current.getValue();

		if (current.getRight() != null)
			str += "\n" + inOrder(current.getRight());

		return str;
	}
	public int treeDepth()
	{
		return treeDepth(root);
	}
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
	
	//Finding the leaf nodes
	public int leafNodes()
	{
		return leafNodes(root);
	}
	
	public int leafNodes(TreeNode node)
	{
		if(node == null)
			return 0;
		if(node.getLeft() == null && node.getRight() == null)
			return 1;
		else
			return leafNodes(node.getLeft()) + leafNodes(node.getRight());
	}
	
	//Finding the the external nodes
	public int extNodes()
	{
		extNodes = 0;
		return extNodes(root);
	}
	
	public int extNodes(TreeNode node)
	{
		if(node == null)
			return 0;
		if(node.getLeft() == null && node.getRight() == null)
			return 2;
		else if(node.getLeft() == null)
			return 1 + extNodes(node.getRight());
		else if(node.getRight() == null)
			return 1 + extNodes(node.getLeft());
		else
			return extNodes(node.getLeft()) + extNodes(node.getRight());
	}
	
	//Returns internal path length
	public int IPL()
	{
		return IPL(root, 0);
	}
	
	public int IPL(TreeNode node, int curLevel)
	{
		if(node != null)
			return curLevel + IPL(node.getLeft(), curLevel+1) + IPL(node.getRight(), curLevel+1);
		else
			return 0;
	}
}
