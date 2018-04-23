/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
      Appt appt1 = new Appt(2,3,0,null,null,null);
//      String string1 = appt1.toString();

    //Email address can be pulled
      assertEquals("",appt1.getEmailAddress());

      //Null XML element
      assertEquals(null, appt1.getXmlElement());

      //No time set
      assertFalse(appt1.hasTimeSet());

      //make sure isOn returns normally
      assertTrue(appt1.isOn(2,3,0));
      assertFalse(appt1.isOn(3,3,0));
      assertFalse(appt1.isOn(2,4,0));
      assertFalse(appt1.isOn(2,3,2));

      //Year invalid
      appt1.setValid();
      assertFalse(appt1.getValid());
}
    public void test02()  throws Throwable  {
        Appt appt2 = new Appt(15, 72,2,3,2018,"test","test","test");

        //see if setting list to null sets recur days to 0
        appt2.setRecurrence(null,2,2,2);
        int[] recurDays2 = new int[0];
        assertEquals(recurDays2,appt2.getRecurDays());

        //Check to see if all of the variables return the way they should
        assertTrue(appt2.getValid());
        assertEquals(15,appt2.getStartHour());
        assertEquals(72,appt2.getStartMinute());
        assertEquals(2,appt2.getStartDay());
        assertEquals(3,appt2.getStartMonth());
        assertEquals(2018,appt2.getStartYear());

        //Minute invalid
        appt2.setValid();
        assertFalse(appt2.getValid());
    }

    public void test03()  throws Throwable  {
        Appt appt3 = new Appt(15, 15,40,5,2018,"test","test","test");

        //Check to see if all of the variables return the way they should
        assertTrue(appt3.getValid());
        assertEquals(15,appt3.getStartHour());
        assertEquals(15,appt3.getStartMinute());
        assertEquals(40,appt3.getStartDay());
        assertEquals(5,appt3.getStartMonth());
        assertEquals(2018,appt3.getStartYear());

        //Day invalid
        appt3.setValid();
        assertFalse(appt3.getValid());
    }
}
