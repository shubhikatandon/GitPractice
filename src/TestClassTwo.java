

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

@Test
public class TestClassTwo {
	
	
	public void GetWeatherDetailsCondensed()
	{
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		Response response = httpRequest.get("/Hyderabad");
		
		//System.out.println("Status Code" +response.getStatusCode());
		//System.out.println("Contnt type" +response.getContentType());
		//System.out.println("Status Line" + response.getStatusLine());
		//System.out.println("Header type" +response.getHeaders());
		System.out.println("Server value----"+response.header("Server"));
		System.out.println( "Content Encoding---"+response.header("Content-Encoding"));
		// .header(String arg0) method is used to get a particular header. In the argument of this method pass the exact header name.

		System.out.println("Get Header Server"+response.getHeader("Server"));
		
		//get Header and header will do the same job can be replaced with each other
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		//ResponseBody interface also has a method called .asString(), as used in the above code, which converts a ResponseBody into its String representation
		
		
		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		Assert.assertEquals(body.asString().contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		
		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + response.asString());
	}

}
