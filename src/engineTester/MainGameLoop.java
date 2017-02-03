package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader  = new Loader();
		Renderer renderer = new Renderer();
		
		StaticShader shader = new StaticShader();
		
		float[] vertices = { 
				-0.5f, 0.5f,0, 	//V0   v0 ---- v3
				-0.5f,-0.5f,0,	//V1     |    |
				0.5f, -0.5f,0,	//V2     |    |
				0.5f, 0.5f,0,	//V3   v1 ---- v2
		};
		int[] indices = {
				0,1,3,
				3,1,2
		};
		
		float[] textureCords = {
				0,0,	//V0
				0,1,	//V1
				1,1,	//v2
				1,0		// v3
		};
		
		RawModel model = loader.loadToVAO(vertices,textureCords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("rabbit"));
		TexturedModel textureModel = new TexturedModel(model, texture);
		
		while(!Display.isCloseRequested()){
			//Game Logic
			
			//Render
			renderer.prepare();
			shader.start();
			renderer.render(textureModel);
			shader.stop();
			DisplayManager.updateDisplay();
			
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		
	}

}
