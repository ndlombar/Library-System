package library;

import java.io.IOException;
import java.io.PrintWriter;

public class Student {

	private String name;
	private String password;
	private String encryptedPass;
	private String rentedBook;
	private String rentalHistory;
	
	 public Student(String title, String pass, String rentedBook1, String rentalHistory1) throws IOException{
	        
	        name = title;
	        password = pass;
	        encryptedPass = encryptPassword(pass);
	        rentedBook = rentedBook1;
	        rentalHistory = rentalHistory1;
	        
	        PrintWriter out = new PrintWriter("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + title + ".txt");
	        	        
	        out.println("Student");
	        out.println(title);
	        out.println(encryptedPass);
	        out.println(rentedBook);
	        out.println(rentalHistory);
	        
	        out.close();
	 }
	 
	 public Student() {
		 //needed for another class, not just random empty constructor
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
	    public String decrypt(String original){
	        
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
	                case '1': answer += "l";
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
	                case 'l': answer += "9";
	                          break;
	                          
	            }
	        }
	        
	        return answer;
	    }
	    public String getRentedBook() {
	    	return this.rentedBook;
	    }
}