package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Get08  extends JsonPlaceHolderBaseUrl {
       /*
        Serialization: To convert Java Object to JSON Data
        De-Serialization: To convert JSON Data to Java Object

        To do De-Serialization and Serialization we can use the followings;
        1)Gson: Google Created
        2)Object Mapper: More popular
     */

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
         I send GET Request to the URL
       Then
         Status code is 200
         And "completed" is false
         And "userId" is 1
         And "title" is "quis ut nam facilis et officia qui"
         And header "Via" is "1.1 Vegur"
         And header "Server" is "cloudflare"
         {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

//  @Test
//  public void get01(){
//      // set the url
//      spec.pathParams("first","todos","second",2);
//      // set the data
//      Map<String,Object> expectedDate=new HashMap<>();
//      expectedDate.put("completed",false);
//      expectedDate.put("userId",1);
//      expectedDate.put("title","quis ut nam facilis et officia qui");
//      expectedDate.put("Status code",200);
//      expectedDate.put("Via","1.1 vegur");
//      expectedDate.put("Server","cloudflare");
//      System.out.println(expectedDate);
//
//
//      //send the request get the response
// Response response=     given().spec(spec).when().get("/{first}/{second}");
// response.prettyPrint();
//      // do assertion
//Map<String,Object> actualData=response.as(HashMap.class);
//      System.out.println(actualData);
//assertEquals(expectedDate.get("userId"),actualData.get("userId"));
//assertEquals(expectedDate.get("completed"),actualData.get("completed"));
//assertEquals(expectedDate.get("title"),actualData.get("title"));
//      assertEquals(expectedDate.get("Status code"),response.getStatusCode());
//      assertEquals(expectedDate.get("Via"),response.getHeader("Via"));
//      assertEquals(expectedDate.get("Server"),response.getHeader("Server"));
////response.
////        then().
////        assertThat().
////        statusCode(200).
////        body("completed",equalTo(false),
////        "userId",equalTo(1),"title",equalTo("quis ut nam facilis et officia qui"));
////       assertEquals("cloudflare",response.getHeader("Server"));
////       assertEquals("1.1 vegur",response.getHeader("Via"));
//
//  }
@Test
    public void get02(){
    // set the url
    spec.pathParams("first","todos","second",2);
    // set the data
    JsonPlaceHolderTestData expectedData=new JsonPlaceHolderTestData();
   Map<String,Object> expectedDataMap=expectedData.expectedDataWithAllKeys(1,"quis ut nam facilis et officia qui",false);
    expectedDataMap.put("Status code",200);
    expectedDataMap.put("Via","1.1 vegur");
    expectedDataMap.put("Server","cloudflare");

    //send the request get the response
    Response response=     given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // do assertion
    Map<String,Object> actualData=response.as(HashMap.class);
    assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));
assertEquals(expectedDataMap.get("title"),actualData.get("title"));
     assertEquals(expectedDataMap.get("Status code"),response.getStatusCode());
     assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
      assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));

}

}
