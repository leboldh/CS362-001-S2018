package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.DateOutOfRangeException;

public class DateOutOfRangeExceptionTest {
    @Test(timeout = 4000)
    public void test00()  throws Throwable  {
        DateOutOfRangeException Exc0 = new DateOutOfRangeException();
    }

    @Test(timeout = 4000)
    public void test01()  throws Throwable  {
        String test = "test";
        DateOutOfRangeException Exc1 = new DateOutOfRangeException(test);
    }
}
