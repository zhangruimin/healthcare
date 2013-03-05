package com.fengtuo.healthcare.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/4/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketCodecFactory implements ProtocolCodecFactory {
    private ProtocolEncoder encoder;
    private ProtocolDecoder decoder;

    public PacketCodecFactory() {
        decoder = new PacketRequestDecoder();

        encoder = new PacketRequestEncoder();
    }

    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return encoder;
    }

    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return decoder;
    }
}
