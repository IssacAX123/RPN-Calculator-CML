package com.prolitent;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sumScan = new Scanner(System.in);
        String sum;
        System.out.print("Enter your sum: ");
        sum = sumScan.nextLine();
        System.out.println(sum);
        GetIntegers GetInteger  = new GetIntegers(sum);
        LinkedList<String> sumList = GetInteger.GetList();
        ConvertToReversePolishNotation ConvertToReversePolishNotation = new ConvertToReversePolishNotation(sumList);
        LinkedList<String> rpnList = ConvertToReversePolishNotation.GetList();
        RPNToAnswer RPNToAnswer = new RPNToAnswer(rpnList);
    }
}
