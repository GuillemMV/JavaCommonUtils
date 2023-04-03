import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @author Guillem Magriña Vernet
 *
 */
public class Utils implements Interface {

    public Utils() {}
    
    /**
	 * Returns a matrix from the given rows and columns.
	 * @param rows
	 * @param cols
	 * @return int[][]
	 */
    @Override
    public int[][] generateIntegerMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
	        }
        }
        return matrix;
    }
    /**
     * Fill the given matrix with random generated numbers between a specified range.
     * @param matrix
     * @return int[][]
     */
    @Override
    public int[][] fillRandomIntegerMatrix(int[][] matrix, int[] range) {
    	int[][] filledMatrix = new int[matrix.length][matrix[1].length];
    	Random random = new Random();
    	int min = range[0];
    	int max = range[1];
    	int r = max-min;
    	
    	for(int i=0; i<filledMatrix.length; i++) {
    		for(int j=0; j<filledMatrix[i].length; j++) {
    			int randomNumber = random.nextInt(r+1)+min;
    			filledMatrix[i][j] = randomNumber;
    		}
    	}
        return filledMatrix;
    }
    /**
     * Prints the given matrix as a parameter.
     * @param matrix
     */
    @Override
    public void printIntegerMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
            	System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
    /**
     * Reads and prints a file line by line from the given file path.
     * @param filePath
     */
    @Override
    public void readFile(String filePath){
    	try {
    		File file =  new File(filePath);
    		FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	
        	String line;
        	while((line = br.readLine()) != null && !(line.equals(""))){
        		System.out.println(line);
        	}
        	br.close();
        	fr.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 
     * @param content
     * @param filePath
     */
    @Override
    public void writeFile(String content, String filePath) {
    	try {
    		File file = new File(filePath);
    		FileWriter fw = new FileWriter(file);
    		fw.write(content);
    		fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * Removes the duplicate elements from an array and it returns a new array without them.
     * @param array
     * @return String[]
     */
    @Override
    public String[] removeArrayDuplicates(String[] array) {
    	HashSet<String> hashset = new HashSet<>();
    	String[] newArray = new String[array.length];
    	
    	for(int i = 0; i<array.length; i++) {
    		String actualElement = array[i];
    		hashset.add(actualElement);
    	}
    	
    	for(int i = 0; i<newArray.length; i++) {
    		if(newArray[i]==null) {
    			newArray[i] = "";
    		}
    	}
    	
    	hashset.toArray(newArray);
    	return newArray;
    }
}