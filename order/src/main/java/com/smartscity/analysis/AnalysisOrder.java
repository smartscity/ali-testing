package com.smartscity.analysis;

import com.smartscity.file.FileUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <B>文件名称：</B>AnalysisOrder<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>SMARTSCITY Technology<BR>
 * <B>创建时间：</B>2018/6/22 上午11:38<BR>
 *
 * @author apple  lyl2008dsg@163.com
 * @version 1.0
 **/


public class AnalysisOrder extends BaseService {

  /**
   * 1、读文件，维护top100，最终保存至last.txt文件
   * @param TOP
   */
  public void analysis(int TOP) {

    // 生成每个文件TOP
    genAllFiletoMid(TOP);

    // 生成最终TOP
    genLastFile(TOP);

  }

  private void genLastFile(int TOP) {
    Map<BigDecimal, String> lines = new HashMap<BigDecimal, String>();
    for (int i = 0; i < TOP * 10; i++) {
      // 生成单个文件计算结果
      singleFileComputing (TOP, "mid", lines, i);
    }
    // 保存到last
    saveFile(lines, "last.txt");

    // 控制台打印
    System.out.println(" 最终结果 ");
    for (Map.Entry<BigDecimal, String> entry : lines.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    System.out.println(" 最终结果 ");
  }

  private void genAllFiletoMid(int TOP) {
    for(int k = 0; k<10;k++) {
      Map<BigDecimal, String> lines = new HashMap<BigDecimal, String>();
      for (int i = 0; i < 1000; i++) {
        // 生成单个文件计算结果
        singleFileComputing (TOP, k+"", lines, i);
      }
      // 保存到mid
      saveFile(lines, "mid.txt");
    }
  }

  private void saveFile(Map<BigDecimal, String> lines, String s) {
    for (Map.Entry<BigDecimal, String> entry : lines.entrySet()) {
      FileUtils.write(path + s, entry.getValue() + "," + entry.getKey());
    }
  }

  private void singleFileComputing(int TOP, String fileName, Map<BigDecimal, String> lines, int i) {
    String line = FileUtils.read(path + fileName + ".txt", i);
    String[] array = line.split(",");

    BigDecimal amout = new BigDecimal(array[1]).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    lines.put(amout, array[0]);


    BigDecimal[] amountArray = lines.keySet().toArray(new BigDecimal[0]);
    Arrays.sort(amountArray);

    // 找到 TOP100 以外的数字， 删除掉
    if (amountArray.length < TOP)
      return;

    if (amountArray.length > TOP) {
      for (int j = amountArray.length - TOP - 1; j >= 0; j--) {
        lines.remove(amountArray[j]);
      }
    }
  }

}
