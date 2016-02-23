package supercars.swing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import supercars.swing.model.cards.AlfaRomeo182;
import supercars.swing.model.cards.AlfaRomeo199;
import supercars.swing.model.cards.BenettonBF31Ford;
import supercars.swing.model.cards.Card;
import supercars.swing.model.cards.Ferrari312A;
import supercars.swing.model.cards.Ferrari365GTB;
import supercars.swing.model.cards.Lotus72;
import supercars.swing.model.cards.Mercedes12GT;
import supercars.swing.model.cards.Mercedes13XS;
import supercars.swing.model.cards.Tyrell009;
import supercars.swing.model.cards.WilliamsFl200Renault;

/**
 * Deck of cards for the game.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Deck {

	/**
	 * Starting size of the deck.
	 */
	public static final int DECK_SIZE = 10;

	/**
	 * Contains all cards of the deck.
	 */
	private final List<Card> cards = new ArrayList<Card>(DECK_SIZE);

	/**
	 * Creates a new shuffled Deck with size indicated by {@link #DECK_SIZE}.
	 */
	public Deck() {
		initialize();
	}

	/**
	 * Pops a card from the deck.
	 * 
	 * @return popped card
	 */
	public Card pop() {
		return cards.remove(0);
	}

	/**
	 * Current size of the deck.
	 * 
	 * @return current size of the deck
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * Adds all cards to the deck. Should be used by initialization.
	 */
	private void addCards() {
		cards.add(new AlfaRomeo182());
		cards.add(new AlfaRomeo199());
		cards.add(new BenettonBF31Ford());
		cards.add(new Ferrari312A());
		cards.add(new Ferrari365GTB());
		cards.add(new Lotus72());
		cards.add(new Mercedes12GT());
		cards.add(new Mercedes13XS());
		cards.add(new Tyrell009());
		cards.add(new WilliamsFl200Renault());
	}

	/**
	 * Initializes the deck by adding all cards and shuffling the deck.
	 */
	private void initialize() {
		addCards();
		Collections.shuffle(cards);
	}

}
