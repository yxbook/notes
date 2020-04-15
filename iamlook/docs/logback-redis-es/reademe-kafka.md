https://www.cnblogs.com/bigben0123/p/10613257.html


input {
  kafka {
    bootstrap_servers => ["172.16.24.52:9092"]
    topics => ["topic-test"]
    codec => "json"
  }
}
output {
 # 放开if过滤INFO日志
 if [level] != "INFO" {
    elasticsearch {
      hosts => "172.16.24.31:9200"
      index => "micro-kafka-log-%{+YYYY-MM}"
    }
    #注释输入到控制台
    stdout{}
  }
}
