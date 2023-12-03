import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача:          В галактике Сникерс на планете Юпитер есть N городов, некоторые " +
                "\n                 из которых соединены дорогами. Император Кузко галактики Сникерс решил " +
                "\n                 провести инветаризацию дорог на планете ,питер. Но, как оказалось, он не" +
                "\n                 силен в математике, поэтому он просит вас сосчитать количество дорог" +
                "\nВходные данные:  В первой строке задается число N(0<=N<=100).В следующих N строках содержится" +
                "\n                 по N чисел, каждое из которых является единицей или нулем. Причем, если в" +
                "\n                 в позиции(i,j) квадратной матрицы стоит единичка, то i-ый и j-ый города" +
                "\n                 соединены дорогами, а если ноль, то не соединены \nВыходные данные: Выведите" +
                "одно число- количество дорог на планете Сникерс\nВведите число N:");
        Scanner inputting = new Scanner(System.in);//ввод N
        while ((!inputting.hasNextInt())) {
            System.out.println("Число не соответствует данным задачи");
            inputting.next();
        }
        int number = inputting.nextInt();
        while ((number <= 0) || (number >= 100)) {
            System.out.println("Число не соответствует данным задачи");
            number = inputting.nextInt();
        }
        int[][] arr = new int[number][number];//считывание графа путей между городами
        boolean flag = true;
        System.out.println("Введите матрицу графа");
        while (true) {
            graph(number, arr);
            if (check(arr)) {
                break;
            }
        }
        System.out.println("Количество путей в данном графе "+road(arr));
    }

    static void graph(int number, int arr[][]) {//заполнение массива
        Scanner inputting = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                while (!inputting.hasNextInt()) {
                    System.out.println("Число не соответствует данным задачи");
                    inputting.next();
                }
                arr[i][j] = inputting.nextInt();
            }
        }
    }

    static boolean check(int arr[][]) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (result) {
                    if ((arr[i][j] != 0) && (arr[i][j] != 1)) {//проверка значения 1 или 0
                        System.out.println("Число не соответствует данным задачи(значение не равны 0 или 1)");
                        result = false;
                    }
                }
                if (result) {
                    if (arr[i][j] != arr[j][i]) {//проверка на симметричность графа
                        System.out.println("Число не соответствует данным задачи(граф не симметричен)");
                        result = false;
                    }
                }
                if (result) {
                    if (arr[i][i] != 0) {
                        System.out.println("Число не соответствует данным задачи(диагональные элементы не равны 0)");
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    static int road(int arr[][]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    result++;
                }
            }
        }
        return result / 2;
    }
}