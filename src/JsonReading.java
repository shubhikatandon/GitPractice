import java.net.MalformedURLException;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Test

public class JsonReading {
	
//	public void JsonPathUsage() throws MalformedURLException
//	{
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.get("");
//
//		// First get the JsonPath object instance from the Response interface
//		JsonPath jsonPathEvaluator = response.jsonPath();
//
//		// Read all the books as a List of String. Each item in the list
//		// represent a book node in the REST service Response
//		List<Book> allBooks = jsonPathEvaluator.getList("books", Book.class);
//
//		// Iterate over the list and print individual book item
//		// Note that every book entry in the list will be complete Json object of book
//		for(Book book : allBooks)
//		{
//			System.out.println("Book: " + book.title);
//		}
	
	public void JsonPathUsage() throws MalformedURLException
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Read all the books as a List of String. Each item in the list
		// represent a book node in the REST service Response
		List<String> allBooks = jsonPathEvaluator.getList("books.title");

		// Iterate over the list and print individual book item
		for(String book : allBooks)
		{
			System.out.println("Book: " + book);
		}
	}
	
	
	
	public void JsonArrayToList()
	{

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		System.out.println("Response Body -> " + response.body().asString());

		// Using JsonPath we can convert an Array of Json objects into
		// List of Class Type representing the Json Object.
		// In the below code we can use JsonPath.getList(<NodeName>) method
		// to get a list of Books.
		Book[] books = response.jsonPath().getObject("books", Book[].class);
		System.out.println("Books as String " + books.toString());

		// Iterate over all the books and print the author name
		for(Book book : books)
		{
			System.out.println("Author name of book: " + book.author);
		}
	}
	}


