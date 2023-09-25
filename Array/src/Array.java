import java.util.Arrays;

public class Array {
    private int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    public Array(int size) {
        this.array = new int[size];
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public void bubbleSort() {
        int n = array.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public void shakerSort() {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            left++;
        }
    }

    public void selectionSort() {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public void insertionSort() {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void shellSort() {
        int n = array.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }

            if (gap == 2) {
                gap = 1;
            } else {
                gap = (int) (gap / 2.2);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 9, 3, 4, 6};
        Array arr = new Array(data);

        System.out.println("Original array:");
        arr.printArray();

        arr.bubbleSort();
        System.out.println("\nBubble sorted array:");
        arr.printArray();

        int[] data2 = {8, 1, 7, 6, 0, 4};
        Array arr2 = new Array(data2);

        System.out.println("\nOriginal array:");
        arr2.printArray();

        arr2.shakerSort();
        System.out.println("\nShaker sorted array:");
        arr2.printArray();

        int[] data3 = {12, 11, 13, 5, 6};
        Array arr3 = new Array(data3);

        System.out.println("\nOriginal array:");
        arr3.printArray();

        arr3.selectionSort();
        System.out.println("\nSelection sorted array:");
        arr3.printArray();

        int[] data4 = {9, 7, 8, 3, 5};
        Array arr4 = new Array(data4);

        System.out.println("\nOriginal array:");
        arr4.printArray();

        arr4.insertionSort();
        System.out.println("\nInsertion sorted array:");
        arr4.printArray();

        int[] data5 = {10, 2, 6, 8, 4};
        Array arr5 = new Array(data5);

        System.out.println("\nOriginal array:");
        arr5.printArray();

        arr5.mergeSort();
        System.out.println("\nMerge sorted array:");
        arr5.printArray();

        int[] data6 = {15, 9, 12, 7, 6};
        Array arr6 = new Array(data6);

        System.out.println("\nOriginal array:");
        arr6.printArray();

        arr6.shellSort();
        System.out.println("\nShell sorted array:");
        arr6.printArray();
    }
}
