import java.util.*;

class Solution {    
    public String[] solution(String[] record) {
        HashMap<String, String> hashmap = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] oneRecord = record[i].split(" ");
            String command = oneRecord[0];
            
            if(command.equals("Enter")) {
                String id = oneRecord[1];
                String nickname = oneRecord[2];
                hashmap.put(id, nickname);
                
            }else if(command.equals("Leave")) {
                String id = oneRecord[1];
                
            }else if(command.equals("Change")) {
                String id = oneRecord[1];
                String nickname = oneRecord[2];
                hashmap.replace(id, nickname);
                
            }
        }
        
        ArrayList<String> log = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            String command = record[i].split(" ")[0];
            String id = record[i].split(" ")[1];
            
            if(command.equals("Enter")) {
                log.add(hashmap.get(id) + "님이 들어왔습니다.");
            }else if(command.equals("Leave")) {
                log.add(hashmap.get(id) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = log.toArray(new String[0]);
        return answer;
    }
}