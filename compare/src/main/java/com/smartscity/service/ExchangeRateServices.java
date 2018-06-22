package com.smartscity.service;

import com.smartscity.bean.Order;

import java.math.BigDecimal;

/**
 * <B>文件名称：</B>ExchangeRateServices<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>SMARTSCITY Technology<BR>
 * <B>创建时间：</B>2018/6/22 下午12:44<BR>
 *
 * @author apple  lyl2008dsg@163.com
 * @version 1.0
 **/
public class ExchangeRateServices {

  /**
   * 1人民币=16.9109日元
   * @param unitPrice
   * @param from
   * @param to
   * @return
   */
  public BigDecimal exchange(long unitPrice, String from, String to){
    BigDecimal rate =  exchangeRate(from, to);
    BigDecimal up = new BigDecimal(unitPrice);
    return up.multiply(rate);
  }

  private BigDecimal exchangeRate(String from, String to) {
    if(from.equals("CNY") && to.equals("JPY")){   //1人民币=16.9109日元
      return new BigDecimal(16.9109);
    }
    return null;
  }

  /**
   *
   * @return 1  大于
   * @return 0  等于
   * @return -1 小于
   *
   * @param a
   * @param b
   */
  public int compare(Order a, Order b){
    BigDecimal ae = exchange(a.unitPrice, a.ccy, b.ccy);
    BigDecimal be = new BigDecimal(b.unitPrice);
    return ae.compareTo(be);
  }
}
