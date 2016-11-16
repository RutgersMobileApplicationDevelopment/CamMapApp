package com.rumad.cammapapp.cammapapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rumad.cammapapp.cammapapp.api.CampMapService;
import com.rumad.cammapapp.cammapapp.api.RetrofitFactory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private final static String TOKEN_KEY_NAME = "token";

    private Button registerBtn;
    private EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBtn = (Button)findViewById(R.id.register_btn);
        username = (EditText)findViewById(R.id.username_field);
        email = (EditText)findViewById(R.id.email_field);
        password = (EditText)findViewById(R.id.password_field);

        final Retrofit retrofit = RetrofitFactory.getRetrofit();
        final CampMapService campMapService = retrofit.create(CampMapService.class);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = username.getText().toString();
                String e = email.getText().toString();
                String p = password.getText().toString();

                Call<ResponseBody> call = campMapService.register(u, e, p);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("MainActivity","Response = " + response.toString());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("MainActivity","Error = "  + t.getMessage());
                    }
                });

            }
        });

    }
}
