package com.elasticloadbalancer;

public class ElasticLoadParser {
  public static ElasticLBBean parser(String[] content) {
    ElasticLBBean elasticLBBean = new ElasticLBBean();
    elasticLBBean.setClientIp(IpAddressParser(content[4]));
    elasticLBBean.setRedirectURl(content[13]);
    elasticLBBean.setUserAgent(content[5]);
    return elasticLBBean;
  }

  private static String IpAddressParser(String ipAndPort) {
    String value[] = ipAndPort.split(":");
    return value[0];
  }
}
