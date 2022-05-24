package datastrucutresAndAlgorithms.ey.training.week8.day33;

public class RotateImage {
	
	
	/**
	 * 1 2 3       7 4 1
	 * 4 5 6       8 5 2
	 * 7 8 9       9 6 3
	 * 
	 * 
	 * 9 6 3
	 * 4 5 2
	 * 7 8 1
	 * 
	 * 
	 * 9 6 3
	 * 8 5 2
	 * 7 4 1
	 * 
	 * 
	 * 
	 * 7 4 1
	 * 8 5 2
	 * 9 6 3
	 */
	
	public void rotate(int[][] matrix) {
        int index  =0;
        for( ; index < matrix.length-1; index++ ){

            int startRow = index , column = matrix.length-index-1, tempColumn =matrix.length-index-2, tempRow =index+1;

            while(tempColumn > -1){
                int tempValue = matrix[startRow][tempColumn];
                matrix[startRow][tempColumn--] =  matrix[tempRow][column];
                matrix[tempRow++][column] = tempValue;
            }
        }

        int start = 0, end = matrix.length-1;

        while(start < end){
            int[] temp = matrix[start];
            matrix[start++] = matrix[end];
            matrix[end--]=temp;
        }

    }

}
