package rafsapp.com.opentune;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rafsapp.com.opentune.Adapters.RoomListAdapter;
import rafsapp.com.opentune.Interfaces.ServerCallback;
import rafsapp.com.opentune.JSON_Interfaces.GerritAPI;
import rafsapp.com.opentune.JSON_Models.Marca;
import rafsapp.com.opentune.JSON_Models.Room;
import rafsapp.com.opentune.JSON_Models.RoomSchedule;
import rafsapp.com.opentune.ViewModel.RoomController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private Date current_set_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            setDay();
            loadAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set time_text field initial value
     */
    private void setDay() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        current_set_Time = Calendar.getInstance().getTime();
        changeTimeText(df);
    }

    /**
     * First load of all rooms available for today
     *
     * @throws Exception
     */
    public void loadAllRooms() throws Exception {
        sendRequestToGetRooms("today");
    }

    private void sendRequestToGetRooms(String date) {
        final Context context = this;
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        RoomController controller = new RoomController();
        RoomSchedule schedule = new RoomSchedule();
        schedule.setDate(date);
        controller.getRooms(schedule, new ServerCallback() {
            @Override
            public void onSuccess(List<Room> result) {
                recyclerView.setAdapter(new RoomListAdapter(result,context));

                RecyclerView.LayoutManager layout = new LinearLayoutManager(context,
                        LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layout);
            }
        });


    }

    /**
     * Change current date for a day before and do a request to get Rooms available
     *
     * @param v
     */
    public void beforeDate(View v) {
        modifyDate(-1);
        changeTimeText(dateFormat);
        sendRequestToGetRooms(getTimestamp());
    }

    /**
     * Change current date for a day after and do a request to get Rooms available
     *
     * @param v
     */
    public void afterDate(View v) {
        modifyDate(1);
        changeTimeText(dateFormat);
        sendRequestToGetRooms(getTimestamp());
    }

    /**
     * Return Unix TimeStamp of current_set_Time attribute
     *
     * @return
     */
    private String getTimestamp() {
        long output = current_set_Time.getTime() / 1000L;
        String str = Long.toString(output);
        long timestampLong = Long.parseLong(str) * 1000;
        return String.valueOf(timestampLong);
    }

    /**
     * Change time_text field to new current_set_time
     *
     * @param df SimpleDateFormat value
     */
    private void changeTimeText(SimpleDateFormat df) {
        TextView current_date_text_field = (TextView) findViewById(R.id.time_text);
        current_date_text_field.setText(df.format(current_set_Time));
    }

    /**
     * Modify current_set_time for a day after or before of current day set on attribute
     *
     * @param amount
     */
    private void modifyDate(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current_set_Time);
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        current_set_Time = calendar.getTime();
    }
}
