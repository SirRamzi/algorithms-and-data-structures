import java.util.Scanner;

public class BrickGame {
    static int[][] field = new int[4][4];
    static int[][] bricks = { { 2, 1 }, { 1, 2 } };
    static int[] xCoords = new int[4];
    static int[] yCoords = new int[4];

    public static void main(String[] args) {
        String s;
        try (Scanner in = new Scanner(System.in)) {
            s = in.nextLine();
        } catch (Exception e) {
            System.out.println("Ошибка чтения строки");
            return;
        }
        int brickCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int brickType = Integer.parseInt(s.substring(i, i + 1));
            boolean placed = false;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (field[j][k] == 0) {
                        if (bricks[brickType][0] <= 4 - j && bricks[brickType][1] <= 4 - k) {
                            for (int l = j; l < j + bricks[brickType][0]; l++) {
                                for (int m = k; m < k + bricks[brickType][1]; m++) {
                                    field[l][m] = 1;
                                }
                            }
                            xCoords[brickCount] = j;
                            yCoords[brickCount] = k;
                            brickCount++;
                            placed = true;


for (int a = 0; a < 4; a++) {
        boolean isRowComplete = true;
        boolean isColComplete = true;
        for (int b = 0; b < 4; b++) {
            if (field[a][b] != 1) {
                isRowComplete = false;
            }
            if (field[b][a] != 1) {
                isColComplete = false;
            }
        }
        if (isRowComplete) {
            for (int b = 0; b < 4; b++) {
                field[a][b] = 0;
            }
        }
        if (isColComplete) {
            for (int b = 0; b < 4; b++) {
                field[b][a] = 0;
            }
        }
    }


                            break;
                        }
                    }
                }
                if (placed) {
                    break;
                }
            }
            if (!placed) {
                System.out.println("Невозможно разместить все кирпичи на поле.");
                return;
            }
        }
        for (int i = 0; i < brickCount; i++) {
            System.out.println((xCoords[i]+1) + " " + (yCoords[i]+1));
        }
    }
}
