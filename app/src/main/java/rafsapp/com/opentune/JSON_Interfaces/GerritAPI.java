package rafsapp.com.opentune.JSON_Interfaces;

import java.util.List;

import rafsapp.com.opentune.JSON_Models.Marca;
import rafsapp.com.opentune.JSON_Models.Room;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Rafael on 29/01/2018.
 */

public interface GerritAPI {

    @POST
    Call<List<Room>> loadRooms();
}
