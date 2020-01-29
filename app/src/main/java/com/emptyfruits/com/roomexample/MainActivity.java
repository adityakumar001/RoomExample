package com.emptyfruits.com.roomexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.emptyfruits.com.roomexample.database.User;
import com.emptyfruits.com.roomexample.database.UserDatabase;
import com.emptyfruits.com.roomexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding dataBinding;
    UserAdapter userAdapter;
    UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        userDatabase = UserDatabase.getUserDatabase(this);
        userAdapter = new UserAdapter(this);
        refresh();
        dataBinding.saveEdt.setOnClickListener(e -> {
            String name = dataBinding.nameEdt.getText().toString();
            String phone = dataBinding.phoneEdt.getText().toString();
            if (name.equals("") || phone.equals("")) {
                Toast.makeText(this, "Enter valid info!!", Toast.LENGTH_SHORT).show();
            } else {
                User toSave = new User(name, phone);
                UserDatabase database = UserDatabase.getUserDatabase(getApplicationContext());
                database.getUserDao().saveUser(toSave);
                refresh();
            }
        });
        dataBinding.clearRecordsBtn.setOnClickListener(e -> userDatabase.getUserDao().clearRecords());
    }

    private void refresh() {
        userDatabase.getUserDao().getUsers().observe(this, users -> {
            userAdapter.setUsers(users);
            dataBinding.recyclerView.setAdapter(userAdapter);
            dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    }
}
