package calc.controllers;

import calc.services.anotherNumberSystem.ArabicInRoman;
import calc.services.anotherNumberSystem.RomanInArabic;
import calc.services.arithmeticOperations.SplitBrackets;
import calc.services.checks.CheckCorrect;
import calc.services.checks.CheckMoreThanTenAndNumberOfTermsIsParentheses;
import calc.services.checks.CheckParameters;
import calc.services.checks.CheckSigns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {
/*
  калькулятор выполняет условия задачи, в то же время если снять ограничения,
  может считать выражения со скобками и римские числа в результате имеющие до 4000.
  Римские числа большие 4000 имеют сложные символы, поэтому расчеты в них не целесообразны.
 */
    public static void main(String[] args) throws IOException {

        String dataExpresion = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String result = "";
        dataExpresion = dataExpresion.replaceAll(" ", "");

        try {
            String isRome = new CheckParameters().check(dataExpresion);
            if (isRome.equals("rome")) {
                new CheckCorrect().check(dataExpresion);
                dataExpresion = new RomanInArabic().inArabic(dataExpresion);
            }
            new CheckMoreThanTenAndNumberOfTermsIsParentheses().check(dataExpresion);
            new CheckSigns().check(dataExpresion);

            result = new SplitBrackets().splitBrackets(dataExpresion);

            if (isRome.equals("rome")) {
                result = new ArabicInRoman().inRome(result);
            }
            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("неверный формат выражения");
        }
    }
}
