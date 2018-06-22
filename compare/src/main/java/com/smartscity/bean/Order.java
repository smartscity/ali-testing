package com.smartscity.bean;

/**
 *
 */
public class Order {
  public long unitPrice;
  public String ccy;
  public Order(long unitPrice, String ccy){
     this.unitPrice = unitPrice;
    this.ccy = ccy;
  }
}