package com.company.codelearn;

public class LectureCell extends LecturesCell {
    Integer lessonNumber;
    String title;
    Integer progress;
    Integer maxPoints;
    public Boolean unlocked = false;

    public LectureCell(Integer lessonNumber,String title, Integer progress, Integer maxPoints ) {
        this.lessonNumber = lessonNumber;
        this.type = CellType.lecture;
        this.title = title;
        this.progress = progress;
        this.maxPoints = maxPoints;
    }
}
