package supercars.swing.model.cards;

/**
 * Card class for the Ferrari 312 A.
 * 
 * @author Daniel Tischner
 * 
 */
public final class Ferrari312A implements Card {

	/**
	 * Name of the car.
	 */
	private static final String NAME = "Ferrari 312 A";
	/**
	 * Weight of the car.
	 */
	private static final int WEIGHT = 540;
	/**
	 * Amount of cylinders from the car.
	 */
	private static final int CYLINDER = 12;
	/**
	 * Power of the car.
	 */
	private static final int POWER = 450;
	/**
	 * Engine displacement of the car.
	 */
	private static final int ENGINE_DISPLACEMENT = 3000;
	/**
	 * Maximal speed of the car.
	 */
	private static final int MAX_SPEED = 312;
	/**
	 * Maximal revolutions of the car.
	 */
	private static final int MAX_REVOLUTIONS = 11000;

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
