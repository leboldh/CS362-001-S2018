package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void deleteApptTest()  throws Throwable  {
		 //create randomizer seed
		 long randomseed =System.currentTimeMillis(); //10
		 //	System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);

		 for (int x = 0; x < 50; x++){
		     boolean autoSave = false;
		     int saveOn = ValuesGenerator.getRandomIntBetween(random, 1,100);
		     if (saveOn < 50){ //change autosave value
		         autoSave = true;
             }
             DataHandler dat0 = new DataHandler("test0", autoSave);

             LinkedList<Appt> apptsList = new LinkedList<Appt>();

             for (int y = 0; y < 10; y++) {
                 int isValid = ValuesGenerator.getRandomIntBetween(random, 1, 100);

                 int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
                 String title = "Test title";
                 String description = "Test description.";
                 String emailAddress = "test@testmail.com";

                 if (isValid < 50){ //appointment will be invalid
                     startHour = ValuesGenerator.getRandomIntBetween(random, 50, 100);
                     startMinute = ValuesGenerator.getRandomIntBetween(random, 90, 100);
                     startDay = ValuesGenerator.getRandomIntBetween(random, 50, 100);
                     startMonth = ValuesGenerator.getRandomIntBetween(random, 50, 100);
                     }
                 Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
                 appt0.setValid();
                 apptsList.add(appt0);
             }

             for (int z = 0; z < apptsList.size(); z++) {
                 int willSave = ValuesGenerator.getRandomIntBetween(random, 0, 100);
                 if (willSave < 50) { //appointment will not save, therefore there will be a null XML node, no delete
                     assertFalse(dat0.deleteAppt(apptsList.get(z)));
                 } else {
                     dat0.saveAppt(apptsList.get(z));
                     if (apptsList.get(z).getValid()) { //if the appointment is valid it's deletable
                         assertTrue(dat0.deleteAppt(apptsList.get(z)));
                     } else { //if the appointment is invalid it never saved, therefore no delete
                         assertFalse(dat0.deleteAppt(apptsList.get(z)));
                     }
                 }
             }
         }
	 }

	@Test
	public void getApptRangeTest()  throws Throwable  {
		//create randomizer seed
		long randomseed =System.currentTimeMillis(); //10
		//System.out.println(" Seed:"+randomseed );
		Random random = new Random(randomseed);

		for (int x = 0; x < 100; x++) {
            DataHandler dat0 = new DataHandler("test0", false);

            LinkedList<Appt> apptsList = new LinkedList<Appt>();

            for (int y = 0; y < 10; y++) {
                int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
                String title = "Test title";
                String description = "Test description.";
                String emailAddress = "test@testmail.com";

                Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
                appt0.setValid();

                int sizeArray=ValuesGenerator.getRandomIntBetween(random, 1, 5);
                int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                int recur=ApptRandomTest.RandomSelectRecur(random);
                int recurIncrement = ValuesGenerator.RandInt(random);
                int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                appt0.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

                apptsList.add(appt0);
            }
            for (int z = 0; z < apptsList.size(); z++) {
                dat0.saveAppt(apptsList.get(z));
            }
            GregorianCalendar minday = new GregorianCalendar(2018,0,1);
            GregorianCalendar maxday = new GregorianCalendar(2018,10,1);
            CalDay min = new CalDay(minday);
            CalDay max = new CalDay(maxday);

            List<CalDay> cal0 = dat0.getApptRange(minday,maxday);
//            assertEquals(min.getDay(),cal0.get(0).getDay());
//            assertEquals(max.getDay(),cal0.get(cal0.size()-1).getDay());
        }
	}
	
}
