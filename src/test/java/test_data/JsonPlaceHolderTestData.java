package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public  Map<String,Object> getPayLoad(Integer userId,String title,Boolean completed){

        //bazen null göndermek isteyebiliriz onun için hata almamak için wrapper class kullandık yani
        //int yerine Integer yazdık
        Map<String, Object> payLoad = new HashMap<>();
        if (userId != null) {
            payLoad.put("userId", userId);
        }
        if (title != null) {
            payLoad.put("title", title);
        }
        if (completed != null) {
            payLoad.put("completed", completed);
        }
        return payLoad;
    }

    public Map<String, Object> getPayLoad2(Integer userId, String title, Boolean completed) {
        Map<String, Object> payload = new HashMap<>();
        if (userId != null || title != null || completed != null) {
            payload.put("userId", userId);
            payload.put("title", title);
            payload.put("completed", completed);
        }
        return payload;
    }





}


 /*
     Map<String,Object> payLoad= new HashMap<>();
        payLoad.put("userId",21);
        payLoad.put("title","Wash the dishes");
        payLoad.put("completed",false);
     */
