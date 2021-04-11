package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }
    // ADD TESTS TO CHECK PARTITIONS
    @Test
    public void test2x3() {
        int[][] inMatrix  = { {1, 2, 3}, {3, 4, 5} };
        int[][] expOutput = { {1, 2, 3}, {5, 4, 3} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

    @Test
    public void test3x5() {
        int[][] inMatrix  = { {1, 2, 3}, {3, 4, 5}, {5, 2, 7}, { 6, 2, 7}, { 9, 6, 2} };
        int[][] expOutput = { {1,2,3},{5,7,7} , { 2,6,9} ,{6,5,3},{4,2,2}  };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }
    @Test
    public void test3x3(){
        int[][] inMatrix  = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] expOutput = { {1, 2, 3}, {6, 9, 8}, {7, 4, 5} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

    @Test
    public void test3x2(){
        int[][] inMatrix  = { {1, 1}, {2, 2}, {3, 3} };
        int[][] expOutput = { {1, 1}, {2, 3}, {3, 2} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

    @Test
    public void test4x2(){
        int[][] inMatrix  = { {1, 1, 3, 4}, {2, 2 , 6 ,5} };
        int[][] expOutput = { {1, 1, 3, 4}, {5, 6, 2, 2} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }
    @Test
    public void test2x4(){
        int[][] inMatrix  = { {1, 1},{ 3, 4}, {2, 2 }, {6 ,5} };
        int[][] expOutput = { {1, 1} ,{4, 2}, {5, 6}, {2, 3} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }
    @Test
    public void test3x4(){
        int[][] inMatrix  = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {11,12,13} };
        int[][] expOutput = { {1, 2, 3}, {6, 9, 13},{12, 11, 7}, {4, 5, 8} };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

    @Test
    public void test5x5(){
        int[][] inMatrix  = { {1, 2, 3, 4, 5}, {4, 5, 6, 7 ,8}, {7, 8, 9, 10 ,11}, {11, 12, 13, 1, 2} ,{1,2,3,4,5}};
        int[][] expOutput = { {1, 2, 3, 4, 5}, {8, 11, 2, 5, 4},{3, 2, 1, 11 , 7}, {4, 5, 6, 7, 10},{1,13, 12, 8,9}  };
        assertArrayEquals(expOutput,MatrixHelixMorph.helix(inMatrix));
    }

}
