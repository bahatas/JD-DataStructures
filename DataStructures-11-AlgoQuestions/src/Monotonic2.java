public class Monotonic2 {

        public static boolean isMonotonic2(int[] array) {
            boolean flag1=true;boolean flag2=true;
            for (int i = 0; i < array.length - 1; ++i){
                if (array[i] > array[i+1]) flag1=false;
                if (array[i] < array[i+1]) flag2=false;
            }
            return flag1||flag2;
        }
}

