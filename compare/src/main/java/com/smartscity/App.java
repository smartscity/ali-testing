package com.smartscity;

import com.smartscity.bean.Order;
import com.smartscity.service.ExchangeRateServices;

/**
 * 三、请写一段代码比较两个订单的金额：
 * public class Order {
 *   public long unitPrice;
 *   public String ccy;
 *   public Order(long unitPrice, String ccy){
 *      this.unitPrice = unitPrice;
 *     this.ccy = ccy;
 *   }
 * }
 * Order a = new Order(1000, “CNY”);
 * Order b = new Order(1000, “JPY”);
 * 求哪个订单金额大？
 *
 *
 * 思路：
 *      1、获取实时汇率接口（实际按业务，比如当天固定采用前一天最后时刻汇率，作为结算汇率）
 *
 *      2、
 *
 * 例如：
 *      1000日元=59.1209人民币元
 */
public class App 
{
    public static void main( String[] args )
    {
        // 获取实时汇率列表
        // 假如：CNY to USA  =

        Order a = new Order(59, "CNY");
        Order b = new Order(1000, "JPY");

        ExchangeRateServices services = new ExchangeRateServices();
        int result = services.compare(a, b);
        System.out.println(" 1 大于； 0 等于； -1 小于 ：" + result);

    }
}
