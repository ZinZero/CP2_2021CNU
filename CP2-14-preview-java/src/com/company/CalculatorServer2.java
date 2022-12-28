package com.company;

import java.net.*;
import java.io.*;
public class CalculatorServer2 implements Runnable{
    ServerSocket serverSocket;
    Thread[] threadArr;
    public static void main(String args[]) {
        CalculatorServer2 calServer = new CalculatorServer2(3);
        calServer.start();
    }
    public CalculatorServer2(int num){
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server is ready");
            System.out.println("Waiting for new connections");
            threadArr = new Thread[3];
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        for (int i = 0; i< threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }
    public void run()
    {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("Accept from the Thread "+Thread.currentThread().getName());

                InputStream in = socket.getInputStream();
                DataInputStream din = new DataInputStream(in);
                String formula = din.readUTF().trim();
                int answer=0;
                String[] operands = formula.split("[+-]");
                if (formula.contains("+"))
                    answer = Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]);
                else if (formula.contains("-"))
                    answer = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
                else
                    answer=0;
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
