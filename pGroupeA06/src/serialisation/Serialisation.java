package serialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Question;

public class Serialisation {
	/*
	public static void saveQuestion(Question q) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Question.obj"))) {
			out.writeObject(q);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Question loadQuestion() {
		try(ObjectInputStream x8464 = new ObjectInputStream(new FileInputStream("Question.obj"))) {
			Object obj = x8464.readObject();
			if(obj instanceof Question) {
				Question q = (Question) obj;
				return q;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
