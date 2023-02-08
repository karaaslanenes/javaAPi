package revison;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.*;

public class RevTrk2 extends DummyRestApiBaseUrl {
    //https://dummy.restapiexample.com/api/v1
    //https://dummy.restapiexample.com/api/v1
    //https://dummy.restapiexample.com/api/v1/employees
    @Test

    public void test(){
// set the url
        spec.pathParam("first","employees");
  // set the expected data

// send the request get the response
  Response response=     given().spec(spec).when().get("/{first}");

  response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.statusCode());

        //response.prettyPrint();

        JsonPath json=response.jsonPath();
//        List<Integer> idList=json.getList("data.id");
//        int cout=0;
//        for (Integer w:idList) {
//          if(w>10){
//              cout++;
//          }
//
//        }
//        System.out.println(cout);
//        Assert.assertEquals(14,cout);
//        System.out.println(idList.size());


        List<Integer> idList=json.getList("data.findAll{it.id>10}.id");
        //  List<Integer> idList=json.getList("data.id.findAll{it>10}");
        System.out.println(idList);
        Collections.sort(idList,Collections.reverseOrder());
        System.out.println(idList);
        assertTrue(idList.size()==14);

        List<Integer> ageList=json.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println(ageList);
        Collections.sort(ageList);
        System.out.println(ageList);
        assertTrue(ageList.get(ageList.size()-1)==23);
List<String>empName=json.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(empName);
        assertTrue(empName.contains("Charde Marshall"));


        response.then().assertThat().statusCode(200).body("data.employee_name",hasItems("Charde Marshall"));







    }




}
