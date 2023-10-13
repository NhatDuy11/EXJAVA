import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.zookeeper.Transaction;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

class MyTransaction {
    public double amount;

    public MyTransaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public  static class TransactionProcessor {

        public static void main(String[] args) {
            Properties props = new Properties();
            props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "172.19.182.0:9021");
            props.put(StreamsConfig.APPLICATION_ID_CONFIG, "transaction-processor");
            StreamsBuilder streamBuilder = new StreamsBuilder();
            KStream<String, MyTransaction> transactionStream = streamBuilder.stream("transactions");
            KTable<Windowed<String>, Double> transactionSumTable = transactionStream
                    .groupByKey(Grouped.with(Serdes.String(), new Serde<MyTransaction>() {
                        @Override
                        public Serializer<MyTransaction> serializer() {
                            return null;
                        }

                        @Override
                        public Deserializer<MyTransaction> deserializer() {
                            return null;
                        }
                    }))
                    .windowedBy(TimeWindows.of(Duration.ofMinutes(5)))
                    .aggregate(
                            () -> 0.0,
                            (key, transaction, aggregate) -> aggregate + transaction.getAmount(),
                            Materialized.as("transaction-sum")
                    );

            // In kết quả vào màn hình console
            transactionSumTable.toStream()
                    .map((key, value) -> new KeyValue<>(key.key(), value))
                    .to("transaction-sum");
            KafkaStreams streams = new KafkaStreams(streamBuilder.build(), props);
            streams.start();

        }
    }
}
