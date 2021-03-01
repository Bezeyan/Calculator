package calc.servicesDao;


public class Operation {
    public final String superPriorityOperators = "()";
    public final String priorityOperators = "*/";
    public final String operators = "+-";
    public final String delimiters =  operators + priorityOperators;
    public final String allOperators = delimiters + superPriorityOperators;

    public String getSuperPriorityOperators() {
        return superPriorityOperators;
    }

    public String getAllOperators() {
        return allOperators;
    }

    public String multiplication(String firstTerm, String secondTerm) {
        return Integer.toString(Integer.parseInt(firstTerm) * Integer.parseInt(secondTerm));
    }

    public String division(String firstTerm, String secondTerm) {
        return Integer.toString(Integer.parseInt(firstTerm) / Integer.parseInt(secondTerm));
    }

    public String addition(String firstTerm, String secondTerm) {
        return Integer.toString(Integer.parseInt(firstTerm) + Integer.parseInt(secondTerm));
    }

    public String subtraction(String firstTerm, String secondTerm) {
        return Integer.toString(Integer.parseInt(firstTerm) - Integer.parseInt(secondTerm));
    }
}

