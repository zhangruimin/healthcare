package com.fengtuo.healthcare.socket;

import com.fengtuo.healthcare.service.PacketService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        PacketService packetService = new PacketService();
        ServerSocket serverSocket = new ServerSocket(5678);
        while (true){
            Socket accept = serverSocket.accept();
            ReceiverThread receiver = new ReceiverThread(accept, packetService);
            new Thread(receiver).start();
        }
    }
}
