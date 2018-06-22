package com.smartscity.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <B>文件名称：</B>FileUtils<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>SMARTSCITY Technology<BR>
 * <B>创建时间：</B>2018/6/22 上午11:24<BR>
 *
 * @author apple  lyl2008dsg@163.com
 * @version 1.0
 **/


public class FileUtils extends ArrayList<String> {

  public static String read(String filename, int lineNum) {

    StringBuilder sb = new StringBuilder();
    try {
      lineNum = lineNum+1;
      LineNumberReader in = new LineNumberReader(new FileReader(new File(filename).getAbsoluteFile()));
      try {
        String line = null;

        while((line = in.readLine()) != null) {
          if(in.getLineNumber() == lineNum) {
            sb.append(line);
            break;
          }
        }
      } finally {
        in.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }

  public static void write(String fileName, String text) {
    try {
      FileWriter out = new FileWriter(new File(fileName).getAbsoluteFile(), true);
      try {
        out.write(text+ "\n");
      } finally {
        out.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public FileUtils(String fileName, String splitter) {
    super(Arrays.asList(read( fileName,0).split(splitter)));
  }

  public FileUtils(String fileName) {
    this(fileName, "\n");
  }

  public void write(String fileName) {
    try {
      PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
      try {
        for (String item : this)
          out.println(item);
      } finally {
        out.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
