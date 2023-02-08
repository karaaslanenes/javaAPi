package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get10 extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
                "meta": null,
                "data": {"id": 13,
                    "name": "Fr. Ajit Prajapat",
                    "email": "ajit_fr_prajapat@barrows.org",
                    "gender": "female",
                    "status": "active"
                }
            }
     */
    @Test
    public void get01(){

        //1.Step:Set the URL
        spec.pathParams("first", "users", "second", 13);

        //2.Step: Set the Expected Data
        GoRestTestData dataKey = new GoRestTestData();
 Map<String,String>   dataMap=    dataKey.dataKeyMap("Aditya Shukla","aditya_shukla@carroll-rolfson.org","female","active");
        System.out.println(dataMap);
        //send the request get the response
Map<String,Object> expectedDataMap =dataKey.expectedDataKeyMap(null,dataMap);
      Response response=  given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();
 Map<String,Object>  actualData   =response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals(expectedDataMap.get("meta"),actualData.get("meta"));
        assertEquals(dataMap.get("name"), ((Map)actualData.get("data")).get("name"));
        assertEquals(dataMap.get("email"),((Map) actualData.get("data")).get("email"));
        assertEquals(dataMap.get("gender"),((Map) actualData.get("data")).get("gender"));
        assertEquals(dataMap.get("status"),((Map) actualData.get("data")).get("status"));

    }
}