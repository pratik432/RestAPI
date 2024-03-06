package testcase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleApi {
	Reusable ru = new Reusable();
	public RequestSpecification request = ru.reqInit("https://rahulshettyacademy.com");
	@Test(priority=0)
	public void getPostcall() {
		JSONObject requestparam = new JSONObject();
		JSONObject child = new JSONObject();
		child.put("lat", -38.383494);
		child.put("lng", 33.427362);
		requestparam.put("location", child);
		requestparam.put("accuracy", "50");
		requestparam.put("name", "Frontline house");
		requestparam.put("phone_number", "(+91) 983 893 3937");
		requestparam.put("address", "29, side layout, cohen 09");
		JSONArray arr = new JSONArray();
		arr.add("shop");
		arr.add("shoe park");
		requestparam.put("types", arr);
		requestparam.put("website", "http://google.com");
		requestparam.put("language", "French-IN");
		request.header("Content-Type", "application/json");
		request.body(requestparam.toJSONString());
		request.queryParam("key", "qaclick123");
		Response response = request.post("maps/api/place/add/json");
		System.out.println("Response " + response.asString());
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(response.getStatusCode(), 200);
		String status = response.jsonPath().get("status");
		sa.assertEquals(status, "OK");
		// ru.setPlaceid(response.jsonPath().get("place_id"));
		ru.setPlaceid(response.jsonPath().get("place_id"));
		sa.assertEquals(!(response.jsonPath().get("place_id")).equals(null), true);
		sa.assertAll();
		}
	@Test(priority=1)
	public void putMethod() {
		request.header("Content-Type", "application/json");
		Response response = request.queryParam("key", "qaclick123").queryParam("place_id", ru.getPlaceid())
		.get("/maps/api/place/get/json");
		System.out.println("Response " + response.asString());
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(response.getStatusCode(), 200);
		sa.assertAll();
	}
	@Test(priority=2)
	 public void getPutMethod() {
		 JSONObject requestparam = new JSONObject();
		 requestparam.put("place_id", ru.getPlaceid());
		 requestparam.put("address", "70 , Summer walk , USA");
		 requestparam.put("key", "qaclick123");
		 request.header("Content-Type", "application/json");
		 request.body(requestparam.toJSONString());
		 Response response = request.queryParam("key", "qaclick123").queryParam("place_id", ru.getPlaceid())
		 .put("/maps/api/place/get/json");
		 System.out.println("Response " + response.asString());
		 SoftAssert sa = new SoftAssert();
		 sa.assertEquals(response.getStatusCode(), 200);
		 sa.assertAll();
	 }
	
	
}
