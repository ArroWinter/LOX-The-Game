package ru.lox;

public class Game {
    public static void main(String[] args) {
        boolean end, x_o = false;
        LOX_Field lox = new LOX_Field();
        do {
            x_o = !x_o;
            lox.DrawField();
            System.out.println("mark " + (x_o ? "X" : "O"));
            int n = lox.getNumber();
            lox.setField(x_o ? 1 : 2, n);
            //System.out.println(n);
            //lox.DrawField();
            end = lox.isGameOver(n);
        } while (end);
    }
}
