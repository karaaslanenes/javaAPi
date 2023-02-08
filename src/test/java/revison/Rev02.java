package revison;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Rev02 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/1
        When
         I send GET Request to the url
      Then
         Response body should be like that;
        {
    "firstname": "Ambre",
    "lastname": "Garcia",
    "totalprice": 216,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-05-05",
        "checkout": "2022-05-10"
    },
    "additionalneeds": "Dinner"
}
     */
   @Test
    public void get01(){
       spec.pathParams("first","booking","second",164);
       Response response  = given().spec(spec).when().get("/{first}/{second}");
      // response.prettyPrint();
//response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
//        body("firstname",equalTo("Ambre"),
//                "lastname",equalTo("Garcia"),"totalprice",
//                equalTo(216),"depositpaid",equalTo(true),
//                "bookingdates.checkin",equalTo("2022-05-05"),
//                "bookingdates.checkout",equalTo("2022-05-10") ,
//                "additionalneeds",equalTo("Dinner"));

//
      //JsonPath json=response.jsonPath();

// assertEquals("Ambre",json.getString("firstname"));
// assertEquals( "Garcia",json.getString("lastname"));
// assertEquals(216,json.getInt("totalprice"));
// assertEquals( true,json.getBoolean("depositpaid"));
// assertEquals("2022-05-05",json.getString("bookingdates.checkin"));
// assertEquals("2022-05-10",json.getString("bookingdates.checkout"));
// assertEquals("Dinner",json.getString("additionalneeds"));

    // set the expected data

      Map<String,String> bookingDate=new HashMap<>();
      bookingDate.put("checkin","2022-05-05");
      bookingDate.put("checkout","2022-05-10");

       Map<String ,Object>   expectedData=new HashMap<>();
       expectedData.put("firstname","Ambre");
       expectedData.put("lastname","Garcia");
       expectedData.put("totalprice",216);
       expectedData.put("depositpaid",true);
       expectedData.put("bookingdates",bookingDate);
      System.out.println(expectedData);


       Map<String,Object>actualData=response.as(HashMap.class);
      System.out.println(actualData);
      assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
      assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
      assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
      assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
      assertEquals(bookingDate.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
   }




}
