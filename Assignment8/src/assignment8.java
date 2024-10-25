import java.util.*;
import java.io.*;

class operations{
	int rollNum,marks,id;
	String name,address;
	Scanner sc = new Scanner(System.in);
	File dB = new File("StudentRecord.txt");
	//declared required variables
	void create() {
		
		try {
			if(dB.createNewFile()) {
				System.out.println("Database created succesfully!");
			}else {
				System.out.println("Database already exists!Please modify it");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void add(){ //adds a new record
		
		
		
	}
	
	void display() { //displays all records
		
	}
	
	void delete() {
		
	}
	
	void update() {
		
	}
	
	void search() {
		
	}
}

public class assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
