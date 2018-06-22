package com.smartscity;

import com.smartscity.analysis.AnalysisOrder;
import com.smartscity.generate.GenerateOrderFile;

/**
 * 题目二、有限内存（256MB），有10个1G的文件，每个文件中均是订单记录（订单号+金额，分隔符自定），尝试找出所有这10个文件中金额最大的100个订单。
 *
 * 思路：
 *      1、对于1G的文件逐行读取
 *      2、读出每个文件TOP 100 的订单 + 金额，并逐行保存到同一个新的文件中，最终 10 * 100 条数据；
 *      3、将 10 * 100 的文件内存排序，输出 最终TOP 100 即可
 */
public class App 
{
    public static void main( String[] args )
    {

        int TOP = 10;
        GenerateOrderFile generate = new GenerateOrderFile();
        generate.generate();

        AnalysisOrder order = new AnalysisOrder();
        order.analysis( TOP);

    }
}
