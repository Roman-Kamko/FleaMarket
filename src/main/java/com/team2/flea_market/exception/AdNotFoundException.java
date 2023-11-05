package com.team2.flea_market.exception;

public class AdNotFoundException extends RuntimeException {

    private final Integer adId;

    public AdNotFoundException(Integer adId) {
        this.adId = adId;
    }

    @Override
    public String getMessage() {
        return "объявление с ID %d не найдено".formatted(adId);
    }

}
