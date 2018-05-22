package calendar;


import org.junit.Test;


import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void addApptTest()  throws Throwable  {
		 //create randomizer seed
		 long randomseed =System.currentTimeMillis(); //10
		 //			System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);


		 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
         int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
         int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
         int startHour = 0;
         int startMinute = 0;
         String title = "Test title";
         String description = "Test description.";
         String emailAddress = "test@testmail.com";

         GregorianCalendar calday0 = new GregorianCalendar(startYear,startMonth,startDay);
         CalDay cal0 = new CalDay(calday0);

         startMonth = startMonth + 1;
         for (int y = 0; y < 100; y ++){
             int isValid = ValuesGenerator.getRandomIntBetween(random, 1, 100);
             if (isValid < 50){//appointment will be invalid
                 startHour = ValuesGenerator.getRandomIntBetween(random, 1,20);
                 startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 50);
             } else {//appointment will be valid
                 startHour = ValuesGenerator.getRandomIntBetween(random, 50,100);
                 startMinute = ValuesGenerator.getRandomIntBetween(random, 50, 100);
             }
             Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
             appt0.setValid();
             cal0.addAppt(appt0);
         }

	 }


	
}
