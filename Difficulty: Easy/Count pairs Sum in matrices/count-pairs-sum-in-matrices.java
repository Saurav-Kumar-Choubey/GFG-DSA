class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        
          int n=mat1.length;
        int[] arr1 = new int[n*n];  
        int[] arr2 = new int[n*n]; 
        int count=0;
        int p=0;
        int q=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr1[p]=mat1[i][j];
                p++;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr2[q]=mat2[i][j];
                q++;
            }
        }
        int i=0;
        int j=arr2.length-1;
        while(i<arr1.length&&j>=0){
            int sum = arr1[i]+arr2[j];
            if(sum==x){
                count++;
                i++;
                j--;
            }
            else if(sum<x){
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
}