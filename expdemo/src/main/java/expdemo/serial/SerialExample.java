package expdemo.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialExample {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "Lyric";
		emp.address = "Middle of some where";
		emp.SSN = 12345678;
		emp.number = 1112223333;
		
		try{
			FileOutputStream fileOut = new FileOutputStream("emp.ser"); 
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
	        out.close();
	        fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
}

class Employee implements Serializable {
	  
	   public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
	}
//