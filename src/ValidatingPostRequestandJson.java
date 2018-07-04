import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class ValidatingPostRequestandJson {

	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		
		
	 
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
	 
		System.out.println("Response body: " + response.body().asString());

	//	int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "200");
		//String successCode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
}
