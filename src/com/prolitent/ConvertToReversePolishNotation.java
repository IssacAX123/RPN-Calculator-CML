package com.prolitent;

import java.util.HashMap;
import java.util.Stack;
import java.util.LinkedList;

public class ConvertToReversePolishNotation {
    LinkedList<String> sum;
    char[] integerList = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    char[] operaterList = new char[]{'(',')','*','/','+','-','^' };
    Stack<String> operaterStack = new Stack();
    LinkedList<String> postfix = new LinkedList<>();
    HashMap<Integer, String> bidmas =  new HashMap<Integer, String>();

    public ConvertToReversePolishNotation(LinkedList<String> sum){
        this.sum = sum;
        bidmas.put(1,"(");
        bidmas.put(2,"-");
        bidmas.put(3,"+");
        bidmas.put(4,"/");
        bidmas.put(5,"*");
        bidmas.put(6,"^");

        int i = 0;
        while(i < sum.size()){
            String currentList = this.sum.get(i);
            char currentValue = currentList.charAt(0);
            String currentListString = String.valueOf(currentList);
            boolean operaterAnswer = this.LinearSearchOperaterList(currentValue);
            if(operaterAnswer){
                if(currentValue==')'){
                    while (!operaterStack.isEmpty()){
                        String poppedValue = operaterStack.pop();
                        if (!poppedValue.equals("(")){
                            postfix.add(poppedValue);
                            i = i + 1;
                        }
                    }
                }
                else{
                    operaterStack.push(currentList);
                    i = i + 1;
                }
            }
            else{
                postfix.add(currentList);
                i = i + 1;
            }
        }

        while (!operaterStack.isEmpty()){
            String poppedValue = operaterStack.pop();
            if (!poppedValue.equals("(")){
                postfix.add(poppedValue);
            }
        }
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

    public LinkedList<String> GetList(){
        return this.postfix;
    }


}
