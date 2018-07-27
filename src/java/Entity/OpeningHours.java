/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Windows 10 Version 2
 */
public class OpeningHours {

    private int id;
    private String dayInWeek;
    private int openTime;
    private int closeTime;
    private boolean isActive;

    public OpeningHours(String dayInWeek, int openTime, int closeTime, boolean isActive) {
        this.dayInWeek = dayInWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return dayInWeek + " " + openTime + " " + closeTime + " " + isActive;
    }

    
}
