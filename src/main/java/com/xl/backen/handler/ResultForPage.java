package com.xl.backen.handler;

/**
 * ResultForPage
 */
public class ResultForPage<T> {
  private Integer code;
  private String msg;
  private PageInfo<T> data;

  public ResultForPage(BusinessStatus businessStatus, PageInfo<T> pageInfo) {
    this.code = businessStatus.getCode();
    this.msg = businessStatus.getMsg();
    this.data = pageInfo;
  }

  public ResultForPage(BusinessStatus businessStatus) {
    this.code = businessStatus.getCode();
    this.msg = businessStatus.getMsg();
  }

  /**
   * @return the data
   */
  public PageInfo<T> getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(PageInfo<T> data) {
    this.data = data;
  }

  /**
   * @return the code
   */
  public Integer getCode() {
    return code;
  }

  /**
   * @return the msg
   */
  public String getMsg() {
    return msg;
  }

  /**
   * @param msg the msg to set
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * @param code the code to set
   */
  public void setCode(Integer code) {
    this.code = code;
  }

}