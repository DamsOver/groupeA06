package serialisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileWriter;

import model.Deck;
import model.Question;

public class Serialisation {

	public static void saveDeckClear(Deck q,String nom) throws IOException {
		
		FileWriter fileWriter = new FileWriter(nom);
		fileWriter.write(q.toJson());
		fileWriter.close();
	}
	
	public static Deck loadDeckClear(String nom) throws FileNotFoundException {
		String data = null;
	    File myObj = new File(nom);
	    Scanner scanner = new Scanner(myObj);
	    data = scanner.nextLine();
	    scanner.close();
		return new Deck().fromJson(data);
	}
}
