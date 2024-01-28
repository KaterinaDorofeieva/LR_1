import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {

    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the width of the matrix (max 20): ");
        int width = Math.min(scanner.nextInt(), MAX_SIZE);

        System.out.print("Enter the height of the matrix (max 20): ");
        int height = Math.min(scanner.nextInt(), MAX_SIZE);

        int[][] matrix;

        System.out.print("Choose matrix creation method (1 - Manual, 2 - Random): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            matrix = createMatrixManually(width, height, scanner);
        } else if (choice == 2) {
            matrix = createMatrixRandomly(width, height);
        } else {
            System.out.println("Invalid choice. Exiting program.");
            return;
        }

        System.out.println("Matrix:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Minimum Element: " + min);
        System.out.println("Maximum Element: " + max);
        System.out.println("Arithmetic Average: " + average);
    }

    private static int[][] createMatrixManually(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }

        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }
}
