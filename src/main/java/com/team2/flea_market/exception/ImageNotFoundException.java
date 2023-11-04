package com.team2.flea_market.exception;

public class ImageNotFoundException extends RuntimeException {

    private final Integer id;

    public ImageNotFoundException(Integer id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Картинка с id " + id + " не найдена";
    }

}
