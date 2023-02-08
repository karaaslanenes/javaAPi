package revison;

import base_urls.JsonPlaceHolderBaseUrl;
import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RevTrk3 extends JsonPlaceHolderBaseUrl {

    @Test

    public void set10() {

       spec.pathParams("first","todos","second",2);

Response response=given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();

response.then().statusCode(200);

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put( "userId", 1);
        expectedData.put( "id", 2);
        expectedData.put( "title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        System.out.println(expectedData);


        HashMap<String,Object>actauldData=response.as(HashMap.class);
        System.out.println(actauldData);

        Assert.assertTrue(expectedData.get("userId").equals(actauldData.get("userId")));
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),json.getInt("userId"));

        response.getHeaders();
        response.prettyPrint();
    }
}
