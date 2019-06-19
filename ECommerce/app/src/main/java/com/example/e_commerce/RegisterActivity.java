package com.example.e_commerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText InputName,InputPhoneNumber,Inputpassword;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        InputName = (EditText) findViewById(R.id.register_username_input);
        InputPhoneNumber =(EditText) findViewById(R.id.register_phone_number_input);
        Inputpassword =(EditText) findViewById(R.id.register_password_input);

        CreateAccountButton =(Button) findViewById(R.id.register_btn);

        loadingBar = new ProgressDialog(this);

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });



    }

    private void CreateAccount() {

        String name  = InputName.getText().toString();
        String phone = InputPhoneNumber.getText().toString();
        String password  = Inputpassword.getText().toString();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(RegisterActivity.this,"Please Enter your name...",Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(phone)){
            Toast.makeText(RegisterActivity.this,"Please Enter your phone number...",Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this,"Please Enter Password...",Toast.LENGTH_LONG).show();
        }
        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, While we Registered your data..");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            ValidatePhoneNumber(name, phone ,password );
        }


    }

    private void ValidatePhoneNumber(final String name, final String phone, final String password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if( !(dataSnapshot.child("Users").child(phone).exists())){

                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone",phone);
                    userdataMap.put("password",password);
                    userdataMap.put("name",name);

                    RootRef.child("Users").child(phone).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                  if (task.isSuccessful()){
                                      Toast.makeText(RegisterActivity.this,"Congratulations, your account has been created.",Toast.LENGTH_SHORT).show();
                                      loadingBar.dismiss();

                                      Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                      startActivity(intent);

                                  }
                                  else {
                                      loadingBar.dismiss();

                                      Toast.makeText(RegisterActivity.this,"Network error:please try after some times...",Toast.LENGTH_SHORT).show();

                                  }
                                }
                            });

                }
                else {
                    Toast.makeText(RegisterActivity.this,"This"+phone+"already exists.",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"Please Try again using another phone number.",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
