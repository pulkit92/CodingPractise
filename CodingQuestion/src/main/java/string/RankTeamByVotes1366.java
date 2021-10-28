package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeamByVotes1366 {
  public static void main(String args[]) {
    RankTeamByVotes1366 rankTeamByVotes1366 = new RankTeamByVotes1366();
    /*String votes[] = {"FVSHJIEMNGYPTQOURLWCZKAX",
        "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR",
        "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN"
        , "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL",
        "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF"
        , "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG",
        "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"};*/
    String votes[]={"ABC","ACB","ABC","ACB","ACB"};
    System.out.println(rankTeamByVotes1366.rankTeams(votes));
  }

  public String rankTeams(String[] votes) {
    if (votes == null || votes.length == 0) return "";
    if (votes.length == 1) return votes[0];

    Map<Character, int[]> map = new HashMap<>();

    for (String vote:votes){
      for(int i=0;i<vote.length();i++){
        char ch= vote.charAt(i);
        int a[]=map.getOrDefault(ch,new int[26]);
        a[i]++;
        map.put(ch,a);
      }
    }

    // sort descending
    List<Character> list = new ArrayList<>(map.keySet());

    Collections.sort(list, (a,b) -> {
      for(int i = 0 ; i < 26 ;i++) {
        if (map.get(b)[i] != map.get(a)[i]) {
          return map.get(b)[i] - map.get(a)[i];
        }
      }
      return a.compareTo(b);
    });

    StringBuilder result = new StringBuilder(list.size());
    for(int i = 0 ; i < list.size() ;i++) {
      result.append(list.get(i));
    }

    return result.toString();
  }
}


class Pair {
  char ch;
  int count;

  Pair(char ch, int count) {
    this.ch = ch;
    this.count = count;
  }
}
