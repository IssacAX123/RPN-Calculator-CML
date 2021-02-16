package com.prolitent;

import java.util.LinkedList;

public class GetIntegers {
    String sum;
    char[] integerList = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    char[] operaterList = new char[]{'(',')','*','/','+','-','^' };
    LinkedList<String> sumArray = new LinkedList<>();

    public GetIntegers(String sum){
        this.sum = sum;
        int totalSize = this.LinearSearchOperaterSize(this.sum);

        int i = 0;
        while(i < sum.length()){
            char currentValue = this.sum.charAt(i);
            String currentValueString = String.valueOf(currentValue);
            boolean operaterAnswer = this.LinearSearchOperaterList(currentValue);
            if(operaterAnswer){
                sumArray.add(currentValueString);
                i = i + 1;
            }
            else{
                if (sumArray.size() != 0){
                    String previousValue = sumArray.getLast();
                    char checkChar = previousValue.charAt(0);
                    String previousValueString = String.valueOf(previousValue);
                    boolean operaterAnswerSecond = this.LinearSearchOperaterList(checkChar);
                    if (operaterAnswerSecond){
                        sumArray.add(currentValueString);
                    }
                    else{
                        String digits = previousValueString+currentValueString;
                        int index = sumArray.indexOf(previousValueString);
                        sumArray.set(index, digits);
                    }
                    i = i + 1;
                }
                else{
                    sumArray.add(currentValueString);
                    i = i + 1;
                }

            }
        }
    }

    public boolean LinearSearchIntegerList(char element){
        for (char c : integerList) {
            if(element == c) {
                return true;
            }
        }
        return false;
    }

    public boolean LinearSearchOperaterList(char element){
        for (char c : operaterList) {
            if(element == c) {
                return true;
            }
        }
        return false;
    }

    public int LinearSearchOperaterSize(String sum){
        int totalSize = 0;
        for (int x = 0; x < sum.length(); x = x + 1) {
            char currentValue = this.sum.charAt(x);
            for (char c : operaterList) {
                if(currentValue == c){
                    totalSize = totalSize + 1;
                }
            }
        }
        return totalSize*2;
    }

    public LinkedList<String> GetList(){
        return this.sumArray;
    }


}
