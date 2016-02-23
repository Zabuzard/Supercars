package supercars.swing.model.cards;

/**
 * Interface for a car card.
 * 
 * @author Daniel Tischner
 * 
 */
public interface Card {

	/**
	 * @return the cylinder
	 */
	int getCylinder();

	/**
	 * @return the engine displacement
	 */
	int getEngineDisplacement();

	/**
	 * @return the maximal revolutions
	 */
	int getMaxRevolutions();

	/**
	 * @return the maximal speed
	 */
	int getMaxSpeed();

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @return the power
	 */
	int getPower();

	/**
	 * @return the weight
	 */
	int getWeight();

}
