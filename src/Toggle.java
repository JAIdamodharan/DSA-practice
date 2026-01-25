public class Toggle {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        boolean[] b = new boolean[n+1];
//        int c=0, o=0;
//        for(int i=1; i<=n; i++){
//            for(int j=i; j<=n; j+=i){
//                b[j] = !b[j];
//            }
//        }
//        for(int a=0; a<n; a++){
//            if(b[a]){
//                o++;
//            } else c++;
//        }
//        System.out.println(o);
//        System.out.println(c);
        //Proper Toggle code

//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        StringBuilder res = new StringBuilder();
//        for(char c : s.toCharArray()){
//            res.append((c == '0')? '1':'0');
//        }
//        System.out.println(res.toString());

//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        StringBuilder res = new StringBuilder();
//        for(char c : input.toCharArray()){
//            if(c >= 'A' && c <= 'Z'){
//                res.append((char) (c+32));
//            } else if (c >= 'a' && c <= 'z'){
//                res.append((char) (c-32));
//            } else {
//                res.append(c);
//            }
//        }
//        System.out.println(res.toString());

        int n = 10;
        boolean[] bulbs = new boolean[n];

        for(int round = 1; round <= n; round++){
            for(int i = round - 1; i < n; i += round){
                bulbs[i] = !bulbs[i]; // toggle
            }
        }

        System.out.print("Bulbs ON (index positions): ");
        for(int i = 0; i < n; i++){
            if(bulbs[i]) {
                System.out.print((i) + " "); // bulb numbers start at 1
            }
        }
    }
}
