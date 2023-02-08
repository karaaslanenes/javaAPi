package revison;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Rev4 extends DummyRestApiBaseUrl {
     /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */
    /*
given
https://dummy.restapiexample.com/api/v1/employees
when
user send get request to the url
then
Status code should be 200
and
There are 24 employees
and
"Tiger Nixon" and "Garrett Winters" are among the employees
and
 The greatest age is 66
 and
The name of the lowest age is "[Tatyana Fitzpatrick]"
and
Total salary of all employees is 6,644,770
     */






    @Test
    public void get01(){
        // set the url
spec.pathParam("first","employees");
// set the expected data
// send the request get the response
    Response response= given().spec(spec).when().get("/{first}");
 // response.prettyPrint();
        // do assertion
        response.then().assertThat().statusCode(200).
                body("data.id",hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        JsonPath json=response.jsonPath();
List<Integer>age     = json.getList("data.findAll{it.id>0}.employee_age");
        Collections.sort(age);
assertEquals(66,(int)age.get(age.size()-1));
 String empname=    "data.findAll{it.employee_age==" +  age.get(0) + "}.employee_name";
        assertEquals("[Tatyana Fitzpatrick]",json.getString(empname));
  List<Integer>empSalry      =json.getList("data.findAll{it.id>0}.employee_salary");
        System.out.println(empSalry);
        int sum=0;
        for (Integer w:empSalry) {
            sum=sum+w;
        }
        System.out.println(sum);
        assertEquals(6644770,sum);
    }

}
