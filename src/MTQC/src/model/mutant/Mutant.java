package model.mutant;

public class Mutant {

	private String name;

	private String originalFile;

	private String mutantFile;

	private int lineChanged;

	public Mutant(String name, String originalFile, String mutantFile, int lineChanged) {
		this.name = name;
		this.originalFile = originalFile;
		this.mutantFile = mutantFile;
		this.lineChanged = lineChanged;
	}

	public String getName() {
		return name;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public String getMutantFile() {
		return mutantFile;
	}

	public int getLineChanged() {
		return lineChanged;
	}
	
	public String toString() {
		return name;
	}
	
	
}
