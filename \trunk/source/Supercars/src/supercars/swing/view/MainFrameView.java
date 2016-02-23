package supercars.swing.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 * View of the main frame.
 * 
 * @author Daniel Tischner
 * 
 */
public final class MainFrameView {

	/**
	 * Dimensions of the view.
	 */
	public static final int HEIGHT = 450, WIDTH = 600;

	/**
	 * Amount of different choosable values.
	 */
	public static final int VALUES = 6;

	/**
	 * Values of the choosable values.
	 */
	public static final int WEIGHT_VALUE = 0, CYLINDER_VALUE = 1,
			POWER_VALUE = 2, ENGINE_VALUE = 3, MAXSPEED_VALUE = 4,
			MAXREVOLUTIONS_VALUE = 5, VALUE_NO = -1;

	/**
	 * The default font size of the view.
	 */
	private static final int DEFAULT_FONT_SIZE = 11;

	/**
	 * The big font size of the view.
	 */
	private static final int BIG_FONT_SIZE = 20;

	/**
	 * The default amount of columns for fields of the view.
	 */
	private static final int DEFAULT_FIELD_COLUMNS = 10;

	/**
	 * Container of the view.
	 */
	private Container container;
	/**
	 * Card panel of the view.
	 */
	private JPanel cardPanel;
	/**
	 * Stack size panel of the view.
	 */
	private JPanel stackSizePanel;
	/**
	 * Log pane of the view.
	 */
	private JScrollPane logPane;
	/**
	 * Log area of the view.
	 */
	private JTextArea logArea;
	/**
	 * Name field of the view.
	 */
	private JTextField nameField;
	/**
	 * Weight field of the view.
	 */
	private JTextField weightField;
	/**
	 * Cylinder field of the view.
	 */
	private JTextField cylinderField;
	/**
	 * Power field of the view.
	 */
	private JTextField powerField;
	/**
	 * Engine field of the view.
	 */
	private JTextField engineField;
	/**
	 * Maximal speed field of the view.
	 */
	private JTextField maxSpeedField;
	/**
	 * Maximal revolutions field of the view.
	 */
	private JTextField maxRevolutionsField;
	/**
	 * Player field of the view.
	 */
	private JTextField playerField;
	/**
	 * Stack size field of the view.
	 */
	private JTextField stackSizeField;
	/**
	 * Weight radio button of the view.
	 */
	private JRadioButton weightRadioBtn;
	/**
	 * Cylinder radio button of the view.
	 */
	private JRadioButton cylinderRadioBtn;
	/**
	 * Power radio button of the view.
	 */
	private JRadioButton powerRadioBtn;
	/**
	 * Engine radio button of the view.
	 */
	private JRadioButton engineRadioBtn;
	/**
	 * Maximal speed radio button of the view.
	 */
	private JRadioButton maxSpeedRadioBtn;
	/**
	 * Maximal revolutions radio button of the view.
	 */
	private JRadioButton maxRevolutionsRadioBtn;
	/**
	 * Choose button of the view.
	 */
	private JButton chooseBtn;
	/**
	 * Radio button container for the choosable values.
	 */
	private JRadioButton[] radioButtons = new JRadioButton[VALUES];

	/**
	 * Create the view.
	 * 
	 * @param thatContainer
	 *            container of the view
	 */
	public MainFrameView(final Container thatContainer) {
		container = thatContainer;
		initialize();
	}

	/**
	 * Adds an action listener to the choose button.
	 * 
	 * @param listener
	 *            listener to add
	 */
	public void addListenerToChooseButton(final ActionListener listener) {
		chooseBtn.addActionListener(listener);
	}

	/**
	 * Adds an action listener to all value buttons.
	 * 
	 * @param listener
	 *            listener to add
	 */
	public void addListenerToValueButtons(final ActionListener listener) {
		for (JRadioButton button : radioButtons) {
			button.addActionListener(listener);
		}
	}

	/**
	 * Gets the radio button container for the choosable values.
	 * 
	 * @return the radio button container for the choosable values
	 */
	public JRadioButton[] getValueButtons() {
		return radioButtons;
	}

	/**
	 * Appends a line to the log area.
	 * 
	 * @param line
	 *            line to append
	 */
	public void log(final String line) {
		logArea.setForeground(Color.BLACK);
		logArea.append(line + "\n");
	}

	/**
	 * Appends a line to the log area using a red font.
	 * 
	 * @param line
	 *            line to append
	 */
	public void logError(final String line) {
		logArea.setForeground(Color.RED);
		logArea.append(line + "\n");
	}

