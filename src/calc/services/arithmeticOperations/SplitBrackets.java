package calc.services.arithmeticOperations;

import calc.servicesDao.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SplitBrackets  {
    List<String> dataList = new ArrayList<>();

    public String splitBrackets(String dataExpresion) {
        StringTokenizer tokenizer = new StringTokenizer
                (dataExpresion, new Operation().getSuperPriorityOperators(), true);
        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }// делим строку на токены по скобкам

        try {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).equals(")")) {
                    dataList.set(i - 1, new Calculations().split(dataList.get(i - 1)));
                    dataList.remove(i);
                    dataList.remove(i - 2);
                } // выражение между скобками отправляем на расчет
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("не хватает скобок");
            throw new NumberFormatException();
        }

        String outPut = "";
        for (String s : dataList) {
            outPut += s;  //получаем строку без скобок
        }
        return new Calculations().split(outPut);
    }
}

