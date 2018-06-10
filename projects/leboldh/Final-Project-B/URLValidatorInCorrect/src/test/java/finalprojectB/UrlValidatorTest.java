
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Random;
//import

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

//   public void testManualTestF1()
//   {
//    UrlValidator urlVal = new UrlValidator();
//    assertTrue(urlVal.isValid("http://www.google.com"));
//   }
//
//   public void testManualTestF2()
//   {
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertTrue(urlValAll.isValid("https://www.google.com"));
//   }
//
//   public void testManualTestF3()
//   {
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertTrue(urlValAll.isValid("ftp://www.google.com:40/test1?action=view#bar"));
//   }
//
//   public void testManualTestF4()
//   {
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertTrue(urlValAll.isValid("hahaha://www.google.com"));
//   }
//
//   public void testManualTestF5()
//   {
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.NO_FRAGMENTS);
//     assertTrue(urlValAll.isValid("http://www.google.com"));
//   }
//
//   public void testManualTestP1()
//   {
//     String testString = null;
//
//     UrlValidator urlVal = new UrlValidator();
//     assertFalse(urlVal.isValid("hahaha://www.google.com"));
//     assertFalse(urlVal.isValid(testString));
//     assertFalse(urlVal.isValid(""));
//     assertFalse(urlVal.isValid("7"));
//   }
//
//   public void testManualTestP2()
//   {
//     String testString = null;
//
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertTrue(urlValAll.isValid("http://www.google.com"));
//     assertFalse(urlValAll.isValid(testString));
//     assertFalse(urlValAll.isValid(""));
//     assertFalse(urlValAll.isValid("7"));
//   }
//
//   public void testManualTestP3()
//   {
//     String testString = null;
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.NO_FRAGMENTS);
//     assertFalse(urlValAll.isValid("ftp://www.google.com:40/test1?action=view#bar"));
//     assertFalse(urlValAll.isValid(testString));
//     assertFalse(urlValAll.isValid(""));
//     assertFalse(urlValAll.isValid("7"));
//   }
//
//   public void testYourFirstPartitionF1()
//   {
//     //Partition 1: simple URLs without port, path, query, or fragment
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertFalse(urlValAll.isValid("http://"));
//   }
//
//   public void testYourFirstPartitionF2()
//   {
//     //Partition 1: simple URLs without port, path, query, or fragment
//     String[] CUST_SCHEMES = {"http", "https", "file", "test"};
//     UrlValidator urlValCust = new UrlValidator(CUST_SCHEMES);
//     assertTrue(urlValCust.isValid("http://www.google.com"));
//   }
//
//   public void testYourFirstPartitionF3()
//   {
//     //Partition 1: simple URLs without port, path, query, or fragment
//     String[] CUST_SCHEMES = {"http", "https", "file", "test"};
//     UrlValidator urlValCust = new UrlValidator(CUST_SCHEMES);
//     assertTrue(urlValCust.isValid("test://www.google.com"));
//   }
//
//   public void testYourFirstPartitionF4()
//   {
//     //Partition 1: simple URLs without port, path, query, or fragment
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertFalse(urlValAll.isValid("http://aaa"));
//   }
//
// public void testYourFirstPartition()
// {
//   //Partition 1: simple URLs without port, path, query, or fragment
//   UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//   assertTrue(urlValAll.isValid("http://www.google.com"));
// }
//
//   public void testYourSecondPartitionF1(){
//     //Partition 2: complex URLs - include at least one of port, path, query, or fragment
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertTrue(urlValAll.isValid("http://www.google.com:40/test1?action=view#bar"));
//   }
//
//   public void testYourSecondPartition(){
//     //Partition 2: complex URLs - include at least one of port, path, query, or fragment
//     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
//     assertFalse(urlValAll.isValid("http://www.google.com:-1/test1?action=view#bar"));
//
//     UrlValidator urlValNF = new UrlValidator(UrlValidator.NO_FRAGMENTS);
//     assertFalse(urlValNF.isValid("http://www.google.com:40/test1?action=view#bar"));
//   }
//

   //Programming based testing
    public static int getRandomIntBetween(Random random, int min, int max) {

        long range       = (long)max - (long)min + 1;
        long fraction    = (long)(range * random.nextDouble());
        int randomNumber = (int)(fraction + min);
        return randomNumber;
    }

    @Test
    public void testScheme(){
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int pick = getRandomIntBetween(random, 0,1);
        //pick = 2;

        switch (pick){
            case 0: //all schemes
                UrlValidator allSchemes = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
                assertTrue(allSchemes.isValid("http://www.google.com"));
                assertTrue(allSchemes.isValid("ftp://www.google.com"));
                assertTrue(allSchemes.isValid("test://www.google.com"));
                assertTrue(allSchemes.isValid("file://localhost/c:/test.txt"));

                assertFalse(allSchemes.isValid("www.google.com"));
                break;
            case 1: //default schemes
                UrlValidator defaultSchemes = new UrlValidator();
                assertTrue(defaultSchemes.isValid("https://www.google.com"));
                assertTrue(defaultSchemes.isValid("http://www.google.com"));
                assertTrue(defaultSchemes.isValid("ftp://www.google.com"));

                assertFalse(defaultSchemes.isValid("file://localhost/c:/test.txt"));
                assertFalse(defaultSchemes.isValid("test://www.google.com"));
                break;
            default: //custom schemes
                String[] schemes = {"ftp", "http", "file", "test"};
                UrlValidator customSchemes = new UrlValidator(schemes);

                assertTrue(customSchemes.isValid("http://www.google.com"));
                assertTrue(customSchemes.isValid("ftp://www.google.com"));
                assertTrue(customSchemes.isValid("test://www.google.com"));
                assertTrue(customSchemes.isValid("file://localhost/c:/test.txt"));

                assertFalse(customSchemes.isValid("www.google.com"));
                assertFalse(customSchemes.isValid("https://www.google.com"));
                break;
        }
    }

    @Test
    public void testFragment(){
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int pick = getRandomIntBetween(random, 0,1);
        //pick = 1;

        if (pick == 0) { //allow fragments
            UrlValidator allowFragments = new UrlValidator();

            assertTrue(allowFragments.isValid("https://www.google.com:40/test1?action=view#bar"));
            assertTrue(allowFragments.isValid("https://www.google.com#bar"));
            assertTrue(allowFragments.isValid("https://www.google.com"));
        } else { //disallow fragments
            UrlValidator noFragments = new UrlValidator(UrlValidator.NO_FRAGMENTS);

            assertFalse(noFragments.isValid("https://www.google.com:40/test1?action=view#bar"));
            assertFalse(noFragments.isValid("https://www.google.com#bar"));

            assertTrue(noFragments.isValid("https://www.google.com"));
        }
    }

    @Test
    public void testSlash(){
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int pick = getRandomIntBetween(random, 0,1);
        //pick = 1;

        if (pick == 0) { //allow double slashes
            UrlValidator allowSlashes = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);

            assertTrue(allowSlashes.isValid("https://www.google.com//test//test"));
        } else { //disallow double slashes
            UrlValidator noSlashes = new UrlValidator();

            assertFalse(noSlashes.isValid("https://www.google.com//test//test"));
        }
    }

    @Test
    public void testAuthority() {
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int pick = getRandomIntBetween(random, 0,1);
        //pick = 1;

        if (pick == 0) { //check empty authority
            UrlValidator emptyAuth = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

            assertTrue(emptyAuth.isValid("file:///c:/test.txt"));

            assertFalse(emptyAuth.isValid("https:///test/"));
        } else {
            UrlValidator authority = new UrlValidator();

            assertTrue(authority.isValid("https://test.edu/"));
            assertTrue(authority.isValid("https://bleh.gov/"));
            assertTrue(authority.isValid("https://bloop.co.uk/"));
        }
    }

    @Test
    public void testQuery(){
        UrlValidator query = new UrlValidator();

        assertTrue(query.isValid("https://www.google.com?id=123"));
        assertTrue(query.isValid("https://www.google.com:40/test1?id=123"));
        assertTrue(query.isValid("https://www.google.com:40/test1?id=123/"));
    }

    @Test
    public void testPath() {
        UrlValidator path = new UrlValidator();

        assertTrue(path.isValid("https://www.google.com:3000/"));
        assertTrue(path.isValid("https://www.google.com:40/test1/bleep/bloop/blop"));
        assertTrue(path.isValid("https://www.google.com/test1/bleep/bloop/blop/"));
    }

    @Test
    public void testPort(){
        UrlValidator port = new UrlValidator();

        assertTrue(port.isValid("https://www.google.com:3000"));
        assertTrue(port.isValid("https://www.google.com:40"));
    }


   @Test
   public void testIsValidRand01() {
       long testTimeout = 60*500*1;
       long startTime = Calendar.getInstance().getTimeInMillis();
       long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

       for (int x = 0; elapsed < testTimeout; x++){
        System.out.println(elapsed + ", " + testTimeout);
        long seed = Calendar.getInstance().getTimeInMillis();
        Random random = new Random(seed);

        int URLportion = getRandomIntBetween(random, 0,6);

        switch (URLportion){
            case 0: //test scheme
                testScheme();
                break;
            case 1: //test authority
                testAuthority();
                break;
            case 2: //test path
                testPath();
                break;
            case 3: //test query
                testQuery();
                break;
            case 4: //test fragment
                testFragment();
                break;
            case 5: //test port
                testPort();
                break;
            default: //test double slashes
                testSlash();
                break;
        }

        elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
       }
   }



}
