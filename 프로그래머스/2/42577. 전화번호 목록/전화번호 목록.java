import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {

        Set<String> set= new HashSet<>();        
        
        for(String book: phoneBook)
            set.add(book);
        
        for(String book: phoneBook){
            for(int i=0; i<book.length() -1; i++){
                
                String st= book.substring(0, i+1);
                if(set.contains(st)) return false;
            }
        }
        
        return true;
    }
}