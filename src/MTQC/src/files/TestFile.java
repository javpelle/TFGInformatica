package files;

import java.io.File;

public class TestFile {

	private String mutantName;

	private int idTest;

	private String path;

	private String fileName;

	private String completeName;

	public TestFile(String mutantName, int idTest, String path, String fileName) {
		this.mutantName = mutantName;
		this.idTest = idTest;
		this.path = path;
		this.fileName = fileName.substring(0, fileName.length() - 3);
		completeName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getCompletePath() {
		return path + File.separator + completeName;
	}

	public String getMutantName() {
		return mutantName;
	}

	public int getIdTest() {
		return idTest;
	}
}
