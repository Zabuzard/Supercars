package supercars.swing.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import supercars.swing.controller.MainFrameController;
import supercars.swing.controller.logging.Logger;
import supercars.swing.model.cards.Card;
import supercars.swing.view.MainFrameView;

/**
 * Listener of the choose button.
 * 
 * @author Daniel Tischner
 * 
 */
public final class ChooseListener implements ActionListener {

	/**
	 * The view of the main frame.
	 */
	private final MainFrameView view;
	/**
	 * The controller of the main frame.
	 */
	private final MainFrameController controller;
	/**
	 * Logger of the main frame.
	 */
	private final Logger logger;

	/**
	 * Creates a new listener of the choose button.
	 * 
	 * @param thatView
	 *            view of the main frame
	 * @param thatController
	 *            controller of the main frame
	 * @param thatLogger
	 *            logger of the main frame
	 */
	public ChooseListener(final MainFrameView thatView,
			final MainFrameController thatController, final Logger thatLogger) {
		view = thatView;
		controller = thatController;
		logger = thatLogger;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		try {
			if (controller.isGameOver()) {
				logger.logGameOver();
				return;
			}
			int currentValue = currentValue();
			if (currentValue != MainFrameView.VALUE_NO) {
				int[] values = new int[controller.getPlayers().length];

				switch (currentValue) {
				case MainFrameView.CYLINDER_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getCylinder();
					}
					break;
				case MainFrameView.ENGINE_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getEngineDisplacement();
					}
					break;
				case MainFrameView.MAXREVOLUTIONS_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getMaxRevolutions();
					}
					break;
				case MainFrameView.MAXSPEED_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getMaxSpeed();
					}
					break;
				case MainFrameView.POWER_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getPower();
					}
					break;
				case MainFrameView.WEIGHT_VALUE:
					for (int i = 0; i < values.length; i++) {
						values[i] = controller.getPlayers()[i].lookupTopCard()
								.getWeight();
					}
					break;
				default:
					logger.logNoButtonError();
				}

				int bestPlayer = 0;
				int maxValue = -1;
				for (int i = 0; i < values.length; i++) {
					if (values[i] > maxValue) {
						maxValue = values[i];
						bestPlayer = i;
					}
				}
				for (int i = 0; i < values.length; i++) {
					if (i != bestPlayer && values[i] == maxValue) {
						logger.logPlayerDraw();
						return;
					}
				}

				logger.logPlayerWonTurn(controller.getPlayers()[bestPlayer],
						bestPlayer, controller.getPlayers(), values);

				Card[] cards = new Card[values.length];

				for (int i = 0; i < values.length; i++) {
					cards[i] = controller.getPlayers()[i].removeTopCard();
				}
				for (Card card : cards) {
					controller.getPlayers()[bestPlayer]
							.insertCardAtBottom(card);
				}

				controller.nextTurn(bestPlayer);
			} else {
				logger.logNoButtonError();
			}
		} catch (Exception ex) {
			if (logger != null) {
				logger.logUnknownError(ex);
			}
		}
	}

	/**
	 * Gets the current selected choosable value of the view.
	 * 
	 * @return current selected choosable value of the view
	 */
	private int currentValue() {
		JRadioButton[] buttons = view.getValueButtons();
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].isSelected()) {
				return i;
			}
		}
		return MainFrameView.VALUE_NO;
	}

}
