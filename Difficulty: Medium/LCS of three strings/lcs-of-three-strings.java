class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        
         int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        
        int[][][] dp = new int[l1 + 1][l2 + 1][l3 + 1];
        
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                for (int k = 1; k <= l3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                        Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        
        return dp[l1][l2][l3];
    }
}