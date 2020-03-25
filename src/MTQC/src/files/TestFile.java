package files;

import model.mutant.Mutant;

public class TestFile {
	
	private Mutant m;
	
	private int idTest;
	
	private String path;
	
	private String file;
	
	private String namespace;
	
	public TestFile (Mutant m, int idTest, String path, String file, String namespace) {
		this.m = m;
		this.idTest = idTest;
		this.path = path;
		this.file = file;
		this.namespace = namespace;
	}
	
	public TestFile (Mutant m, int idTest, String path, String file) {
		this.m = m;
		this.idTest = idTest;
		this.path = path;
		this.file = file;
		namespace = null;
	}
}
