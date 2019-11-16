#一、安装JAVA JDK
1、下载安装包
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
注意：根据32/64位操作系统下载对应的安装包
2、添加系统变量：JAVA_HOME=C:\Program Files (x86)\Java\jdk1.8.0_144

#二、安装ZooKeeper
1、 下载安装包
http://zookeeper.apache.org/releases.html#download
2、 解压并进入ZooKeeper目录，笔者：D:\Kafka\zk\conf
3、 将“zoo_sample.cfg”重命名为“zoo.cfg”
4、 打开“zoo.cfg”找到并编辑dataDir=D:\\Kafka\zk\\tmp
5、 添加系统变量：ZOOKEEPER_HOME=D:\Kafka\zk
6、 编辑path系统变量，添加路径：%ZOOKEEPER_HOME%\bin
7、 在zoo.cfg文件中修改默认的Zookeeper端口（默认端口2181）
8、 打开新的cmd，输入“zkServer“，运行Zookeeper
9、 命令行提示如下：说明本地Zookeeper启动成功

#三、安装Kafka
1、 下载安装包
http://kafka.apache.org/downloads
注意要下载二进制版本
2、 解压并进入Kafka目录，笔者：D:\software\kafka
3、 进入config目录找到文件server.properties并打开
4、 找到并编辑log.dirs=D:\software\logs
5、 找到并编辑zookeeper.connect=localhost:2181
6、 Kafka会按照默认，在9092端口上运行，并连接zookeeper的默认端口：2181
7、 进入Kafka安装目录D:\software\kafka，按下Shift+右键，选择“打开命令窗口”选项，打开命令行，输入：
.\bin\windows\kafka-server-start.bat .\config\server.properties

#四、测试
 zookeeper-server-start.bat ..\..\config\zookeeper.properties
 kafka-server-start.bat ..\..\config\server.properties
 
1、 创建主题，进入Kafka安装目录D:\Kafka\kafka_2.12-0.11.0.0，按下Shift+右键，选择“打开命令窗口”选项，打开命令行，输入：
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test0811
2、 创建生产者，进入Kafka安装目录D:\Kafka\kafka_2.12-0.11.0.0，按下Shift+右键，选择“打开命令窗口”选项，打开命令行，输入：
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test0811
3、 创建消费者，进入Kafka安装目录D:\Kafka\kafka_2.12-0.11.0.0，按下Shift+右键，选择“打开命令窗口”选项，打开命令行，输入：
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test0811 --from-beginning
