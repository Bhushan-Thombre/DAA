// Name = Bhushan Thombre
// Division = D
// Batch = D1
// Roll No. = 324021
// Gr No. = 22010801

// Assignment 1
// Implement Quick Sort using Divide and Conquer

import java.util.Arrays;

public class Main {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Array before sorting is");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 3);
        System.out.println("Array after sorting is");
        System.out.println(Arrays.toString(arr));
    }
}

// Time Complexity
// Best Case = O(nlogn)
// Worst Case = O(n * n)