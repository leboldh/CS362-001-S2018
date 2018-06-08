
package finalprojectB;

import junit.framework.TestCase;
//import

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTestF1()
   {
    UrlValidator urlVal = new UrlValidator();
    assertTrue(urlVal.isValid("http://www.google.com"));
   }

   public void testManualTestF2()
   {
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlValAll.isValid("https://www.google.com"));
   }

   public void testManualTestF3()
   {
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlValAll.isValid("ftp://www.google.com:40/test1?action=view#bar"));
   }

   public void testManualTestF4()
   {
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlValAll.isValid("hahaha://www.google.com"));
   }

   public void testManualTestF5()
   {
     UrlValidator urlValAll = new UrlValidator(UrlValidator.NO_FRAGMENTS);
     assertTrue(urlValAll.isValid("http://www.google.com"));
   }

   public void testManualTestP1()
   {
     String testString = null;

     UrlValidator urlVal = new UrlValidator();
     assertFalse(urlVal.isValid("hahaha://www.google.com"));
     assertFalse(urlVal.isValid(testString));
     assertFalse(urlVal.isValid(""));
     assertFalse(urlVal.isValid("7"));
   }

   public void testManualTestP2()
   {
     String testString = null;

     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlValAll.isValid("http://www.google.com"));
     assertFalse(urlValAll.isValid(testString));
     assertFalse(urlValAll.isValid(""));
     assertFalse(urlValAll.isValid("7"));
   }

   public void testManualTestP3()
   {
     String testString = null;
     UrlValidator urlValAll = new UrlValidator(UrlValidator.NO_FRAGMENTS);
     assertFalse(urlValAll.isValid("ftp://www.google.com:40/test1?action=view#bar"));
     assertFalse(urlValAll.isValid(testString));
     assertFalse(urlValAll.isValid(""));
     assertFalse(urlValAll.isValid("7"));
   }

   public void testYourFirstPartitionF1()
   {
     //Partition 1: simple URLs without port, path, query, or fragment
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertFalse(urlValAll.isValid("http://"));
   }

   public void testYourFirstPartitionF2()
   {
     //Partition 1: simple URLs without port, path, query, or fragment
     String[] CUST_SCHEMES = {"http", "https", "file", "test"};
     UrlValidator urlValCust = new UrlValidator(CUST_SCHEMES);
     assertTrue(urlValCust.isValid("http://www.google.com"));
   }

   public void testYourFirstPartitionF3()
   {
     //Partition 1: simple URLs without port, path, query, or fragment
     String[] CUST_SCHEMES = {"http", "https", "file", "test"};
     UrlValidator urlValCust = new UrlValidator(CUST_SCHEMES);
     assertTrue(urlValCust.isValid("test://www.google.com"));
   }

   public void testYourFirstPartitionF4()
   {
     //Partition 1: simple URLs without port, path, query, or fragment
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertFalse(urlValAll.isValid("http://aaa"));
   }

 public void testYourFirstPartition()
 {
   //Partition 1: simple URLs without port, path, query, or fragment
   UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
   assertTrue(urlValAll.isValid("http://www.google.com"));
 }

   public void testYourSecondPartitionF1(){
     //Partition 2: complex URLs - include at least one of port, path, query, or fragment
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertTrue(urlValAll.isValid("http://www.google.com:40/test1?action=view#bar"));
   }

   public void testYourSecondPartition(){
     //Partition 2: complex URLs - include at least one of port, path, query, or fragment
     UrlValidator urlValAll = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
     assertFalse(urlValAll.isValid("http://www.google.com:-1/test1?action=view#bar"));

     UrlValidator urlValNF = new UrlValidator(UrlValidator.NO_FRAGMENTS);
     assertFalse(urlValNF.isValid("http://www.google.com:40/test1?action=view#bar"));
   }

   public void testIsValid()
   {
	   //You can use this function for programming based testing
      

   }



}
