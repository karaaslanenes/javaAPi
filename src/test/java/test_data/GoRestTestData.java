package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {


    public Map<String, String> dataKeyMap(String name, String email, String gender, String status) {
        Map<String, String> data1 = new HashMap<>();

        data1.put("name", name);
        data1.put("email", email);
        data1.put("gender", gender);
        data1.put("status", status);
        return data1;
    }

    public Map<String, Object> expectedDataKeyMap(Object meta, Map<String, String> data) {
        Map<String, Object> data2 = new HashMap<>();

        data2.put("meta", meta);
        data2.put("data", data);

        return data2;


    }
}