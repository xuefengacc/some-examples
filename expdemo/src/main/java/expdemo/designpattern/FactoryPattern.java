package expdemo.designpattern;
/*The factory design pattern is used when we have a superclass with multiple 
 * sub-classes and based on input, we need to return one of the sub-class. 
 * This pattern takes out the responsibility of the instantiation of a class 
 * from the client program to the factory class*/

/*Factory design pattern provides approach to code for interface rather than implementation.
  Factory pattern removes the instantiation of actual implementation classes from client code. 
  Factory pattern makes our code more robust, less coupled and easy to extend. For example, we 
    can easily change PC class implementation because client program is unaware of this.
  Factory pattern provides abstraction between implementation and client classes through inheritance.*/

/* jdk examples: valueOf() of wrapp class */
public class FactoryPattern {
    public static void main(String args[]) {
    	
    }
}

abstract class Computer{
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	@Override
	public String toString() {
		return "RAM="+this.getRAM()+", HDD="+this.getHDD()
		    +", CPU="+this.getCPU();
	}
}

class PC extends Computer{

	private String ram;
	private String hdd;
	private String cpu;
	
	public PC(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public String getRAM() {
		return ram;
	}

	@Override
	public String getHDD() {
		return hdd;
	}

	@Override
	public String getCPU() {
		return cpu;
	}
	
}

class Server extends Computer{

	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public String getRAM() {
		return ram;
	}

	@Override
	public String getHDD() {
		return hdd;
	}

	@Override
	public String getCPU() {
		return cpu;
	}
	
}
//Factory class
class ComputerFactory{
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
		else return null;
	}
}

