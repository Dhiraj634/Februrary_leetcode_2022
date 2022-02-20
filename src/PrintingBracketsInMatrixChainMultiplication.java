import java.util.Arrays;

class PrintingBracketsInMatrixChainMultiplication{
    static String matrixChainOrder(int p[], int n){
        int[][] dp = new int[n][n];
        for(int[] t: dp)
            Arrays.fill(t, Integer.MAX_VALUE);
        String[][] pair = new String[n][n];
        char ch = 'A';
        for(int i=1;i<=n-1;i++){
            pair[i][i] = String.valueOf((char)(ch + i -1));
            dp[i][i]=0;
        }
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<n;i++){
                int row = i;
                int col = i+len -1;
                int finalK = -1;
                for(int k=row;k<col && col <n;k++){
                    int temp = dp[row][k]+dp[k+1][col]+p[row-1]*p[k]*p[col];
                    if(temp < dp[row][col]){
                        finalK = k;
                    }
                    dp[row][col] = Math.min(dp[row][col],temp);
                }
                if(finalK!=-1)
                    pair[row][col] = "("+pair[row][finalK]+pair[finalK+1][col]+")";
            }
        }
        return pair[1][n-1];

    }
}
