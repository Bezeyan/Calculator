package calc.services.checks;

import calc.servicesDao.Numbers;
import calc.servicesDao.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckParameters {

    List<String> dataList = new ArrayList();

    public String check(String dataExpresion) {

        StringTokenizer tokenizer = new StringTokenizer(dataExpresion, new Operation().getAllOperators(), false);

        while (tokenizer.hasMoreTokens()) {
            dataList.add(tokenizer.nextToken());
        }

        boolean flagArabicNumber = isArabicNumber();

        boolean flagRomeNumber = isRomeNumber();

        if ((!flagArabicNumber) && (!flagRomeNumber)) {
            throw new NumberFormatException("неправильный формат данных!!!");
        }
        if (flagArabicNumber) {
            return "arabic";
        }
        return "rome";
    }

    private boolean isRomeNumber() {
        boolean flagRomeNumber = true;
        boolean flag = false;
        for (String s : dataList) {
            for (int i = s.length(); i > 0; i--) {
                for (String romeNumber : new Numbers().getDataRomeNumber()) {
                    if (s.charAt(i - 1) == romeNumber.charAt(0)) {
                        flag = true;
                    }
                }
                if (!flag) {
                    flagRomeNumber = false;
                }
                flag = false;
            }
        }
        return flagRomeNumber;
    }

    private boolean isArabicNumber() {
        boolean flagArabicNumber = true;
        boolean flag = false;
        for (String s : dataList) {
            for (int i = s.length(); i > 0; i--) {
                for (String arabicNumber : new Numbers().getDataArabicNumber()) {
                    if (s.charAt(i - 1) == arabicNumber.charAt(0)) {
                        flag = true;
                    }
                }
                if (!flag) {
                    flagArabicNumber = false;
                }
                flag = false;
            }
        }
        return flagArabicNumber;
    }

}
