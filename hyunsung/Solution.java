package hyunsung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public long solution(long n) {
        
        List<Long> nums = new ArrayList<>();
        long result = n;
        
        
        while (n > 0) {
            nums.add(n% 10);
            n /= 10;
        }
        result = 0;
        nums.sort(Comparator.reverseOrder());

        
        for (int i = 0; i < nums.size(); i++) {
            result = result * 10 + nums.get(i);
        }

        return result;
    
    }
}