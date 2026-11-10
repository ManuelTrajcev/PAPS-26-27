package AV4.Algorithms;

public class Cookies {
    public static void main(String[] args) {
        int[] originalSizes = {4, 1, 12, 4, 8};
        int[] desiredSizes = {2, 5, 4, 3, 11};

        bubbleSort(originalSizes);
        bubbleSort(desiredSizes);

        if (desiredSizes.length> originalSizes.length){
            System.out.println("Not enough cookies for all children.");
        }

        for (int i = 0; i < desiredSizes.length; i++)  {
            System.out.println("Child descired size: " + desiredSizes[i] + ", Cookie size: " + originalSizes[i]);
        }

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
