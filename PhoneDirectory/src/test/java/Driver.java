package test.java;

import main.java.PhoneDirectory;

import java.io.IOException;
import java.util.Scanner;
public class Driver extends PhoneDirectory{
	public Driver() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] s) throws IOException {
	   PhoneDirectory book = new PhoneDirectory();
	   
	   System.out.println("This is the current Phone Directory");
	   //prints current phonebook
	   book.print();
	   
	   int choice = 0;
	   Scanner inFile = new Scanner(System.in);
	   String name, number;
	  
	   do{ 
		   
		   System.out.println("Choose a number corresponding to desired request");
		   System.out.println("1 = add entry");
		   System.out.println("2 = delete entry");
		   System.out.println("3 = change entry");
		   System.out.println("4 = get number from entry");
		   System.out.println("5 = print new directory");
		   System.out.println("0 = exit program");
		   
		   choice = inFile.nextInt();
		   inFile.nextLine();
		   switch(choice){
		   case 1: //add
			   System.out.println("Enter new name");
			   name = inFile.nextLine();
			   name.trim();
			   System.out.println("Enter new number");
			   number = inFile.nextLine();
			   book.addEntry(name, number);
			   break;
	   
		   case 2: //delete
			   System.out.println("Enter the name you wish to delte");
			   name = inFile.nextLine();
			   name.trim();
			   book.deleteEntry(name);
			   break;
		   case 3: //change
			   System.out.println("Enter the name you wish to change");
			   name = inFile.nextLine();
			   name.trim();
			   System.out.println("Enter the number you wish to changer");
			   number = inFile.nextLine();
			   book.changeEntry(name, number);
			   break;
		   case 4: //get number
			   System.out.println("Enter the name you wish to recieve a number for and press enter");
			   name = inFile.nextLine();
			   name.trim();
			   System.out.println(book.getNumber(name));
			   break;
		   case 5: //print new phonebook
			   book.print();
			   break;
		   default:
			   break;
	   }
	   }while(choice != 0);	   
	   
	   inFile.close();
	}
}

