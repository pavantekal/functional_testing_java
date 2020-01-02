package api.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DeleteUserData {

	@Test
	public void putData() {
	String userid = "1596";
	try {
	Response response = given()
			.headers("Authorization", "Bearer sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK", "Content-Type", "application/json")
			.delete("https://gorest.co.in/public-api/users/"+userid);
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
