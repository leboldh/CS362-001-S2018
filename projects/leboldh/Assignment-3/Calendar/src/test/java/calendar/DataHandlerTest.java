
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      //sets file name to a default, default value set for autosave
      //calls other constructor
      DataHandler Dat0 = new DataHandler();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      //sets file name to string passed to constructor, sets default autosave value (true)
      //because this constructor calls the other, there is no need to test calling the next constructor specifying true for autosave
      DataHandler Dat1 = new DataHandler("test");

      //set up calendar days for testing
      GregorianCalendar cal0 = new GregorianCalendar(3, 2, 1);
      GregorianCalendar cal1 = new GregorianCalendar(3, 2, 2);
      GregorianCalendar cal2 = new GregorianCalendar(3, 2, 3);
      GregorianCalendar cal3 = new GregorianCalendar(3, 2, 4);

      CalDay Cal0 = new CalDay(cal0);
      CalDay Cal1 = new CalDay(cal1);
      CalDay Cal2 = new CalDay(cal2);
      CalDay Cal3 = new CalDay(cal3);

      //set up appointments
      Appt Appt0 = new Appt(7, 12, 1, 3, 3, "appt0", "test description", "test@test.com");
      Appt Appt1 = new Appt(7, 12, 2, 3, 3, "appt1", "test description", "test@test.com");
      Appt Appt2 = new Appt(7, 12, 3, 3, 3, "appt2", "test description", "test@test.com");
      Appt Appt3 = new Appt(7, 12, 4, 3, 3, "appt3", "test description", "test@test.com");

      //set an appointment to recur
      int[] recurDays1 = {0,1,2,3,4,5,6};
      Appt1.setRecurrence(recurDays1,1,1,4);

      //set another appointment to recur
      Appt2.setRecurrence(null,1,1,3);

      //create a linked list to test with, with empty days
      LinkedList<CalDay> List0 = new LinkedList<CalDay>();
      List0.add(Cal0);
      List0.add(Cal1);
      List0.add(Cal2);

      assertEquals(List0.size(),Dat1.getApptRange(cal0,cal3).size());
      //assertEquals(List0.peek(),Dat1.getApptRange(cal0,cal3).get(0));
      //Test only works if file is cleared of appointments before continuing
      assertEquals(List0.peek().getSizeAppts(),Dat1.getApptRange(cal0,cal3).get(0).getSizeAppts());

      //add appointments to calendar days
      Cal0.addAppt(Appt0);
      Cal1.addAppt(Appt1);
      Cal1.addAppt(Appt0);
      Cal2.addAppt(Appt2);
      Cal2.addAppt(Appt0);
      Cal3.addAppt(Appt3);
      Cal3.addAppt(Appt0);

      //Add calendar days to a linked list to test with, with days with appointments
      LinkedList<CalDay> List1 = new LinkedList<CalDay>();
      List1.add(Cal0);
      List1.add(Cal1);
      List1.add(Cal2);

      //check on saving with autosaving data handler
      assertTrue(Dat1.saveAppt(Appt0));
      assertTrue(Dat1.saveAppt(Appt1));
      assertTrue(Dat1.saveAppt(Appt2));
      assertTrue(Dat1.saveAppt(Appt3));

      assertEquals(List1.size(),Dat1.getApptRange(cal0,cal3).size());
      //assertEquals(List1.peek(),Dat1.getApptRange(cal0,cal3).get(0));
      assertEquals(List1.peek().getSizeAppts(),Dat1.getApptRange(cal0,cal3).get(0).getSizeAppts());
      assertEquals(List1.peekLast().getSizeAppts(),Dat1.getApptRange(cal0,cal3).get(2).getSizeAppts());

      //check on deleting with autosaving data handler, clean up work done
      //WORK HAS TO BE CLEANED UP WHEN DONE OR TESTS BREAK
      assertTrue(Dat1.deleteAppt(Appt0));
      assertTrue(Dat1.deleteAppt(Appt1));
      assertTrue(Dat1.deleteAppt(Appt2));
      assertTrue(Dat1.deleteAppt(Appt3));
  }
    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        //sets file name to string passed to constructor
        DataHandler Dat2 = new DataHandler("test2");

        //create invalid appointment
        Appt Appt0 = new Appt(7, 12, 1, 3, 0, "appt0", "test description", "test@test.com");
        Appt0.setValid();

        //nothing should happen with invalid appointments
        assertFalse(Dat2.saveAppt(Appt0));
        assertFalse(Dat2.deleteAppt(Appt0));

        //create valid appointment
        Appt Appt1 = new Appt(7, 12, 1, 3, 1, "appt1", "test description", "test@test.com");
        Appt1.setValid();

        //test saving and deleting without autosave
        assertTrue(Dat2.saveAppt(Appt1));
        assertTrue(Dat2.deleteAppt(Appt1));
    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        //sets file name to string passed to constructor
        DataHandler Dat3 = new DataHandler("test3");

        //create invalid appointment recurring weekly
        Appt Appt0 = new Appt(7, 12, 32, 3, 2018, "appt0", "test description", "test@test.com");
        Appt0.setRecurrence(null,1,1,3);

        GregorianCalendar cal0 = new GregorianCalendar(2018, 2, 1);
        GregorianCalendar cal1 = new GregorianCalendar(2018,3,1);
