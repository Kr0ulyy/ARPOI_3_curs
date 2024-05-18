package lvl1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivByZeroException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        List<Fraction> listOfFractions = new ArrayList<>();
        Random random = new Random();

        // Создание массива случайных дробей, обработка возможных исключений
        for (int i = 0; i < size; i++) {
            int numerator = random.nextInt(100);
            int denominator = 1 + random.nextInt(99);
            try {
                listOfFractions.add(new Fraction(numerator, denominator));
            } catch (DivByZeroException e) {
                System.out.println(e.getMessage());
                // В случае исключения, можно добавить дробь с безопасным знаменателем
                listOfFractions.add(new Fraction(numerator, 1));
            }
        }

        Fraction.show(listOfFractions);
        Fraction.change(listOfFractions);
        System.out.println("Дроби после изменений:");
        Fraction.show(listOfFractions);

        System.out.println("***************");
        try {
            Fraction f1 = new Fraction(1, 0);  // Это вызовет исключение
            Fraction f2 = new Fraction(4, 9);
            f1.add(f2).show();
        } catch (DivByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}

