package lvl1;

import java.util.List;

public class Fraction {
    private int numerator;
    private int denominator;

    // Конструктор по умолчанию
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Конструктор принимающий одно значение
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    // Измененный конструктор для числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Конструктор копирования
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }


    // Геттеры и сеттеры
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    public void checkDenominator(Fraction obj) throws DivByZeroException {
        if (this.denominator == 0) {
            throw new DivByZeroException("Знаменатель не может быть равен нулю");
        }
    }

    // Метод для нахождения НОК
    private int lcm(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max; ; i++) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
    }

    // Методы сложения дробей
    public Fraction add(Fraction other) {
        checkDenominator(this);
        checkDenominator(other);
        int lcm = lcm(this.denominator, other.denominator);
        this.numerator = this.numerator * (lcm / this.denominator) + other.numerator * (lcm / other.denominator);
        this.denominator = lcm;
        return this;
    }

    public Fraction add(List<Fraction> listOfFractions) {
        for (Fraction other : listOfFractions) {
            add(other);
        }
        return this;
    }

    public Fraction add(Fraction... others) {
        for (Fraction other : others) {
            add(other);
        }
        return this;
    }

    // Методы умножения
    public Fraction multiply(Fraction other) {
        checkDenominator(this);
        checkDenominator(other);
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
        return this;
    }

    public Fraction multiply(Fraction... others) {
        for (Fraction other : others) {
            multiply(other);
        }
        return this;
    }

    // Метод деления
    public Fraction divide(Fraction other) {
        checkDenominator(this);
        checkDenominator(other);
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
        return this;
    }

    // Метод для сокращения дроби
    public Fraction reduce() {
        checkDenominator(this);
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    // Вспомогательный метод для нахождения НОД
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Метод для вывода дроби
    public void show() {
        checkDenominator(this);
        System.out.println(this.numerator + "/" + this.denominator);
    }

    public static void show(List<Fraction> listOfFractions) {
        for (Fraction fraction : listOfFractions) {
            fraction.show();
        }
    }

    public static void change(List<Fraction> others) {
        for (int i = 0; i < others.size(); i++) {
            if (i % 2 == 0 && i != others.size() - 1) {
                others.get(i).add(others.get(i + 1));
            }
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
