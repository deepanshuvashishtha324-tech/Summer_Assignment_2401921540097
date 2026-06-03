class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left=0;
        int right=n-1;
        int index=n-1;
        int[] res= new int[n];
        while(left<=right){
            int leftSqr = nums[left]* nums[left];
            int rightSqr = nums[right]* nums[right];
            if(leftSqr > rightSqr){
                res[index]= leftSqr;
                left++;
            }
            else{
                res[index]= rightSqr;
                right--;
            }
            index--;
        }
        return res;

        
    }
}