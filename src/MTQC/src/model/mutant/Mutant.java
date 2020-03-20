package model.mutant;

import java.io.File;


public class Mutant {

	private String name;

	private String originalFile;

	private String mutantFile;

	private static final String tempOriginalFile = "aux_temp";

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

	public void switchOriginalMutantNames() {
		File original = new File(originalFile);
		File aux = new File(tempOriginalFile);
		File mutant = new File(mutantFile);

		original.renameTo(aux);
		mutant.renameTo(original);

	}

	public void resetOriginalMutantNames() {
		File original = new File(originalFile);
		File aux = new File(tempOriginalFile);
		File mutant = new File(mutantFile);

		original.renameTo(mutant);
		aux.renameTo(original);
		
		aux.delete();

	}
}
