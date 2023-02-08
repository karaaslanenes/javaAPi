package revison;

import base_urls.GoRestBaseUrl;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

public class Rev3 extends GoRestBaseUrl {
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
                "data": {
                    "id": 13,
                    "name": "Fr. Ajit Prajapat",
                    "email": "ajit_fr_prajapat@barrows.org",
                    "gender": "female",
                    "status": "active"
                }
            }
     */

@Test
public void get01(){
    spec.pathParams("first","users","second",13);

    GoRestTestData dataobj=new GoRestTestData();
Map<String,String>  dataMap=  dataobj.dataKeyMap("Fr. Ajit Prajapat","ajit_fr_prajapat@barrows.org","female","active");

}


}
