package supercars.swing.model;

import java.util.ArrayList;
import java.util.List;

import supercars.swing.model.cards.Card;

/**
 * Stack of cards for a {@link Player}.
 * 
 * @author Daniel Tischner
 * 
 */
public final class CardStack {

	/**
	 * Contains all cards of the stack.
	 */
	private final List<Card> cards = new ArrayList<Card>();

	/**
	 * Peeks a card from the stack.
	 * 
	 * @return peeked card
	 */
	public Card peek() {
		return cards.get(0);
	}

	/**
	 * Pops a card from the stack.
	 * 
	 * @return popped card
	 */
	public Card pop() {
		return cards.remove(0);
	}

	/**
	 * Pushes a card to the bottom of the stack.
	 * 
	 * @param card
	 *            card to push
	 */
	public void pushBottom(final Card card) {
		cards.add(card);
	}

	/**
	 * Size of the stack.
	 * 
	 * @return size of the stack
	 */
	public int size() {
		return cards.size();
	}
}
