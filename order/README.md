#### 有限内存数据分析

- 有限内存（256MB），有10个1G的文件，每个文件中均是订单记录（订单号+金额，分隔符自定），尝试找出所有这10个文件中金额最大的100个订单。

- 思路：
 *      1、对于1G的文件逐行读取
 *      2、读出每个文件TOP 100 的订单 + 金额，并逐行保存到同一个新的文件中，最终 10 * 100 条数据；
 *      3、将 10 * 100 的文件内存排序，输出 最终TOP 100 即可

- 时限：3天
- 基础测试用例：com.smartscity.AppTest

单元测试用例

- PASS 共1/1个

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
