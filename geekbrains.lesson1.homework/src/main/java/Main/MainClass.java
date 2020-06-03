package Main;

public class MainClass {
    public static void main(String[] args){
        // Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        //где a, b, c, d – аргументы этого метода, имеющие тип float.


        float a = 5;
        float b = 3;
        float c = 7;
        float d = 9;

        // Не сказано про то, куда возвращать, поэтому использовал Println

        System.out.println(calc(a,b,c,d));

        //Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
        // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

        int e = 10;
        int f = 10;

        System.out.println(check(e,f));

        //Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
        // в консоль, положительное ли число передали или отрицательное.

        int g = 0;

        checkSign(g);

        // Написать метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное.

        int h = -10;

        checkNegativeSign(h);

        //Написать метод, которому в качестве параметра передается строка, обозначающая имя.
        // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

        String name = "RandomName";
        printName(name);

        // *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        int year = 1987;

        leapYearCheck(year);
    }

    public static float calc(float a, float b,float c,float d){
        return (a*(b +(c / d)));
    }

    public static boolean check(int a, int b){
        if((a + b) >= 10 && (a + b) <= 20)
            return true;
            else return false;
    }

    public static void checkSign(int a){
        if (a >= 0)
            System.out.println("Переданное число положительное");
        else
            System.out.println("Переданное число отрицательное");
    }

    public static void checkNegativeSign(int a){
        if (a < 0)
            System.out.println(true);
        else
            return;
    }

    public static void printName(String a){
        System.out.println("Привет, " + a + "!");
    }

    public static void leapYearCheck (int a){
        if(a%400 == 0 && a > 0) System.out.println(a + " является високосным годом.");
        else if (a%100 == 0 && a > 0) System.out.println(a + " не является високосным годом.");
        else if (a%4 == 0 && a >= 8) System.out.println(a + " является високосным годом.");
        else if (a == 4 || a == 4) System.out.println(a + " не является високосным годом. Потому что так решил император Август.");
        else if (a >= -42 && a <= -9 && a%3 == 0) System.out.println(a + " является високосным годом.");
        else System.out.println(a + " не является високосным годом.");
    }
}
