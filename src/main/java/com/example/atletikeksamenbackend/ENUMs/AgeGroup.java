package com.example.atletikeksamenbackend.ENUMs;

public enum AgeGroup {
    CHILD(6, 9),
    YOUTH(10, 13),
    JUNIOR(14, 22),
    ADULT(23, 40),
    SENIOR(41, Integer.MAX_VALUE);

    private final int minAge;
    private final int maxAge;

    AgeGroup(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public static AgeGroup fromAge(int age) {
        for (AgeGroup group : AgeGroup.values()) {
            if (age >= group.minAge && age <= group.maxAge) {
                return group;
            }
        }
        throw new IllegalArgumentException("Age out of range");
    }

}
