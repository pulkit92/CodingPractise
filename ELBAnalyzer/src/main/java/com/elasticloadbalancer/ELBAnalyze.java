package com.elasticloadbalancer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ELBAnalyze {
  Map<String, Integer> topUserAgent = new HashMap<>();
  Map<String, Integer> topUrl = new HashMap<>();
  Map<String, Integer> topClientIP = new HashMap<>();

  List<ElasticLBBean> recordedElbBean = new ArrayList<>();

  public void recorrdElbStats(ElasticLBBean elasticLBBean) {
    recordedElbBean.add(elasticLBBean);
    recordUSerAgent(elasticLBBean.getUserAgent());
    recordClientIp(elasticLBBean.getClientIp());
    recordUrl(elasticLBBean.getRefrenceId());
  }

  public void recordUSerAgent(String userAgent) {
    int freq = topUserAgent.getOrDefault(userAgent, 0);
    topUserAgent.put(userAgent, freq + 1);

  }

  public List<String> topUserAgent() {
    List<Map.Entry<String, Integer>> result = topUserAgent.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .collect(Collectors.toList());
    List<String> out = new ArrayList<>();
    for (Map.Entry<String, Integer> en : result) {
      out.add(en.getKey());
    }
    return out;
  }

  public void recordUrl(String url) {
    int freq = topUrl.getOrDefault(url, 0);
    topUrl.put(url, freq + 1);

  }

  public List<String> topUrl() {
    List<Map.Entry<String, Integer>> result = topUrl.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .collect(Collectors.toList());
    List<String> out = new ArrayList<>();
    for (Map.Entry<String, Integer> en : result) {
      out.add(en.getKey());
    }
    return out;
  }

  public void recordClientIp(String Ip) {
    int freq = topClientIP.getOrDefault(Ip, 0);
    topClientIP.put(Ip, freq + 1);

  }

  public List<String> topIP() {
    List<Map.Entry<String, Integer>> result = topClientIP.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .collect(Collectors.toList());
    List<String> out = new ArrayList<>();
    for (Map.Entry<String, Integer> en : result) {
      out.add(en.getKey());
    }
    return out;
  }
}
