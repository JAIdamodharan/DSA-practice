public class longest1 {
    public static int longestSeq(int bin_num){
        String bin_str = Integer.toBinaryString(bin_num);
        int cnt = 0;
        int maxCnt = 0;
        for(char ch : bin_str.toCharArray()){
            if(ch == '1'){
                cnt++;
                if(cnt > maxCnt){
                    maxCnt = cnt;
                }
            } else {
                cnt = 0;
            }
        }
        return maxCnt;
    }
    public static int consec(int bin_num){
        String bin_str = Integer.toBinaryString(bin_num);
        int maxLength = 0;
        int currLength = 0;
        int prevLength = 0;
        for (char ch : bin_str.toCharArray()){
            if(ch == '1'){
                currLength++;
            } else {
                maxLength = Math.max(maxLength, currLength + prevLength+1);
                prevLength = currLength;
                currLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currLength + prevLength+1);
        return maxLength;
    }

    public static void main(String[] args) {
        int n = 0b11100110;
        System.out.println(longestSeq(n));
        System.out.println(consec(n));
    }
}
