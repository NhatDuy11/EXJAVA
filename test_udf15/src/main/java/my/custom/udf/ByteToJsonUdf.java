    package my.custom.udf;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import io.confluent.ksql.function.udf.Udf;
    import io.confluent.ksql.function.udf.UdfDescription;
    import io.confluent.ksql.function.udf.UdfParameter;
    
    @UdfDescription(name = "as_json", description = "Convert bytes to JSON")
    public class ByteToJsonUdf {
        @Udf(description = "Converts bytes to JSON")
        public String asJson(@UdfParameter(value = "input", description = "bytes to convert") final byte[] input) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Object jsonObject = objectMapper.readValue(input, Object.class);
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert bytes to JSON", e);
            }
        }
    
    }
