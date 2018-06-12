/*
 * Nhi Tuong CSC3410 MW phonedir
 * 
 * PURPOSE:		To gain experience using Linked List and be able to use java library;
 * SOLUTION: 	Program creates a linked list that stores a contact object called contacts. 
 * 				The contacts class have methods that returns name and method that lets you 
 * 				change/manipulate names. The main class use a system.in to get user's input and 
 * 				use a switch statement to accept certain commands and execute those commands. 
 * 				it is put in a while loop, while true to continue printing out the commands until
 * 				input q(quit) is entered. 
 * DATA STRUCTURE: LINKED LIST
 * HOW TO USE: Execute command listed and follow the console output commands. Press q to quit. 
 * PURPOSE: CONTACT CLASS: create individual contact object to store name and phone number. and 
 * 							to edit/get information from object.
 * 			PHONEDIR CLASS: execute listed commands and perform specific algorithm to get desire results.
 * 
 * 
 */


package phonedir;
import java.util.*;

public class phonedir {

public static LinkedList<contacts> listRecords = new LinkedList<contacts>();
static String firstName, lastName, phoneNum;
public static int current = 0;


	public static void main(String[] args) {
        
		
        Scanner in = new Scanner(System.in);
        
        
        
        mainLoop: while (true) {
            
            System.out.println("   a.  Show all records");
            System.out.println("   d.  Delete the current record");
            System.out.println("   f.  Change the first name in the current record");
            System.out.println("   l.  Change the last name in the current record");
            System.out.println("   n.  Add a new record");
            System.out.println("   p.  Change the phone number in the current record");
            System.out.println("   q.  Quit");
            System.out.println("   s.  Select a record from the record list to become the current record.");
            System.out.println("Enter a command from the list above (q to quit): ");
            

            String command;
            while ( !in.hasNext("[adflnpqs]")) {
            	System.out.println("\nILLEGAL RESPONSE.  YOU MUST ENTER A LETTER.");
            	in.next();
            }
            command = in.next();
            
            
           
            switch(command){
            case "a":
            	printAllRecords();
            	displayCurrent();
            	continue;
            case "d":
            	deleteRecord();
            	continue;
            case "f":
            	System.out.println("Enter new first name: ");
            	listRecords.get(current).changeFirst(in.next());
            	displayCurrent();
            	continue;
            case "l":
            	System.out.println("Enter new last name: ");
            	listRecords.get(current).changeLast(in.next());
            	displayCurrent();
            	continue;
            case "n":
            	System.out.println("Enter first name: ");
            	firstName = in.next();
            	System.out.println("Enter last name: ");
            	lastName = in.next();
            	System.out.println("Enter phone number: ");
            	String pNum = in.next();
            	while (pNum.length() != 10){
            		System.out.println("Invalid phone number. Must be 10 characters.");
            		System.out.println("Enter phone number: ");
            		pNum = in.next();
   
            	} 
            	
            	listRecords.add(new contacts(firstName, lastName, pNum));
            	current++;
            	displayCurrent();
            	System.out.println("");
            	continue;
           	
            case "p":
            	System.out.println("Enter new phone number: ");
            	listRecords.get(current).changeNum(in.next());
            	displayCurrent();
            	continue;
            case "q":
            	System.exit(0);
            case "s":
            	System.out.print("Enter first name: ");
            	String f = in.next();
            	System.out.print("Enter last name: ");
            	String l = in.next();
            	changeRecord(f,l);
            	displayCurrent();
            	continue;
            
            }
            in.close();
        }
                 
	}
/*
 * precondition: must not be empty.
 * postcondition: delete object from linked list
 * 
 */
	public static void deleteRecord(){
		System.out.println("Deleted: " + listRecords.remove(current - 1));
		current = 0;
	}
/*
 * precondition: must not be empty.
 * postcondition: display all objects in linkedlist.
 * invariant: linked list objects
 */
	public static void displayCurrent(){
		
		System.out.println("Current record is: " + listRecords.get(current-1));
	}
/*
 * precondition: must not be empty
 * postcondition: print all objects in linked list.
 * invariant: objects
 */
	public static void printAllRecords() {
		if (current >= 0){
		System.out.println("");
        System.out.println("First Name      "
                + "Last Name      "
                + "Phone Number      "
        		);
        System.out.println("----------      "
                + "---------      "
                + "------------      "
                );
		for(int i = 0; i < listRecords.size(); i++){
		 System.out.println(listRecords.get(i));
		 }
     }else{
			System.out.println("Record is empty. ");
		
	}
	
	}
/*
 * precondition: must be strings
 * postcondition: change to desire current record.
 * 
 */
	public static void changeRecord(String f, String l){
		for (int i = 0; i < listRecords.size(); i++){
			if (listRecords.get(i).getFirstName().equals(f) &&
					listRecords.get(i).getLastName().equals(l)){
				current = i + 1;
			}
		}
	}

}
