public class FrontandBackSearch {
    public static int fbSearch(int[] array, int data){
         // Start searching from both ends
            int front = 0, back = array.length - 1;
         // Keep searching while two indexes do not cross.
            while (front <= back)
            {
                if (array[front] == data) return front;
                if (array[back] == data) return back;
                front++;
                back--;
            }
      return -1;
    }
}
