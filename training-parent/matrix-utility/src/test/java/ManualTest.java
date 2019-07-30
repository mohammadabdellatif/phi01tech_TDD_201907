import com.phi01tech.training.matrix.MatrixUtility;

public class ManualTest {

    public static void main(String[] args) {
        // given (setup and inputs)
        int[][] first = new int[][]{
                {1, 2, 3},
                {3, 4, 5}
        };
        int[][] second = new int[][]{
                {5, 6, 7},
                {9, 0}
        };

        // when (action to perform)
        int[][] result = MatrixUtility.sum(first, second);

        // then (verification)
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.append(result[row][col] + "").append(" ");
            }
            System.out.println();
        }
    }
}
