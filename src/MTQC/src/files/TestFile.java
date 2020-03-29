package files;

public class TestFile {
	
	private String mutantName;
	
	private int idTest;
	
	private String path;
	
	private String fileName;
	
	private String extension;
	
	public TestFile (String mutantName, int idTest, String path, String fileName) {
		this.mutantName = mutantName;
		this.idTest = idTest;
		this.path = path;
		this.fileName = fileName.substring(0, fileName.length() - 3);
		extension = fileName.substring(fileName.length() - 3);
	}
	
	public String getFileName() {
		return fileName;
	}
}
