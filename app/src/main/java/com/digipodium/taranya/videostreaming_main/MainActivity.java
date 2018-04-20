package com.digipodium.taranya.videostreaming_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText et_email;
    private EditText et_pass;
    private String TAG = "login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        TextView frgtpass = findViewById(R.id.frgtpass);
        Button btn_login = findViewById(R.id.btn_login);
        TextView register = findViewById(R.id.register);
        btn_login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String email = et_email.getText().toString();
        String password = et_pass.getText().toString();
        switch (v.getId()) {
            case R.id.btn_login:
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    Intent intent = new Intent(MainActivity.this, settings.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(MainActivity.this, "Signin Successful",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Signin Failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
                break;
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (mAuth != null) {
            if (mAuth.getCurrentUser() != null) {
                Intent intent = new Intent(MainActivity.this, settings.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this, "Signin Successful",
                        Toast.LENGTH_SHORT).show();

            }
        }


    }
}