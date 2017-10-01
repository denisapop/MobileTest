package com.popescu.mobiletest.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.popescu.mobiletest.ws.Api;
import com.popescu.mobiletest.utils.Constants;
import com.popescu.mobiletest.R;
import com.popescu.mobiletest.adapters.UsersListViewAdapter;
import com.popescu.mobiletest.model.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private UsersListViewAdapter adapter;
    private int nr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.usersListView);
        listView.setOnItemClickListener(this);
        if (Users.sUsers == null || Users.sUsers.isEmpty()) {
            getUsers();
        } else
            loadListView();
    }

    private void getUsers() {
        Call<Users> call = Api.getApiClient().getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                Users.setsUsers(response.body().getUser());
                loadListView();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }


    private void loadListView() {
        adapter = new UsersListViewAdapter(this, Users.sUsers);
        //	note : this should come next to loading view
        listView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
        intent.putExtra(Constants.KEY_USER_POSITION, position);
        startActivity(intent);


    }
}
