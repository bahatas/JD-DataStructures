public class MyBubbleSort {
    public static int[] bubbleSort( int[] array) {
        for (int i=0;i<array.length;i++) {
            boolean swapped=false;
            for(int j=0;j<array.length-1-i;j++) {
                if(array[j]>array[j+1]) {swap(array,j,j+1);swapped=true;}
            }
            if(!swapped) return array;
        }
        return array;
    }
    private static void swap(int[] arrayx, int index1, int index2) {
        int temp=arrayx[index1];
        arrayx[index1]=arrayx[index2];
        arrayx[index2]=temp;
    }
}
