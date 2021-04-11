package helix;

import java.util.ArrayList;
import java.util.List;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a inMatrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        int R = inMatrix.length; // getting number of rows
        int C = inMatrix[0].length; // getting number of columns
        List listArray = new ArrayList(); //empty list array to store the values
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0;
        int c = 0;
        int di = 0;
        for (int i = 0; i < R * C; i++) {
            listArray.add(inMatrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        int listIndex = 0;
        int[][] spiralMatrix = new int[R][C];
        for (int i = 0; i < inMatrix.length; i++) {
            for (int j = 0; j < inMatrix[0].length; j++) {
                spiralMatrix[i][j] = (int) listArray.get(listIndex);
                listIndex++;
            }
        }
        return spiralMatrix;
    }
}
//        //converting list to 2d array
//        int resultRows = ans.size()/R;
//        if(ans.size()%R!=0){
//            resultRows++;
//        }
//        int[][] result = new int[resultRows][R];
//        // ans;
//        return result; //MODIFY THIS METHOD https://www.educative.io/edpresso/spiral-matrix-algorithm

