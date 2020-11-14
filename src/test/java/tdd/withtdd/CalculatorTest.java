package tdd.withtdd;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void whenTwoAddToTwoItEqualsFour() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2,2);

        Assert.assertEquals(4, result);
    }

    @Test
    public void whenTwoMinusTwoItEqualsZero() {
        Calculator calculator = new Calculator();

        int result = calculator.subtract(2,2);

        Assert.assertEquals(0, result);
    }
}
