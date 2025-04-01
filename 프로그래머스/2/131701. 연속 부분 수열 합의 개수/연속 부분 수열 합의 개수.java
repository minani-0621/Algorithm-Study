import java.util.*;

class Solution {
    HashSet<Integer> hashset = new HashSet<>();
    
    public int solution(int[] elements) {
        int[] array = new int[elements.length * 2];
        int[] prefixSum = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
            array[i + elements.length] = elements[i];
        }
        
        prefixSum[0] = array[0];
        
        for(int i = 1; i < elements.length * 2; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
        
        for(int i = 1; i <= elements.length; i++) { // window 사이즈 (1 ~ 최대 크기까지)
            for(int j = 0; j <= elements.length - 1; j++) { // 윈도우 시작 지점
                if(j == 0) {
                    hashset.add(prefixSum[i - 1]);
                }else {
                    hashset.add(prefixSum[i + j - 1] - prefixSum[j - 1]);
                }
            }
        }
        
        return hashset.size();
    }
}