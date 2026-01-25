public class SegmentedSieve {
    public static void segSieve(int l, int h){
        boolean[] prime = new boolean[h+1];
        for(int p=2; p<=h ; p++){
            int sm = (l/p)*p;
            if(sm < l) sm+=p;
            for(int i=sm; i<= h; i+=p){
                if(i!=p) prime[i] = true;
            }
        }
        for(int i=l; i<= h ; i++){
            if(!prime[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        segSieve(60,100);
    }
}