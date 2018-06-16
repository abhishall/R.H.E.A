package com.abhishekkansal.rhea_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class LoginPage extends AppCompatActivity {
    DatabaseHelper MYDB;
    Button login;
    Button signup;
    EditText uname;
    EditText passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        MYDB = new DatabaseHelper(this);

        Intent intentFromSignup = getIntent();
        Bundle extrasignup = intentFromSignup.getExtras();
        if(extrasignup!=null){
            Toast.makeText(this, "Name: "+ extrasignup.getString("signup_name")+
                                              " Email: "+extrasignup.getString("signup_email")+
                                              " Course: "+extrasignup.getString("signup_course")+
                                              " Sem: "+ extrasignup.getString("signup_sem")+
                                              " Password: "+ extrasignup.getString("signup_password"), Toast.LENGTH_SHORT).show();
        }

        login = (Button)findViewById(R.id.bt_LP_login);
        signup = (Button)findViewById(R.id.bt_LP_signup);

        uname = (EditText)findViewById(R.id.et_LP_username);
        passw = (EditText)findViewById(R.id.et_LP_password);

        checkUnamePasswAndLogin();
        goToSignupPage();

    }

    public void checkUnamePasswAndLogin(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String checkUname = uname.getText().toString();
                String checkPassw = passw.getText().toString();

                Cursor res = MYDB.checkUser(checkUname,checkPassw);
               // Toast.makeText(LoginPage.this,res.getString(1), Toast.LENGTH_SHORT).show();
                if(res.getCount()==0){
                    Toast.makeText(LoginPage.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                }

                if(res.getCount()>0){
                        res.moveToFirst();

                    //if(res.getString(2)==checkUname && res.getString(5)==checkPassw){
                        Intent loginToLoggedIn = new Intent(LoginPage.this, LoggedIn.class);
                       loginToLoggedIn.putExtra("id", res.getString(0));
                       loginToLoggedIn.putExtra("name", res.getString(1));
                       loginToLoggedIn.putExtra("username", res.getString(2));
                       loginToLoggedIn.putExtra("course",res.getString(3));
                       loginToLoggedIn.putExtra("sem",res.getString(4));
                       loginToLoggedIn.putExtra("password", res.getString(5));
                        startActivity(loginToLoggedIn);
                    //}

                }


            }
        });
    }

    public void goToSignupPage(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(LoginPage.this, SignUp.class);
                startActivity(i2);
            }
        });
    }
}