	/**
	 * Sets the cylinderFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setCylinderFieldText(final String text) {
		cylinderField.setText(text);
	}

	/**
	 * Sets the engineFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setEngineFieldText(final String text) {
		engineField.setText(text);
	}

	/**
	 * Sets the maxRevolutionsFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setMaxRevolutionsFieldText(final String text) {
		maxRevolutionsField.setText(text);
	}

	/**
	 * Sets the maxSpeedFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setMaxSpeedFieldText(final String text) {
		maxSpeedField.setText(text);
	}

	/**
	 * Sets the nameFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setNameFieldText(final String text) {
		nameField.setText(text);
	}

	/**
	 * Sets the playerFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setPlayerFieldText(final String text) {
		playerField.setText(text);
	}

	/**
	 * Sets the powerFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setPowerFieldText(final String text) {
		powerField.setText(text);
	}

	/**
	 * Sets the stackSizeFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setStackSizeFieldText(final String text) {
		stackSizeField.setText(text);
	}

	/**
	 * Sets the weightFieldText.
	 * 
	 * @param text
	 *            text to set
	 */
	public void setWeightFieldText(final String text) {
		weightField.setText(text);
	}

	/**
	 * Initialize the contents of the view.
	 */
	private void initialize() {
		initializePanels();
		initializeLabels();
		initializeButtons();
		initializeRadioButtons();
		initializeSeparators();
		initializeTextFields();

		logArea = new JTextArea();
		logArea.setEditable(false);
		logArea.setLineWrap(true);
		logPane.setViewportView(logArea);
	}

	/**
	 * Initialize the buttons.
	 */
	private void initializeButtons() {
		chooseBtn = new JButton("Ausw\u00E4hlen");
		chooseBtn.setBounds(252, 306, 109, 23);
		container.add(chooseBtn);
	}

