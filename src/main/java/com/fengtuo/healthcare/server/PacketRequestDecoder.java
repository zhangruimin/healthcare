package com.fengtuo.healthcare.server;

import com.fengtuo.healthcare.extractor.HealthRecordExtractor;
import com.fengtuo.healthcare.util.NumUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/4/13
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketRequestDecoder extends CumulativeProtocolDecoder {

    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        byte[] buffer = new byte[in.remaining()];
        in.get(buffer);
        StringBuffer sb = new StringBuffer();
        for (byte b : buffer) {
            sb.append(String.format("%x",NumUtils.toInt(b))).append(",");
        }
        sb.deleteCharAt(sb.length()-1).append("-----");
        System.out.println(sb.toString());
        out.write(HealthRecordExtractor.extract(buffer));
        return true;
    }
}