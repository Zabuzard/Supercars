package supercars.swing.model;

import supercars.swing.model.cards.Card;

/**
 * Player of the game which has a card stack.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Player {

	/**
	 * Name of the player.
	 */
	private final String name;
	/**
	 * Card stack of the player.
	 */
	private final CardStack cardStack = new CardStack();

	/**
	 * Creates a new Player with a name.
	 * 
	 * @param thatName
	 *            name of the player
	 */
	public Player(final String thatName) {
		name = thatName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns if the player has cards left in his card stack.
	 * 
	 * @return true if the player has cards left in his card stack
	 */
	public boolean hasCards() {
		return cardStack.size() > 0;
	}

	/**
	 * Inserts a card at the bottom of players card stack.
	 * 
	 * @param card
	 *            card to insert
	 */
	public void insertCardAtBottom(final Card card) {
		cardStack.pushBottom(card);
	}

	/**
	 * Looks the top card of players card stack up.
	 * 
	 * @return card which was looked up
	 */
	public Card lookupTopCard() {
		return cardStack.peek();
	}

	/**
	 * Removes the card at the top of players card stack and returns it.
	 * 
	 * @return card which was removed
	 */
	public Card removeTopCard() {
		return cardStack.pop();
	}

	/**
	 * Returns the size of the players card stack.
	 * 
	 * @return size of the players card stack
	 */
	public int stackSize() {
		return cardStack.size();
	}

}
