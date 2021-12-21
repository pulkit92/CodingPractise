package string.searchingAndMatching;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {
    Map<String,Boolean> map=new HashMap<>();
    public static void main(String args[]){
        WildcardMatching matching=new WildcardMatching();
        System.out.println(matching.isMatch("aa","a*"));
    }
    public boolean isMatch(String s, String p) {
    p=remove(p);
    return isHelper(s,p);
    }
    public String remove(String p){
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<p.length();i++){
            if(p.charAt(i)=='*' && p.charAt(i)==p.charAt(i-1)){
                continue;
            }
            else {
                sb.append(p.charAt(i));
            }

        }
        return sb.toString();
    }
    boolean isHelper(String s,String p){
        if(map.containsKey(s+p)){return map.get(s+p);}
        if(s.equals(p)){
            map.put(s+p,true);
            return true;
        }
        else if (s.length()==0|| p.length()==0){
            map.put(s+p,false);
            return false;
        }
        else if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?'){
           boolean b= isHelper(s.substring(1),p.substring(1));
            map.put(s+p,b);
            return  b;
        }
        else if(p.charAt(0)=='*'){
            boolean b =(isHelper(s.substring(1),p) || isHelper(s,p.substring(1)));
            map.put(s+p,b);
            return b;
        }
        else
            return false;
    }
}
