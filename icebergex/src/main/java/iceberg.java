import org.apache.hadoop.conf.Configuration;
import org.apache.iceberg.Schema;
import org.apache.iceberg.PartitionSpec;
import org.apache.iceberg.Table;
import org.apache.iceberg.catalog.TableIdentifier;
import org.apache.iceberg.hadoop.HadoopCatalog;
import org.apache.iceberg.types.Types;

public class iceberg {
    public static void main(String[] args) {

        String warehouseLocation = "/wsl.localhost/Ubuntu/home/nhatduy/warehouse";


        String tableLocation = warehouseLocation + "/my_table";


        Schema schema = new Schema(
                Types.NestedField.required(1, "id", Types.IntegerType.get()),
                Types.NestedField.required(2, "name", Types.StringType.get())
        );


        PartitionSpec spec = PartitionSpec.builderFor(schema).build();

        Configuration conf = new Configuration();
        HadoopCatalog catalog = new HadoopCatalog(conf, warehouseLocation);
        TableIdentifier name = TableIdentifier.of("my_logging", "logs");


        if (catalog.tableExists(name)) {
            System.out.println("Bảng Iceberg đã tồn tại.");
        } else {
            Table table = catalog.createTable(name, schema, spec);
            System.out.println("Bảng Iceberg đã được tạo tại: " + tableLocation);
        }
    }
}