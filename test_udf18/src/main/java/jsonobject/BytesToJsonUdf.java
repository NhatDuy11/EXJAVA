package jsonobject;
import java.nio.charset.StandardCharsets;
public class BytesToJsonUdf {

    public String fromBytesToJson(byte[] bytes) {
        // Your conversion logic here
        String json = new String(bytes, StandardCharsets.UTF_8);
        // Bạn nên thêm vào đây một số kiểm tra để đảm bảo chuỗi là một chuỗi JSON hợp lệ
        return json;
    }
}
