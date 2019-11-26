
kafka启动

./zookeeper-server-start.sh -daemon /home/sddt/kafka/kafka_2.11-2.3.0/config/zookeeper.properties


./kafka-server-start.sh /home/sddt/kafka/kafka_2.11-2.3.0/config/server.properties

后台启动
./bin/kafka-server-start.sh -daemon config/server.properties &

查看topic
./kafka-topics.sh --list --zookeeper localhost:2181

创建topic
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic alert-metrics

发送数据
./kafka-console-producer.sh --broker-list localhost:9092 --topic alert-metrics

接收数据
 ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic flink-sql --from-beginning