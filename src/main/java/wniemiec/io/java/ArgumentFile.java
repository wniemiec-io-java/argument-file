/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Responsible for generating argument files.
 */
public class ArgumentFile {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private Path argumentFile;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	/**
	 * Argument file generator.
	 * 
	 * @param		directory Directory where the argument file will be stored
	 * @param		filename Argument filename (without extension)
	 * 
	 * @throws		IllegalArgumentException If directory is null or if filename
	 * is empty or null
	 */
	public ArgumentFile(Path directory, String filename) {
		if (directory == null)
			throw new IllegalArgumentException("Directory cannot be null");
		
		if ((filename == null) || filename.isBlank())
			throw new IllegalArgumentException("Filename cannot be empty");
		
		argumentFile = directory.resolve(filename + ".txt");
	}

	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	/**
	 * Generates argument file from a list of paths.
	 * 
	 * @param		paths List of paths
	 * 
	 * @return		Argument file
	 * 
	 * @throws 		IOException If an error occurs while writing the file
	 * @throws		IllegalArgumentException If paths is null
	 */
	public Path create(List<Path> paths) throws IOException {
		if (paths == null)
			throw new IllegalArgumentException("Paths cannot be null");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(argumentFile.toFile()))) {
			Path path;
			
			bw.write("\"\\");
			bw.newLine();
			
			// Writes list of paths
			for (int i=0; i<paths.size()-1; i++) {
				path = paths.get(i);
				
				bw.write(path.toAbsolutePath().toString().replaceAll("\\\\", "\\\\\\\\"));
				bw.write(File.pathSeparator + "\\");
				bw.newLine();
			}
			
			path = paths.get(paths.size()-1);
			bw.write(path.toAbsolutePath().toString().replaceAll("\\\\", "\\\\\\\\"));
			bw.write("\"");
			bw.newLine();
		}
		
		return argumentFile;
	}
	
	public void delete() throws IOException {
		Files.deleteIfExists(argumentFile);
	}
	
	public boolean exists() {
		return Files.exists(argumentFile);
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters
	//-------------------------------------------------------------------------
	public Path getFile() {
		return argumentFile;
	}
}
