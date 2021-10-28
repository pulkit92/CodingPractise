package com.elasticloadbalancer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ElasticLoadProcessor {
  private ELBAnalyze elbAnalyze;

  public ElasticLoadProcessor(ELBAnalyze elbAnalyze) {
    this.elbAnalyze = elbAnalyze;
  }

  public void processLogs(String filePath) {
    try {
      FileInputStream fstream = new FileInputStream(filePath);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;
      /* read log line by line */
      while ((strLine = br.readLine()) != null) {
        ElasticLBBean elasticLBBean = ElasticLoadParser.parser(strLine.split(" "));
        System.out.println(elasticLBBean.getUserAgent());
        elbAnalyze.recorrdElbStats(elasticLBBean);
      }
      fstream.close();
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
