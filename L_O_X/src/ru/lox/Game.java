package ru.lox;

public class Game {
    public static void main(String[] args) {
        boolean end, x_o = false;
        LOX_Field lox = new LOX_Field();
        do {
            lox.clearScreen();
            x_o = !x_o;
            lox.DrawField();
            System.out.println("mark " + (x_o ? "X" : "O"));
            lox.setField(x_o ? 11 : 22, lox.getNumber());
            end = lox.isGameOver();
            if (!end) {
                lox.clearScreen();
                lox.DrawField();
                lox.whoWin(x_o);
            }
        } while (end);
    }
}
