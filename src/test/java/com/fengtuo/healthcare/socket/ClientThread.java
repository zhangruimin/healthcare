package com.fengtuo.healthcare.socket;

import com.fengtuo.healthcare.builder.PacketStreamBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

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
                os.write(new PacketStreamBuilder().build());
                os.flush();
                socket.shutdownOutput();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
