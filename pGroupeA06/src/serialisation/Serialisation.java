package serialisation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

import model.Board;
import model.Deck;
import util.Constants;

public class Serialisation implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void saveDeckClear(Deck q, String nom) {

		try (FileWriter writer = new FileWriter(nom); BufferedWriter bw = new BufferedWriter(writer)) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);

			bw.write(json);
			bw.close();

		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public static Deck loadDeckClear(String nom) {

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(nom));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().fromJson(bufferedReader, Deck.class);
	}

	public static void saveBoardClear(Board q, String nom) {

		try (FileWriter writer = new FileWriter(nom); BufferedWriter bw = new BufferedWriter(writer)) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);

			bw.write(json);
			bw.close();

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static Board loadBoardClear(String nom) {
		
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(nom));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return new Gson().fromJson(bufferedReader, Board.class);
	}

}
