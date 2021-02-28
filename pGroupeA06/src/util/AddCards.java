package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import enumerations.Theme;
import exceptions.AlreadyPresentException;
import exceptions.TooManyException;
import model.BasicCard;
import model.Deck;
import serialisation.Serialisation;

public class AddCards {

	public static void main(String[] args) {
		Deck d = new Deck();

		d = Serialisation.loadDeckClear("deck.JSON");

		System.out.println(d.toString());
		int x = 1;
		Scanner sc = new Scanner(System.in);
		while (x != 0) {
			System.out.println("Do you want to add a card?\n0 : no\n1 : yes");
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

				System.out.println("Name of the author :");
				String name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Theme of the card :");
				String subject = sc.nextLine();
				BasicCard bc = new BasicCard(name,
						(choix == 1) ? Theme.IMPROBABLE
								: (choix == 2) ? Theme.PLEASURE : (choix == 3) ? Theme.INFORMATICS : Theme.SCHOOL,
						subject);
				for (int i = 1; i <= 4; i++) {
					System.out.println("\nQuestion " + i + " :");
					System.out.println("What is the question?");
					String question = sc.nextLine();
					System.out.println("What is the answer?");
					String answer = sc.nextLine();
					try {
						bc.addQuestion(question, answer);
					} catch (AlreadyPresentException | TooManyException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\nDo you want to add that card?\n" + bc.toString());
				System.out.println("0 : no\n1 : yes");
				choix = sc.nextInt();
				if (choix == 1) {
					try {
						d.addBasicCard(bc);
					} catch (AlreadyPresentException e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println(d.toString());

		Serialisation.saveDeckClear(d, "deck.JSON");

	}

}
