
    import java.util.Random;
    import java.util.Scanner;

    public class MainClass {

        // Заведение констант на допустимый ввод
        // Какими символами (фигками) играет игрок
        private static final char DOT_HUMAN = 'X';
        // Что вводит компьютер
        private static final char DOT_AI = 'O';
        // Символ пустой клетка
        private static final char DOT_EMPTY = ' ';

        // Упрощения вместо использования field.length
        private static int fieldSizeX;
        private static int fieldSizeY;
        // Игровое поля
        private static char[][] field;

        private static final Scanner SCANNER = new Scanner(System.in);
        private static final Random RANDOM = new Random();

        private static final int fieldSize = 3;

        // Добавил эти переменные, чтобы передавать их в метод проверки победы.
        private static int xTurn;
        private static int yTurn;

        //main
        public static void main(String[] args) {

            while (true) {
                init(fieldSize);
                printField();
                playOnce(fieldSize);
                System.out.println("Играть сначала?");
                if (SCANNER.next().equals("no")) {
                    break;
                }
            }
        }

        private static void playOnce(int fieldSize) {
            while (true) {
                humanTurn();
                printField();
                if (isWinnerExists(DOT_HUMAN, xTurn, yTurn)) {
                    System.out.println("Победил Игрок!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Ничья!");
                    break;
                }

                aiTurn();
                printField();
                if (isWinnerExists(DOT_AI, xTurn, yTurn)) {
                    System.out.println("Победил Компьютер!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Ничья!");
                    break;
                }

            }
        }

        //initField
        private static void init(int fieldSize) {
            fieldSizeX = fieldSize;
            fieldSizeY = fieldSize;

            field = new char[fieldSizeY][fieldSizeX];

            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    field[y][x] = DOT_EMPTY;
                }
            }
        }

        //printField
        private static void printField() {
            System.out.println("=============");

            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print("| ");
                for (int x = 0; x < fieldSizeX; x++) {
                    System.out.print(field[y][x] + " | ");
                }
                System.out.println();
            }
        }

        //isValidField
        // Проврека, что координаты находятся в допустимом диапазоне
        private static boolean isValidField(int x, int y) {
            return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
        }

        //isNotEmptyField
        // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
        private static boolean isNotEmptyField(int x, int y) {
            return field[y][x] != DOT_EMPTY;
        }

        //humanTurn
        // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
        private static void humanTurn() {
            // 3 1
            int x;
            int y;
            do {
                System.out.print("Введите координаты хода X и Y (от 1 до " + fieldSizeY + ") через пробел >>> ");
                x = SCANNER.nextInt() - 1;
                y = SCANNER.nextInt() - 1;
                xTurn = x;
                yTurn = y;
            } while (!isValidField(x, y) || isNotEmptyField(x, y));
            field[y][x] = DOT_HUMAN;
        }

        //aiTurn
        private static void aiTurn() {
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
                xTurn = x;
                yTurn = y;
            } while (isNotEmptyField(x, y));
            field[y][x] = DOT_AI;
        }

        //isDraw
        private static boolean isDraw() {
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (field[y][x] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        //checkWin
        // Первый вариант с перебором всего поля. Выглядит еще хуже чем восемь "Если".
        private static boolean isWinnerExists(char symb) {

            int horizontalSum = 0;
            int verticalSum = 0;
            int diagonalSum = 0;
            int revDiagonalSum = 0;

            for(int i = 0; i < 3; i++){

                if (verticalSum == 3 || horizontalSum == 3 || diagonalSum == 3 || revDiagonalSum == 3)
                    return true;
                verticalSum = 0;
                horizontalSum = 0;
                diagonalSum = 0;
                revDiagonalSum = 0;

                for(int j = 0; j < 3; j++){

                    if(field[i][j] == symb)
                        horizontalSum++;
                    if(field[j][i] == symb)
                        verticalSum++;
                    if(field[j][j] == symb)
                        diagonalSum++;
                    if(field[j][2 - j] == symb)
                        revDiagonalSum++;
                }

            }

//            if (field[0][0] == symb && field[0][1] == symb && field[0][2] == symb) return true;
//            if (field[1][0] == symb && field[1][1] == symb && field[1][2] == symb) return true;
//            if (field[2][0] == symb && field[2][1] == symb && field[2][2] == symb) return true;
//
//            if (field[0][0] == symb && field[1][0] == symb && field[2][0] == symb) return true;
//            if (field[0][1] == symb && field[1][1] == symb && field[2][1] == symb) return true;
//            if (field[0][2] == symb && field[1][2] == symb && field[2][2] == symb) return true;
//
//            if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
//            if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) return true;
            return false;
        }


        // Проверяю вертикаль и горизонталь последнего хода. Если ход был в угол или центр, то и диагональ.
        private static boolean isWinnerExists(char symb, int x, int y){
            int verticalSum = 0;
            int horizontalSum = 0;
            int diagonalSum = 0;
            int reverseDiagonalSum = 0;

            for(int i = 0; i < 3; i++){
                if(field[y][i] == symb)
                    horizontalSum++;
                if(field[i][x] == symb)
                    verticalSum++;
            }

            if((x + y) % 2 == 0){
                for(int i = 0; i < 3; i ++){
                    if(field[i][i] == symb)
                        diagonalSum++;
                    if(field[i][2 - i] == symb)
                        reverseDiagonalSum++;
                }
            }

            if(verticalSum == 3 || horizontalSum == 3 || diagonalSum == 3 || reverseDiagonalSum == 3)
                return true;

            return false;
        }

        // Для поля 5 на 5. Не смог придумать решения для диагоналей. 
        private static boolean isWinnerExists5on5(char symb, int x, int y){
            int verticalSum = 0;
            int horizontalSum = 0;

            int[] arrHorizontal = new int[5];
            int[] arrVertical = new int[5];

            for(int i = 0; i < 5; i++){
                if(field[y][i] == symb) {
                    horizontalSum++;
                    arrHorizontal[i] = field[y][i];
                }
                if(field[i][x] == symb) {
                    verticalSum++;
                    arrVertical[i] = field[i][x];
                }
            }

            // Не придумал способа для проверки диагоналей. Поэтому наколхозил восемь "если".
            if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb && field[3][3] == symb) return true;
            if (field[4][4] == symb && field[1][1] == symb && field[2][2] == symb && field[3][3] == symb) return true;
            if (field[4][0] == symb && field[3][1] == symb && field[2][2] == symb && field[1][3] == symb) return true;
            if (field[0][4] == symb && field[3][1] == symb && field[2][2] == symb && field[1][3] == symb) return true;
            if (field[1][0] == symb && field[2][1] == symb && field[3][2] == symb && field[4][3] == symb) return true;
            if (field[0][1] == symb && field[1][2] == symb && field[2][3] == symb && field[3][4] == symb) return true;
            if (field[0][3] == symb && field[1][2] == symb && field[2][1] == symb && field[3][0] == symb) return true;
            if (field[1][4] == symb && field[2][3] == symb && field[3][2] == symb && field[4][1] == symb) return true;

            if(verticalSum == 5 || horizontalSum == 5)
                return true;

            if(horizontalSum == 4)
                return checkLine(arrHorizontal, symb);
            if(verticalSum == 4)
                return checkLine(arrVertical, symb);

            return false;
        }

        // Метод проверки, что 4 одинаковых символа идут подряд.
        private static boolean checkLine(int[] arr, char symb) {
            int sum = 0;
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] == symb)
                    sum++;
            }
            if (sum == 4) return true;
            for(int i = 1; i < arr.length; i++){
                if(arr[i] == symb)
                    sum++;
            }
            if (sum == 4) return true;

            return false;
        }
    }


