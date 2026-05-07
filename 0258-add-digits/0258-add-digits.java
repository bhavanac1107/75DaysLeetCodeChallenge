class Solution {

    public int addDigits(int num) {
        
        // base condition
        if(num < 10){
            return num;
        }

        return addDigits(sumOfDigits(num));
    }

    public int sumOfDigits(int num){

        // base condition
        if(num == 0){
            return 0;
        }

        return (num % 10) + sumOfDigits(num / 10);
    }
}