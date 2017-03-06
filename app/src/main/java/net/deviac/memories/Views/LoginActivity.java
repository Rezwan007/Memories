package net.deviac.memories.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.deviac.memories.R;
import net.deviac.memories.Views.HomeScreenActivity;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText userName, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPass);

        sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("username", "admin");
        editor.putString("password", "12345");
        editor.commit();
    }

    public void login(View view) {
        String user = sharedPreferences.getString("username", null).toString();
        String pass = sharedPreferences.getString("password", null);

        if( user.equals(userName.getText().toString()) && pass.equals(userPassword.getText().toString())) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intentHomeScreen = new Intent(getApplicationContext(), HomeScreenActivity.class);
            startActivity(intentHomeScreen);
        } else {
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
        }

    }
}
