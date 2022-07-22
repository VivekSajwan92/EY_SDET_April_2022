package org.example;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import java.sql.Time;
import java.util.Calendar;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        ServiceNowRequest build = ServiceNowRequest.builder().shortDescription("short desc").approval("yes").impact("2").build();

        System.out.println(build);

        assertTrue( true );
    }
}