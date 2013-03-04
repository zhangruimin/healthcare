package com.fengtuo.healthcare.server;

import com.fengtuo.healthcare.model.Packet;
import com.fengtuo.healthcare.repository.PacketRepository;
import com.fengtuo.healthcare.service.PacketService;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/4/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketHandler extends IoHandlerAdapter {
    private PacketRepository packetRepository;

    public PacketHandler(PacketRepository packetRepository) {
        this.packetRepository = packetRepository;
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Packet packet = (Packet) message;
        System.out.println(packet.getWaveRecords().size());
        packetRepository.save(packet);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }
}
