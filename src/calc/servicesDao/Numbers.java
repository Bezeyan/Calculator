package calc.servicesDao;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    List<String> dataRomeNumber = new ArrayList<>();
    List<String> dataArabicNumber = new ArrayList<>();
    List<String> romeNumber = new ArrayList<>();

    {
        dataRomeNumber.add("I1");
        dataRomeNumber.add("V5");
        dataRomeNumber.add("X10");
        dataRomeNumber.add("L50");
        dataRomeNumber.add("C100");
        dataRomeNumber.add("D500");
        dataRomeNumber.add("M1000");
    }


    {
        romeNumber.add("I");
        romeNumber.add("II");
        romeNumber.add("III");
        romeNumber.add("IV");
        romeNumber.add("V");
        romeNumber.add("VI");
        romeNumber.add("VII");
        romeNumber.add("VIII");
        romeNumber.add("IX");
        romeNumber.add("X");
    }

    {
        for (int i = 0; i < 10; i++) {
            dataArabicNumber.add(Integer.toString(i));
        }

    }

    public List<String> getDataRomeNumber() {
        return dataRomeNumber;
    }

    public List<String> getDataArabicNumber() {
        return dataArabicNumber;
    }

    public List<String> getRomeNumber() {
        return romeNumber;
    }
}
