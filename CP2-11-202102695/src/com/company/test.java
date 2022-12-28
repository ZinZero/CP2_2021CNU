package com.company;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] inSrc = sc.nextLine().toCharArray();
        char[] outSrc1 = null;
        char[] outSrc2 = null;

        CharArrayReader input = new CharArrayReader(inSrc);
        CharArrayWriter output1 = new CharArrayWriter();
        CharArrayWriter output2 = new CharArrayWriter();

        // You may need some more variables
        char[] temp = new char[1];
        int len = 0;

        try {
            while (true) {
                // Solve the problem here

                if ((len = input.read(temp)) > 0){
                    if (65 <= temp[0] && temp[0] <= 90){
                        output1.write(temp, 0, len);
                    }else if (97 <= temp[0] && temp[0] <= 122){
                        output2.write(temp, 0, len);
                    }
                }else {
                    break;
                }
            }
        } catch (IOException e) {   }

        outSrc1 = output1.toCharArray();
        outSrc2 = output2.toCharArray();

        System.out.println(outSrc1);
        System.out.println(outSrc2);
    }
}

//HwEoLrLlOd
