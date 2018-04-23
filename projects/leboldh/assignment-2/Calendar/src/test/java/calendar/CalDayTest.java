/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CalDay Cal0 = new CalDay();

      //default constructor - always creates invalid CalDay
      assertFalse(Cal0.isValid());

      //reaches line 111
      String info0 = Cal0.toString();
      assertEquals("",info0);
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      GregorianCalendar cal = new GregorianCalendar(3, 2, 1);
      CalDay Cal1 = new CalDay(cal);
      Appt Appt0 = new Appt(7, 12, 1, 3, 3, "test title", "test description", "test@test.com");
      Cal1.addAppt(Appt0);
      Cal1.toString();

      //constructor - always creates valid CalDay
      assertTrue(Cal1.isValid());

      //test get functions
      assertEquals(3, Cal1.getYear());
      //Gregorian calendar application functions on a 0-11 basis, meaning month sent to CalDay is incremented by 1
      assertEquals(3, Cal1.getMonth());
      assertEquals(1, Cal1.getDay());
      assertEquals(1, Cal1.getSizeAppts());

      //Look at full appointment information
      String info1 = Cal1.getFullInfomrationApp(Cal1);
      assertEquals("3-1-3 \n" +
              "\t7:12AM test title test description ",info1);
      //System.out.println(info1);
  }

    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
        CalDay Cal2 = new CalDay(cal);
        Appt Appt0 = new Appt(10, 5, 5, 12, 2018, "test title", "test description", "test@test.com");
        Cal2.addAppt(Appt0);
        Appt Appt1 = new Appt(0, 12, 5, 12, 2018, "test title", "test description", "test@test.com");
        Cal2.addAppt(Appt1);
        Appt Appt2 = new Appt(14, 12, 5, 12, 2018, "test title", "test description", "test@test.com");
        Cal2.addAppt(Appt2);

        //Look at full appointment information
        String info2 = Cal2.getFullInfomrationApp(Cal2);
        assertEquals("12-5-2018 \n" +
                "\t2:12PM test title test description \n" +
                "\t10:05AM test title test description \n" +
                "\t12:12AM test title test description ",info2);
        //System.out.println(info2);
    }

}
