package calc.services.checks;

import calc.servicesDao.Numbers;
import calc.servicesDao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckCorrect {
    List<String> dataList = new ArrayList();

    public void check(String dataExpresion) {

        StringTokenizer tokenizer = new StringTokenizer
                (dataExpresion, new Operation().allOperators, false);

        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }

        List<String> romeNumbers = new Numbers().getRomeNumber();
        boolean flag = false;

        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < romeNumbers.size(); j++) {
                if (dataList.get(i).equals(romeNumbers.get(j))){

                    flag = true;
                }
            }
            if (!flag){
                throw new NumberFormatException();
            }
            flag = false;
        }
    }
}
