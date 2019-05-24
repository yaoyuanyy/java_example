package com.yy.example.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description: netty 服务器端
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-05-24 at 10:33
 */
public class TimeServer {

    public void bind(int port) throws InterruptedException {
        try (EventLoopGroup bossgGroup = new NioEventLoopGroup(); EventLoopGroup workerGroup = new NioEventLoopGroup();) {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossgGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8088;
        new TimeServer().bind(port);
    }

    private class ChildChannelHandler extends ChannelInitializer {

        @Override
        protected void initChannel(Channel channel) throws Exception {
            //
            channel.pipeline().addLast(new TimeServerHandler());
        }
    }


}
