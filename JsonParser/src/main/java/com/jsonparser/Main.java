package com.jsonparser;

import java.util.Map;

public class Main {
    public static void main(String args[]){
        JsonParser jsonParser =new JsonParser();
        Map<String,Object> map=jsonParser.parseJson("{\"abc\":{\"bcde\":\"fg\",\"xml\":\"asd\"}}");
        map.get("abc");
    }
}
