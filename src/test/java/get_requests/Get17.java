package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get17 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/employee/1
       HTTP Request Method: GET Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "employee_name" is "Tiger Nixon"
              iii) "employee_salary" is 320800
               iv)  "employee_age" is 61
                v) "status" is "success"
               vi)  "message" is "Successfully! Record has been fetched."
     */
    /*
    given
    https://dummy.restapiexample.com/api/v1/employee/1
    when
    user send get request to the url
  then
    Status code is 200
    and
    "employee_name" is "Tiger Nixon"
    and
    "employee_salary" is 320800
    and
    "employee_age" is 61
    and
     "status" is "success"
     and
     "message" is "Successfully! Record has been fetched."

     */

    @Test
    public void get01(){
        //set tthe url
        spec.pathParams("first","employee","second",1);
//send the request get the result
  Response response= given().spec(spec).when().get("/{first}/{second}");
  response.prettyPrint();
//        Map<String,Object> dataMap=new HashMap<>();
//dataMap.put("employee_name","Tiger Nixon")   ;
//dataMap.put("employee_salary",320800);
//dataMap.put("employee_age",61);
//dataMap.put("profile_image","");
//        System.out.println(dataMap);
//1st way matchers
//        response.then().assertThat().statusCode(200).body("status",equalTo("success"),
//                "data.employee_name",equalTo("Tiger Nixon"),"data.employee_salary",equalTo(320800),
//                "data.employee_age",equalTo(61),
//                "data.profile_image",equalTo(""),"message",equalTo("Successfully! Record has been fetched."));
//
// second way json
//        JsonPath json=response.jsonPath();
//assertEquals("Successfully! Record has been fetched.",json.getString("message"));
//assertEquals("success",json.getString("status"));
//assertEquals("Tiger Nixon",json.getString("data.employee_name"));
//assertEquals(320800,json.getInt("data.employee_salary"));
//assertEquals(61,json.getInt( "data.employee_age"));
//assertEquals(200,response.statusCode());
//3rd way method calls
        Map<String,Object> dataMap=new HashMap<>();
dataMap.put("employee_name","Tiger Nixon")   ;
dataMap.put("employee_salary",320800);
dataMap.put("employee_age",61);
dataMap.put("profile_image","");
        System.out.println(dataMap);

        Map<String ,Object>expectedMap=new HashMap<>();
    expectedMap.put("status","success");
        expectedMap.put("data",dataMap);
        expectedMap.put("message","Successfully! Record has been fetched.");
        System.out.println(expectedMap);

Map<String,Object>actualMap=response.as(HashMap.class);
        System.out.println(actualMap);

assertEquals(expectedMap.get("status"),actualMap.get("status"));
assertEquals(expectedMap.get("message"),actualMap.get("message"));
assertEquals(dataMap.get("employee_name"),((Map)actualMap.get("data")).get("employee_name"));
assertEquals(dataMap.get("employee_name"),((Map)actualMap.get("data")).get("employee_name"));
    }

}
