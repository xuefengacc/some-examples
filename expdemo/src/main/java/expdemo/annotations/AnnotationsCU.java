package expdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationsCU {

	public static void main(String[] args) {
		
	}
	
}
//This is what signals to the Java compiler and 
//JVM that the annotation should be available via reflection at runtime
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
//@Inherited
//@Documented
@interface JsonField{
	public String value() default "";
}

class Car {
    @JsonField("manufacturer")
    private final String make;
    @JsonField
    private final String model;
    private final String year;
    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getYear() {
        return year;
    }
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}