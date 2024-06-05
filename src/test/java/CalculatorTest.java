import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;
    @BeforeAll
    static void init() {
         calculator = new Calculator();
    }

    @Test
    void CalculatorTest() {
        
      Double delizhen = calculator.delizhen(5.0, 1.0);
       // Assertions.assertNotEquals(5,delizhen);

        Assertions.assertAll(()->calculator.truFalse("1"),()->calculator.delizhen(5.5,1.0));
       /* Assertions.assertEquals(5.0,delizhen);
        Assertions.assertNotNull(delizhen);
        Assertions.assertNull(delizhen);*/
        //  Assertions.assertThrows(ArithmeticException.class,()-> calculator.delizhen(5.5,0.0));
        // Assertions.assertFalse();
    }

    @Test
    void tryFalseTest() {

        Assertions.assertFalse( calculator.truFalse("555555"));
    }
    @Test
    void notNull(){
        Assertions.assertNotNull(calculator.calculators("444"));

    }

}