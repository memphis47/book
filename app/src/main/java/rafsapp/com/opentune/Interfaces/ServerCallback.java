package rafsapp.com.opentune.Interfaces;

import java.util.List;

import rafsapp.com.opentune.JSON_Models.Room;

/**
 * Created by Rafael on 02/04/2018.
 */

public interface ServerCallback {
    void onSuccess(List<Room> result);
}
