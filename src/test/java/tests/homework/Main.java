package tests.homework;

public class Main {
    public static void main(String[] args) {

    int a = 25;
    int b = 15;
    int c = 10;
    double d = 2.8;

    //Простые арифметические операции
        System.out.println("Сумма = " + (a + b));
        System.out.println("Разница = " + (a - b));
        System.out.println("Произведение = " + a * b);
        System.out.println("Целое частное = " +  a / b + "; остаток = "+ a % b);

        //Смешанные вычисления
        double result = 0;
        result = (c+d)/d + c*d;

        System.out.println("Результат = " + result);

        //Логические операции
        if (a>b) {
            System.out.println("1. a действительно больше b");}
            else {
            System.out.println("1. Утверждение неверное");}
            if (a<=b) {
                System.out.println("2. a действительно больше b");}
            else {
                System.out.println("2. Утверждение неверное");}
            if (c==d) {
                System.out.println("3. Утверждение верное");}
            else {
                System.out.println("3. Абра-кадабра");}

        //Работа с предельными значениями примитивных типов
        System.out.println(Float.MAX_VALUE); // Максимальная величина float
        System.out.println(Float.MIN_NORMAL); //Минимальная нормализованная положительная величина
        System.out.println(Float.MIN_VALUE); //Минимальная ненормализованная положительная величина
        System.out.println(Double.MAX_VALUE); // Максимальная величина double
        System.out.println(Double.MIN_NORMAL); //Минимальная нормализованная положительная величина
        System.out.println(Double.MIN_VALUE); //Минимальная ненормализованная положительная величина

        // Переполнение границ double
        double maxDouble = Double.MAX_VALUE;
        double result1 = maxDouble+maxDouble;
        System.out.println("Результат суммы двух Double.MAX_VALUE = " + result1);
        // Infinity бесконечное значение при выходе за границы допустимого диапазона
    };
    }


