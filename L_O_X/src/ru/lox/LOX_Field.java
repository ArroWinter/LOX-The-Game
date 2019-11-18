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

    int getNumber(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < field.length && field[n]==0){
                    return n;
                }
                System.out.println("Choose free cell and enter its number");
            } catch (NumberFormatException | IOException e) {
                System.out.println("Please enter the number");
            }
        }
    }

    boolean isGameOver(int n){
        // 0 1 2
        // 3 4 5
        // 6 7 8
        //поиск совпадений по горизонтали
        int row = n-n%3; //номер строки - проверяем только её
        if (field[row]==field[row+1] &&
                field[row]==field[row+2]) return true;
        //поиск совпадений по вертикали
        int column = n%3; //номер столбца - проверяем только его
        if (field[column]==field[column+3])
            if (field[column]==field[column+6]) return true;
        //мы здесь, значит, первый поиск не положительного результата
        //если значение n находится на одной из граней - возвращаем false
        if (n%2!=0) return false;
        //проверяем принадлежит ли к левой диагонали значение
        if (n%4==0){
            //проверяем есть ли совпадения на левой диагонали
            if (field[0] == field[4] &&
                    field[0] == field[8]) return true;
            if (n!=4) return false;
        }
        return field[2] == field[4] &&
                field[2] == field[6];
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
        for (int n : field) if (n==0) return false;
        return true;
    }
}
