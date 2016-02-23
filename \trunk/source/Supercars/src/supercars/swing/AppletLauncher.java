package supercars.swing;

import java.awt.Container;

import javax.swing.JApplet;

import supercars.swing.controller.MainFrameController;
import supercars.swing.controller.logging.Logger;
import supercars.swing.view.MainFrameView;

/**
 * Starts the game in an applet.
 * 
 * @author Daniel Tischner
 * 
 */
public final class AppletLauncher extends JApplet {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -5872079495272280073L;

	/**
	 * True if tool has started.
	 */
	private boolean started = false;

	@Override
	public void init() {

	}

	@Override
	public void start() {
		if (!started) {
			started = true;
			Container container = null;
			MainFrameView window = null;
			Logger logger = null;
			try {
				container = new Container();
				window = new MainFrameView(container);
				logger = new Logger(window);
				MainFrameController controller = new MainFrameController(
						window, logger);
				controller.initialize();
			} catch (Exception e) {
				if (logger != null) {
					logger.logUnknownError(e);
				}
			} finally {
				setContentPane(container);
				setFocusable(false);
				if (container != null) {
					container.setFocusCycleRoot(true);
					container.setVisible(true);
				}
			}
		}
	}

	@Override
	public void stop() {
		if (started) {
			started = false;
		}
	}

}
