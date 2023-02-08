package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Patch01 extends JsonPlaceHolderBaseUrl {
  /*  Given
    https://jsonplaceholder.typicode.com/todos/198
    {
        "title": "Wash the dishes",
    }
    When
    I send PATCH Request to the Url
            Then
    Status code is 200
    And response body is like   {
        "userId": 10,
                "title": "Wash the dishes"
                "completed": true,
                "id": 198
   */
  @Test
  public void patch() {
    // set the url
    spec.pathParams("first", "todos", "second", 198);
    // set the request body
    JsonPlaceHolderTestData requestBody=new JsonPlaceHolderTestData();
   Map<String,Object> requestBodyMap= requestBody.expectedDataWithAllKeys(null,"Wash the dishes",null);
    // sent tthe patch request and get the response
  Response response=  given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
response.prettyPrint();
response.then().assertThat().statusCode(200).body("title",equalTo(requestBodyMap.get("title")));

Map<String,Object>MapToAssertAllDetails=requestBody.expectedDataWithAllKeys(10,"Wash the dishes",true);
response.then().assertThat().body("title",equalTo(MapToAssertAllDetails.get("title")),
        "userId",equalTo(MapToAssertAllDetails.get("userId")),
        "completed",equalTo(MapToAssertAllDetails.get("completed")));


  }
}