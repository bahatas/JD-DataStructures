import java.util.Random;

public class TestAppForLinearSearch {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] myarray = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            myarray[i] = rand.nextInt(1000000);
        }

         // myarray[750000]=-11;

       // int data=-11;
        var frontandbacksearch = new FrontandBackSearch();
        var mylinearsearch = new MyLinearSearch();

        int[] linearSearchResults=new int[10000];// will collect linear search time results
        int[] frontBackSearchResults=new int[10000]; // will collect front and back search results

        //expcount stands for Experiment count
        for (int expCount = 0; expCount < 10000; expCount++) {
           int data = rand.nextInt(1000000);
            // Calculate time for Linear Search
            long startTime = System.currentTimeMillis();
            mylinearsearch.linearSearch(myarray, data);
            long endTime = System.currentTimeMillis();
            linearSearchResults[expCount]= (int)(endTime - startTime);
            //-------------Calculate time for Front Back Search
            startTime = System.currentTimeMillis();
            frontandbacksearch.fbSearch(myarray, data);
            endTime = System.currentTimeMillis();
            frontBackSearchResults[expCount]= (int)(endTime - startTime);
        }
        double sum=0;
        for (double num: linearSearchResults) {
            sum += num;
        }
        double averageLinSearch = sum / linearSearchResults.length;
        System.out.format("The average of Linear Search is: %.2f", averageLinSearch);

        sum=0;
        for (double num: frontBackSearchResults) {
            sum += num;
        }
        System.out.println();
        double averageFBSearch = sum / frontBackSearchResults.length;
        System.out.format("The average of Front Back Search is: %.2f", averageFBSearch);

    }
}
