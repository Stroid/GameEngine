package shaders;

public class StaticShader extends ShaderProgram{

	private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	private static final String FAGMENT_FILE = "src/shaders/fragmentShader.txt";
	
	public StaticShader() {
		super(VERTEX_FILE, FAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCords");
	}

}
