package ru.itmo.database.entity;

public class Course {
    private int id;
    private String title;
    private double duration;
    private int price;

    public Course() { }

    public Course(String title, double duration, int price) {
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}