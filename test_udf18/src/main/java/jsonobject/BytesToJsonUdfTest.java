package jsonobject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.charset.StandardCharsets;

public class BytesToJsonUdfTest {
    @Test
    public void testFromBytesToJson() {
        BytesToJsonUdf udf = new BytesToJsonUdf();

        String json = "{\"VALUE\": \"\\u0000\\u0000\\u0000\\u0000\\u0004<row id=\\\"82619\\\">\\n  <c1>111803</c1>\\n  <c2>3101</c2>\\n  <c3>Small Business Loan</c3>\\n  <c5>Mark Howard</c5>\\n  <c7>TR</c7>\\n  <c8>USD</c8>\\n  <c9>1</c9>\\n  <c11>28</c11>\\n  <c12>29</c12>\\n  <c23>-200</c23>\\n  <c24>-200</c24>\\n  <c25>-200</c25>\\n  <c26>-200</c26>\\n  <c27>-200</c27>\\n  <c40>20170327</c40>\\n  <c41>-200</c41>\\n  <c42>813</c42>\\n  <c46>20170331</c46>\\n  <c76>NO</c76>\\n  <c78>20170327</c78>\\n  <c85>3101</c85>\\n  <c93>USD</c93>\\n  <c94>1</c94>\\n  <c95>USD</c95>\\n  <c96>1</c96>\\n  <c99>LEGACY</c99>\\n  <c99 m=\\\"2\\\">T24.IBAN</c99>\\n  <c99 m=\\\"3\\\">PREV.IBAN</c99>\\n  <c100 m=\\\"2\\\"/>\\n  <c108>NO</c108>\\n  <c142>Y</c142>\\n  <c167>20170327</c167>\\n  <c181>AA17086H5XP1</c181>\\n  <c214>1</c214>\\n  <c215>21938_OFFICER__OFS_SEAT_AAACT170867Z5YCG8V</c215>\\n  <c216>1705141009</c216>\\n  <c217>21938_OFFICER_OFS_SEAT_AAACT170867Z5YCG8V</c217>\\n  <c218>GB0010001</c218>\\n  <c219>1</c219>\\n</row>\\n\"}";
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

        String result = udf.fromBytesToJson(bytes);

        assertEquals(json, result);
    }

    @Test
    public void testFromBytesToJsonWithInvalidInput() {
        BytesToJsonUdf udf = new BytesToJsonUdf();

        byte[] bytes = "invalid".getBytes(StandardCharsets.UTF_8);

        assertThrows(RuntimeException.class, () -> udf.fromBytesToJson(bytes));
    }

}
