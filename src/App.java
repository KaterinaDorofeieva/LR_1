import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    public static final int MAX_SIZE = 20;
    public static final int MIN_RANDOM = 1;
    public static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        int width = scanner.nextInt();
        System.out.print("Введіть висоту матриці (не більше 20): ");
        int height = scanner.nextInt();

        int[][] matrix;

        if (width <= MAX_SIZE && height <= MAX_SIZE) {
            System.out.print("Оберіть спосіб заповнення матриці (1 - ручний, 2 - рандомний): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                matrix = createManualMatrix(width, height, scanner);
            } else if (choice == 2) {
                matrix = createRandomMatrix(width, height);
            } else {
                System.out.println("Невірний вибір. Програма завершить роботу.");
                return;
            }

            printMatrix(matrix);
            findMinMaxAverage(matrix);
        } else {
            System.out.println("Розміри матриці перевищують максимально допустимі. Програма завершить роботу.");
        }
    }

    private static int[][] createManualMatrix(int width, int height, Scanner scanner) {
        int[][] matrix = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("Введіть елемент матриці [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] createRandomMatrix(int width, int height) {
        int[][] matrix = new int[width][height];
        Random random = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void findMinMaxAverage(int[][] matrix) {
        int min = matrix[0][0];
        int max = matrix[0][0];
        double sum = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                if (element < min) {
                    min = element;
                }
                if (element > max) {
                    max = element;
                }
            }
        }

        double average = sum / (matrix.length * matrix[0].length);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }
}
