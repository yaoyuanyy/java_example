
## ## tutorial1
```$xslt

com.yy.example.mutil_thread.thread.socket.simple.ServerSocketDemo实验时

大坑：
开始我遇到一个问题，服务端收不到客服端的信息，把我气的啊。后来知道了原因：BufferedReader.readLine()与PrintWriter.writer() or print()这是个大坑。
readLine()需要得到换行符出现，而writer() and print()都不没有换行，改成println()立马收到信息了

```

## tutorial2
```$xslt

设计思路：多个客户端向服务端发送消息，服务器可以向多个客户端广播消息

大坑：
reader.readLine()是阻塞方法，会停在while这，所以语句(6)永远不会执行到。
所以receiveFromServer(socket)方法不能放在main线程中
```

## 参考
```aidl
https://www.cnblogs.com/ygj0930/p/5827212.html
```