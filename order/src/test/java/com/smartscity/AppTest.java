package com.smartscity;

import com.smartscity.analysis.AnalysisOrder;
import com.smartscity.generate.GenerateOrderFile;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        int TOP = 10;
        GenerateOrderFile generate = new GenerateOrderFile();
        generate.generate();

        AnalysisOrder order = new AnalysisOrder();
        order.analysis( TOP);
    }
}
