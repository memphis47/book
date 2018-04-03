package rafsapp.com.opentune.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import rafsapp.com.opentune.JSON_Models.Room;
import rafsapp.com.opentune.R;
import rafsapp.com.opentune.ViewHolders.RoomViewHolder;

/**
 * Created by Rafael on 02/04/2018.
 */

public class RoomListAdapter extends RecyclerView.Adapter {

    private final List<Room> roomList;
    private Context context;

    public RoomListAdapter(List<Room> roomList, Context context) {
        this.roomList = roomList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.room_layout, parent, false);

        RoomViewHolder roomViewHolder = new RoomViewHolder(view);

        return roomViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RoomViewHolder roomViewHolder = (RoomViewHolder) holder;

        Room room = roomList.get(position);

        roomViewHolder.roomNameTV.setText(room.getName());
        roomViewHolder.roomCapacityTV.setText(String.valueOf(room.getCapacity()));
        roomViewHolder.roomLocationTV.setText(room.getLocation());
        roomViewHolder.roomSizeTV.setText(String.valueOf(room.getSize()));
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }
}
