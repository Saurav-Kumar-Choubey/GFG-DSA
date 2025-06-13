class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int left = 1, right = 0;
        for (int pile : arr) {
            right = Math.max(right, pile);
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : arr) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
