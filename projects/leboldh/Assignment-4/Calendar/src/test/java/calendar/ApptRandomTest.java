package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }

	 @Test
	 public void setValidTest() throws Throwable{
	 	//create randomizer seed
		 long randomseed =System.currentTimeMillis(); //10
		 //	System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);

		 for (int x = 0; x < 200; x++) {
			 int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
			 String title = "Test title";
			 String description = "Test description.";
			 String emailAddress = "test@testmail.com";

			 int y = ValuesGenerator.getRandomIntBetween(random, 0,9);
			 switch(y){
				 case 0: //month <1
					 startMonth = -startMonth;
				 	break;
				 case 1: //month >12
					 startMonth = ValuesGenerator.getRandomIntBetween(random, 13, 100);
				 	break;
				 case 2: //hour <0
					 startHour = -startHour;
				 	break;
				 case 3: //hour >23
					 startHour = ValuesGenerator.getRandomIntBetween(random, 24,100);
				 	break;
				 case 4: //minute <0
					 startMinute = -startMinute;
				 	break;
				 case 5: //minute >59
					 startMinute = ValuesGenerator.getRandomIntBetween(random, 60, 100);
				 	break;
				 case 6: //year <=0
					 startYear = ValuesGenerator.getRandomIntBetween(random,0,2018);
					 startYear = -startYear;
				 	break;
				 case 7: //day <1
					 startDay = -startDay;
				 	break;
				 case 8: //days >numdaysinmonth
					 startDay = ValuesGenerator.getRandomIntBetween(random, 32,100);
				 	break;
				 default:
				 	break;
			 }
			 Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
			 appt0.setValid();
			 if (y==9){ //nothing was changed, appt valid
			 	assertTrue(appt0.getValid());
			 } else { //something was changed, appt not valid
				assertFalse(appt0.getValid());
			 }
		 }
	 }

	 @Test
	public void setRecurDaysTest() throws Throwable{
	 	//create randomizer seed
		 long randomseed =System.currentTimeMillis(); //10
		 //	System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);
		for (int x = 0; x < 100; x++) {
			int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
			String title = "Test title";
			String description = "Test description.";
			String emailAddress = "test@testmail.com";

			Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);

			int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			int[] recurDays;
			if (sizeArray == 0){
				recurDays = null;
			} else {
				recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
			}
			int recur=ApptRandomTest.RandomSelectRecur(random);
			int recurIncrement = ValuesGenerator.RandInt(random);
			int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			appt0.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
		}
	 }

	@Test
	public void isOnTest() throws Throwable{
	 	//create randomizer seed
		long randomseed =System.currentTimeMillis(); //10
		//System.out.println(" Seed:"+randomseed );
		Random random = new Random(randomseed);

		for (int x = 0; x < 500; x++) {
			//generate random values for constructor input
			int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
			String title="Test title";
			String description="Test description.";
			String emailAddress="test@testmail.com";

			//generate appointment with random data
			Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);

			int isTrue = ValuesGenerator.getRandomIntBetween(random, 1, 100);
			if (isTrue <= 50){
				assertTrue(appt0.isOn(startDay,startMonth,startYear));
			} else {
				int y = ValuesGenerator.getRandomIntBetween(random, 1,3);

				int newDay = startDay;
				int newMonth = startMonth;
				int newYear = startYear;
				switch(y){
					case 1: //day will be different
						newDay = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						break;
					case 2: //month will be different
						newMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						break;
					case 3: //year will be different
						newYear = ValuesGenerator.getRandomIntBetween(random, 2019,2090);
						break;
					default:
						break;
				}
				if (newDay != startDay || newMonth != startMonth || newYear!=startYear) {
					assertFalse(appt0.isOn(newDay, newMonth, newYear));
				}
			}
		}
	}

}
