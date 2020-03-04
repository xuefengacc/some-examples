package expdemo.designpattern.singleton;

public class singletondemo {
    
	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
	}
	
}


class Singleton{
	
	// static variable single_instance of type Singleton
	private static Singleton single_instance = null;
	
	public String s;
	
	//private constructor
	private Singleton() {
		s = "String from singleton class";
	}
	
	public static Singleton getInstance() {
		if (single_instance == null) {
			single_instance = new Singleton();
		}
		
		return single_instance;
	}
}