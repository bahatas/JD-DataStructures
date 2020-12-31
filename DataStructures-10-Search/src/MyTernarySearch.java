public class MyTernarySearch {
    public static int ternarySearch(int[] array,int data){
        return ternarySearch(array,data,0, array.length-1);
    }
    public static int ternarySearch(int[] array,int data,int left ,int right){
        if (right<left) return -1;// Base Condition, termination
        int partition=(right-left)/3;
        int middle1=left+partition;
        int middle2=right-partition;

        if(array[middle1]==data) return middle1;
        if(array[middle2]==data) return middle2;

        if(data<array[middle1]) return ternarySearch(array, data,left,middle1-1);
        if(data>array[middle2]) return ternarySearch(array, data,middle2+1,right);

        return ternarySearch(array, data,middle1+1,middle2-1);//middle partition
    }
}
