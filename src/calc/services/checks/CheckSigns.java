package calc.services.checks;

import calc.servicesDao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckSigns {
    List<String> dataList = new ArrayList();

    public void check(String dataExpresion) {

        StringTokenizer tokenizer = new StringTokenizer(dataExpresion, new Operation().delimiters, true);

        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }

        if (dataList.size() > 3){
            throw new NumberFormatException();
        }
    }
}
