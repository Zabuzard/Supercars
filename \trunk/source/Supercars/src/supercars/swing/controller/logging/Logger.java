package supercars.swing.controller.logging;

import supercars.swing.model.Player;
import supercars.swing.view.MainFrameView;

/**
 * Logger of the main frame.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Logger {

	/**
	 * View of the main frame.
	 */
	private final MainFrameView view;

	/**
	 * Creates a new Logger using the view of the main frame.
	 * 
	 * @param thatView
	 *            view of the main frame
	 */
	public Logger(final MainFrameView thatView) {
		view = thatView;
	}

	/**
	 * Logs when the game is over.
	 */
	public void logGameOver() {
		if (view != null) {
			view.log("Das Spiel ist vorbei.");
		}
	}

	/**
	 * Logs an error when no radio button was selected.
	 */
	public void logNoButtonError() {
		if (view != null) {
			view.logError("Es wurde kein Button ausgewählt.");
		}
	}

	/**
	 * Logs when a draw occurred.
	 */
	public void logPlayerDraw() {
		if (view != null) {
			view.log("Gleichstand, nochmal mit einem anderen Wert versuchen.");
		}
	}

	/**
	 * Logs when a player has lost the game.
	 * 
	 * @param player
	 *            player who has lost the game
	 */
	public void logPlayerLoose(final Player player) {
		if (view != null) {
			view.log(player.getName() + " hat keine Karten mehr und verliert.");
		}
	}

	/**
	 * Logs when a player has won the game.
	 * 
	 * @param player
	 *            player who has won the game
	 */
	public void logPlayerWonGame(final Player player) {
		if (view != null) {
			view.log(player.getName()
					+ " ist der letzte Spieler und gewinnt das Spiel.");
		}
	}

	/**
	 * Logs when a player has won a turn.
	 * 
	 * @param player
	 *            player who has won the turn
	 * @param playerIndex
	 *            index of player in the player array
	 * @param allPlayers
	 *            player array of all players
	 * @param values
	 *            values of all players in this turn
	 */
	public void logPlayerWonTurn(final Player player, final int playerIndex,
			final Player[] allPlayers, final int[] values) {
		if (view != null) {
			StringBuilder message = new StringBuilder();
			message.append(player.getName());
			message.append(" gewinnt mit ");
			message.append(player.lookupTopCard().getName());
			message.append(" (").append(values[playerIndex]);
			message.append(") gegen ");

			for (int i = 0; i < values.length; i++) {
				if (i != playerIndex) {
					message.append(allPlayers[i].getName()).append("s ");
					message.append(allPlayers[i].lookupTopCard().getName());
					message.append(" (").append(values[i]).append("), ");
				}
			}
			view.log(message.substring(0, message.length() - 2));
		}
	}

	/**
	 * Logs an unknown error.
	 * 
	 * @param e
	 *            error
	 */
	public void logUnknownError(final Exception e) {
		if (view != null) {
			view.logError("Ein unbekannter Fehler trat auf.");
			if (e.getMessage() != null) {
				view.logError(e.getMessage());
			}
		}
	}
}
