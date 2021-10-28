package com.elasticloadbalancer;

public class ElasticLBBean {

  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getRefrenceId() {
    return refrenceId;
  }

  public void setRefrenceId(String refrenceId) {
    this.refrenceId = refrenceId;
  }

  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  public int getClientPort() {
    return clientPort;
  }

  public void setClientPort(int clientPort) {
    this.clientPort = clientPort;
  }

  public String getTargetIp() {
    return targetIp;
  }

  public void setTargetIp(String targetIp) {
    this.targetIp = targetIp;
  }

  public int getTargetPort() {
    return targetPort;
  }

  public void setTargetPort(int targetPort) {
    this.targetPort = targetPort;
  }

  public String getRedirectURl() {
    return redirectURl;
  }

  public void setRedirectURl(String redirectURl) {
    this.redirectURl = redirectURl;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  private long timeStamp;
  private String refrenceId;
  private String clientIp;
  private int clientPort;
  private String targetIp;
  private int targetPort;
  private String redirectURl;
  private String userAgent;
}
