package get_requests;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Rev5 extends HerOkuAppBaseUrl {
    /*
            Given
                https://restful-booker.herokuapp.com/booking/5
            When
                User send a GET request to the URL
            Then
                HTTP Status Code should be 200
            And
                Response content type is "application/json"
            And
                Response body should be like;
               {
    "firstname": "Susan",
    "lastname": "Jones",
    "totalprice": 624,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2017-04-12",
        "checkout": "2017-11-25"
    }
}
         */
@Test

    public void get01(){
    spec.pathParams("first","booking","second",5);

Response response=given().spec(spec).when().get("/{first}/{second}");
//response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
//        body("firstname",equalTo("Sally"),
//                "lastname",equalTo("Smith"),
//                ""totalprice",equalTo(null),
//                "depositpaid",equalTo(true),
//                "bookingdates.checkin",equalTo("2021-08-10"),
//                "bookingdates.checkout",equalTo("2021-10-02"));

    JsonPath json=response.jsonPath();
    assertEquals("Eric",json.getString("firstname"));
    assertEquals("Ericsson",json.getString("lastname"));
    assertEquals(947,json.getInt("totalprice"));
    assertEquals(false,json.getBoolean("depositpaid"));
    assertEquals("2017-05-29",json.getString("bookingdates.checkin"));

}
}