package ru.job4j.chess;




public class Task {
    public static void main(String[] args) {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(1, 1));
        Bishop bishop1 = new Bishop(new Cell(6, 1));
        Bishop bishop2 = new Bishop(new Cell(8, 6));

        board.add(bishop);
        board.add(bishop1);
        board.add(bishop2);
        System.out.println(board);

    }
}
