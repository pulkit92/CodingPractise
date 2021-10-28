package map;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostTOMoveChipsTOTheSamePosition1217 {
  public int minCostToMoveChips(int[] position) {
    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<position.length;i++){
      if(position[i]%2==0){
        map.put(2,map.getOrDefault(2,0) + 1);
      }
      else{
        map.put(1,map.getOrDefault(1,0) + 1);
      }
    }
    if(!map.containsKey(1)|| !map.containsKey(2)){
      return 0;
    }
    if(map.get(1)>map.get(2)){
      return map.get(2);
    }
    else{
      return map.get(1);
    }


  }
  public static void main(String args[]){
    int pos[]={1,2,3};
    MinimumCostTOMoveChipsTOTheSamePosition1217 m=new MinimumCostTOMoveChipsTOTheSamePosition1217();
    m.minCostToMoveChips(pos);
  }
}
