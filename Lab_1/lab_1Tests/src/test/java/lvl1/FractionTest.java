package lvl1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void checkDenominatorNegative() throws DivByZeroException {
        Fraction fraction1 = new Fraction(1, 0);
        Fraction fraction2 = new Fraction(1, 5);
        Exception exception = assertThrows(DivByZeroException.class, () -> {
            fraction1.checkDenominator(fraction1);
        });
        assertEquals("Знаменатель не может быть равен нулю", exception.getMessage());
    }

    @Test
    void addPositive() throws DivByZeroException {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        f1.add(f2);
        assertEquals(5, f1.getNumerator());
        assertEquals(6, f1.getDenominator());
    }


    @Test
    void multiplyPositive() throws DivByZeroException {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        f1.multiply(f2);
        assertEquals(1, f1.getNumerator());
        assertEquals(6, f1.getDenominator());
    }


    @Test
    void dividePositive()throws DivByZeroException {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        f1.divide(f2);
        assertEquals(3, f1.getNumerator());
        assertEquals(2, f1.getDenominator());
    }


    @Test
    void reducePositive()throws DivByZeroException {
        Fraction f1 = new Fraction(4, 6);
        f1.reduce();
        assertEquals(2, f1.getNumerator());
        assertEquals(3, f1.getDenominator());
    }

    @Test
    void change() {}

}