package test_data;


import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,Object> expectedDataSetUp(String firstname ,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){
Map<String,Object> data1=new HashMap<>();
data1.put("firstname",firstname);
data1.put("lastname",lastname);
data1.put("totalprice",totalprice);
data1.put("depositpaid",depositpaid);
data1.put("bookingdates",bookingdates);
return  data1;
    }
public Map<String,String> bookingDateSetUp(String checkin,String checkout) {
    Map<String,String> data2=new HashMap<>();
    data2.put("checkin",checkin);
    data2.put("checkout",checkout);
    return data2;
}


    }









