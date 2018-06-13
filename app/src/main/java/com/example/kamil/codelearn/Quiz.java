package com.example.kamil.codelearn;

public class Quiz {
    String id;
    String title;
    Integer points;
    Integer maxPoints;
    Boolean unlocked;

    public Quiz(String id, String title, Integer points, Integer maxPoints, Boolean unlocked) {
        this.id = id;
        this.title = title;
        this.points = points;
        this.maxPoints = maxPoints;
        this.unlocked = unlocked;
    }
}
