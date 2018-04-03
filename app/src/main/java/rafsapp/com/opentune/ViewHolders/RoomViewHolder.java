package rafsapp.com.opentune.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import rafsapp.com.opentune.R;

/**
 * Created by Rafael on 02/04/2018.
 */

public class RoomViewHolder extends RecyclerView.ViewHolder{
    public TextView roomNameTV;
    public TextView roomCapacityTV;
    public TextView roomLocationTV;
    public TextView roomSizeTV;

    public RoomViewHolder(View view) {
        super(view);
        roomNameTV = (TextView) view.findViewById(R.id.room_name);
        roomCapacityTV = (TextView) view.findViewById(R.id.room_capacity);
        roomLocationTV = (TextView) view.findViewById(R.id.room_location);
        roomSizeTV = (TextView) view.findViewById(R.id.room_size);
    }
}
