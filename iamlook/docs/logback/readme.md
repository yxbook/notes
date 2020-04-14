

# ELK

```
docker pull logstash:6.4.3


创建容器
docker run --rm -di --name logstash logstash:6.4.3

# 创建用于存放配置的目录
mkdir -p logstash
# 复制配置文件，冒号前面为容器ID
docker cp logstash:/usr/share/logstash/config /home/redis1/logstash/config/
# 复制logstash管道文件
docker cp logstash:/usr/share/logstash/pipeline /home/redis1/logstash/pipeline/
#重新创建容器，并挂载上面两个文件夹
# 停止原有容器，否则无法删除
docker stop logstash
# 删除原有容器，使用容器ID删除
docker rm logstash
#进入/home/sddt/logstash/config
vim logstash.yml  修改对应es地址

#进入/home/sddt/logstash/pipeline  
vim logstash.yml 替换如下内容修改正确的信息

input {
    redis {
        data_type => "list" #logstash redis插件工作方式
        key => "logstash" #监听的键值
        host => "192.168.188.91" #redis地址
        codec => "json"
        port => 26380 #redis端口号
        type => "redis-cluster-input"
    }
}
output {
  elasticsearch {
    hosts => "172.16.24.31:9200"
    index => "system-log-%{+YYYY.MM.dd}"
  }

 stdout{}
}

# 创建新容器并挂载目录
docker run -di --name=logstash -v /home/sddt/logstash/config:/usr/share/logstash/config -v /home/sddt/logstash/pipeline:/usr/share/logstash/pipeline logstash:6.4.3

docker run -di --name=logstash -v /home/redis1/logstash/config:/usr/share/logstash/config -v /home/redis1/logstash/pipeline:/usr/share/logstash/pipeline logstash:6.4.3



#docker exec -it logstash /bin/bash



#安装kibana
docker pull kibana:6.4.3
docker run -d --name kibana -p 5601:5601 kibana:6.4.3
# 创建存放配置文件的目录
mkdir -p kibana
# 复制
docker cp kibana:/usr/share/kibana/config /home/redis1/kibana/config

重新创建容器，并挂载配置文件目录
# 停止原有容器
docker stop kibana
# 删除原有容器
docker rm kibana
# 创建新容器
docker run -di --name=kibana -p 5601:5601 -v /home/redis1/kibana/config:/usr/share/kibana/config kibana:6.4.3

# 修改kibana配置文件
vim kibana/config/kibana.yml

server.name: kibana
# 允许所有地址访问
server.host: "0.0.0.0"
# elasticsearch的地址
elasticsearch.url: http://192.168.136.104:9200
xpack.monitoring.ui.container.elasticsearch.enabled: true



```



1、pom.xml文件加入依赖

<!--logback-redis-->
<dependency>
    <groupId>com.cwbase</groupId>
    <artifactId>logback-redis-appender</artifactId>
    <version>1.1.6</version>
</dependency>

2、将文件logback-spring.xml拷贝到resource目录