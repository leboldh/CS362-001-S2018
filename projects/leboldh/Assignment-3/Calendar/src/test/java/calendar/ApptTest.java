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
      //create new appointment without start hour and start minute
      // has invalid year
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

    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        //create appointment with invalid start minute, greater than 59
        Appt appt2 = new Appt(15, 72,2,3,2018,"test","test","test");

        //see if setting list to null sets recur days to 0
        appt2.setRecurrence(null,2,2,2);
        int[] recurDays2 = new int[0];
        //assertEquals(recurDays2,appt2.getRecurDays());
        assertTrue(appt2.isRecurring());

        //Check to see if all of the variables return the way they should
        assertTrue(appt2.getValid());
        assertTrue(appt2.hasTimeSet());
        assertEquals(15,appt2.getStartHour());
        assertEquals(72,appt2.getStartMinute());
        assertEquals(2,appt2.getStartDay());
        assertEquals(3,appt2.getStartMonth());
        assertEquals(2018,appt2.getStartYear());

        //Minute invalid
        appt2.setValid();
        assertFalse(appt2.getValid());
    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        // create appointment with invalid start day, beyond end of month
        Appt appt3 = new Appt(15, 15,40,5,2018,"test","test","test");

        //Check to see if all of the variables return the way they should
        assertTrue(appt3.getValid());
        assertTrue(appt3.isOn(40,5,2018));
        assertEquals(15,appt3.getStartHour());
        assertEquals(15,appt3.getStartMinute());
        assertEquals(40,appt3.getStartDay());
        assertEquals(5,appt3.getStartMonth());
        assertEquals(2018,appt3.getStartYear());

        //Day invalid
        appt3.setValid();
        assertFalse(appt3.getValid());
    }

    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        // create appointment with invalid start month, less than 1
        Appt appt4 = new Appt(15, 15,10,0,2018,"test","test","test");

        //Day invalid
        appt4.setValid();
        assertFalse(appt4.getValid());
    }

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        // create appointment with invalid start month, greater than 12
        Appt appt5 = new Appt(15, 15,10,15,2018,"test","test","test");

        //Day invalid
        appt5.setValid();
        assertFalse(appt5.getValid());
    }
    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        // create appointment with invalid start day, less than 1
        Appt appt6 = new Appt(15, 15,0,10,2018,"test","test","test");

        //Day invalid
        appt6.setValid();
        assertFalse(appt6.getValid());
    }
    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        // create appointment with invalid start minute, less than 0
        Appt appt7 = new Appt(15, -2,1,10,2018,"test","test","test");

        //Day invalid
        appt7.setValid();
        assertFalse(appt7.getValid());
    }
    @Test(timeout = 4000)
    public void test08()  throws Throwable  {
        // create appointment with invalid start hour, less than 0
        Appt appt8 = new Appt(-12, 15,1,10,2018,"test","test","test");

        //Day invalid
        appt8.setValid();
        assertFalse(appt8.getValid());
    }
    @Test(timeout = 4000)
    public void test09()  throws Throwable  {
        // create appointment with invalid start hour, greater than 23
        Appt appt9 = new Appt(25, 15,1,10,2018,"test","test","test");

        //Day invalid
        appt9.setValid();
        assertFalse(appt9.getValid());
    }
}
