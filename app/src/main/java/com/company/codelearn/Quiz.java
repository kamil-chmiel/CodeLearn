package com.company.codelearn;

public class Quiz {
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public Boolean getUnlocked() {
        return unlocked;
    }

    private String id;
    private String title;
    private Integer points;
    private Integer maxPoints;
    private Boolean unlocked;

    public Quiz(String id, String title, Integer points, Integer maxPoints, Boolean unlocked) {
        this.id = id;
        this.title = title;
        this.points = points;
        this.maxPoints = maxPoints;
        this.unlocked = unlocked;
    }
}
