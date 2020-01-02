package api.testing;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class AddNewUser {

	@Test
	public void addUser() {
		String firstname = "Sam";
		String lastname = "Miller";
		String gender = "male";
		String email = "sam.miller@example.com";
		String dob = "1980-10-09";
		
		try {
		Response response = given().formParams("first_name",firstname,"last_name",lastname,"gender",gender,"dob",dob,"email",email)
		.post("https://gorest.co.in/public-api/users?_format=json&access-token=sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK");
		System.out.println("Status Line is"+response.getStatusLine());
		System.out.println("Time Taken:"+response.getTime());
		System.out.println("Response = "+response.asString());
		MatcherAssert.assertThat(response.getStatusCode(), is(equalTo(200)));
		}
		catch(Exception e) {
			System.out.println("Error thrown-"+e.getMessage());
		}
		
	}
	
}
