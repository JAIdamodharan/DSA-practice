public class HourGlass{
    static int findMaxSum(int[][] mat, int r, int c) {
        int maxSum = 0;
        int sum;
        if (r < 3 || c < 3){
            System.out.println("not possible");
            System.exit(0);
        }
        for(int i=0; i< r-2; i++){
            for(int j=0; j< c-2; j++){
                sum = (mat[i][j] +
                        mat[i][j+1]+
                        mat[i][j+2])+
                        (mat[i+1][j+1])+
                        (mat[i+2][j]+
                        mat[i+2][j+1]+
                        mat[i+2][j+2]);
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println(findMaxSum(mat, 6, 6));
    }
}