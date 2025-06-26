package tests.homework;

import org.junit.jupiter.api.Test;

public class Lesson10Test {
    @Test
    void basicsJava0() {
        int a = 25;
        int b = 15;
        System.out.println("Сумма = " + (a + b));
        System.out.println("Разница = " + (a - b));
        System.out.println("Произведение = " + a * b);
        System.out.println("Целое частное = " +  a / b + "; остаток = "+ a % b);
    }
    @Test
    void basicsJava1() {
        int c = 10;
        double d = 2.8;
        double result = 0;

        result = (c+d)/d + c%d - d;

        System.out.println("Результат = " + result);
    }

}
