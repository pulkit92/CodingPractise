package com.elasticloadbalancer;

public class ElasticLoadApplication {
  public static void main(String args[]) {
    ELBAnalyze elbAnalyze=new ELBAnalyze();
    ElasticLoadProcessor elasticLoadProcessor = new ElasticLoadProcessor(elbAnalyze);
    String filePath = "/Users/pbajpai/Desktop/untitled folder/752180062774_elasticloadbalancing_us-west-2_app"
        + ".megapool-retool-app.dbb257b8adaa87cf_20210601T2350Z_52.42.29.158_4ylaofpl.log";
    elasticLoadProcessor.processLogs(filePath);
    System.out.println(elbAnalyze.topIP());
    System.out.println(elbAnalyze.topUserAgent());

  }
}
