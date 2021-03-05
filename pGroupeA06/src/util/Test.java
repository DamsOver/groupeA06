package util;

import java.util.ArrayList;

import enumerations.PlayerColors;
import model.GameOperation;
import model.Player;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("martin");
		names.add("salut");
		
		GameOperation bo = new GameOperation();
		bo.addPlayers(names);
		//p1.getColor();
	}

}
