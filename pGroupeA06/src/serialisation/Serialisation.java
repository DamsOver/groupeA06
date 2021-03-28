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

		//"res/deckTest.JSON"
		try(FileWriter writer = new FileWriter("src/res/deckTest.JSON");
		         BufferedWriter bw = new BufferedWriter(writer)) {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);

			bw.write(json);
			bw.close();
			
//			fileWriter = new FileWriter(nom);
//			fileWriter.write(json);
//			fileWriter.close();
		} catch (IOException e) {
		System.err.println(e);
		}

	}

	public static Deck loadDeckClear(String nom) {
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new InputStreamReader(Board.class.getResourceAsStream(nom)));
		
		return new Gson().fromJson(bufferedReader,Deck.class);
	}
	
	public static void saveBoardClear(Board q, String nom) {

		try(FileWriter writer = new FileWriter("src/res/board.JSON");
		         BufferedWriter bw = new BufferedWriter(writer)) {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);


			bw.write(json);
			bw.close();
			
//			fileWriter = new FileWriter(nom);
//			fileWriter.write(json);
//			fileWriter.close();
		} catch (IOException e) {
		System.err.println(e);
		}
	}
	
	public static Board loadBoardClear(String nom) {
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new InputStreamReader(Board.class.getResourceAsStream(nom)));
		
		return new Gson().fromJson(bufferedReader,Board.class);
	}
	
}
