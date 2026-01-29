public class TOH {
    static int moveCnt = 0;

    public static void toh(int n, char s, char a, char d){
        if(n == 1){
            System.out.println("move disk 1 from "+s+" to "+d);
            moveCnt++;
            return;
        }

        toh(n-1, s,a,d);
        System.out.println("Move disk "+n+" from "+s+" to "+d);
        moveCnt++;
        toh(n-1, a,d,s);
    }

    public static void main(String[] args) {
        toh(3,'A','B','C');
        System.out.println("Total Moves: "+moveCnt);
    }
}

