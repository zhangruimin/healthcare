package com.fengtuo.healthcare.socket;

import com.fengtuo.healthcare.service.PacketService;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiverThread implements Runnable {
    private Socket socket;
    private PacketService packetService;

    public ReceiverThread(Socket socket, PacketService packetService) {
        this.socket = socket;
        this.packetService = packetService;
    }

    @Override
    public void run() {
        Date previousTime = new Date();
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while (true) {
                Date currentTime = new Date();
                if(currentTime.getTime()-previousTime.getTime() > 1000 * 10){
                    break;
                }
                byte[] resultBuff = new byte[0];
                byte[] buff = new byte[1024];
                int k = -1;
                while ((k = inputStream.read(buff, 0, buff.length)) > -1) {
                    byte[] newBuff = new byte[resultBuff.length + k];
                    System.arraycopy(resultBuff, 0, newBuff, 0, resultBuff.length);
                    System.arraycopy(buff, 0, newBuff, resultBuff.length, k);
                    resultBuff = newBuff;
                }
                if (resultBuff.length > 0) {
                    previousTime = currentTime;
                    StringBuffer sb = new StringBuffer();
                    for (byte b : resultBuff) {
                        sb.append(b).append(",");
                    }
                    sb.deleteCharAt(sb.length()-1).append("-----");
                    System.out.println(sb.toString());
                    packetService.savePacket(resultBuff);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
