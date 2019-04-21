//Person.java

//import reqyired packages

import java.util.ArrayList;

//Declare class

public class Person

{

     //Declare variables

     private String name;

     private ArrayList<Book> getCheckedOut = new ArrayList<Book>();

     private String address;

     final private int libraryCardNum;

     //Constructor

     public Person(String name, String address, int libraryCardNum){

          this.name = name;

          this.address = address;

          this.libraryCardNum = libraryCardNum;

     }

     //accessor and mutator methods

     public String getName() {

          return this.name;

     }

     public void setName(String name) {

          this.name = name;

     }

     public int getLibraryCardNum() {

          return this.libraryCardNum;

     }

     public ArrayList<Book> getCheckedOut() {

          return this.getCheckedOut;

     }

     public String getAddress(){

          return this.address;

     }

     public void setAddress(String address) {

          this.address = address;

     }

    

     //Implement the methods

     public boolean addBook(Book b)

     {

          if (getCheckedOut.contains(b)){

               return false;

          }

          else{

               getCheckedOut.add(b);

               return true;

          }

     }

     //implement method has read

     public boolean hasRead(Book b){

          if (getCheckedOut.contains(b)){

               return true;

          }

          return false;

     }

    

     //check whether the book is there or not

     //if the book is there then remove the book

     public boolean removeBook(Book b)

     {

          if (getCheckedOut.contains(b))

          {

               getCheckedOut.remove(b);

               return true;

          }

          return false;

     }

     //implement number of books to read

     public int numBooksRead()

     {

          return getCheckedOut.size();

     }

     public boolean equals(Object o)

     {

          Person newPerson = (Person) o;

          return this.libraryCardNum == newPerson.libraryCardNum;

     }

     //toString method

     public String toString(){

          return "Name: " + this.name + "\n" + "Address: "

                    + this.address + "\n" + "Id:" + this.libraryCardNum + "\n" + "Books read: "

                    + getCheckedOut.toString();

     }

     //Implement the method commonBooks

     public static ArrayList<Book> commonBooksPersons(Person a, Person b)

     {

          //declare arraylist

          ArrayList<Book> listOfCommonBooks = new ArrayList<Book>();

          //Using for-loop to repeat the checked books

          for(Book i : a.getCheckedOut){

               for(Book j : b.getCheckedOut){

                    if(i.equals(j))

                    {

                         listOfCommonBooks.add(i);

                    }

               }

          }

          return listOfCommonBooks;

     }

     //Implement the method silimarity with two person objects

     public static double similaritymeasure(Person p1, Person p2)

     {

         

          double commonvalue = commonBooksPersons(p1, p2).size();

          double total_checked = (p1.getCheckedOut.size() + p2.getCheckedOut.size());

          return commonvalue / total_checked;

     }

}