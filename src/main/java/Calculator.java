public class Calculator {
public Double delizhen(Double a,Double b){
    if (b==0){
        throw new  ArithmeticException() ;
    }
    return a/b;
};
Boolean truFalse(String s){
    if (s.length() > 5){
        return true;}
    else return false;
}
Calculator calculators(String s){
    if (s.length() < 2){
        return new Calculator();
    }else return null;
}
}
