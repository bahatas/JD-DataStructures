public class MySelectionSort {
    public static int[] selectionSort(int[] array){
        for(int i=0;i<array.length;i++) {
            int minIndex=i;
            for(int j=i+1;j<array.length;j++) if(array[j]<array[minIndex]) minIndex=j;
            swap(array,minIndex,i);
        }
        return array;
    }
    private static void swap(int[] array, int index1, int index2) {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
}
