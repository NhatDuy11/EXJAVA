package jsonobject;
import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;

public class BytesToStringJsonConverter {
    public static String bytestoString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
    public static <T> T jsonStringToObject(String jsonString, Class<T> objectClass) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, objectClass);
    }
    public static void main(String[] args) {
        // tạo một bảng byte tương ứng với chuỗi JSON
        byte[] bytes ="{\"key\":\"value\" }".getBytes(StandardCharsets.UTF_8);
        // chuyển đổi mảng byte thành chuỗi
        String jsonString = BytesToStringJsonConverter.bytestoString(bytes);
        System.out.println(jsonString);

        // chuyển đổi JSON thành đối tượng person
        Person person = BytesToStringJsonConverter.jsonStringToObject(jsonString,Person.class);
        System.out.println("Name: " + person.getName());

    }
}
  class Person {
      private String name;
      private int age;


      public String getName() {
          return this.name;
      }
      public void setName(String name) {
          this.name = name;
      }
  }

