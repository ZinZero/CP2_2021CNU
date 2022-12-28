package com.company;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Scanner;

public class snailTest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        char[] inSrc = sc.nextLine().toCharArray();
        char[] outSrc = null;
        int up = sc.nextInt();
        int down = sc.nextInt();

        CharArrayReader input = new CharArrayReader(inSrc);
        CharArrayWriter output = new CharArrayWriter();

        char[] temp1 = new char[up - down]; // 3-1 2
        char[] temp2 = new char[down]; // 1
        int len = 0;
        int len2 = 0;

        try{
            while ((len = input.read(temp1)) > 0){
                output.write(temp1, 0 ,len); // he
                input.mark(down); //he*
                len2 = input.read(temp2);// l

                if (len2 > 0){
                    output.write(temp2, 0, len2);// (he)l
                }
                input.reset();
            }

        }catch (IOException e){ }

        outSrc = output.toCharArray();
        System.out.println(outSrc);
    }
}
