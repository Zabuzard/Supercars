package supercars.swing.model.cards;

/**
 * Card class for the Mercedes 12GT.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Mercedes12GT implements Card {

	/**
	 * Name of the car.
	 */
	private static final String NAME = "Mercedes 12GT";
	/**
	 * Weight of the car.
	 */
	private static final int WEIGHT = 560;
	/**
	 * Amount of cylinders from the car.
	 */
	private static final int CYLINDER = 8;
	/**
	 * Power of the car.
	 */
	private static final int POWER = 490;
	/**
	 * Engine displacement of the car.
	 */
	private static final int ENGINE_DISPLACEMENT = 3200;
	/**
	 * Maximal speed of the car.
	 */
	private static final int MAX_SPEED = 250;
	/**
	 * Maximal revolutions of the car.
	 */
	private static final int MAX_REVOLUTIONS = 9000;

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
