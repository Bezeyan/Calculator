package calc.services.anotherNumberSystem;

import calc.servicesDao.Numbers;
import calc.servicesDao.Operation;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RomanInArabic {

    List<String> dataList = new ArrayList();
    String result = "";

    public String inArabic(String dataExpresion) {

        StringTokenizer tokenizer = new StringTokenizer(dataExpresion, new Operation().getAllOperators(), true);

        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());// делим по токенам
        }
        boolean isTrue = false;
        int prev = 0;
        int newNumber = 0;

        for (int i = 0; i < dataList.size(); i++) {
            for (int j = dataList.get(i).length(); j > 0; j--) {
                for (String number : new Numbers().getDataRomeNumber()) {

                    if (dataList.get(i).charAt(j - 1) == number.charAt(0)) {
                        isTrue = true;
                        if (prev <= Integer.parseInt(number.substring(1))) {
                            newNumber += Integer.parseInt(number.substring(1));
                            prev = Integer.parseInt(number.substring(1));

                        } else {
                            newNumber -= Integer.parseInt(number.substring(1));
                        }
                    }
                }
            }

            if (isTrue) {
                dataList.set(i, Integer.toString(newNumber));
                isTrue = false;
                newNumber = 0;
                prev = 0;
            }
        }// переводим римские числа в арабские, чтобы отличать
        // IV от VI сравнивает предыдущую цифру с последующей


        for (String s : dataList) {
            result += s;
        }
        return result;
    }
}

