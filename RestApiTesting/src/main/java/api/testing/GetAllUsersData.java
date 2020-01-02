package api.testing;


import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class GetAllUsersData {

	public static void main(String[] args) {
		getUserData();
	}
	@Test
	public static void getUserData() {
//		given().get("https://gorest.co.in/public-api/users?_format=json&access-token=sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK")
//		.then().body("_meta.code", equalTo(200)).log().all();
		Response response = given().get("https://gorest.co.in/public-api/users?_format=json&access-token=sBnUCg0pyD75DqsaboRe0BYFH5vHniLyM3AK");
		System.out.println("Status code returned - "+response.getStatusCode());
		System.out.println("Status Line is - "+response.getStatusLine());
		System.out.println("Time Taken:"+response.getTime());
		System.out.println("Response = "+response.asString());
		MatcherAssert.assertThat(response.getStatusCode(), is(equalTo(200)));
	}
	
}
