package com.fengtuo.healthcare.server;

import com.fengtuo.healthcare.repository.PacketRepository;
import com.fengtuo.healthcare.socket.SocketServerSpringConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinaServer {
    public static final int PORT = 5001;
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SocketServerSpringConfig.class);

        PacketRepository packetRepository =
                (PacketRepository) ctx.getBean("packetRepository");

        PacketHandler handler = new PacketHandler(packetRepository);
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new PacketCodecFactory()));
        acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
        acceptor.setHandler(handler);
        acceptor.bind();
        System.out.println("server is listening at port " + PORT);
    }
}
