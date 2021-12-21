package string;
/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int max=0;
        int pos=0;
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
                max=count[i];
                pos=i;
            }
        }
        if(max>(s.length()+1)/2){
            return "";
        }
        char ch[]=new char[s.length()];
        int index=0;

        while(count[pos]>0){
            ch[index]= (char) (pos+'a');
            count[pos]--;
            index=index+2;
        }

        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                if(index>=ch.length){
                    index=1;
                }
                ch[index]= (char) (i+'a');
                count[i]--;
                index=index+2;

            }
        }
        return String.valueOf(ch);
    }
}