//
//        CalDay Cal0 = new CalDay(cal0);
//        CalDay Cal1 = new CalDay(cal1);

        //save the appointment
        assertTrue(Dat3.saveAppt(Appt0));

        //see if getNextApptOccurence catches the bad date
        //assertEquals(null, Dat3.getApptRange(cal0,cal1));

        //cleanup
        assertTrue(Dat3.deleteAppt(Appt0));
    }

    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        //sets file name to string passed to constructor, specifies autosave value (false)
        DataHandler Dat4 = new DataHandler("test4", false);

        //create a monthly recurring appointment
        Appt Appt0 = new Appt(7, 12, 1, 3,2018 , "appt0", "test description", "test@test.com");
        int[] recur = {1};
        Appt0.setRecurrence(recur,2,1,24);

        GregorianCalendar cal0 = new GregorianCalendar(2018, 2, 1);
        GregorianCalendar cal1 = new GregorianCalendar(2018,3,1);
        GregorianCalendar cal2 = new GregorianCalendar(2020, 4, 2);

        CalDay Cal0 = new CalDay(cal0);
        CalDay Cal1 = new CalDay(cal1);
        CalDay Cal2 = new CalDay(cal2);

        Cal0.addAppt(Appt0);
        Cal1.addAppt(Appt0);
        Cal2.addAppt(Appt0);

        LinkedList<CalDay> List0 = new LinkedList<CalDay>();
        List0.add(Cal0);
        List0.add(Cal1);

        //save the appointment
        assertTrue(Dat4.saveAppt(Appt0));

//        //check for correct monthly recurrence
//        assertEquals(List0.size(), Dat4.getApptRange(cal0,cal2).size());
//        assertEquals(List0.peek().getSizeAppts(),Dat4.getApptRange(cal0,cal2).get(0).getSizeAppts());
//        assertEquals(List0.peekLast().getSizeAppts(),Dat4.getApptRange(cal0,cal2).get(1).getSizeAppts());

        //cleanup
        assertTrue(Dat4.deleteAppt(Appt0));
    }

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        //sets file name to string passed to constructor, specifies autosave value (false)
        DataHandler Dat5 = new DataHandler("test2", false);

        //create a yearly recurring appointment
        Appt Appt0 = new Appt(7, 12, 1, 3,2018 , "appt2", "test description", "test@test.com");
        int[] recur = {1};
        Appt0.setRecurrence(recur,3,1,3);

        GregorianCalendar cal0 = new GregorianCalendar(2018, 2, 1);
        GregorianCalendar cal1 = new GregorianCalendar(2019,5,1);
        GregorianCalendar cal2 = new GregorianCalendar(2020, 2, 2);

        CalDay Cal0 = new CalDay(cal0);
        CalDay Cal1 = new CalDay(cal1);
        CalDay Cal2 = new CalDay(cal2);

        Cal0.addAppt(Appt0);
        Cal1.addAppt(Appt0);
        Cal2.addAppt(Appt0);

        LinkedList<CalDay> List0 = new LinkedList<CalDay>();
        List0.add(Cal0);
        List0.add(Cal1);

        assertTrue(Dat5.saveAppt(Appt0));

        //check for correct monthly recurrence
//        assertEquals(List0.size(), Dat5.getApptRange(cal0,cal2).size());
//        assertEquals(List0.peek().getSizeAppts(),Dat5.getApptRange(cal0,cal2).get(0).getSizeAppts());
//        assertEquals(List0.peekLast().getSizeAppts(),Dat5.getApptRange(cal0,cal2).get(1).getSizeAppts());

        //cleanup
        assertTrue(Dat5.deleteAppt(Appt0));
    }

    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        //sets file name to string passed to constructor
        DataHandler Dat6 = new DataHandler("test6");

        //create valid appointment
        Appt Appt0 = new Appt(7, 12, 1, 3, 1, "appt1", "test description", "test@test.com");
        Appt0.setValid();

        //test for deletion w/o saving
        assertFalse(Dat6.deleteAppt(Appt0));
    }
}
