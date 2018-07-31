package com.xl.backen.util;

import java.util.Date;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;

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
}
