package com.popescu.mobiletest.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.popescu.mobiletest.R;
import com.popescu.mobiletest.model.UserProfileInfo;

import java.util.ArrayList;

/**
 * Created by atnm-4 on 30/09/2017.
 */

public class UserProfileInfoAdapter extends ArrayAdapter<ArrayList> {
    private ArrayList mList;
    private Activity mContext;

    public UserProfileInfoAdapter(Activity context, ArrayList objects) {
        super(context, R.layout.user_profile_item, objects);
        this.mContext = context;
        this.mList = objects;

    }

    public View getView(int position, View rowView, ViewGroup parent) {
        UserProfileInfoAdapter.Holder holder;
        if (rowView == null) {
            LayoutInflater inflator = mContext.getLayoutInflater();
            rowView = inflator.inflate(R.layout.user_profile_item, null, true);
            holder = new UserProfileInfoAdapter.Holder();

            holder.userField = (TextView) rowView.findViewById(R.id.itemField);
            holder.userValue = (TextView) rowView.findViewById(R.id.itemValue);

            rowView.setTag(holder);
        } else {
            holder = (UserProfileInfoAdapter.Holder) rowView.getTag();
        }

        UserProfileInfo item = (UserProfileInfo) this.mList.get(position);
        if (item.getValue() != null)
            holder.userValue.setText(item.getValue());
        holder.userField.setText(item.getField());
        return rowView;
    }

    static class Holder {
        TextView userField;
        TextView userValue;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}

