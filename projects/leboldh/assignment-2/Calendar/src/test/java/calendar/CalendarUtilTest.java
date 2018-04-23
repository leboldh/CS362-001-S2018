package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.CalendarUtil;

public class CalendarUtilTest {
    @Test(timeout = 4000)
    public void test00()  throws Throwable  {
        //testing cases for February
        assertEquals(28, CalendarUtil.NumDaysInMonth(2013,1));
        assertEquals(29, CalendarUtil.NumDaysInMonth(2000, 1));
        assertEquals(29, CalendarUtil.NumDaysInMonth(1996, 1));
        assertEquals(28, CalendarUtil.NumDaysInMonth(600, 1));

        //test a case for another month
        assertEquals(31, CalendarUtil.NumDaysInMonth(1998, 11));
    }
}
