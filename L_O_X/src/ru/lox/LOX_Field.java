package ru.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LOX_Field {
    private int[] field = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public LOX_Field() {
    }

    public void setField(int var, int num) {
        this.field[num] = var;
    }

    public int[] getField() {
        return field;
    }

    int getNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < field.length && field[n] == 0) {
                    return n;
                }
                System.out.println("Choose free cell and enter its number");
            } catch (NumberFormatException | IOException e) {
                System.out.println("Please enter the number");
            }
        }
    }

    boolean isGameOver() {
        /*
        0 1 2
        3 4 5
        6 7 8
        */
        if (field[1] == field[4] && field[7] == field[4] && field[1] != 0) return false;
        if (field[8] == field[4] && field[0] == field[4] && field[8] != 0) return false;
        if (field[3] == field[4] && field[5] == field[4] && field[3] != 0) return false;
        if (field[2] == field[4] && field[6] == field[4] && field[2] != 0) return false;
        if (field[0] == field[1] && field[2] == field[1] && field[0] != 0) return false;
        if (field[6] == field[7] && field[7] == field[8] && field[6] != 0) return false;
        if (field[3] == field[6] && field[3] == field[0] && field[3] != 0) return false;
        if (field[2] == field[5] && field[2] == field[8] && field[2] != 0) return false;
        return true;
    }

    void DrawField() {
        String[] xoxo = {"_", "_", "_", "_", "_", "_", "_", "_", "_"};
        for (int i = 0; i < 9; i++) {
            if (this.field[i] == 1) xoxo[i] = "X";
            if (this.field[i] == 2) xoxo[i] = "O";
        }
        System.out.println(xoxo[0] + "|" + xoxo[1] + "|" + xoxo[2]);
        System.out.println("=====");
        System.out.println(xoxo[3] + "|" + xoxo[4] + "|" + xoxo[5]);
        System.out.println("=====");
        System.out.println(xoxo[6] + "|" + xoxo[7] + "|" + xoxo[8]);
    }

    public boolean isDraw() {
        for (int n : field) if (n == 0) return false;
        return true;
    }

    public void whoWin(boolean win) {
        if (win) System.out.println("X Player win this game");
        else System.out.println("O Player win this game");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
