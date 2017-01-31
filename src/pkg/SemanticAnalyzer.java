package pkg;

public class SemanticAnalyzer {

	public void typeChecking(SimpleNode tree) 
	{
		String n;
		if (tree.children != null) 
		{
			for (int i = 0; i<tree.children.length; ++i) 
			{
				typeChecking((SimpleNode) tree.children[i]);
				
				if (tree.children[i].toString().equals("LHS")) 
				{
					System.out.println(tree.children[i].jjtGetChild(0).getType());
					System.out.println(tree.children[i+1].jjtGetChild(0).jjtGetChild(0).getType());
					System.out.println(tree.children[i+1].jjtGetChild(1).jjtGetChild(0).getType());	
					if(tree.children[i].jjtGetChild(0).getType().equals(tree.children[i+1].jjtGetChild(0).jjtGetChild(0).getType())
							&& tree.children[i].jjtGetChild(0).getType().equals(tree.children[i+1].jjtGetChild(1).jjtGetChild(0).getType()))
						System.out.println("Successful !");
					else
						System.out.println("Unsuccessful !");
				}
			}
		}
	}

}