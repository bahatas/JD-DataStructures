public class MyBinarySearchRec {
    public static int binarySearchRec(int[] array,int data){
        return binarySearchRec(array,data,0, array.length-1);
    }
    public static int binarySearchRec(int[] array,int data,int left ,int right){
        if (right<left) return -1;
        int middle=(left+right)/2;
        if(array[middle]==data) return middle;
        if(data<array[middle]) return binarySearchRec(array, data,left,middle-1);
        return binarySearchRec(array, data,middle+1,right);
    }
}
