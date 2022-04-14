package jd2;

import java.util.Arrays;

public class ArrayProduct {
/*
    Write a function that takes in a non-empty array of integers and returns an array of the same
    length, where each element in the output array is equal to the product of every other number
    in the input array. In other words, the value at output[i] is equal to the product of every
    number in the input array other than input[i] . Note that you're expected to solve this problem
    without using division.
    Sample Input array = [5, 1, 4, 2]
    Sample Output [8, 40, 10, 20]
    // 8 is equal to 1 x 4 x 2
    // 40 is equal to 5 x 4 x 2
// 10 is equal to 5 x 1 x 2
// 20 is equal to 5 x 1 x 4

1) for loop , go for each element
2) set current element to 1
3) multiply all elements and assign to its proper location in the new array

 */

    public static void main(String[] args) {

        int[] arr = {5, 1, 4, 2}; //  {8,1,4,2}

        //   Left Array[1, 5, 5, 20]
        //  Right Array[8, 8, 2, 1]
        //   [8, 40, 10, 20]

        //  System.out.println(Arrays.toString(multiplierMain(arr)));
        productArray(arr);

    }
    public int[] productExceptSelf(int[] nums) {
    int[] products = new int[nums.length];
    int leftRunningProduct = 1;
    for(int i = 0; i < nums.length; i++) {
        products[i] = leftRunningProduct;
        leftRunningProduct *= nums[i];
    }
    int rightRunningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
        products[i] *= rightRunningProduct;
        rightRunningProduct *= nums[i];    }
   return products;


}

    public static int[] multiplierMain(int[] arr) {  // current number is not to be multiplied


        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = multiplier(arr, arr[i]);
        } // O(n^2)

        return newArr;
    }


    public static int multiplier(int[] array, int current) {
        int product = 1;
        for (int i = 0; i < array.length; i++) { //O(n)
            if (array[i] != current) {
                product *= array[i];
            }
        }
        return product;
    }


    public static int[] productArray(int arr[]) {
        int n = arr.length;
        // Base case
        if (n == 1) {
            System.out.print(0);
            return new int[]{};
        }
        // Initialize memory to all arrays
        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];

        int i, j;

        /* Left most element of left array
is always 1 */
        left[0] = 1;

        /* Right most element of right
array is always 1 */
        right[n - 1] = 1;

        /* Construct the left array */
        for (i = 1; i < n; i++) {  // i=1,2,3
            left[i] = arr[i - 1] * left[i - 1];
            // System.out.println(left[i]);
        }

        /* Construct the right array */
        for (j = n - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j + 1];
            //  System.out.println(right[j]);
        }

        /* Construct the product array using
        left[] and right[] */
        for (i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];

        }


        System.out.println("Left Array"+Arrays.toString(left));
        System.out.println("Right Array" + Arrays.toString(right));
        System.out.println(Arrays.toString(prod));

        return prod;
    }
}
