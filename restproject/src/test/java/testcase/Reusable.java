package testcase;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Reusable {
	public String placeid;
	public RequestSpecification request;
	
	public RequestSpecification reqInit(String url) {
		request = RestAssured.given();
		request.baseUri(url);
		return request;
		}
	public void setPlaceid(Object placeid1) {
		placeid = (String) placeid1;
		}
	public String getPlaceid() {
		
		return placeid;
		
	}
	}