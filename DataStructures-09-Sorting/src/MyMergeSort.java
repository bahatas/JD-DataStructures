public class MyMergeSort {
    public void mergeSort(int[] array){
        if (array.length<2) return;// termination criteria;
        int mid=array.length/2; // calculate middle value
        int [] leftArray=new int[mid];// create new array for left part
            for(int i=0;i<mid;i++) leftArray[i]=array[i]; // assign values with the left part
        int [] rightArray=new int[array.length-mid];//create new array for right part
             for(int i=mid;i<array.length;i++) rightArray[i-mid]=array[i];//assign values
        mergeSort(leftArray); // call merge sort recursively for left
        mergeSort(rightArray); // call merge sort recursively for right
        merge(leftArray,rightArray,array);// merge solutions
    }
    private void merge(int[] left, int[] right, int[] result){
        int i=0,j=0,k=0;
        while(i<left.length&& j<right.length){
            if(left[i]<=right[j]) result[k++]=left[i++];
            else result[k++]=right[j++];
        }
        while (i<left.length) result[k++]=left[i++];
        while (j<right.length) result[k++]=right[j++];
    }
}
