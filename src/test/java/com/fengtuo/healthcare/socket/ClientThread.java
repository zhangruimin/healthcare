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
    private static final int LOOP_NUM = 10;
    public ClientThread() {
    }

    @Override
    public void run() {
        for (int i = 0; i < LOOP_NUM; i++)
            try {
                Socket socket = new Socket("localhost", 5678);
                OutputStream os = socket.getOutputStream();
                os.write(new PacketStreamBuilder().build());
                os.flush();
                socket.shutdownOutput();
                os.close();
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
