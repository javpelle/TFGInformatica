package model.mutant;

import java.io.File;

/**
 * 
 * @author Javier & Luis
 *
 */
public class Mutant {
	
	/**
	 * Mutant name.
	 */
	private String name;

	
	/**
	 * Original file path.
	 */
	private String originalFile;
	
	
	/**
	 * Mutant file path.
	 */
	private String mutantFile;
	
	/**
	 * Temporal path for original file.
	 */
	private static final String tempOriginalFile = "aux_temp";

	/**
	 * Line where file was been modified.
	 */
	private int lineChanged;

	/**
	 * Class Constructor
	 * 
	 * @param name Mutant Name.
	 * @param originalFile Original File Path.
	 * @param mutantFile Mutant File Path.
	 * @param lineChanged Line where file was been modified.
	 */
	public Mutant(String name, String originalFile, String mutantFile, int lineChanged) {
		this.name = name;
		this.originalFile = originalFile;
		this.mutantFile = mutantFile;
		this.lineChanged = lineChanged;
	}
	
	/**
	 * Returns mutant name.
	 * @return Mutant Name String.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns original File Path.
	 * @return original File Path String.
	 */
	public String getOriginalFile() {
		return originalFile;
	}
	
	/**
	 * Returns mutant File Path.
	 * @return mutant File Path String.
	 */
	public String getMutantFile() {
		return mutantFile;
	}
	
	/**
	 * Returns line changed.
	 * @return line changed integer.
	 */
	public int getLineChanged() {
		return lineChanged;
	}

	public String toString() {
		return name;
	}
	
	/**
	 * Renames original file path to aux_temp path and
	 * mutant file path to original.
	 */
	public void switchOriginalMutantNames() {
		File original = new File(originalFile);
		File aux = new File(tempOriginalFile);
		File mutant = new File(mutantFile);

		original.renameTo(aux);
		mutant.renameTo(original);

	}
	
	/**
	 * Renames original file path to mutant path and
	 * aux_temp file path to original.
	 */
	public void resetOriginalMutantNames() {
		File original = new File(originalFile);
		File aux = new File(tempOriginalFile);
		File mutant = new File(mutantFile);

		original.renameTo(mutant);
		aux.renameTo(original);
		
		aux.delete();
	}
}
