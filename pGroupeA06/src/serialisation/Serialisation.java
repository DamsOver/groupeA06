package serialisation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

import model.Deck;

public class Serialisation implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void saveDeckClear(Deck q, String nom) {

		FileWriter fileWriter;
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);

			fileWriter = new FileWriter(nom);
			fileWriter.write(json);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Deck loadDeckClear(String nom) {

		return new Deck().fromJson(nom);

	}
}
