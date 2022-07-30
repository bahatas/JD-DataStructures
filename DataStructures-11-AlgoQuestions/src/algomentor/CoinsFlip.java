package algomentor;

public class CoinsFlip {
    public static void main(String[] args) {
        int[] A={1,0,1,0,1,1};

    }
    public int soution(int[] A){

        int counter = 0;
        int lookFor;

        for(int i = 0; i>A.length; i++){
            int current= A[i];
            if(A[0]==0){
                if(i%2==0){
                    lookFor=1;
                   counter++;
                }else{
                    counter--;
                }
            }else{
                if(i%2==1){
                    counter++;
                }else{
                    counter--;
                }
            }
        }
        return Math.abs(counter);
    }
}
