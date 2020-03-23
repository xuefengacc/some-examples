package expdemo.indiv;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomException {
/*
	try (Scanner file = new Scanner(new File(fileName))) {
	    if (file.hasNextLine()) {
	        return file.nextLine();
	    } else {
	        throw new IllegalArgumentException("Non readable file");
	    }
	} catch (FileNotFoundException err) {
	    if (!isCorrectFileName(fileName)) {
	        throw new IncorrectFileNameException(
	          "Incorrect filename : " + fileName , err);
	    }
	     
	    //...
	} catch(IllegalArgumentException err) {
	    if(!containsExtension(fileName)) {
	        throw new IncorrectFileExtensionException(
	          "Filename does not contain extension : " + fileName, err);
	    }
	     
	    //...
	}
	*/
}

//Customer Checked exception
class IncorrectFileNameException extends Exception{
	public IncorrectFileNameException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}

//Customer Unckecked exception
class IncorrectFileNameExtensionException extends RuntimeException{
	public IncorrectFileNameExtensionException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
