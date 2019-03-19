package org.pursuit.viewpager_json;

public class Planets {
    private String name;
    private int number;
    private String image;

    public Planets(String name, int number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }

}
