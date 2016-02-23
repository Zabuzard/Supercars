package supercars.swing.model.cards;

/**
 * Card class for the Ferrari 365 GTB.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Ferrari365GTB implements Card {

	/**
	 * Name of the car.
	 */
	private static final String NAME = "Ferrari 365 GTB";
	/**
	 * Weight of the car.
	 */
	private static final int WEIGHT = 530;
	/**
	 * Amount of cylinders from the car.
	 */
	private static final int CYLINDER = 10;
	/**
	 * Power of the car.
	 */
	private static final int POWER = 425;
	/**
	 * Engine displacement of the car.
	 */
	private static final int ENGINE_DISPLACEMENT = 3200;
	/**
	 * Maximal speed of the car.
	 */
	private static final int MAX_SPEED = 330;
	/**
	 * Maximal revolutions of the car.
	 */
	private static final int MAX_REVOLUTIONS = 11500;

	@Override
	public int getCylinder() {
		return CYLINDER;
	}

	@Override
	public int getEngineDisplacement() {
		return ENGINE_DISPLACEMENT;
	}

	@Override
	public int getMaxRevolutions() {
		return MAX_REVOLUTIONS;
	}

	@Override
	public int getMaxSpeed() {
		return MAX_SPEED;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getPower() {
		return POWER;
	}

	@Override
	public int getWeight() {
		return WEIGHT;
	}
}
