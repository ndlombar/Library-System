package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dustin Adkins, Duadkins, ID: 0003567195
 */
public class Librarian {

    //A Librarian consists of a name and password
    private String name = "";
    private String password = "";
    String encryptedPass = "";
    
    //Constructor takes a name and a password, writes a file containing
    //the occupation, name, and an encrypted password
    public Librarian(String title, String pass) throws IOException{
        
        name = title;
        password = pass;
        encryptedPass = encryptPassword(pass);
        
        PrintWriter out = new PrintWriter("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + title + ".txt");
        
        out.println("Librarian");
        out.println(title);
        out.println(encryptedPass);
        
        out.close();
        

        
            
            
            
    }
    
    //Encrypts the password with a simple code. Decrypt is the opposite
    public String encryptPassword(String original){
        
        String answer = "";
        int times = original.length();
        
        for(int i = 0; i < times; i++){
            char toReplace = original.charAt(i);
            
            switch (toReplace){
                case 'a': answer += "y";
                          break;
                case 'b': answer += "p";
                          break;
                case 'c': answer += "r";
                          break;
                case 'd': answer += "7";
                          break;
                case 'e': answer += "e";
                          break;
                case 'f': answer += "g";
                          break;
                case 'g': answer += "u";
                          break;
                case 'h': answer += "2";
                          break;
                case 'i': answer += "c";
                          break;
                case 'j': answer += "s";
                          break;
                case 'k': answer += "5";
                          break;
                case 'l': answer += "1";
                          break;   
                case 'm': answer += "a";
                          break;
                case 'n': answer += "d";
                          break;
                case 'o': answer += "b";
                          break;
                case 'p': answer += "4";
                          break;
                case 'q': answer += "m";
                          break;
                case 'r': answer += "h";
                          break;
                case 's': answer += "i";
                          break;
                case 't': answer += "n";
                          break;
                case 'u': answer += "x";
                          break;
                case 'v': answer += "z";
                          break;
                case 'w': answer += "o";
                          break;
                case 'x': answer += "3";
                          break;   
                case 'y': answer += "9";
                          break;
                case 'z': answer += "k";
                          break;
                case '0': answer += "w";
                          break;
                case '1': answer += "f";
                          break;
                case '2': answer += "j";
                          break;
                case '3': answer += "6";
                          break;
                case '4': answer += "t";
                          break;
                case '5': answer += "v";
                          break;
                case '6': answer += "8";
                          break;
                case '7': answer += "q";
                          break;   
                case '8': answer += "0";
                          break;
                case '9': answer += "l";
                          break;
                          
            }
        }
        
        return answer;
    }
    
    //De-codes an encrypted password
    public String decryptPassword(String original){
        
        String answer = "";
        int times = original.length();
        
        for(int i = 0; i < times; i++){
            char toReplace = original.charAt(i);
            
            switch (toReplace){
                case 'y': answer += "a";
                          break;
                case 'p': answer += "b";
                          break;
                case 'r': answer += "c";
                          break;
                case '7': answer += "d";
                          break;
                case 'e': answer += "e";
                          break;
                case 'g': answer += "f";
                          break;
                case 'u': answer += "g";
                          break;
                case '2': answer += "h";
                          break;
                case 'c': answer += "i";
                          break;
                case 's': answer += "j";
                          break;
                case '5': answer += "k";
                          break;
                case 'l': answer += "1";
                          break;   
                case 'a': answer += "m";
                          break;
                case 'd': answer += "n";
                          break;
                case 'b': answer += "o";
                          break;
                case '4': answer += "p";
                          break;
                case 'm': answer += "q";
                          break;
                case 'h': answer += "r";
                          break;
                case 'i': answer += "s";
                          break;
                case 'n': answer += "t";
                          break;
                case 'x': answer += "u";
                          break;
                case 'z': answer += "v";
                          break;
                case 'o': answer += "w";
                          break;
                case '3': answer += "x";
                          break;   
                case '9': answer += "y";
                          break;
                case 'k': answer += "z";
                          break;
                case 'w': answer += "0";
                          break;
                case 'f': answer += "1";
                          break;
                case 'j': answer += "2";
                          break;
                case '6': answer += "3";
                          break;
                case 't': answer += "4";
                          break;
                case 'v': answer += "5";
                          break;
                case '8': answer += "6";
                          break;
                case 'q': answer += "7";
                          break;   
                case '0': answer += "8";
                          break;
                case '1': answer += "9";
                          break;
                          
            }
        }
        
        return answer;
    }
    
    //Takes a Book and a String that represents the title of the book that needs
    //changed. This opens that file and creates a new book there
    
    public void modifyBook(String title, String modification,  String addition) throws FileNotFoundException{
    	
            //Gathering all data from the book file
    	    File file = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + title + ".txt");
            Scanner s = new Scanner(file);
            String occupation = s.nextLine();
            String name = s.nextLine();
            String auth = s.nextLine();
            String description = s.nextLine();
            String currentRenter = s.nextLine();
            String yearReleased = s.nextLine();
            String bookID = s.nextLine();
            String historyOfRenters = s.nextLine();
            String checkoutDate = s.nextLine();
            String returnDate = s.nextLine();
            String overdraftFee = s.nextLine();
            
            //Determining which field to edit
           
            
            
            switch (modification){
            	case "name": Book newBook = new Book(addition, auth, description, currentRenter, yearReleased, bookID, historyOfRenters, checkoutDate, returnDate, overdraftFee);
            				 break;
            	case "author": Book newBook1 = new Book(name, addition, description, currentRenter,
                        yearReleased, bookID, historyOfRenters, checkoutDate, returnDate, overdraftFee);
            	break;
            	
            	case "description": Book newBook2 = new Book(name, auth, addition, currentRenter,
	                                yearReleased, bookID, historyOfRenters, checkoutDate, returnDate, overdraftFee);
		                            break;
            	case "currentRenter": Book newBook3 = new Book(name, auth, description, addition,
	                                  yearReleased, bookID, historyOfRenters, checkoutDate, returnDate, overdraftFee);
		                              break;
		                              
            	case "yearReleased": Book newBook4 = new Book(name, auth, description, currentRenter, 
	                                 addition, bookID, historyOfRenters, checkoutDate, returnDate, overdraftFee);
		                             break;
            	case "bookID": Book newBook5 = new Book(name, auth, description, currentRenter,  
	                           yearReleased, addition, historyOfRenters, checkoutDate, returnDate, overdraftFee);
		                       break;
            	case "historyOfRenters": Book newBook6 = new Book(name, auth, description, currentRenter, 
	                                     yearReleased, bookID, historyOfRenters + addition, checkoutDate, returnDate, overdraftFee);
		                                 break;
            	case "checkoutDate": Book newBook7 = new Book(name, auth, description, currentRenter, 
	                                 yearReleased, bookID, historyOfRenters, addition, returnDate, overdraftFee);
		                             break;
            	case "returnDate": Book newBook8 = new Book(name, auth, description, currentRenter, 
	                                      yearReleased, bookID, historyOfRenters, checkoutDate, addition, overdraftFee);
		                                  break;
            	case "overdraftFee": Book newBook9 = new Book( name, auth, description, currentRenter,  
	                                 yearReleased, bookID, historyOfRenters, checkoutDate, returnDate, addition);
		                             break;
            
        }
        
    }
    
    public void deleteBook(String nameOfBook) {
    	
    	File file = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\"+ nameOfBook + ".txt");
        
        if(file.delete())
        {
            System.out.println("Book deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the book");
        }
        
    }
    
    //Returns all of the current rentals using the Library class
    public ArrayList<String> seeAllRentals() throws FileNotFoundException, IOException{
    	Library tempLib = new Library();
        return tempLib.returnCurrentRentals();
    }
}