package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PostPojo04 extends JsonPlaceHolderBaseUrl {

    /*
             Given
                https://jsonplaceholder.typicode.com/todos
                {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false
                }
            When
                I send POST Request to the Url
            Then
                Status code is 201
            And
                response body is like {
                                        "userId": 55,
                                        "title": "Tidy your room",
                                        "completed": false,
                                        "id": 201
                                        }
         */
    @Test
    public void postPojo01() {

        // set the url
        spec.pathParam("first", "todos");
//set the expected data
        JsonPlaceHolderPojo requestBody = new JsonPlaceHolderPojo(55, "Tidy your room", false);
//send the post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).post("/{first}");
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        assertEquals(requestBody.getUserId(),actualData.getUserId());
        assertEquals(requestBody.getCompleted(),actualData.getCompleted());
        assertEquals(requestBody.getTitle(),actualData.getTitle());
    }
}