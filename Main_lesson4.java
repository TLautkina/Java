package ru.geekbrains.courses.java.LautkinaT.Lesson4;

/* Крестики-нолики в процедурном стиле
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

import java.util.Random;
import java.util.Scanner;

public class Main_lesson4 {

    public static final int SIZE_Y = 5; //размер поля по вертикали
    public static final int SIZE_X = 5; //расчет поля по горизонтали

    public static final int SIGNS_TO_WIN = 4;
    // сколько ячеек нужно подряд заполнить, чтобы победить

    public static final char EMPTY_SIGN = '•';
    // заполнитель для пустой ячейки
    public static final char USER_SIGN = 'X';
    // символ, которым играет первый игрок
    public static final char AI_SIGN = 'O';
    // символ, которым играет второй игрок
    static final char[][] fieldg = new char[SIZE_Y][SIZE_X];
    // объявление классов ввода и случайного числа для игры
    public static Scanner scr = new Scanner(System.in);
    public static Random rnd = new Random();

    //поле в начале игры
    private static void emptyField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                fieldg[i][j] = EMPTY_SIGN;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= fieldg.length; i++) {
            // шапка по горизонтали - координаты X
            System.out.print(i == 0 ? "  " : i + " ");
            // двойной пробел в качестве первого символа
        }
        System.out.println();
        for (int i = 0; i < fieldg.length; i++) {
            System.out.print((i + 1) + " ");
            // шапка по вертикали - координаты Y
            for (int j = 0; j < fieldg.length; j++) {
                System.out.print(fieldg[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //запись хода игрока на поле
    private static void SIGNField(int y, int x, char SIGN) {
        fieldg[y][x] = SIGN;
    }

    //Ход человева
    private static void USER_MOVE() {
        int x, y;
        do {
            System.out.printf("Введите координаты хода через пробел в формате X(= 1..%d) Y(= 1..%d):\n", SIZE_X, SIZE_Y);
            x = Integer.valueOf(scr.next()) - 1;
            y = Integer.valueOf(scr.next()) - 1;
        } while (!checkMove(y, x));
        SIGNField(y, x, USER_SIGN);
    }

    //Ход компьютера
    private static void AI_MOVE() {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличия поля для проверки
                if (h + SIGNS_TO_WIN <= SIZE_X) {
                    //по горизонтали
                    if (checkLineHorisont(v, h, USER_SIGN) == SIGNS_TO_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, AI_SIGN)) return;
                    }

                    if (v - SIGNS_TO_WIN > -2) {
                        //вверх по диагонали
                        if (checkDiaUp(v, h, USER_SIGN) == SIGNS_TO_WIN - 1) {
                            if (MoveAiDiaUp(v, h, AI_SIGN)) return;
                        }
                    }
                    if (v + SIGNS_TO_WIN <= SIZE_Y) {
                        //вниз по диагонали
                        if (checkDiaDown(v, h, USER_SIGN) == SIGNS_TO_WIN - 1) {
                            if (MoveAiDiaDown(v, h, AI_SIGN)) return;
                        }
                    }
                }
                if (v + SIGNS_TO_WIN <= SIZE_Y) {
                    //по вертикали
                    if (checkLineVertical(v, h, USER_SIGN) == SIGNS_TO_WIN - 1) {
                        if (MoveAiLineVertical(v, h, AI_SIGN)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличия поля для проверки
                if (h + SIGNS_TO_WIN <= SIZE_X) {
                    //по горизонтали
                    if (checkLineHorisont(v, h, AI_SIGN) == SIGNS_TO_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, AI_SIGN)) return;
                    }

                    if (v - SIGNS_TO_WIN > -2) {
                        //вверх по диагонали
                        if (checkDiaUp(v, h, AI_SIGN) == SIGNS_TO_WIN - 1) {
                            if (MoveAiDiaUp(v, h, AI_SIGN)) return;
                        }
                    }
                    if (v + SIGNS_TO_WIN <= SIZE_Y) {
                        //вниз по диагонали
                        if (checkDiaDown(v, h, AI_SIGN) == SIGNS_TO_WIN - 1) {
                            if (MoveAiDiaDown(v, h, AI_SIGN)) return;
                        }
                    }

                }
                if (v + SIGNS_TO_WIN <= SIZE_Y) {
                    //по вертикали
                    if (checkLineVertical(v, h, AI_SIGN) == SIGNS_TO_WIN - 1) {
                        if (MoveAiLineVertical(v, h, AI_SIGN)) return;
                    }
                }
            }
        }
        //случайный ход
        do {
            y = rnd.nextInt(SIZE_Y);
            x = rnd.nextInt(SIZE_X);
        } while (!checkMove(y, x));
        SIGNField(y, x, AI_SIGN);
    }

    //ход компьютера по горизонтали
    private static boolean MoveAiLineHorisont(int v, int h, char SIGN) {
        for (int j = h; j < SIGNS_TO_WIN; j++) {
            if ((fieldg[v][j] == EMPTY_SIGN)) {
                fieldg[v][j] = SIGN;
                return true;
            }
        }
        return false;
    }

    //ход компьютера по вертикали
    private static boolean MoveAiLineVertical(int v, int h, char SIGN) {
        for (int i = v; i < SIGNS_TO_WIN; i++) {
            if ((fieldg[i][h] == EMPTY_SIGN)) {
                fieldg[i][h] = SIGN;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонали вверх

    private static boolean MoveAiDiaUp(int v, int h, char SIGN) {
        for (int i = 0, j = 0; j < SIGNS_TO_WIN; i--, j++) {
            if ((fieldg[v + i][h + j] == EMPTY_SIGN)) {
                fieldg[v + i][h + j] = SIGN;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вниз
    private static boolean MoveAiDiaDown(int v, int h, char SIGN) {
        for (int i = 0; i < SIGNS_TO_WIN; i++) {
            if ((fieldg[i + v][i + h] == EMPTY_SIGN)) {
                fieldg[i + v][i + h] = SIGN;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения выбранного для хода игроком
    private static boolean checkMove(int y, int x) {
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y) return false;
        else return fieldg[y][x] == EMPTY_SIGN;

    }

    //проверка на ничью (все  ячейки поля заполнены ходами)
    private static boolean fullField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (fieldg[i][j] == EMPTY_SIGN) return false;
            }
        }
        System.out.println("Ничья! Постарайтесь выиграть в следующий раз!");
        return true;
    }

    //проверка победы
    private static boolean checkWin(char SIGN) {
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличия поля для проверки
                if (h + SIGNS_TO_WIN <= SIZE_X) {
                    //по горизонтали
                    if (checkLineHorisont(v, h, SIGN) >= SIGNS_TO_WIN) return true;

                    if (v - SIGNS_TO_WIN > -2) {
                        //вверх по диагонали
                        if (checkDiaUp(v, h, SIGN) >= SIGNS_TO_WIN) return true;
                    }
                    if (v + SIGNS_TO_WIN <= SIZE_Y) {
                        //вниз по диагонали
                        if (checkDiaDown(v, h, SIGN) >= SIGNS_TO_WIN) return true;
                    }
                }
                if (v + SIGNS_TO_WIN <= SIZE_Y) {
                    //по вертикали
                    if (checkLineVertical(v, h, SIGN) >= SIGNS_TO_WIN) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вверх
    private static int checkDiaUp(int v, int h, char SIGN) {
        int count = 0;
        for (int i = 0, j = 0; j < SIGNS_TO_WIN; i--, j++) {
            if ((fieldg[v + i][h + j] == SIGN)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по диагонали вниз
    private static int checkDiaDown(int v, int h, char SIGN) {
        int count = 0;
        for (int i = 0; i < SIGNS_TO_WIN; i++) {
            if ((fieldg[i + v][i + h] == SIGN)) count++;
        }
        return count;
    }

    private static int checkLineHorisont(int v, int h, char SIGN) {
        int count = 0;
        for (int j = h; j < SIGNS_TO_WIN + h; j++) {
            if ((fieldg[v][j] == SIGN)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по вертикали
    private static int checkLineVertical(int v, int h, char SIGN) {
        int count = 0;
        for (int i = v; i < SIGNS_TO_WIN + v; i++) {
            if ((fieldg[i][h] == SIGN)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Крестики-нолики!");
        emptyField();
        printField();
        System.out.println("Вы ходите первым.");
        do {
            USER_MOVE();
            System.out.println("Ваш ход на поле");
            printField();
            if (checkWin(USER_SIGN)) {
                System.out.println("Поздравляем, Вы выиграли!!!");
                break;
            } else if (fullField()) break;
            AI_MOVE();
            System.out.println("Ход ИИ на поле");
            printField();
            if (checkWin(AI_SIGN)) {
                System.out.println("К сожалению, выйграл компьютер:(.. Может быть, повезет в другой раз.");
                break;
            } else if (fullField()) break;
        } while (true);
        System.out.println("!Конец игры!");
    }
}