package com.xl.backen.util.util;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;

import java.util.Date;

/**
 * 与活动，任务相关的校验  和    计算
 */
public class TimeUtil {
  public static Boolean volidTime(Date sDate, Date eDate) {
    // 开始时间时间戳
    Long startTime = sDate.getTime();
    // 结束时间戳
    Long endTime = eDate.getTime();

    if(startTime >= endTime) {
      throw new BusinessException(BusinessStatus.TIME_ERROR);
    }

    return true;
  }

  /**
   * 活动时间校验
   * @param sDate 开始时间
   * @param eDate 结束时间
   * @param bsData 报名开始时间
   * @param beData 报名结束时间
   * @return
   */
  public static Boolean volidTime(Date sDate, Date eDate,Date bsData, Date beData) {
    volidTime(sDate,eDate);
    volidTime(bsData,beData);

    /*开始报名时间大于开始时间*/
    if(beData.getTime() >= sDate.getTime()) {
      throw new BusinessException(BusinessStatus.TIME_ERROR);
    }

    return true;
  }



  public static int compareTime(Date sDate, Date eDate) {
    Long startTime = sDate.getTime();
    Long endTime = eDate.getTime();
    Long nowTime = new Date().getTime();

    if(nowTime < startTime) {
      return CommonConst.NO_START;
    }else if(nowTime > startTime && nowTime < endTime) {
      return CommonConst.IN_START;
    }else{
      return CommonConst.OUT_START;
    }
  }

  /**
   *
   * @param sDate 报名开始
   * @param eDate 报名结束
   * @param bsData 活动开始
   * @param beData 活动结束
   * @return
   */
  public static int compareTime(Date sDate, Date eDate, Date bsData, Date beData) {
    Long startTime = sDate.getTime();
    Long endTime = eDate.getTime();
    Long nowTime = new Date().getTime();

    Long bsTime = bsData.getTime();
    Long beTime = beData.getTime();

    if(nowTime < startTime) {
      return CommonConst.NO_START;
    }else if(nowTime > startTime && nowTime < endTime) {
      return CommonConst.IN_START;
    }else if(nowTime > endTime && nowTime < bsTime) {
      return CommonConst.OUT_START;
    }else if(nowTime > bsTime && nowTime <beTime) {
      return CommonConst.ACTIVITY_IN_START;
    }else{
      return CommonConst.ACTIVITY_OUT_START;
    }
  }
}
