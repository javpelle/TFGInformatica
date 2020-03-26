package files;

public class TestFile {
	
	private String mutantName;
	
	private int idTest;
	
	private String path;
	
	private String fileName;
	
	public TestFile (String mutantName, int idTest, String path, String fileName) {
		this.mutantName = mutantName;
		this.idTest = idTest;
		this.path = path;
		this.fileName = fileName;
	}
}
