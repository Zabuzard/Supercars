package supercars.swing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import supercars.swing.controller.MainFrameController;
import supercars.swing.controller.logging.Logger;
import supercars.swing.view.MainFrameView;

/**
 * Starts the game in a frame.
 * 
 * @author Zabuza
 * 
 */
public final class FrameLauncher {

	/**
	 * Launch the view.
	 * 
	 * @param args
	 *            Not supported
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = null;
				MainFrameView window = null;
				Logger logger = null;
				try {
					frame = new JFrame();
					frame.setResizable(false);
					frame.setTitle("Autoquartett");
					frame.setBounds(0, 0, MainFrameView.HEIGHT,
							MainFrameView.WIDTH);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					frame.setLocation(
							(screenSize.width - frame.getWidth()) / 2,
							(screenSize.height - frame.getHeight()) / 2);

					window = new MainFrameView(frame.getContentPane());
					logger = new Logger(window);
					MainFrameController controller = new MainFrameController(
							window, logger);
					controller.initialize();
					controller.startGame();
				} catch (Exception e) {
					if (logger != null) {
						logger.logUnknownError(e);
					}
				} finally {
					if (frame != null) {
						frame.setVisible(true);
					}
				}
			}
		});
	}

	/**
	 * Utility class. No implementation.
	 */
	private FrameLauncher() {

	}

}
