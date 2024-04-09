package com.sourav.spring_jdbc;
import java.util.*;
public class MainContainer extends CRUD{
	public static void main( String[] args )
    {
		Scanner in=new Scanner(System.in);
		MainContainer ob=new MainContainer();
		char ch='y';
		int chc;
		while(ch=='y' || ch=='Y') 
		{
			System.out.println("****************---->>>>IPL Players<<<<----*****************");
			System.out.println("Press:");
			System.out.println("1. To add a new player in the database");
			System.out.println("2. To delete a player from the database");
			System.out.println("3. To update player information in the database");
			System.out.println("4. To display all the records from the database");
			System.out.println("Enter your choice!");
			chc=in.nextInt();
			in.nextLine(); // Consume the newline character
			switch(chc)
			{
				case 1:
					ob.insert();
					break;
				case 2:
					ob.delete();
					break;
				case 3:
					ob.update();
					break;
				case 4:
					ob.displayAll();
					break;
				default:
					System.out.println("Wrong choice, please enter again !");
			}
			System.out.println("Press y/Y to use again !");
			ch=in.nextLine().charAt(0);
		}
	}
}