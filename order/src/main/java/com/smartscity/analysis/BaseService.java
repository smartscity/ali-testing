package com.smartscity.analysis;

/**
 * <B>文件名称：</B>BaseService<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>SMARTSCITY Technology<BR>
 * <B>创建时间：</B>2018/6/22 下午1:03<BR>
 *
 * @author apple  lyl2008dsg@163.com
 * @version 1.0
 **/


public class BaseService {


    int SCALE = 2;

    String path = this.getClass().getClassLoader().getResource("").getPath();
}
