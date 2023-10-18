package pojos.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)// aşagıdaki datalar haricinde gelen butun degerleri görmezden gel demiş oluyoruz bunu yaparak


public class JsonPlaceHolderPojo {

    // 1. Private variable'lar oluştur
    private Integer userId;
    private String title;
    private Boolean completed;

    // 2. Parametreli ve parametresiz constructor'ları oluştur
    public JsonPlaceHolderPojo() {
    }
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    // 3. public getter ve setter metotlarını oluştur
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4. toString() metodunu oluştur
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}


/*
 {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }

           bu dataya göre bir method oluşturuyoz
 */
