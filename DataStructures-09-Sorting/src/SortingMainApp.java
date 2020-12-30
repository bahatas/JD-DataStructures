import java.util.Arrays;

public class SortingMainApp {
    public static void main(String[] args) {
        var myarray=new int[]{8, 2, 4, 1, 3};
        //var quickSort= new MyQuickSort();
        //quickSort.sort(myarray);
        //System.out.println(Arrays.toString(myarray));
        var mybubbleSort=new MyBubbleSort();
        System.out.println(Arrays.toString(mybubbleSort.bubbleSort(myarray)));
    }

}
