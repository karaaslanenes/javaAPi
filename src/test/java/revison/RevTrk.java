package revison;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.*;

public class RevTrk extends JsonPlaceHolderBaseUrl {
//{
//    "userId": 1,
//    "id": 7,
//    "title": "illo expedita consequatur quia in",
//    "completed": false
//}

    @Test
    public void setup(){
        //get url
        spec.pathParams("first","todos","second",7);

        // expected data

        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);

        System.out.println("expected data : "+expectedData);

        //send request get response

Response response= given().spec(spec).when().get("/{first}/{second}");

response.prettyPrint();

//
// from json to java de serialization
//Map<String,Object>actualData=response.as(HashMap.class);
//        System.out.println("Actual Data "+actualData);
//        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
//        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
//        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
//        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));

  //matchers

  response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("userId",equalTo(1),"id",equalTo(7),
          "title",equalTo("illo expedita consequatur quia in"),"completed",equalTo(false));

//json path
        JsonPath json=response.jsonPath();
assertEquals(1,json.getInt("userId"));
        assertEquals(7,json.getInt("id"));
        assertEquals(7,json.getInt("id"));
        assertEquals("illo expedita consequatur quia in",json.getString("title"));
        assertEquals(false,json.getBoolean("completed"));

//






    }


}
