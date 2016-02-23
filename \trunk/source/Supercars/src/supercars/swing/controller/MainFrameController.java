package supercars.swing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import supercars.swing.controller.listener.ChooseListener;
import supercars.swing.controller.listener.ValueListener;
import supercars.swing.controller.logging.Logger;
import supercars.swing.model.Deck;
import supercars.swing.model.Player;
import supercars.swing.model.cards.Card;
import supercars.swing.view.MainFrameView;

/**
 * The controller of the main frame.
 * 
 * @author Daniel Tischner
 * 
 */
public final class MainFrameController {

	/**
	 * Array which holds amounts of supported players.
	 */
	public static final String[] SUPPORTED_PLAYERS = { 2 + "", 3 + "" };

	/**
	 * The view of the main frame.
	 */
	private final MainFrameView view;
	/**
	 * Logger of the main frame.
	 */
	private final Logger logger;

	/**
	 * Amount of players.
	 */
	private int amountOfPlayers;
	/**
	 * Array of all players.
	 */
	private Player[] players;
	/**
	 * Index of player who is at turn.
	 */
	private int currentPlayer;
	/**
	 * True if game is over.
	 */
	private boolean gameOver;

	/**
	 * Creates a new controller of the main frame by connecting it to the view.
	 * 
	 * @param thatView
	 *            view of the main frame
	 * @param thatLogger
	 *            logger of the main frame
	 */
	public MainFrameController(final MainFrameView thatView,
			final Logger thatLogger) {
		view = thatView;
		logger = thatLogger;
	}

	/**
	 * @return the currentPlayer
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Initializes the controller.
	 */
	public void initialize() {
		linkListener();
		view.getValueButtons()[MainFrameView.WEIGHT_VALUE].setSelected(true);
	}

	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Invoked if the next turn starts.
	 * 
	 * @param player
	 *            player which is at turn
	 */
	public void nextTurn(final int player) {
		int tmpPlayer = player;
		if (handleWinnerLooser()) {
			gameOver = true;
			logger.logPlayerWonGame(players[0]);
		}
		if (tmpPlayer >= amountOfPlayers) {
			tmpPlayer = amountOfPlayers - 1;
		}
		currentPlayer = tmpPlayer;
		drawCurrentPlayer();
	}

	/**
	 * Starts the game.
	 */
	public void startGame() {
		String amountOfPlayersText = (String) JOptionPane.showInputDialog(null,
				"Spieleranzahl", "Wähle eine Spieleranzahl",
				JOptionPane.QUESTION_MESSAGE, null, SUPPORTED_PLAYERS,
				SUPPORTED_PLAYERS[0]);
		if (amountOfPlayersText == null) {
			amountOfPlayersText = SUPPORTED_PLAYERS[0];
		}
		amountOfPlayers = Integer.parseInt(amountOfPlayersText);

		players = new Player[amountOfPlayers];
		for (int i = 0; i < amountOfPlayers; i++) {
			String name = JOptionPane.showInputDialog("Name von Spieler "
					+ (i + 1) + "?");
			if (name == null) {
				name = "Spieler " + (i + 1);
			}
			players[i] = new Player(name);
		}
		Deck deck = new Deck();

		for (int i = 0; i < Deck.DECK_SIZE; i++) {
			if (i % amountOfPlayers == 0
					&& ((deck.size() + 0.0) / amountOfPlayers) < 1.0) {
				break;
			}
			players[i % amountOfPlayers].insertCardAtBottom(deck.pop());
		}

		currentPlayer = 0;
		drawCurrentPlayer();
		gameOver = false;
	}

	/**
	 * Sets all field texts of the view for the current player.
	 */
	private void drawCurrentPlayer() {
		view.setPlayerFieldText(players[currentPlayer].getName());
		view.setStackSizeFieldText(players[currentPlayer].stackSize() + "");

		Card card = players[currentPlayer].lookupTopCard();
		view.setCylinderFieldText(card.getCylinder() + "");
		view.setEngineFieldText(card.getEngineDisplacement() + "");
		view.setMaxRevolutionsFieldText(card.getMaxRevolutions() + "");
		view.setMaxSpeedFieldText(card.getMaxSpeed() + "");
		view.setNameFieldText(card.getName());
		view.setPowerFieldText(card.getPower() + "");
		view.setWeightFieldText(card.getWeight() + "");
	}

	/**
	 * Removes looser from the game and returns if a player has won the game.
	 * 
	 * @return if a player has won the game
	 */
	private boolean handleWinnerLooser() {
		List<Player> inGame = new ArrayList<Player>();
		for (int i = 0; i < amountOfPlayers; i++) {
			if (!players[i].hasCards()) {
				logger.logPlayerLoose(players[i]);
			} else {
				inGame.add(players[i]);
			}
		}
		players = inGame.toArray(new Player[0]);
		amountOfPlayers = inGame.size();
		return amountOfPlayers < 2;
	}

	/**
	 * Links the listener to the view.
	 */
	private void linkListener() {
		view.addListenerToChooseButton(new ChooseListener(view, this, logger));
		view.addListenerToValueButtons(new ValueListener(view));
	}

}
