package AV3.BruteForce;

public class ChessStrategy {
    public static void main(String[] args) {
        int totalPossibleAttacks = 0;

        for (int i1 = 0; i1 < 8; i1++) {
            for (int j1 = 0; j1 < 8; j1++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    for (int j2 = 0; j2 < 8; j2++) {
                        if (canAttack(i1, j1, i2, j2)) {
                            totalPossibleAttacks++;
                        }
                    }
                }
            }
        }

        System.out.println("Total possible attacks: " + totalPossibleAttacks);
    }

    private static boolean canAttack(int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            return true;
        }

        if (j1 == j2) {
            return true;
        }

        if (Math.abs(i1 - i2) == Math.abs(j1 - j2)) {
            return true;
        }

        return false;
    }
}
