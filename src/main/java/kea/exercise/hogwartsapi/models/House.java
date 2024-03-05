package kea.exercise.hogwartsapi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class House {
    @Id
    private String name;
    private String founder;
    private String color1;
    private String color2;

    public House(String name, String founder, String color1, String color2) {
        this.name = name;
        this.founder = founder;
        this.color1 = color1;
        this.color2 = color2;
    }
    public House() {}

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String[] getColors() {
        return new String[]{color1, color2};
    }
    public void setColor(String color1, String color2) {
        this.color1 = color1;
        this.color2 = color2;

    }
    public void setColors(ArrayList<String> colors) {
        this.color1 = colors.get(0);
        this.color1 = colors.get(1);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }


    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", founder='" + founder + '\'' +
                ", color='" + color1 +  color2 + '\'' +
                '}';
    }
}
