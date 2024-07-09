import java.util.*;

class Solution {
    public int[] solution(String[] opers) {
        
        ArrayList<Integer> list= new ArrayList<>();
        
        for(String oper: opers){
            
            String[] operArray= oper.split(" ");
            
            switch(operArray[0]){
                    
                case "I": list.add(Integer.parseInt(operArray[1]));
                            Collections.sort(list);
                            break;
                
                case "D": 
                   
                    if(!list.isEmpty()){
                         
                        if(operArray[1].equals("1"))
                            list.remove(list.size() -1);
                        else list.remove(0);
                    }
                    
            }
    }
        
            
            if(list.isEmpty()) return new int[]{0,0};
            else return new int[]{list.get(list.size()-1), list.get(0)};
    }
}
