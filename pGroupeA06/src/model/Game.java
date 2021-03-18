package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.SceneManager;
import enumerations.PlayerColors;
import enumerations.Theme;
import exceptions.AlreadyPresentException;
import util.Constants;
import vue.GameAP;

public class Game {
	private List<Player> players;
	private static Board board;
	private int turn;
	private Deck deck;
	List<Integer> playerSquare;

	public Game() {
		board = new Board().fromJson(Constants.BOARD_PATH);
		playerSquare = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
		this.players = new ArrayList<Player>();
		this.turn = 0;
		this.deck = new Deck().fromJson(Constants.DECK_PATH);
	}

	public boolean addPlayer(String name, int number) throws AlreadyPresentException {
		if (number < 0 || number > 7) {
			return false;
		} else {
			if (players.size() == 0) {
				players.add(new Player(name, number));
				return true;
			} else {
				// scanning the list of players to check if the color has already been
				// attributed
				for (Player p : players) {
					if (p.getColor().equals(PlayerColors.getColor(number))) {
						throw new AlreadyPresentException(2.0);
					}
				}

				players.add(new Player(name, number));
				return true;
			}
		}

	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public Square movePlayer(int next, Square sq) {

		boolean ok = false;
		int indice = 0;

		for (Square square : board.getSquares()) {
			if (square.equals(sq)) {
				ok = true;
				indice = board.getSquares().indexOf(sq);
				break;
			}

		}
		if (!ok) {
			return null;
		}

		// if the player won
		if (indice + next > board.getSquares().size() + 1) {
			return null;
		}

		int tmp;
		switch (players.indexOf(GameOperation.getPlayerTurn())) {
		case 0:
			tmp = playerSquare.get(0) + SceneManager.getRating().getRating();
			playerSquare.set(0, tmp);
			GameAP.setIvPlayer01(
					Game.getBoard().getSquares().get(playerSquare.get(0)).getPlayersPosition().get(0).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(0)).getPlayersPosition().get(0).getY());
			break;
		case 1:
			tmp = playerSquare.get(1) + SceneManager.getRating().getRating();
			playerSquare.set(1, tmp);
			GameAP.setIvPlayer02(
					Game.getBoard().getSquares().get(playerSquare.get(1)).getPlayersPosition().get(1).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(1)).getPlayersPosition().get(1).getY());
			break;
		case 2:
			tmp = playerSquare.get(2) + SceneManager.getRating().getRating();
			playerSquare.set(2, tmp);
			GameAP.setIvPlayer03(
					Game.getBoard().getSquares().get(playerSquare.get(2)).getPlayersPosition().get(2).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(2)).getPlayersPosition().get(2).getY());
			break;
		case 3:
			tmp = playerSquare.get(3) + SceneManager.getRating().getRating();
			playerSquare.set(3, tmp);
			GameAP.setIvPlayer04(
					Game.getBoard().getSquares().get(playerSquare.get(3)).getPlayersPosition().get(3).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(3)).getPlayersPosition().get(3).getY());
			break;
		case 4:
			tmp = playerSquare.get(4) + SceneManager.getRating().getRating();
			playerSquare.set(4, tmp);
			GameAP.setIvPlayer05(
					Game.getBoard().getSquares().get(playerSquare.get(4)).getPlayersPosition().get(4).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(4)).getPlayersPosition().get(4).getY());
			break;
		case 5:
			tmp = playerSquare.get(5) + SceneManager.getRating().getRating();
			playerSquare.set(5, tmp);
			GameAP.setIvPlayer06(
					Game.getBoard().getSquares().get(playerSquare.get(5)).getPlayersPosition().get(5).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(5)).getPlayersPosition().get(5).getY());
			break;
		case 6:
			tmp = playerSquare.get(6) + SceneManager.getRating().getRating();
			playerSquare.set(6, tmp);
			GameAP.setIvPlayer07(
					Game.getBoard().getSquares().get(playerSquare.get(6)).getPlayersPosition().get(6).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(6)).getPlayersPosition().get(6).getY());
			break;
		case 7:
			tmp = playerSquare.get(7) + SceneManager.getRating().getRating();
			playerSquare.set(7, tmp);
			GameAP.setIvPlayer08(
					Game.getBoard().getSquares().get(playerSquare.get(7)).getPlayersPosition().get(7).getX(),
					Game.getBoard().getSquares().get(playerSquare.get(7)).getPlayersPosition().get(7).getY());
			break;
		}
		return board.getSquares().get(indice + next);
	}

	public static Board getBoard() {
		return board;
	}

	public void turnUp() {
		this.turn++;
	}

	public Deck getDeck() {

		// not clone to be able to remove the used cards
		return deck.clone();
	}

	public int getTurn() {
		return this.turn;
	}

	public Game clone() {
		Game g = new Game();
		for (Player p : players) {
			g.addPlayer(p.clone());
		}
		g.turn = this.turn;
		g.deck = this.deck.clone();
		return g;
	}

	public List<Player> getPlayers() {
		List<Player> p = new ArrayList<Player>();
		for (Player pl : players) {
			p.add(pl);
		}
		return p;
	}
}