#### 
运行kafka相关代码需要提前电脑安装kafka

- Mac下安装Kafka

安装
```
brew install kafka
可能会提示brew cask install java

中途会被安装zookeeper
```

修改server.properties
```
vim /usr/local/etc/kafka/server.properties
增加一行配置
listeners=PLAINTEXT://localhost:9092
```

首先我们启动zookeeper
```
zkserver start
```

启动kafka server
```
cd /usr/local/Cellar/kafka/0.10.1.0/bin
./kafka-server-start /usr/local/etc/kafka/server.properties
```

参考：
https://my.oschina.net/kakoi/blog/1335256
