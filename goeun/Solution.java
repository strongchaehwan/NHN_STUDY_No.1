import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();


        for(int i=0; i<arr.length; i++){
            if(i == 0){
                answer.add(arr[0]);
            }
            else if(answer.get(answer.size()-1) != arr[i]){
                answer.add(arr[i]);
            }
        }
        
        int[] resultArray = new int[answer.size()];
        for(int i=0; i<resultArray.length; i++){
            resultArray[i] = answer.get(i);
        }
        return resultArray;
    }
}