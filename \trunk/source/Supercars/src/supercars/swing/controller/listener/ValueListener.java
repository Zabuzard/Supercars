package supercars.swing.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import supercars.swing.view.MainFrameView;

/**
 * Listener of the value buttons.
 * 
 * @author Daniel Tischner
 * 
 */
public final class ValueListener implements ActionListener {

	/**
	 * The view of the main frame.
	 */
	private final MainFrameView view;

	/**
	 * Creates a new listener of the value buttons.
	 * 
	 * @param thatView
	 *            view of the main frame
	 */
	public ValueListener(final MainFrameView thatView) {
		view = thatView;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		JRadioButton[] buttons = view.getValueButtons();
		JRadioButton invoker = (JRadioButton) e.getSource();
		if (invoker.isSelected()) {
			for (JRadioButton button : buttons) {
				if (button != invoker) {
					button.setSelected(false);
				}
			}
		} else {
			invoker.setSelected(true);
		}
	}

}
