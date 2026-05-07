class Solution {
    public int addDigits(int num) {
        
        while(num >= 10){   // repeat until single digit
            
            int sum = 0;
            
            while(num > 0){
                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }
            
            num = sum;
        }
        
        return num;
    }
}