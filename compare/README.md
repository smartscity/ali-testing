#### 国际汇率清算

- 请写一段代码比较两个订单的金额：
   ```java public class Order {
      public long unitPrice;
      public String ccy;
      public Order(long unitPrice, String ccy){
         this.unitPrice = unitPrice;
        this.ccy = ccy;
      }
    }
    Order a = new Order(1000, “CNY”);
    Order b = new Order(1000, “JPY”);
    求哪个订单金额大？
    ```

- 思路：
 *      1、获取实时汇率接口（实际按业务，比如当天固定采用前一天最后时刻汇率，作为结算汇率）

- 基础测试用例：com.smartscity.AppTest

单元测试用例

- PASS 共3/3个

运行方式

- Maven 方式
    ```
    mvn clean install
    ```
- Main 函数入口
    ```


    ```
Author

- 李云龙
- Email: lyl2008dsg@163.com

GitHub

- https://github.com/smartscity/ali-testing
