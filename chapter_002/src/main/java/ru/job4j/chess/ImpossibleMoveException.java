package ru.job4j.chess;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 05.03.2018
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
