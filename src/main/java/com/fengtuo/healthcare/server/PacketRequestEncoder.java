package com.fengtuo.healthcare.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/4/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketRequestEncoder extends ProtocolEncoderAdapter {
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
    }
}
