package com.yy.example.java.io.netty;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-05-24 at 11:55
 */
public class TimeClient {

    public void connect (int port, String host) {
//        try(EventLoopGroup group = new NioEventLoopGroup()) {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            // todo
//                            ch.pipeline().addLast(new TimeClientHandler());
//                        }
//                    });
//            ChannelFuture f = b.connect(host, port).sync();
//            f.channel().closeFuture().sync();
//        }catch (Exception e) {}
    }

    public static void main(String[] args) {
        int port = 8088;
        new TimeClient().connect(port, "127.0.0.1");
    }
}
