package rafsapp.com.opentune.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import rafsapp.com.opentune.GSON_Deserializer.DateDeserializer;
import rafsapp.com.opentune.Interfaces.ServerCallback;
import rafsapp.com.opentune.JSON_Interfaces.GerritAPI;
import rafsapp.com.opentune.JSON_Models.Room;
import rafsapp.com.opentune.JSON_Models.RoomSchedule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael on 29/01/2018.
 */

public class RoomController {

    static final String BASE_URL = "https://challenges.1aim.com/roombooking_app/";
    private List<Room> roomList;

    public void getRooms(RoomSchedule date, final ServerCallback callback) {

        //Instancia do interceptador das requisições
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS);

        httpClient.addInterceptor(loggingInterceptor);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();

        //Instância do retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        GerritAPI gerritAPI =retrofit.create(GerritAPI.class);

        Call<List<Room>> call = gerritAPI.loadRooms(date);
        call.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if(response.isSuccessful()) {
                    roomList = response.body();
                    callback.onSuccess(roomList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
               call.toString();
            }
        });
    }
}
