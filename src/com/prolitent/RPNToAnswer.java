package com.prolitent;

import java.util.LinkedList;
import java.util.Stack;

public class RPNToAnswer {
    char[] integerList = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    char[] operaterList = new char[]{'(',')','*','/','+','-','^' };
    LinkedList<String> rpnSum;
    float finalAnswer;

    public RPNToAnswer(LinkedList<String> rpnSum){
        this.rpnSum = rpnSum;
        Stack<String> calculater = new Stack<String>();
        float currentAnswer;
        int i = 0;
        while(i < rpnSum.size()){
            String currentList = this.rpnSum.get(i);
            char currentValue = currentList.charAt(0);
            String currentListString = String.valueOf(currentList);
            boolean operaterAnswer = this.LinearSearchOperaterList(currentValue);
            if(!operaterAnswer){
                calculater.push(currentListString);
                i = i +1;
            }
            else{
                float value2 = Float.parseFloat(calculater.pop());
                float value1 = Float.parseFloat(calculater.pop());
                if (currentListString.equals("+")){
                    currentAnswer = value1 + value2;
                    calculater.push(Float.toString(currentAnswer));
                }
                else if (currentListString.equals("-")){
                    currentAnswer = value1 - value2;
                    calculater.push(Float.toString(currentAnswer));
                }
                else if (currentListString.equals("*")){
                    currentAnswer = value1 * value2;
                    calculater.push(Float.toString(currentAnswer));
                }
                else if (currentListString.equals("/")){
                    currentAnswer = value1 / value2;
                    calculater.push(Float.toString(currentAnswer));
                }
                else if (currentListString.equals("^")){
                    currentAnswer = (int) Math.pow(value1, value2);
                    calculater.push(Float.toString(currentAnswer));
                }
                i = i+1;
            }
        }
        this.finalAnswer = Float.parseFloat(calculater.pop());
        System.out.println(this.finalAnswer);


    }
        public boolean LinearSearchOperaterList(char element){
            for (char c : operaterList) {
                if(element == c) {
                    return true;
                }
            }
            return false;
        }

        public boolean LinearSearchIntegerList(char element){
            for (char c : integerList) {
                if(element == c) {
                    return true;
                }
            }
            return false;
        }
}
