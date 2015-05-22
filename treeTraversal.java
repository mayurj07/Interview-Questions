// program to implement a binary serach tree.
// includes:
// 1. adding nodes to the tree (displays message when duplicate node is input)
// 2. tree traversals (in-order, pre-order, post-order)
// 3. object search (BFS, DFS)
// 4. converts tree toString, in-order format
public class treeTraversal{
	
	node root;
	
	public class node
	{
		node left;
		node right;
		Object data;
		
		// default node constructor
		// sets everything to null
		public node()
		{			
		}
		
		// parameterized constructor
		// sets the new node's data value to inputData
		public node(int inputData)
		{
			data = inputData; 
			left = null;
			right = null;
		}
	}
	
	// default tree constructor
	//creates a new root node and sets all its configs to null
	public treeTraversal()
	{
		root = new node();
	}
	
	// parameterized tree constructor
	// create a tree node, with no children and null links, with value input
	public treeTraversal(int input)
	{
		root = new node(input);
	}
	
	// does not allow user to add duplicate values <binary tree rule>
	// checks for the order of the input value and adds it at appropriate position. 
	public void addToTree(int inputVal)
	{
		if (root == null)
		{
			root = new node(inputVal);
			return;
		}
	
		node temp = root;
		node tempp;
		while(true)
		{
			tempp = temp;
			if((int)temp.data > inputVal)
			{
				temp = temp.left;
				if(temp == null)
				{
					tempp.left = new node(inputVal);
					return;
				}				 
			}
			
			else if((int)temp.data < inputVal)
			{
				temp = temp.right;
				if(temp == null)
				{
					tempp.right = new node(inputVal);
					return;
				}		
			}
			
			else
			{
				System.out.println("Input Value already exists, hence value: " +inputVal +" cannot be added to the binary tree");
				return;
			}			
		}
	}
	
	@Override
	public String toString()
	{
	return toString(this.root);	
	}
	
	// return in-order traversal string of the tree.
	public String toString(node start)
	{
		 if (start == null) 
		 {
		        return null;
		 }
		 
		 return "[" + toString(start.left) + "," + start.data + "," + toString(start.right) + "]";
	}
	
	public static void main(String[] args)
	{
		
		treeTraversal bTree = new treeTraversal(5);
		bTree.addToTree(1);
		bTree.addToTree(4);
		bTree.addToTree(4);
		bTree.addToTree(3);
		bTree.addToTree(7);
		
		System.out.println(bTree.toString());
		
		
	}
	
	
}
