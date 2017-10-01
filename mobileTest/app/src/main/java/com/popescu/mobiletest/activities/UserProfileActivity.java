package com.popescu.mobiletest.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.popescu.mobiletest.utils.Constants;
import com.popescu.mobiletest.R;
import com.popescu.mobiletest.adapters.UserProfileInfoAdapter;
import com.popescu.mobiletest.model.UserProfileInfo;
import com.popescu.mobiletest.model.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserProfileActivity extends Activity implements AdapterView.OnItemClickListener, ActivityCompat.OnRequestPermissionsResultCallback {


    private ListView userInfoList;
    private ArrayList<UserProfileInfo> userProfileInfos;
    private UserProfileInfoAdapter userProfileInfoAdapter;
    private ImageView userProfilePicture;
    private static final int REQUEST_CALL = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        initializeView();
    }

    private void initializeView() {
        userInfoList = (ListView) findViewById(R.id.userProfileInfo);
        int pos = getIntent().getIntExtra(Constants.KEY_USER_POSITION, 0);
        Users.User user = Users.sUsers.get(pos);
        userProfileInfos = new ArrayList<>();
        userProfileInfos.add(new UserProfileInfo(getResources().getString(R.string.phone), user.getPhone()));
        userProfileInfos.add(new UserProfileInfo(getResources().getString(R.string.email), user.getEmail()));
        userProfileInfos.add(new UserProfileInfo(getResources().getString(R.string.address), user.getLocation().getStreet()));
        userProfileInfoAdapter = new UserProfileInfoAdapter(this, userProfileInfos);
        userInfoList.setAdapter(userProfileInfoAdapter);
        userInfoList.setOnItemClickListener(this);
        View header = (View) getLayoutInflater().inflate(R.layout.user_profile_header, null);
        View footer = (View) getLayoutInflater().inflate(R.layout.user_profile_footer, null);
        userInfoList.addHeaderView(header);
        userInfoList.addFooterView(footer);
        TextView userName = (TextView) header.findViewById(R.id.userName);
        userName.setText(user.getUserName().getFirst() + " " + user.getUserName().getLast());
        userProfilePicture = (ImageView) header.findViewById(R.id.profilePicture);
        if (user.getUserPhoto().getMedium() != null)
            Picasso.with(this).load(user.getUserPhoto().getLarge()).into(userProfilePicture);
        TextView userId = (TextView) footer.findViewById(R.id.userId);
        userId.setText(getResources().getString(R.string.id) + " " + user.getId().getValue());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1: {
          
            }
            case 2: {

            }
            case 3: {

            }
            default:
                break;
        }
    }
}
