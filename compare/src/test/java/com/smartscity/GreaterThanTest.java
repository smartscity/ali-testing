package com.smartscity;

import com.smartscity.bean.Order;
import com.smartscity.service.ExchangeRateServices;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GreaterThanTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GreaterThanTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GreaterThanTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void  testApp ()
    {
        Order a = new Order(59, "CNY");
        Order b = new Order(1000, "JPY");
        ExchangeRateServices services = new ExchangeRateServices();
        int result = services.compare(a, b);
        System.out.println(" 1 大于； 0 等于； -1 小于 ：" + result);
        assertTrue( result == -1 );
    }

}
