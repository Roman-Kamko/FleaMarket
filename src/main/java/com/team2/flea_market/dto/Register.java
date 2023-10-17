package com.team2.flea_market.dto;

public record Register(
        String username,
        String password,
        String firstName,
        String lastName,
        String phone,
        Role role
) {
}
