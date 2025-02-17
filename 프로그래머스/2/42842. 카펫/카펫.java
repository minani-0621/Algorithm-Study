class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width, height;
        int[] answer = new int[2];
        
        // 전체 블록의 소인수분해 과정
        for(int i = 1; i <= sum; i++) {
            if(sum % i == 0) { // 소인수이면
                width = sum / i;
                height = i;
                // 가로가 세로보다 같거나 크고, (임시가로의 크기 - 2) * (임시세로의 크기 - 2)가 yellow의 개수와 같아야 함.
                if((width >= height) && ((width - 2) * (height - 2) == yellow)) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        
        return answer;
    }
}