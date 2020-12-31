public class MyBinarySearchIterative {
    public int binSearchIterative(int[] array,int data){
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middle=(left+right)/2;
            if(array[middle]==data) return middle;
            if(data<array[middle]) right=middle-1;
            else left=middle+1;
        }
        return -1;
    }
}
