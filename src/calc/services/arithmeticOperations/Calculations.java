package calc.services.arithmeticOperations;

import calc.servicesDao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculations extends Operation {
    List<String> dataList = new ArrayList<>();

    public String split(String dataExpresion) {
        StringTokenizer tokenizer = new StringTokenizer(dataExpresion, delimiters, true);
        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }// делим строку по токенам (всем действиям)
        spaceDeleted();
        priorityOperator(); // выполняем умножение и деление
        operator(); //выполняем сложение и вычитание
        return dataList.get(0); //exit in SplitBrackets
    }

    public void priorityOperator() {
        try {
            for (int i = 0; i < dataList.size() - 1; i++) {
                if (dataList.get(i).equals("*")) {
                    dataList.set(i + 1, multiplication(dataList.get(i - 1), dataList.get(i + 1)));
                    dataList.remove(i);
                    dataList.remove(i - 1);
                    i--;
                } else {
                    if (dataList.get(i).equals("/")) {
                        dataList.set(i + 1, division(dataList.get(i - 1), dataList.get(i + 1)));
                        dataList.remove(i);
                        dataList.remove(i - 1);
                        i--;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("");
        } catch (ArithmeticException e1) {
            System.out.println("деление на ноль");
        }
    }

    public void operator() {
        try {
            for (int i = 0; i < dataList.size() - 1; i++) {
                if (dataList.get(i).equals("+")) {
                    dataList.set(i + 1, addition(dataList.get(i - 1), dataList.get(i + 1)));
                    dataList.remove(i);
                    dataList.remove(i - 1);
                    i--;
                } else {
                    if (dataList.get(i).equals("-")) {
                        dataList.set(i + 1, subtraction(dataList.get(i - 1), dataList.get(i + 1)));
                        dataList.remove(i);
                        dataList.remove(i - 1);
                        i--;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("");
        }
    }

    public void spaceDeleted(){
        for (int i = 0; i < dataList.size() - 1; i++) {
            if (dataList.get(i).equals(" ")){
                dataList.remove(i);
            }
        }
    }
}
