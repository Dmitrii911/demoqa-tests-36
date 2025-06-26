package tests.homework;

import org.junit.jupiter.api.Test;

public class Lesson10Test {
    int a = 25;
    int b = 15;
    int c = 10;
    double d = 2.8;
    void basicsJava0() {

        System.out.println("Сумма = " + (a + b));
        System.out.println("Разница = " + (a - b));
        System.out.println("Произведение = " + a * b);
        System.out.println("Целое частное = " +  a / b + "; остаток = "+ a % b);
    }
    @Test
    void basicsJava1() {
        double result = 0;
        result = (c+d)/d + c%d - d;

        System.out.println("Результат = " + result);
    }
@Test
    void basicsJava2() {
        if (a>b) {
            System.out.println("1. a действительно больше b");}
            else {
            System.out.println("1. Утверждение неверное");
        }
    if (a<=b) {
        System.out.println("2. a действительно больше b");}
    else {
        System.out.println("2. Утверждение неверное");
    }
    if (c==d) {
        System.out.println("3. Утверждение верное");}
    else {
        System.out.println("3. Абра-кадабра");
    }
        };
    @Test
    void basicsJava3() {
        System.out.println(Float.MAX_VALUE); // Максимальная величина float
        System.out.println(Float.MIN_NORMAL); //Минимальная нормализованная положительная величина
        System.out.println(Float.MIN_VALUE); //Минимальная ненормализованная положительная величина
        System.out.println(Double.MAX_VALUE); // Максимальная величина double
        System.out.println(Double.MIN_NORMAL); //Минимальная нормализованная положительная величина
        System.out.println(Double.MIN_VALUE); //Минимальная ненормализованная положительная величина
    }
    @Test
    void basicsJava4() {
        double maxDouble = Double.MAX_VALUE;
        double result = maxDouble+maxDouble;
        System.out.println("Результат суммы двух Double.MAX_VALUE = " + result);
        // Infinity бесконечное значение при выходе за границы допустимого диапазона
    }
}

