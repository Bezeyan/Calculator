package calc.services.checks;

import calc.servicesDao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckMoreThanTenAndNumberOfTermsIsParentheses {

    List<String> dataList = new ArrayList();

    public void check(String dataExpresion) {

        StringTokenizer tokenizer = new StringTokenizer(dataExpresion, new Operation().getAllOperators(), false);

        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }

        for (String number : dataList) {
            if ((Integer.parseInt(number) > 10) || (Integer.parseInt(number) < 1)){

                throw new NumberFormatException();
            }
        }

        if (dataList.size() != 2){
            throw new NumberFormatException();
        }

        if (dataExpresion.contains("(") || dataExpresion.contains(")")){
            throw new NumberFormatException();
        }

    }
}
