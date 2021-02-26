package com.fh.jedis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LubanSocket {

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public LubanSocket(String ip,int port){
        try {
            this.socket = new Socket(ip,port);
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String string){
        try {
            outputStream.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){
        byte[] bytes = new byte[1024];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
