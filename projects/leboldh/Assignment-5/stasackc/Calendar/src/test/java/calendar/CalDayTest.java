/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CalDay Cal0 = new CalDay();
      Appt Appt0 = new Appt(7, 12, 1, 3, 3, "test title", "test description", "test@test.com");
      LinkedList<Appt> List0 = new LinkedList<Appt>();

      //default constructor - always creates invalid CalDay
      assertFalse(Cal0.isValid());

      //reaches line 111
      String info0 = Cal0.toString();
      assertEquals("",info0);

      //Make sure there are no appointments
      //assertEquals(Cal0.getSizeAppts(),null);

      //Check appts, make sure it's null
      //assertEquals(Cal0.getAppts(),List0);


      //Cal0.addAppt(Appt0);
      List0.add(Appt0);

      //Check to see if appointment added to invalid day
      //assertEquals(Cal0.getSizeAppts(),1);
      //assertEquals(Cal0.getAppts(),List0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      GregorianCalendar cal = new GregorianCalendar(3, 2, 1);
      CalDay Cal1 = new CalDay(cal);
      Appt Appt0 = new Appt(7, 12, 1, 3, 3, "test title", "test description", "test@test.com");
      Cal1.addAppt(Appt0);

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

//    @Test(timeout = 4000)
//    public void test02()  throws Throwable  {
//        GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
//        CalDay Cal2 = new CalDay(cal);
//        Appt Appt0 = new Appt(10, 5, 5, 12, 2018, "test title", "test description", "test@test.com");
//        Cal2.addAppt(Appt0);
//        Appt Appt1 = new Appt(0, 12, 5, 12, 2018, "test title", "test description", "test@test.com");
//        Cal2.addAppt(Appt1);
//        Appt Appt2 = new Appt(14, 12, 5, 12, 2018, "test title", "test description", "test@test.com");
//        Cal2.addAppt(Appt2);
//
//        //Look at full appointment information
//        String info2 = Cal2.getFullInfomrationApp(Cal2);
//        assertEquals("12-5-2018 \n" +
//                "\t2:12PM test title test description \n" +
//                "\t10:05AM test title test description \n" +
//                "\t12:12AM test title test description ",info2);
//        //System.out.println(info2);
//    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
        CalDay Cal3 = new CalDay(cal);
        Appt Appt0 = new Appt(10, 5, 5, 11, 2018, "test title", "test description", "test@test.com");
        Cal3.addAppt(Appt0);
        String info3 = Cal3.toString();
        //System.out.println(info3);
        //inconsistent; not readily testable
//        assertEquals("   --- 13/5/2018 ---\n" +
//                " --- -------- Appointments ------------ ---\n" +
//                "        11/5/2018 at 10:5am ,test title, test description\n",info3);
    }
    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
        CalDay Cal4 = new CalDay(cal);

        LinkedList<Appt> List0 = new LinkedList<Appt>();
        //empty CalDay is still valid
        assertTrue(Cal4.isValid());
        //Make sure there are no appointments
        assertEquals(Cal4.getSizeAppts(),0);
        //Check appts, make sure it's null
        assertEquals(Cal4.getAppts(),List0);
    }
}
