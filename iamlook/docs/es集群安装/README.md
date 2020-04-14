# lrd-streaming

LRD 流式计算模块，目前包括：数据拆分，流式计算

# docker安装elasticsearch集群, 为了支持springboot2.1.5版本 需要安装6.4.3版本, 不推荐docker-compose的方式 API查询会有问题
```
docker pull elasticsearch:6.4.3

创建数据挂在目录，以及配置ElasticSearch集群配置文件，调高JVM线程数限制数量

mkdir -p ES/config
cd  ES
mkdir data1
mkdir data2
mkdir data3
chmod 777 data1 data2 data3

cd ES/config/
firewall-cmd --add-port=9300/tcp
firewall-cmd --add-port=9301/tcp
firewall-cmd --add-port=9302/tcp


vim es1.yml

cluster.name: elasticsearch-cluster
node.name: es-node1
network.bind_host: 0.0.0.0
network.publish_host: 172.16.24.31
http.port: 9200
transport.tcp.port: 9300
http.cors.enabled: true
http.cors.allow-origin: "*"
node.master: true 
node.data: true  
discovery.zen.ping.unicast.hosts: ["172.16.24.31:9300","172.16.24.31:9301","172.16.24.31:9302"]
discovery.zen.minimum_master_nodes: 2



vim es2.yml

cluster.name: elasticsearch-cluster
node.name: es-node2
network.bind_host: 0.0.0.0
network.publish_host: 172.16.24.31
http.port: 9201
transport.tcp.port: 9301
http.cors.enabled: true
http.cors.allow-origin: "*"
node.master: true 
node.data: true  
discovery.zen.ping.unicast.hosts: ["172.16.24.31:9300","172.16.24.31:9301","172.16.24.31:9302"]
discovery.zen.minimum_master_nodes: 2


vim es3.yml

cluster.name: elasticsearch-cluster
node.name: es-node3
network.bind_host: 0.0.0.0
network.publish_host: 172.16.24.31
http.port: 9202
transport.tcp.port: 9302
http.cors.enabled: true
http.cors.allow-origin: "*"
node.master: true 
node.data: true  
discovery.zen.ping.unicast.hosts: ["172.16.24.31:9300","172.16.24.31:9301","172.16.24.31:9302"]
discovery.zen.minimum_master_nodes: 2


vim /etc/sysctl.conf
vm.max_map_count=262144

sysctl -p


docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9200:9200 -p 9300:9300 -v $PWD/es1.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /home/sddt/ES/data1:/usr/share/elasticsearch/data --name ES01 elasticsearch:6.4.3

docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9201:9201 -p 9301:9301 -v $PWD/es2.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /home/sddt/ES/data2:/usr/share/elasticsearch/data --name ES02 elasticsearch:6.4.3
 
docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9202:9202 -p 9302:9302 -v $PWD/es3.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v /home/sddt/ES/data3:/usr/share/elasticsearch/data --name ES03 elasticsearch:6.4.3



```

# elasticsearch-head插件安装 可以使用docker方式安装, 参看官网

```
参照官网：github.com/mobz/elasticsearch-head

install的方式

git clone git://github.com/mobz/elasticsearch-head.git

cd elasticsearch-head

npm install

npm run start


docker的方式

docker pull mobz/elasticsearch-head:5

docker run -p --name eshead 9100:9100 mobz/elasticsearch-head:5

http://127.0.0.1:9100/


```

# 根据自己需求选择创建索引方式 http://127.0.0.1:9200/index_input_feed  这里选择手动创建, postman或者head插件  PUT请求

```json
 
{
    "settings":{
        "number_of_shards":5,
        "number_of_replicas":1
    },
    "mappings":{
        "_doc":{
            "properties":{
                "inputId":{
                    "type":"keyword"
                },
                "upTime":{
                    "type":"long"
                },
                "topicId":{
                    "type":"keyword"
                },
                "calTime":{
                    "type":"long"
                },
                "feedId":{
                    "type":"keyword"
                },
                "prop":{
                    "type":"keyword"
                },
                "upTimeStr":{
                    "type":"date",
                    "format":"yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || epoch_millis"
                },
                "express":{
                    "type":"keyword"
                },
                "calTimeStr":{
                    "type":"date",
                    "format":"yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || epoch_millis"
                },
                "value":{
                    "type":"double"
                }
            }
        }
    }
}

```

# yarn的方式部署flink job
``` 
clean package 打包后，进入到jar目录 
 
sftp root@192.168.188.83

put lrd-flink-jobs-0.1.jar

登录 ssh root@192.168.188.83
运行命令
flink run -c cn.com.larunda.LogToFeedJob lrd-flink-jobs-0.1.jar --port 9000

```