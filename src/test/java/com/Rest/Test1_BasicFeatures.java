package com.Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class Test1_BasicFeatures 
{
	@Test
	public void TestCase1()
	{
		System.out.println("Verify the log details of the web services : - ");
		given().when().get("http://services.groupkt.com/country/get/all").then().statusCode(200).log().all();
	}
	
	@Test
	public void TestCase2()
	{
		System.out.println("Verify that result.name is equal to india : - ");
		given().when().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name", hasItems("India","Cook Islands","Denmark"));
	}
	
	
   // @Test
    public void TestCase3()
	{
		System.out.println("Verify that result.name is equal to india : - ");
		given().when().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name", hasItems("India123","Cook Islands","Denmark"));
	}
	
	@Test
	public void TestCase4()
	{
		System.out.println("Verify that result.name is equal to india : - ");
		given().when().get("http://services.groupkt.com/country/get/iso2code/IN").then().body("RestResponse.result.name", equalTo("India"));
	}
	
	//@Test
	public void TestCase5()
	{
		System.out.println("Verify that result.alpha2_code is equal to india : - ");
		given().when().get("http://services.groupkt.com/country/get/iso2code/IN").then().body("RestResponse.result.alpha2_code", equalTo("USA"));
	}
	
	@Test
	public void TestCase6()
	{
		System.out.println("Verify multiple condition : result.name, result.alpha2_code, result.alpha3_code is equal to india : - ");
		given().when().get("http://services.groupkt.com/country/get/iso2code/IN").then()
		.body("RestResponse.result.name", equalTo("India"))
		.body("RestResponse.result.alpha2_code", equalTo("IN"))
		.body("RestResponse.result.alpha3_code", equalTo("IND"));
	}
	
	
	
	
	
	

}
