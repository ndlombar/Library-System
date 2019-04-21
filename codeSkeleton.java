/////////////////////////////////////////////////////////
// C 212 final project part one 
// code  skeleton
/////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.List;

public class Book {
	private int bookID;
	private  String title , author;
	private double price;


public void book () {
	bookID = 0;
	title = null;
	author = null;
	price = 0;
}


public void book (int bookID, String title, String author, double price) {
	this.bookID = bookID;
	this.title = title;
	this.author = author; 
	this.price = price;
}
@override

public String toString() {
	return "/nTitle:" + title + "/nAuthor:" + author +
			"/BookId:" + bookID + "/Price:"+price ;
			
	
}
public class Libery {
	private List <Book> collection;
	public Libery() {
		collection = new ArrayList <Book>() ;
	}
	public void addBook (Book book) {
		collection.add (book);
		
	}
	
	
	
}


}



