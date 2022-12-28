package com.company;


import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zipper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] inSrc = sc.nextLine().toCharArray();
        char[] outSrc = null;

        // Solve the problem here.
        // You may need some variables.

        CharArrayReader input = new CharArrayReader(inSrc);
        CharArrayWriter output = new CharArrayWriter();

        try{

            while (){
                input.read();
                

            }
            outSrc = output.toCharArray();

        }catch (IOException e){

        }

        System.out.println(outSrc);
    }
}


















// 대문자 65 90 소문자 97 122


//민수는 겨울을 맞아 롱패딩을 사러 어느 옷 가게에 들렀다.
//그런데 가게는 이미 많은 손님들로 붐벼서 그가 피팅룸을 사용할 차례가 오기까지 오랜 시간이 걸렸다.
//이후 그는 자신에게 맞는 사이즈가 딱 하나 남은 패팅을 골라 입어보려고 했다.
//
//그러나 그 패팅은 이전의 손님들이 험하게 다뤄서인지 지퍼가 엉망으로 채워져있었다.
//때문에 그는 지퍼를 풀고 다시 올바르게 채우느라 고생해야 했다.
//
//이 지퍼에는 이빨마다 알파벳이 아주 작게 새겨져있는데, 한 쪽에는 대문자, 반대쪽에는 소문자로 새겨져있었다.
//따라서 대소문자가 번갈아 나오는 것으로 지퍼가 올바르게 맞물린 것을 확인할 수 있으며,
//그렇지 않다면 그 부분을 풀어서 다시 채워야 했다.
//
//이처럼 잘못 채워진 지퍼가 주어질 때, 이를 다시 올바르게 채워보자.

//문제 풀이 시 주의사항
//바르게 채워진 지퍼는 항상 대문자가 먼저 나온다.
//또한 올바른 지퍼는 대소문자의 갯수가 서로 같다. 따라서 어느 쪽이든 남는 알파벳이 생기면 이를 버린다.

//AaaaAAaaAAAAAaa 입력
//AaAaAaAaAaAaAa 출력
