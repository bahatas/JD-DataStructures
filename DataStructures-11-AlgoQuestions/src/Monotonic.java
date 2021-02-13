public class Monotonic {
    public static boolean isMonotonic(int[] array) {
        boolean flag1=true;boolean flag2=true;
        // Check if monotone increasing
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i] > array[i+1]) flag1=false;
        // Check if monotone decreasing
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i] < array[i+1]) flag2=false;

        return flag1||flag2;
    }
}
