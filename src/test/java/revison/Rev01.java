package revison;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
/*{
    "userId": 1,
    "id": 7,
    "title": "illo expedita consequatur quia in",
    "completed": false
}

 */


public class Rev01 extends JsonPlaceHolderBaseUrl {
    @Test
    public void get01(){
        spec.pathParams("first","todos","second",7);
// set the expected data
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);
        System.out.println(expectedData);
     // send the request get the response
  Response response=  given().spec(spec).when().get("/{first}/{second}");
  response.prettyPrint();

  Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println(actualData);
        // assertion
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }

}
