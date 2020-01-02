package api.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.google.gson.JsonObject;
public class UpdateUserData {

	@Test
	public void putData() {
	String userid = "1596";
	String email = "test5@test.com";
	JsonObject userdata = new JsonObject();
    userdata.addProperty("email", email);
	try {
	Response response = given().body(userdata.toString())
			.headers("Authorization", "Bearer sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK", "Content-Type", "application/json")
			.patch("https://gorest.co.in/public-api/users/"+userid);
	System.out.println("Status Line is"+response.getStatusLine());
	System.out.println("Time Taken:"+response.getTime());
	System.out.println("Response = "+response.asString());
	MatcherAssert.assertThat(response.getStatusCode(), is(equalTo(200)));
	JsonPath jsonPathEvaluator = response.jsonPath();
	String email_updated = jsonPathEvaluator.get("result.email");
	MatcherAssert.assertThat(email_updated,is(equalTo(email)));
	}
	catch(Exception e) {
		System.out.println("Error thrown-"+e.getMessage());
	}
	
}
}