	/**
	 * Initialize the labels.
	 */
	private void initializeLabels() {
		JLabel lblCard = new JLabel("Karte");
		lblCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblCard.setFont(new Font("Tahoma", Font.BOLD, BIG_FONT_SIZE));
		lblCard.setBounds(10, 11, 156, 30);
		cardPanel.add(lblCard);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE));
		lblName.setBounds(10, 68, 98, 14);
		cardPanel.add(lblName);

		JLabel lblWeight = new JLabel("Gewicht");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE));
		lblWeight.setBounds(10, 98, 129, 14);
		cardPanel.add(lblWeight);

		JLabel lblCylinder = new JLabel("Zylinder");
		lblCylinder.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE));
		lblCylinder.setBounds(10, 128, 129, 14);
		cardPanel.add(lblCylinder);

		JLabel lblPower = new JLabel("Leistung");
		lblPower.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE));
		lblPower.setBounds(10, 158, 129, 14);
		cardPanel.add(lblPower);

		JLabel lblEngineDisplacement = new JLabel("Hubraum");
		lblEngineDisplacement.setFont(new Font("Tahoma", Font.BOLD,
				DEFAULT_FONT_SIZE));
		lblEngineDisplacement.setBounds(10, 188, 129, 14);
		cardPanel.add(lblEngineDisplacement);

		JLabel lblMaxSpeed = new JLabel("Max. Geschw.");
		lblMaxSpeed.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE));
		lblMaxSpeed.setBounds(10, 218, 129, 14);
		cardPanel.add(lblMaxSpeed);

		JLabel lblMaxRevolutions = new JLabel("Max. Umdrehungen");
		lblMaxRevolutions.setFont(new Font("Tahoma", Font.BOLD,
				DEFAULT_FONT_SIZE));
		lblMaxRevolutions.setBounds(10, 248, 129, 14);
		cardPanel.add(lblMaxRevolutions);

		JLabel lblStackSize = new JLabel("Stapel: ");
		lblStackSize.setBounds(10, 7, 47, 15);
		stackSizePanel.add(lblStackSize);
		lblStackSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStackSize.setFont(new Font("Tahoma", Font.BOLD,
				DEFAULT_FONT_SIZE + 1));

		JLabel lblPlayer = new JLabel("Spieler:");
		lblPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, DEFAULT_FONT_SIZE + 1));
		lblPlayer.setBounds(10, 309, 75, 14);
		container.add(lblPlayer);
	}

	/**
	 * Initialize the panels.
	 */
	private void initializePanels() {
		cardPanel = new JPanel();
		cardPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		cardPanel.setBounds(95, 11, 266, 284);
		container.add(cardPanel);
		cardPanel.setLayout(null);

		stackSizePanel = new JPanel();
		stackSizePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		stackSizePanel.setBounds(176, 0, 90, 30);
		cardPanel.add(stackSizePanel);
		stackSizePanel.setLayout(null);

		logPane = new JScrollPane();
		logPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		logPane.setBounds(10, 340, 424, 220);
		container.add(logPane);
	}

	/**
	 * Initialize the radio buttons.
	 */
	private void initializeRadioButtons() {
		weightRadioBtn = new JRadioButton("");
		weightRadioBtn.setBounds(235, 94, 21, 23);
		cardPanel.add(weightRadioBtn);

		cylinderRadioBtn = new JRadioButton("");
		cylinderRadioBtn.setBounds(235, 124, 22, 23);
		cardPanel.add(cylinderRadioBtn);

		powerRadioBtn = new JRadioButton("");
		powerRadioBtn.setBounds(235, 154, 21, 23);
		cardPanel.add(powerRadioBtn);

		engineRadioBtn = new JRadioButton("");
		engineRadioBtn.setBounds(235, 184, 21, 23);
		cardPanel.add(engineRadioBtn);

		maxSpeedRadioBtn = new JRadioButton("");
		maxSpeedRadioBtn.setBounds(235, 214, 21, 23);
		cardPanel.add(maxSpeedRadioBtn);

		maxRevolutionsRadioBtn = new JRadioButton("");
		maxRevolutionsRadioBtn.setBounds(235, 244, 21, 23);
		cardPanel.add(maxRevolutionsRadioBtn);

		radioButtons[WEIGHT_VALUE] = weightRadioBtn;
		radioButtons[CYLINDER_VALUE] = cylinderRadioBtn;
		radioButtons[POWER_VALUE] = powerRadioBtn;
		radioButtons[ENGINE_VALUE] = engineRadioBtn;
		radioButtons[MAXSPEED_VALUE] = maxSpeedRadioBtn;
		radioButtons[MAXREVOLUTIONS_VALUE] = maxRevolutionsRadioBtn;
	}

	/**
	 * Initialize the separators.
	 */
	private void initializeSeparators() {
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 246, 2);
		cardPanel.add(separator);
	}

	/**
	 * Initialize the text fields.
	 */
	private void initializeTextFields() {
		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setEditable(false);
		nameField.setBounds(110, 65, 146, 20);
		cardPanel.add(nameField);
		nameField.setColumns(DEFAULT_FIELD_COLUMNS);

		weightField = new JTextField();
		weightField.setEditable(false);
		weightField.setBounds(140, 95, 86, 20);
		cardPanel.add(weightField);
		weightField.setColumns(DEFAULT_FIELD_COLUMNS);

		cylinderField = new JTextField();
		cylinderField.setEditable(false);
		cylinderField.setBounds(140, 125, 86, 20);
		cardPanel.add(cylinderField);
		cylinderField.setColumns(DEFAULT_FIELD_COLUMNS);

		powerField = new JTextField();
		powerField.setEditable(false);
		powerField.setBounds(140, 155, 86, 20);
		cardPanel.add(powerField);
		powerField.setColumns(DEFAULT_FIELD_COLUMNS);

		engineField = new JTextField();
		engineField.setEditable(false);
		engineField.setBounds(140, 185, 86, 20);
		cardPanel.add(engineField);
		engineField.setColumns(DEFAULT_FIELD_COLUMNS);

		maxSpeedField = new JTextField();
		maxSpeedField.setEditable(false);
		maxSpeedField.setBounds(140, 215, 86, 20);
		cardPanel.add(maxSpeedField);
		maxSpeedField.setColumns(DEFAULT_FIELD_COLUMNS);

		maxRevolutionsField = new JTextField();
		maxRevolutionsField.setEditable(false);
		maxRevolutionsField.setBounds(140, 245, 86, 20);
		cardPanel.add(maxRevolutionsField);
		maxRevolutionsField.setColumns(DEFAULT_FIELD_COLUMNS);

		stackSizeField = new JTextField();
		stackSizeField.setBounds(57, 7, 23, 15);
		stackSizePanel.add(stackSizeField);
		stackSizeField.setEditable(false);
		stackSizeField.setColumns(DEFAULT_FIELD_COLUMNS);

		playerField = new JTextField();
		playerField.setHorizontalAlignment(SwingConstants.CENTER);
		playerField.setEditable(false);
		playerField.setBounds(95, 307, 109, 20);
		container.add(playerField);
		playerField.setColumns(DEFAULT_FIELD_COLUMNS);
	}
}
