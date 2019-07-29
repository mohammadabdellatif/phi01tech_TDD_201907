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
                {9, 0, 7}
        };

        // when (action to perform)
        int[][] result = MatrixUtility.sum(first, second);

        // then (verification)
        int[][] expected = new int[][]{
                {6, 8, 10},
                {12, 4, 12}
        };

        if (result.length != expected.length) {
            System.err.println("result rows are not as expected");
            return;
        }
        for (int row = 0; row < expected.length; row++) {
            if (result[row].length != expected[row].length) {
                System.err.println("invalid row length");
                return;
            }
            for (int col = 0; col < result[row].length; col++) {
                if (result[row][col] != expected[row][col]) {
                    System.err.println("invalid value found in position: " + row + "," + col);
                    return;
                }
            }
        }

        System.out.println("success");
    }
}
