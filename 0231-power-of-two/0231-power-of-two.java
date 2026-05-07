class Solution {

    public boolean isPowerOfTwo(int n) {

        // negative numbers and 0 are not powers of 2
        if(n <= 0){
            return false;
        }

        // if it becomes 1, it is power of 2
        if(n == 1){
            return true;
        }

        // if not divisible by 2
        if(n % 2 != 0){
            return false;
        }

        // recursive call
        return isPowerOfTwo(n / 2);
    }
}