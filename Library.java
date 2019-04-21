package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dustin Adkins, Duadkins, ID: 0003567195
 */
public class Library {

    //All items are stored as Strings, which can be used to refer to files later
    private ArrayList<String> listOfLibrarians = new ArrayList<>();
    private ArrayList<String> listOfBooks = new ArrayList<>();
    private ArrayList<String> listOfStudents = new ArrayList<>();
    private ArrayList<String> listOfCurrentRentals = new ArrayList<>();
    private ArrayList<LocalDateTime> rentalDates = new ArrayList<>();

    
    //Constructor searches all files and determines which ArrayList it belongs
    //to, based on the first line
    public Library() throws FileNotFoundException, IOException{
        
        //Here is where the directory needs to be changed based on user
    	File dir = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\");
      
        //Iterates through all files in the directory, adds the name of the
        //person or book to the ArrayList<String>
        for (File file : dir.listFiles()) {
            Scanner s = new Scanner(file);
            String occupation = s.nextLine();
            
            if("Librarian".equals(occupation)){
                String name = s.nextLine();
                
                listOfLibrarians.add(name);
            }
            else if("Student".equals(occupation)){
            	String name = s.nextLine();
                
                listOfStudents.add(name);
            }
            else if("Book".equals(occupation)){
                String title = s.nextLine();
                String auth = s.nextLine();
                String descrip = s.nextLine();
                String renter = s.nextLine();
                String date = "";
                String test = "null";
                
                for(int i = 0; i < 5; i ++) {
                date = s.nextLine();  
                }
                
                
                listOfBooks.add(title);
                
                //This checks to see if the book is available. If so, it adds
                //it to the ArrayList
                if(!(renter.equals(test))) {
                	
                	LocalDateTime deadline = LocalDateTime.parse(date.toString());
                	
                	int length = listOfCurrentRentals.size();
                	
                	if(length == 0) {
                		listOfCurrentRentals.add(title);
                		rentalDates.add(deadline);
                	}
                	else {
                		for(int i = 0; i < length; i++) {
                			if(deadline.isBefore(rentalDates.get(i))) {
                				listOfCurrentRentals.add(i, title);
                    		    rentalDates.add(i, deadline);
                    		    break;
                			}
                			else if (i == length - 1) {
                				listOfCurrentRentals.add(title);
                    		    rentalDates.add( deadline);
                			}
                			else {
                		    
                			}
                			
                	}
                	}
                	
                }
                else {
                	
                }
            }
            
            s.close();

           
        }
    } 
    

    //Returns the list determined in the constructor
    public ArrayList<String> returnCurrentRentals() {
    	return listOfCurrentRentals;
    }
    
    //Given a name and a password, it searches for the file with the same name
    //and compares passwords. Returns true if they match, false otherwise
    public boolean attemptLogin(String name, String pass)  {
    	
    	boolean answer = false;
    	
    	Student test = new Student();
    			
    	
    		try {
    		File dir = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + name + ".txt");
    		
    		Scanner s = new Scanner(dir);
    		
    		String occupation = s.nextLine();
        	String studentName = s.nextLine();
        	String encrypPass = s.nextLine();
        	String password = test.decrypt(encrypPass);
        	
        	
        	if(password.equals(pass)) {
        		answer = true;
    	    }
    		}
    		catch(FileNotFoundException e) {
    			answer = false;
    		}
    	
            return answer;
            	
            }
    
    public static ArrayList<String> search(String bookTitle) throws FileNotFoundException{
    	
    	ArrayList<String> result = new ArrayList<>();
		File dir = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + bookTitle + ".txt");
		
		Scanner s = new Scanner(dir);
		
		while(s.hasNextLine()) {
			result.add(s.nextLine());
			
		}
		return result;
    }
        
    	
   
    
   
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
    	//Creating example books
    	Book george = new Book("1984", "George Orwell", "A look into the future.", "null", "1965", "541516513",
    			"Nick, Dustin, Madison", "null", "null", "$1000");
    	Book love = new Book("Anna Karenina", "Leo Tolstoy", "A story of love.", "null", "1872", "698415233",
    			"Bakr", "null", "null", "$1000");
    	Book erag = new Book("Inheritance", "Christopher Paolini", "Dragons", "null", "1965", "86215523",
    			"Tiffany, Roy", "null", "null", "$1000");
    	
    	//Creating some test students  
    	Student maddy = new Student("Madison", "pass", "null", "1984");
    	Student addy = new Student("Addison", "password123", "null", "1984, Anna Karenina");
    	Student bak = new Student("Bakr", "nothere", "null", "Anna Karenina");
    	Student dust = new Student("Dustin", "wow", "null", "Inheritance");
    	Student nic = new Student("Nick", "nothere", "null", "1984");
    	
    	//Test librarian
    	Librarian hera = new Librarian("Herald", "admin123");
    	
    george.checkOutBook("1984", "Madison");
    love.checkOutBook("Anna Karenina", "Madison");
    george.checkOutBook("Inheritance", "Madison");
    
    	//Starting the library
        Library IU = new Library();
    //BooksGUI test = new BooksGUI();
    
   
        LoginWindow test = new LoginWindow();
        
	 
    }
    
}