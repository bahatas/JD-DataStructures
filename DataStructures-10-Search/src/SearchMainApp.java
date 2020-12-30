public class SearchMainApp {
    public static void main(String[] args) {
        int[] myarray=new int[]{1,2,3,4,5,6,89,100,113,109,112};
        var mylinearsearch=new MyLinearSearch();

        System.out.println("Linear Search : " +mylinearsearch.linearSearch(myarray,112));

    }
}
