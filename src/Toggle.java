import java.util.*;

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

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z'){
                result.append((char)(ch+32));
            } else if (ch >= 'a' && ch <= 'z'){
                result.append((char)(ch-32));
            } else{
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
}
