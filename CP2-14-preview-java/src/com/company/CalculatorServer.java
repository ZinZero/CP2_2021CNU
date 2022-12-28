package com.company;

import java.net.*;
import java.io.*;
public class CalculatorServer {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server is ready");
            System.out.println("Waiting for new connections");
            socket = serverSocket.accept();
            System.out.println("connection from "+socket.getInetAddress());
        } catch(IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                InputStream in = socket.getInputStream();
                DataInputStream din = new DataInputStream(in);
                String[] operands = din.readUTF().trim().split("\\+");
                int answer = Integer.parseInt(operands[0])+ Integer.parseInt(operands[1]);

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeInt(answer);
                System.out.println("Answer transferred");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
