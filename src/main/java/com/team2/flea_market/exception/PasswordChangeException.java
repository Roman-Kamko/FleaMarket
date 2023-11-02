package com.team2.flea_market.exception;

public class PasswordChangeException extends RuntimeException {

    private final String username;

    public PasswordChangeException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Пользователь " + username + " указал не верный пароль при попытке сменить пароль";
    }

}
