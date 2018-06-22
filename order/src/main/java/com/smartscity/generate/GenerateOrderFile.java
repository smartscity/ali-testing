package com.smartscity.generate;

import com.smartscity.file.FileUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

/**
 * <B>文件名称：</B>GenerateOrderFile<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>SMARTSCITY Technology<BR>
 * <B>创建时间：</B>2018/6/22 上午11:14<BR>
 *
 * @author apple  lyl2008dsg@163.com
 * @version 1.0
 **/


public class GenerateOrderFile {

  String path = this.getClass().getClassLoader().getResource("").getPath();

  // 保留小数
  int SCALE = 2;

  public void generate(){

    for(int i=0;i<10;i++) {
      for (int j = 0; j < 1000; j++) {
        String line = assembleLine();

        FileUtils.write(path + i + ".txt", line);
      }
    }
  }

  private String assembleLine() {
    String      order  = UUID.randomUUID().toString();
    BigDecimal  amount = new BigDecimal(Math.random() * 100000).setScale(SCALE,  BigDecimal.ROUND_HALF_UP);
    StringBuffer sb = new StringBuffer();
    sb.append(order).append(",").append(amount);
    String line = sb.toString();
    return line;
  }
}
