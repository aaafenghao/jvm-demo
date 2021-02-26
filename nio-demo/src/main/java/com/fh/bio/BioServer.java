package com.fh.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    ServerSocket serverSocket;

    public BioServer(){
        try {
            serverSocket = new ServerSocket(9999);
            while (true){
                Socket accept = serverSocket.accept();//没有客户端连接的时候,阻塞的时候
//                accept.getInputStream().read();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){

    }

    public static void main(String[] args) {
        new BioServer();
    }
}
