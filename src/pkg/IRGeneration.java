package pkg;

public class IRGeneration 
{
	static int w = 0;
	static String right = " ";
	String t0,t1,t2,t3,t4;

	public String InterMedCode(SimpleNode tree)
	{
		if (tree.children != null) 
		{
			for (int i = 0; i < tree.children.length; ++i) 
			{
				SimpleNode n = (SimpleNode) tree.children[i];
				if (n != null) 
				{
					InterMedCode(n);
					if (n.jjtGetValue() != null)
					{
						if(n.jjtGetValue().toString().equals("+") || n.jjtGetValue().toString().equals("-")|| n.jjtGetValue().toString().equals("*")|| n.jjtGetValue().toString().equals("/"))
						{
//							System.out.println(n.jjtGetChild(0).jjtGetChild(0).jjtGetValue());
//							System.out.println(n.jjtGetValue());
//							System.out.println(n.jjtGetChild(1).jjtGetChild(0).jjtGetValue());
							
							if(n.jjtGetChild(0).jjtGetChild(0).jjtGetValue()!=null && n.jjtGetChild(1).jjtGetChild(0).jjtGetValue()!=null)
							{
								right +="\n"+ "t" + w + ": " + n.jjtGetChild(0).jjtGetChild(0).jjtGetValue() + n.jjtGetValue() + n.jjtGetChild(1).jjtGetChild(0).jjtGetValue();
								
							}
							else if(n.jjtGetChild(0).jjtGetChild(0).jjtGetValue()==null && n.jjtGetChild(1).jjtGetChild(0).jjtGetValue()!=null)
							{
								right +="\n"+ "t" + w + ": " + "t" + (w-1) + n.jjtGetValue() + n.jjtGetChild(1).jjtGetChild(0).jjtGetValue();
							}
							w++;
						}
												
					}
				}
			}
		}

		return right;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void assemblyCode() {
		System.out.println("Include Irvine32.inc");
		System.out.println(".data");
		System.out.println("count dword ?");
		System.out.println("xyz dword ?");
		System.out.println("abc dword ?");
		System.out.println("result dword ?");

		System.out.println(".code");
		System.out.println("main PROC");
		System.out.println("mov eax,t1");
		System.out.println("add eax,t2");
		System.out.println("sub eax,t2");
		System.out.println("mul eax,2");

		System.out.println("call crlf");
		System.out.println("main ENDP");
		System.out.println("END main");

	}
}	