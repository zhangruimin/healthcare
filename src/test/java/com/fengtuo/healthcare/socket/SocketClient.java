package com.fengtuo.healthcare.socket;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocketClient {
    private static final int THREAD_NUM = 1;

    public static void main(String[] args) throws Exception {
       for(int i = 0; i<THREAD_NUM;i++){
           new Thread( new ClientThread()).start();
       }
    }
}
