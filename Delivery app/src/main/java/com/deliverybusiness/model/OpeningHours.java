package com.deliverybusiness.model;
import com.deliverybusiness.enums.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "OpeningHours")
public class OpeningHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FromTime")
    @Pattern(regexp = "([0-1][0-9]|2[0-3]):[0-5][0-9]", message = "Time not in correct format.")
    private String fromTime;
    @Column(name = "ToTime")
    @Pattern(regexp = "([0-1][0-9]|2[0-3]):[0-5][0-9]", message = "Time not in correct format.")
    private String toTime;
    private DayOfWeek dayOfWeek;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "restaurant_ID", referencedColumnName = "ID")
    private Restaurant restaurant;

    public OpeningHours() {
    }

    public OpeningHours(int id, String fromTime, String toTime, DayOfWeek dayOfWeek, Restaurant restaurant) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.dayOfWeek = dayOfWeek;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public DayOfWeek getWeekday() {
        return dayOfWeek;
    }

    public void setWeekday(DayOfWeek weekday) {
        this.dayOfWeek = dayOfWeek;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "OpeningHours{" +
                "id=" + id +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", weekday=" + dayOfWeek +
                ", restaurant=" + restaurant +
                '}';
    }
}
