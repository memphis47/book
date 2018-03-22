package rafsapp.com.opentune.JSON_Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rafael on 21/03/2018.
 */

public class Room {

    private String name;
    private String location;
    private ArrayList<String> equipment;
    private String size;
    private int capacity;
    private ArrayList<Date> avail;
    private ArrayList<String> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Date> getAvail() {
        return avail;
    }

    public void setAvail(ArrayList<Date> avail) {
        this.avail = avail;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
