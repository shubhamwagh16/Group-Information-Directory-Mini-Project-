package DSA_MIni;
import java.util.*;

//contains Group class and Node class 
public class GroupInformationDirectory {
	
	//creating class for group info
	class group
	{
		String leadname;
		String members[]=new String[7];
		String grpname;
		public group(String gnm, String l)
		{
		this.leadname=l;
		this.grpname=gnm;
		}
	}
	
	//creating node class (making it static)
	static class Node {
	    group data ;
	    Node next = null;

	    Node(group g) {
	        this.data = g;
	    }

	    Node() {

	    }

	    Node(group g, Node next) {
	        this.data = g;
	        this.next = next;
	    }

}
	
//linkedList Declaration	
LinkedList<Node> list = new LinkedList<Node>();
Scanner scn = new Scanner(System.in);
Node head=null;


//Adding single group
public void addGrp(Scanner sc) {
	
    sc.nextLine(); // NOTE: Added to 'consume' the new line character left over by sc.nextInt()
    try {
    	
    		if(head==null)
    		{
    			System.out.println("enter the name of your project group");
    	        String groupname = scn.nextLine();
    	        System.out.println("Enter Group lead Name");
    	        String lead=sc.nextLine();
    	        group grp1=new group(groupname,lead);
    	        System.out.println("members are");
    	        
    	        for(int i=0;i<7;i++)
    	        {
    	        	grp1.members[i]=sc.nextLine();
    	        }
    	        
    	        Node n1=new Node(grp1,null);
    	        
    	        head=n1;
    	        list.add(n1);
    	        
    		}
    		else
    		{
    			Node start=head;
    			while(start.next!=null)
    			{
    				
    				start=start.next;
    			}
    			System.out.println("enter the name of your project group");
    			String groupname = scn.nextLine();
    			System.out.println("Enter Group lead Name");
    	        String lead=sc.nextLine();
    			group grp1=new group(groupname,lead);
    	        System.out.println("members are  ");
    	        
    	        for(int i=0;i<7;i++)
    	        {
    	        	grp1.members[i]=sc.nextLine();
    	        }
    	        Node n1=new Node(grp1, null);
    	        start.next=n1;
    		}
    }catch (Exception e) 
    {
      System.out.println(e.toString());
    }
}
    		
 
//Printing all groups info
public void display() {
	Node start=head;
	while(start!=null)
	{
		group g1=start.data;
		System.out.println("Group Name = "+ g1.grpname+ "\nLeader Name = "+ g1.leadname+ "\nmembers are :");

		for(int i=0;i<7;i++)
		{
			System.out.println(g1.members[i]);	
		}
		start=start.next;
	}
}

//Function Call 
public static void main(String arg[]) {
    GroupInformationDirectory ll = new GroupInformationDirectory();
  
    int ch;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("\nWelcome to our Project... :)");
    do {
        System.out.println("\nEnter 1 to Add a new Group\nEnter 2 to Search a group\nEnter 3 to Display all groups\nEnter 0 to Exit.");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                ll.addGrp(sc);
                break;
            case 2:
                ll.group1();
                break;
            case 3:
            	ll.display();
            	break;
            case 0:
            	ll.exit();
            	break;
        }
    } while (ch != 0);
    sc.close();
}

//Searching Method for single Group
public void group1() {
	
		Node start=head;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Group Name to be Search");
		String search =sc.nextLine();
		
		while(start!=null)
		{
			group g1=start.data;
			if(g1.grpname.equals(search))
			{
				System.out.println("Group Name = "+ g1.grpname+ "\nLeader Name = "+ g1.leadname+ "\nmembers are :");
				for(int i=0;i<7;i++)
					{
						System.out.println(g1.members[i]);
					}
			return;
			}
			else{
			  start=start.next;
			}	
		}
		System.out.println("Invalid Group Name/please check correctly (its case sensitive) ");
}

//exit method
public void exit()
{
	System.out.println("thanks for using the code!!!");
}

}