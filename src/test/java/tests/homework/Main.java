package tests.homework;

public class Main {
    public static void main(String[] args) {

    int a = 25;
    int b = 15;
    int c = 10;
    double d = 2.8;

    //Простые арифметические операции
        System.out.println("Summa = " + (a + b));
        System.out.println("Difference = " + (a - b));
        System.out.println("Work = " + a * b);
        System.out.println("Whole private = " +  a / b + "; Remainder = "+ a % b);

        //Смешанные вычисления
        double result = 0;
        result = (c+d)/d + c*d;

        System.out.println("Result = " + result);

        //Логические операции
        if (a>b) {
            System.out.println("1. The statement is correct");}
            else {
            System.out.println("1. The statement is not correct");}
            if (a<=b) {
                System.out.println("2. The statement is correct");}
            else {
                System.out.println("2. The statement is not correct");}
            if (c==d) {
                System.out.println("3. The statement is correct");}
            else {
                System.out.println("3. Abra-kadabra");}

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
        System.out.println("Result of the sum Double.MAX_VALUE = " + result1);
        // Infinity бесконечное значение при выходе за границы допустимого диапазона
    };
    }


