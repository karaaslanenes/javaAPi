package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {
    /*
    Given
               https://restful-booker.herokuapp.com/booking/2
        When
            I send GET Request to the URL
      Then
            Status code is 200
{
"firstname": "Mark",
"lastname": "Ericsson",
"totalprice": 726,
"depositpaid": true,
"bookingdates": {
"checkin": "2015-08-07",
"checkout": "2020-10-25"
},
"additionalneeds": "Breakfast"
}
     */
    @Test
    public void get01ObjectMapper(){
        //1. set the url
        spec.pathParams("first","booking","second",2);

        //
        String expectedData = "{\n" +
                "\"firstname\": \"Mark\",\n" +
                "\"lastname\": \"Jones\",\n" +
                "\"totalprice\": 802,\n" +
                "\"depositpaid\": false,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2017-02-18\",\n" +
                "\"checkout\": \"2019-10-26\"\n" +
                "},\n" +
                "\"additionalneeds\": \"\"\n" +
                "}";

        BookingPojo expectedDataPojo =
                JsonUtil.convertJsonToJavaObject(expectedData,BookingPojo.class);

        //3. send GET request and get the response
        Response response = given().
                spec(spec).
                when().
                get("/{first}/{second}");

        response.prettyPrint();

        BookingPojo actualDataPojo =
                JsonUtil.convertJsonToJavaObject(response.asString(),BookingPojo.class);

        assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
        assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
        assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
        assertEquals(expectedDataPojo.getDepositpaid(),actualDataPojo.getDepositpaid());
        assertEquals(expectedDataPojo.getBookingdates().getCheckin(),
                actualDataPojo.getBookingdates().getCheckin());
        assertEquals(expectedDataPojo.getBookingdates().getCheckout(),
                actualDataPojo.getBookingdates().getCheckout());
        // assertEquals(expectedDataPojo.getAdditionalneeds(),actualDataPojo.getAdditionalneeds());

        //Soft Assertion
        // 1) create SoftAssert Object
        // 2) do assertions
        // 3) assertAll() method
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualDataPojo.getFirstname(),expectedDataPojo.getFirstname() );
        softAssert.assertEquals(actualDataPojo.getLastname(), expectedDataPojo.getLastname() );
        softAssert.assertEquals(actualDataPojo.getTotalprice(),expectedDataPojo.getTotalprice() );
        softAssert.assertEquals(actualDataPojo.getDepositpaid(),expectedDataPojo.getDepositpaid() );
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(),
                expectedDataPojo.getBookingdates().getCheckin() );
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(),
                expectedDataPojo.getBookingdates().getCheckout() );

        softAssert.assertAll();

    }
}