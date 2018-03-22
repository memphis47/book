package rafsapp.com.opentune;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import rafsapp.com.opentune.JSON_Interfaces.GerritAPI;
import rafsapp.com.opentune.JSON_Models.Marca;
import rafsapp.com.opentune.JSON_Models.Room;
import rafsapp.com.opentune.ViewModel.RoomController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        try {
            loadAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // add items into spinner dynamically
    public void loadAllRooms() throws Exception {

        GerritAPI service = RoomController.createService(GerritAPI.class);

        Call<List<Room>> call = service.loadRooms();
        final List<String> list = new ArrayList<String>();
        list.add(getString(R.string.selecione_marca));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String marca = (String) parent.getItemAtPosition(position);
        if(marca != null && marca != getString(R.string.selecione_marca)){

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
