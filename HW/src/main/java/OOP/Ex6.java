package OOP;

public class Ex6 {
    import java.sql.SQLException;
import java.sql.Struct;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

    @UdfDescription(name = "structToMap", description = "Converts a Struct to a Map")
    public class StructToMapUdf {

       // @Udf(description = "Converts a Struct to a Map")
        public Map<String, Object> convert(Struct struct) {
            Map<String, Object> map = new HashMap<>();
            try {
                Object[] attrs = struct.getAttributes();
                StructDescriptor desc = struct.getDescriptor();
                int numAttrs = attrs.length;
                for (int i = 0; i < numAttrs; i++) {
                    String attrName = desc.getColumnName(i + 1);
                    Object attrValue = attrs[i];
                    map.put(attrName, attrValue);
                }
                return map;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
