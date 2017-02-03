package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

	private static String title = "GameEngine";
	
 	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private static final int FPS_CAP = 120;
	
	// Open Display.
	public static void createDisplay() {

		ContextAttribs attribs = new ContextAttribs(3,2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		try {
			//Set the Display size.
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			
			//Create the display.
			Display.create(new PixelFormat(), attribs);
			
			//Set the titel of the display
			
			Display.setTitle(title );
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		//Set where the game will be drawn on the display;
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
	}

	// Update display every frame.
	public static void updateDisplay() {

		//Set the max FPS allowed
		Display.sync(FPS_CAP);
		
		//Update the Display.
		Display.update();
		
	}

	// Exit Display.
	public static void closeDisplay() {
		Display.destroy();
	}

}
