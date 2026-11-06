package AV3.Greedy;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int minAmountOfCoins = 0;
        int[] coins = {50, 10, 5, 2, 1};
        int i = 0;

        while (sum > 0) {
            if (sum - coins[i] >= 0) {
                sum -= coins[i];
                minAmountOfCoins++;
            } else {
                i++;
            }
        }


//        VARIATION 2
//        for (int j = 0; j < coins.length; j++) {
//            if (sum / coins[j] > 0) {
//                minAmountOfCoins += sum / coins[j];
//                sum -= coins[j] * (sum / coins[j]);
//            }
//        }


        System.out.println(minAmountOfCoins);
    }

}
