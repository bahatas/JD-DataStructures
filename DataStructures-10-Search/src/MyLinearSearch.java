import java.util.Date;

public class MyLinearSearch {
    public static int linearSearch(int[] array, int data){

        for (int i = 0; i < array.length; i++)
            if (array[i] == data)
                return i;
        return -1;
    }
}
