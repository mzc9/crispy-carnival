/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;


//This is a skeleton for your 3 different test approach

public class MZurlValidatorTest extends TestCase {

	public MZurlValidatorTest(String testName) {
		super(testName);
	}

	public void testManualTest() {
	//TODO
		//  use this function to implement your manual testing

	}

	public void testYourFirstPartition() {
	//TODO
		// use this function to implement your First Partition testing

	}

	public void testYourSecondPartition() {
	//TODO
		// use this function to implement your Second Partition testing

	}
	//TODO
	// more test cases for your Partitions 

//TODO
//Random testing


//PROGRAMMING BASED TESTING	
//==========================
	
/* UNIT TEST 1
 * for loop cycles through the array of Test cases of URL schemes
 */
	public void testSchemeValidity() {
		for (Test rp : testURLScheme)
			assertEquals(
					rp.url, 
					rp.expected, 
					new UrlValidator().isValid(rp.url));
	}
	
	public void testIsValidScheme() {
		for(Test rp : testValidScheme)
			assertEquals(
					rp.url,
					rp.expected,
					new UrlValidator().isValidScheme(rp.url));
	}
	
	/*  UNIT TEST 2
	 * for loop cycles through the array of Test cases of Authority
	 */
	public void testAuthorityValidity() {
		for (Test rp : testAuthority)
			assertEquals(
					rp.url, 
					rp.expected, 
					new UrlValidator().isValid(rp.url));
	}
	

	static class Test {
		String url;
		boolean expected;
		
		Test(String url, boolean expected) {
			this.url = url;
			this.expected = expected;
		}
	}
	
	
	Test[] testURLScheme = {
			
			new Test("https://news.google.com", true),
			new Test("12345678://", false),
			new Test("extremelylongstringthatshouldnotwork://", false),
		    new Test("(*&[*^://", false),
		    new Test("32434123://", false),
		    new Test("http:256.256.256.256:-1/../", false),
		    new Test("http:/256.256.256.256:65a/test1//file\"", false),
		    new Test("http://www.example.com/space%20here.html", true)
	};
	
	Test[] testAuthority = {
			
			
			new Test("http://300.55.32.257.00.98.00.98", false),
			new Test("192.168.1.1", true),
			new Test(":0/test1/?action=edit&mode=up", false),
			new Test("http://192.168.1", false),
			new Test("255.255.255.255", true),
			new Test("http://900.55.33.257", false),
			new Test("1.1.1.1", true),
			new Test("http://256.256.256.256/test1?action=view", false)
	};
	
	Test[] testValidScheme = {

			new Test("{ '", false), 
			new Test("ftp", true), 
			new Test("3ht://255.com", false),
			new Test("https", true)
			

	};
}

