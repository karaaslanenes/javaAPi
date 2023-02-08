package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.ResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get18  extends DummyRestApiBaseUrl {

    /*
 Given
    https://dummy.restapiexample.com/api/v1/employee/1
 When
    User sends the GET request and get the response
 Then
    Status code is 200
 And
    "employee_name" is "Tiger Nixon"
And
   "employee_salary" is 320800
And
   "employee_age" is 61
And
   "status" is "success"
And
   "message" is "Successfully! Record has been fetched."
  */


    @Test
    public void get01() {
        spec.pathParams("first", "employee", "second", 1);
        DummyApiDataPojo dataPojo = new DummyApiDataPojo("Tiger Nixon", 320800, 61, "");
        ResponseBodyPojo responseBody = new ResponseBodyPojo("success", dataPojo, "Successfully! Record has been fetched.");
        System.out.println(responseBody);
        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.then().assertThat().statusCode(200);
    ResponseBodyPojo actualPojo=response.as(ResponseBodyPojo.class);
        System.out.println(actualPojo);
    assertEquals(responseBody.getMessage(),actualPojo.getMessage());
//  assertEquals(responseBody.getData().getEmployeeAge(),actualPojo.getData().getEmployeeAge());
//        assertEquals(responseBody.getData().getEmployeeSalary(),actualPojo.getData().getEmployeeSalary());
//        assertEquals(responseBody.getData().getEmployeeName(),actualPojo.getData().getEmployeeName());
//        assertEquals(responseBody.getData().getProfileImage(),actualPojo.getData().getProfileImage());
//        assertEquals(responseBody.getStatus(),actualPojo.getStatus());




    }
}