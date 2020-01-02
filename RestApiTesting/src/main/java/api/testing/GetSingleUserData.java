package api.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetSingleUserData {
	
	@Test
	public static void getUserData() {
		String firstname = "john";
//		given().get("https://gorest.co.in/public-api/users?_format=json&access-token=sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK")
//		.then().body("_meta.code", equalTo(200)).log().all();
		Response response = given().get("https://gorest.co.in/public-api/users?first_name="+firstname+"&_format=json&access-token=sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK");
		System.out.println("Status code returned - "+response.getStatusCode());
		System.out.println("Status Line is - "+response.getStatusLine());
		System.out.println("Time Taken:"+response.getTime());
		System.out.println("Response = "+response.asString());
		MatcherAssert.assertThat(response.getStatusCode(), is(equalTo(200)));
	}
	
}
