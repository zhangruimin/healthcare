package com.fengtuo.healthcare.socket;

import com.fengtuo.healthcare.builder.PacketStreamBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientThread implements Runnable {
    private static final int LOOP_NUM = 10000;

    public ClientThread() {
    }

    @Override
    public void run() {
        Socket socket = null;
        OutputStream os = null;
        for (int i = 0; i < LOOP_NUM; i++)
            try {
                socket = new Socket("localhost", 5001);
                os = socket.getOutputStream();
                byte[] stream ={(byte)0xA0,(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x04,(byte)0x0D,(byte)0x03,(byte)0x18,(byte)0x0D,(byte)0x35,(byte)0x39,(byte)0xA2,(byte)0x00,(byte)0xCD,(byte)0x33,(byte)0x07,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x95,(byte)0xB7,(byte)0xCD,(byte)0xCD,(byte)0xC0,(byte)0xA3,(byte)0x66,(byte)0x52,(byte)0x51,(byte)0x59,(byte)0x61,(byte)0x65,(byte)0x6A,(byte)0x6D,(byte)0x70,(byte)0x72,(byte)0x73,(byte)0x75,(byte)0x76,(byte)0x77,(byte)0x77,(byte)0x78,(byte)0x78,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x7A,(byte)0x7B,(byte)0x7C,(byte)0x7D,(byte)0x80,(byte)0x81,(byte)0x82,(byte)0x83,(byte)0x84,(byte)0x85,(byte)0x86,(byte)0x86,(byte)0x87,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x87,(byte)0x86,(byte)0x85,(byte)0x83,(byte)0x7E,(byte)0x7B,(byte)0x77,(byte)0x75,(byte)0x74,(byte)0x73,(byte)0x72,(byte)0x72,(byte)0x73,(byte)0x73,(byte)0x73,(byte)0x74,(byte)0x74,(byte)0x75,(byte)0x75,(byte)0x75,(byte)0x76,(byte)0x76,(byte)0x77,(byte)0x77,(byte)0x77,(byte)0x77,(byte)0x77,(byte)0x78,(byte)0x78,(byte)0x78,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x79,(byte)0x7A,(byte)0x7A,(byte)0x7A,(byte)0x7A,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x7B,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xBC,(byte)0xBA,(byte)0xB8,(byte)0xB6,(byte)0xB4,(byte)0xB2,(byte)0x28,(byte)0x2A,(byte)0x2C,(byte)0x2E,(byte)0x65};
                os.write(new PacketStreamBuilder().withTimestamp(new Date()).build());
                os.write(stream);
                os.flush();
                socket.shutdownOutput();
                Thread.sleep(1000);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
