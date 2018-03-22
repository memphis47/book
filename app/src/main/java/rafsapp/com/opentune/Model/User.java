package rafsapp.com.opentune.Model;

import java.util.ArrayList;

import rafsapp.com.opentune.JSON_Models.Room;

/**
 * Created by Rafael on 21/03/2018.
 */

public class User {

    private String name;
    private ArrayList<Room> roomsBooked;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRoomsBooked() {
        return roomsBooked;
    }

    public void setRoomsBooked(ArrayList<Room> roomsBooked) {
        this.roomsBooked = roomsBooked;
    }
}
