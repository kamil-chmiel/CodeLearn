package com.example.kamil.codelearn;

public class LectureCell extends LecturesCell {
    Integer lessonNumber;
    String title;
    Integer progress;
    Integer lessonsCount;

    public LectureCell(String title, Integer progress) {
        this.title = title;
        this.progress = progress;
    }
}
