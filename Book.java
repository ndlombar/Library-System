package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;


public class Book

{

     //Declaring all member variables
     private String title = "";
     private String author;
     private String description;
     private String currentRenter;
     private String yearWritten;
     private String bookID;
     private String historyOfRenters;
     private String checkoutDate;
     private String returnDate;
     private String overdraftFee;


     public Book(String name, String auth, String desc, String currentRent, String year, String ID,
    		 String history, String checkout, String dateOfReturn, String fee) throws FileNotFoundException

     {

    	 //Assigning variables from constructor
    	 title = name;
    	 author = auth;
    	 description = desc;
         currentRenter = currentRent;
         yearWritten = year;
         bookID = ID;
         historyOfRenters = history;
         checkoutDate = checkout;
         returnDate = dateOfReturn;
         overdraftFee = fee;
         

         //Writing all information to a file for state persistence
         PrintWriter out = new PrintWriter("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + title + ".txt");
         
         out.println("Book");
         out.println(name);
         out.println(auth);
         out.println(desc);
         out.println(currentRent);
         out.println(year);
         out.println(ID);
         out.println(history);
         out.println(checkout);
         out.println(dateOfReturn);
         out.println(fee);   
         
         
         
         
         out.close();
     }
     
     public Book() {
    	 
     }

     //Returns true if the book is available
     public boolean available(String nameOfBook) {
    	 if ("null".equals(currentRenter)) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 } 	 
     }
     
     //Simulates checking out a book given the name of the student that is renting it
     public void checkOutBook(String nameOfBook, String nameOfStudent) throws IOException {
    	 
    	 //Created a date based on the local time and edits both files to reflect the check out
		 LocalDateTime now = LocalDateTime.now();  
		 
		 String currentDate = now.toString();
		 checkoutDate = currentDate;
		 String returnDate = now.plusDays(14).toString();
		 
		 
		 
		 
		 //Finding the student
		 File dir = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + nameOfStudent + ".txt");
		 Scanner s = new Scanner(dir);
		 
         String occupation = s.nextLine();
         String studentName = s.nextLine();
         String studentPass = s.nextLine();
         String currentBooks = s.nextLine();
         String rentalHistory = s.nextLine();
         
         Student testing = new Student();
         Student checkingOut = new Student(studentName, testing.decrypt(studentPass), title,
        		 rentalHistory +", " + title);
         
         s.close();
         
         File newFile = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + nameOfBook+ ".txt");
		 Scanner r = new Scanner(newFile);
		 
		 occupation = r.nextLine();
		 title = r.nextLine();
    	 author = r.nextLine();
    	 description = r.nextLine();
         currentRenter = r.nextLine();
         yearWritten =r.nextLine();
         bookID = r.nextLine();
         historyOfRenters = r.nextLine();
         checkoutDate = r.nextLine();
         String unused = r.nextLine();
         overdraftFee = r.nextLine();
         
         r.close();
         
         Book nameOfBookToCreate = new Book(title, author, description, nameOfStudent, yearWritten, bookID,
	    		  historyOfRenters + ", " + nameOfStudent, currentDate, returnDate, overdraftFee);
         
		 
		 System.out.println(title + " has been checked out by "+ nameOfStudent + ". It is due " + returnDate);
	     }
   
     
     public void checkInBook(String bookTitle, String studentNameOfFile) throws IOException {
    	 
    	 //Checks if the book is overdue, if so, it charges the student based on the overdraft fee
    	 //Also edits both files to reflect the change
		 LocalDateTime now = LocalDateTime.now();  
		 String currentDate = now.toString(); 
		 String returnDate1 = "";
		 
		 File file = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\"+ bookTitle + ".txt");
	     Scanner r = new Scanner(file);
	     
	        for(int i = 0; i < 10; i++) {
	        	returnDate1 = r.nextLine();
	        }
		 
		 LocalDateTime deadline = LocalDateTime.parse(returnDate1);

		 if(deadline.isAfter(now)) {
			 System.out.println("You successfully checked in the book");
		 }
		 else {
			 System.out.println("Your book is late. You now owe " + overdraftFee);
		 }
         
		 Book nameOfBook = new Book(title, author, description, "null", yearWritten, bookID,
	    		  historyOfRenters, "null", "null", overdraftFee);
		 
		 
		 
		 File dir = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + studentNameOfFile + ".txt");
		 Scanner s = new Scanner(dir);
		 
         String occupation = s.nextLine();
         String studentName = s.nextLine();
         String studentPass = s.nextLine();
         String currentBooks = s.nextLine();
         String rentalHistory = s.nextLine();
         
         Student testing = new Student();
         Student checkingIn = new Student(studentName, testing.decrypt(studentPass), "null",
        		 rentalHistory);
         
         s.close();
        	 
     }
}