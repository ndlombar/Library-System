package quiz3;

import static java.lang.Math.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;
public class CurrentDateTimeExample1 {
	
	public static void main(String[] args) {    
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  
		 System.out.println(dtf.format(now));  
		}    
	}


