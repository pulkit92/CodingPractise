package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosetNumber {




        /*
         * Complete the 'closestNumbers' function below.
         *
         * The function accepts INTEGER_ARRAY numbers as parameter.
         */

        public static void closestNumbers(List<Integer> numbers) {
            // Write your code here
            Collections.sort(numbers);
            int mindiff=Integer.MAX_VALUE;
            for(int i=0;i<numbers.size()-1;i++){
                int diff=0;
                if(numbers.get(i)<0 && numbers.get(i+1)<0){
                    diff= ((-1)*numbers.get(i))-((-1)*numbers.get(i+1));
                }
                else if(numbers.get(i)<0 && numbers.get(i+1)>=0){
                    diff= numbers.get(i+1)+ ((-1)*numbers.get(i));
                }
                else{
                    diff=numbers.get(i)-numbers.get(i+1);
                }
                mindiff=Math.min(diff, mindiff);
            }
            for(int i=0;i<numbers.size()-1;i++){
                int diff=0;
                if(numbers.get(i)<0 && numbers.get(i+1)<0){
                    diff= ((-1)*numbers.get(i))-((-1)*numbers.get(i+1));
                }
                else if(numbers.get(i)<0 && numbers.get(i+1)>=0){
                    diff= numbers.get(i+1)+ ((-1)*numbers.get(i));
                }
                else{
                    diff=numbers.get(i)-numbers.get(i+1);
                }
                if(diff==mindiff){
                    System.out.println(numbers.get(i)+" "+numbers.get(i+1));
                }
            }
        }
        public static void main(String args[]){
            List<Integer> list = new ArrayList<>(List.of(4,-2 ,-1 ,3));
            closestNumbers(list);
        }


}
