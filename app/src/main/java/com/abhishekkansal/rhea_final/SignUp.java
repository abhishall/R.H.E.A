package com.abhishekkansal.rhea_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class SignUp extends AppCompatActivity implements OnItemSelectedListener{

    DatabaseHelper myDB;
    Button signup_SU;
    EditText et_name, et_email, et_password;
    String signup_name, signup_email, signup_course, signup_sem, signup_password;
    RadioGroup sem_radio_group;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    Spinner course_spinner;
    String[] course_array = {"Select your course", "B.Sc Physical Science"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        myDB = new DatabaseHelper(this);

        signup_SU = (Button)findViewById(R.id.bt_SU_signup);

        course_spinner = (Spinner)findViewById(R.id.sp_SU_course);
        course_spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,course_array);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spinner.setAdapter(aa);

        sem_radio_group = (RadioGroup)findViewById(R.id.RG_SU_sem);
        rb1 = (RadioButton)findViewById(R.id.rb_SU_1);
        rb2 = (RadioButton)findViewById(R.id.rb_SU_2);
        rb3 = (RadioButton)findViewById(R.id.rb_SU_3);
        rb4 = (RadioButton)findViewById(R.id.rb_SU_4);
        rb5 = (RadioButton)findViewById(R.id.rb_SU_5);
        rb6 = (RadioButton)findViewById(R.id.rb_SU_6);

        sem_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == (rb1.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb1.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb1.getText().toString();
                }
                else if(i == (rb2.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb2.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb2.getText().toString();
                }
                else if(i == (rb3.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb3.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb3.getText().toString();
                }
                else if(i == (rb4.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb4.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb4.getText().toString();
                }
                else if(i == (rb5.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb5.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb5.getText().toString();
                }
                else if(i == (rb6.getId())){
                    //Toast.makeText(SignUp.this, "Sem Selected "+rb6.getText().toString(), Toast.LENGTH_SHORT).show();
                    signup_sem = rb6.getText().toString();
                }
            }
        });

        et_name = (EditText)findViewById(R.id.et_SU_name);
        et_email = (EditText)findViewById(R.id.et_SU_email);
        et_password = (EditText)findViewById(R.id.et_SU_password);

        signup_SU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SignUp.this,et_password.getText().toString(), Toast.LENGTH_SHORT).show();
                signup_name = et_name.getText().toString();
                signup_email = et_email.getText().toString();
                signup_password = et_password.getText().toString();
                Intent intent_signup_to_login = new Intent(SignUp.this,LoginPage.class);
                intent_signup_to_login.putExtra("signup_name", signup_name);
                intent_signup_to_login.putExtra("signup_email", signup_email);
                intent_signup_to_login.putExtra("signup_course", signup_course);
                intent_signup_to_login.putExtra("signup_sem", signup_sem);
                intent_signup_to_login.putExtra("signup_password", signup_password);
                startActivity(intent_signup_to_login);
            }
        });

        AddUser();

    }

    @Override
    public void onItemSelected(android.widget.AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, "Selected Course "+ course_array[i], Toast.LENGTH_SHORT).show();
        signup_course = course_array[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void AddUser(){
        signup_SU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SignUp.this,et_password.getText().toString(), Toast.LENGTH_SHORT).show();
                signup_name = et_name.getText().toString();
                signup_email = et_email.getText().toString();
                signup_password = et_password.getText().toString();
                Intent intent_signup_to_login = new Intent(SignUp.this,LoginPage.class);
                intent_signup_to_login.putExtra("signup_name", signup_name);
                intent_signup_to_login.putExtra("signup_email", signup_email);
                intent_signup_to_login.putExtra("signup_course", signup_course);
                intent_signup_to_login.putExtra("signup_sem", signup_sem);
                intent_signup_to_login.putExtra("signup_password", signup_password);
                startActivity(intent_signup_to_login);
                boolean isUserInserted = myDB.insertUser(signup_name,signup_email,signup_course,signup_sem,signup_password);
                if(isUserInserted == true){
                    Toast.makeText(SignUp.this, "User Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignUp.this, "User Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
