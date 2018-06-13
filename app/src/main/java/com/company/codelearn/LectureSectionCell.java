package com.company.codelearn;

import java.util.Date;

public class LectureSectionCell extends LecturesCell{
    String sectionTitle;
    Integer progress;
    Integer maxPoints;
    Date startDate;

    public LectureSectionCell(String sectionTitle, Integer progress, Integer maxPoints, Date startDate) {
        this.type = CellType.section;
        this.sectionTitle = sectionTitle;
        this.progress = progress;
        this.maxPoints = maxPoints;
        this.startDate = startDate;
    }
}
