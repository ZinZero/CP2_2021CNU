package com.company;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.net.*;

public class CalculatorClient {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        try {
            Socket socket = new Socket("localhost", 7777);
            System.out.println("Connected");
            while(true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    OutputStream out = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(out);
                    dos.writeUTF(scanner.nextLine());

                    InputStream in = socket.getInputStream();
                    DataInputStream din = new DataInputStream(in);
                    System.out.println("Answer (from server): " + din.readInt());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
