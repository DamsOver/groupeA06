package util;

import java.util.Scanner;

import enumerations.Theme;
import model.Board;
import model.Square;
import serialisation.Serialisation;

public class BoardCreator {

	public static void main(String[] args) {
		Board bd = new Board();
		bd= bd.fromJson("board.JSON");
		
		
		System.out.println(bd.toString());
		int x = 1;
		Scanner sc = new Scanner(System.in);
		while (x != 0) {
			System.out.println("Do you want to add a square to the board?\n0 : no\n1 : yes");
			x = sc.nextInt();
			if (x == 1) {
				int choix;
				do {
					System.out.println("Theme of the card : ");
					System.out.println("1 : IMPROBABLE");
					System.out.println("2 : PLEASURE");
					System.out.println("3 : INFORMATICS");
					System.out.println("4 : SCHOOL\n");
					choix = sc.nextInt();
				} while (choix > 4 || choix < 1);

				Square s = new Square(
						(choix == 1) ? Theme.IMPROBABLE
								: (choix == 2) ? Theme.PLEASURE 
										: (choix == 3) ? Theme.INFORMATICS : Theme.SCHOOL);
				
				System.out.println("\nDo you want to add that card?\n" + s.toString());
				System.out.println("0 : no\n1 : yes");
				choix = sc.nextInt();
				if (choix == 1) {

					bd.addSquare(s);
				}
			}
		}

		System.out.println(bd.toString());

		Serialisation.saveBoardClear(bd, "board.JSON");
		
	}

}
