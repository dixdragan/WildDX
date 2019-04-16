package org.jboss.as.quickstarts.dxmodel;

import java.time.LocalTime;

public class Arriving implements Comparable<Arriving> {

    private String lineNumber;
    private String stationFrom;
    private String stationTo;
    private LocalTime timeStarted;
    private LocalTime timeArriving;

    public Arriving() {
        super();
    }

    public Arriving(String lineNumber, String stationFrom, String stationTo, LocalTime timeStarted, LocalTime timeArriving) {
        this.lineNumber = lineNumber;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.timeStarted = timeStarted;
        this.timeArriving = timeArriving;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    public String getStationTo() {
        return stationTo;
    }

    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }

    public LocalTime getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(LocalTime timeStarted) {
        this.timeStarted = timeStarted;
    }

    public LocalTime getTimeArriving() {
        return timeArriving;
    }

    public void setTimeArriving(LocalTime timeArriving) {
        this.timeArriving = timeArriving;
    }
    
    @Override
    public int compareTo(Arriving arriving) {
        return this.getTimeArriving().toSecondOfDay() - arriving.getTimeArriving().toSecondOfDay();
    }
}
