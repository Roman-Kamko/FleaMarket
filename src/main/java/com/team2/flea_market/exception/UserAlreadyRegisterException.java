package com.team2.flea_market.exception;

public class UserAlreadyRegisterException extends RuntimeException {

    private final String username;

    public UserAlreadyRegisterException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Пользователь с именем " + username + " уже зарегистрирован в системе";
    }

}
