package com.popescu.mobiletest.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.popescu.mobiletest.R;
import com.popescu.mobiletest.utils.Utils;
import com.popescu.mobiletest.model.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by atnm-4 on 29/09/2017.
 */

public class UsersListViewAdapter extends ArrayAdapter<ArrayList> {
    private ArrayList mList;
    private Activity mContext;

    public UsersListViewAdapter(Activity context, ArrayList objects) {
        super(context, R.layout.users_listview_item, objects);
        this.mContext = context;
        this.mList = objects;

    }

    public View getView(int position, View rowView, ViewGroup parent) {
        UsersListViewAdapter.Holder holder;
        if (rowView == null) {
            LayoutInflater inflator = mContext.getLayoutInflater();
            rowView = inflator.inflate(R.layout.users_listview_item, null, true);
            holder = new UsersListViewAdapter.Holder();

            holder.userName = (TextView) rowView.findViewById(R.id.userName);
            holder.userThumbnail = (ImageView) rowView.findViewById(R.id.userThumbnail);
            holder.userAge = (TextView) rowView.findViewById(R.id.userAge);
            holder.lastTimeOnline = (TextView) rowView.findViewById(R.id.lastTimeOnline);

            rowView.setTag(holder);
        } else {
            holder = (UsersListViewAdapter.Holder) rowView.getTag();
        }

        Users.User item = (Users.User) this.mList.get(position);
        holder.userName.setText(item.getUserName().getFirst() + " " + item.getUserName().getLast());
        Picasso.with(mContext).load(item.getUserPhoto().getMedium()).fit().centerCrop().into(holder.userThumbnail);
        if (item.getDob() != null && item.getNat() != null)
            holder.userAge.setText(Utils.getAge(item.getDob()) + mContext.getResources().getString(R.string.user_age_text) + item.getNat());
        if (item.getRegistered() != null) {
            holder.lastTimeOnline.setText(Utils.getRegistered(item.getRegistered()));
        }


        return rowView;
    }

    static class Holder {
        ImageView userThumbnail;
        TextView userName;
        TextView userAge;
        TextView lastTimeOnline;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
