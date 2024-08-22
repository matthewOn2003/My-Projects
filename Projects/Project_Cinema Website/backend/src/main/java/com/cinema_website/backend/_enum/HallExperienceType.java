package com.cinema_website.backend._enum;

public enum HallExperienceType {
    TWO_DIMENSIONAL("2D"),
    THREE_DIMENSIONAL("3D"),
    FOUR_DIMENSIONAL("4D"),
    STUDIO("STUDIO"),
    IMAGE_MAXIMUM("IMAX"),
    VERY_IMPORTANT_PERSON("VIP");

    private final String experience;

    HallExperienceType(String experience) {
        this.experience = experience;
    }
}
