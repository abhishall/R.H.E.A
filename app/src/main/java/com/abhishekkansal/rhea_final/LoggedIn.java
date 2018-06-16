package com.abhishekkansal.rhea_final;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
public class LoggedIn extends AppCompatActivity implements OnItemSelectedListener {

    String currentCourse,currentSem,currentTopic, getId,getName,getUsername,getCourse,getSem,getPassword;
    Spinner course, sem, topic;
    Button topic1, topic2;
    String[] coursearray = {"B.Sc Physical Science"};
    String[] semarray = {"I","II","III","IV","V","VI"};
    String[] topicarray = {"Introduction to CS", "Python Programming", "DBMS", "MySQL", "OS", "UNIX","CSA","PHP","Programming in JAVA","System Administration", "Internet Technologies","Android Programming"};
    String[] video_link = {"https://www.youtube.com/playlist?list=PLvJoKWRPIu8G6Si7LlvmBPA5rOJ9BA29R", "https://www.youtube.com/playlist?list=PLEA1FEF17E1E5C0DA",
                           "https://www.youtube.com/playlist?list=PLyvBGMFYV3auVdxQ1-88ivNFpmUEy-U3M", "https://www.youtube.com/watch?v=KgiCxe-ZW8o&list=PL32BC9C878BA72085",
                            "https://www.youtube.com/playlist?list=PLTgavEZk0mZX7P2WVuE6hN9qVnkTgrAc9", "https://www.youtube.com/watch?v=hwrnmQumtPw",
                            "https://www.youtube.com/watch?v=leWKvuZVUE8&list=PLQObLunIEgaQ7Drxp8yCmsJqidgSsTqlw", "https://www.youtube.com/playlist?list=PL442FA2C127377F07",
                            "https://www.youtube.com/playlist?list=PL60799AAF105DFE06", "https://www.youtube.com/playlist?list=PLtK75qxsQaMLZSo7KL-PmiRarU7hrpnwK",
                            "https://www.youtube.com/playlist?list=PL04D5787E247DC324", "https://www.youtube.com/watch?v=QAbQgLGKd3Y&list=PL6gx4Cwl9DGBsvRxJJOzG4r4k_zLKrnxl"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        course = (Spinner)findViewById(R.id.courseSpinLI);
        sem = (Spinner)findViewById(R.id.semSpinLI);

        topic1 = (Button) findViewById(R.id.IB_topic1);
        topic2 = (Button) findViewById(R.id.IB_topic2);
        TextView tv_username = (TextView)findViewById(R.id.tv_LI_hellousername);

        Intent i3 = getIntent();
        Bundle extras = i3.getExtras();
        if(extras!=null){
            getId = extras.getString("id");
            getName = extras.getString("name");
            getUsername = extras.getString("username");
            getCourse = extras.getString("course");
            getSem = extras.getString("sem");
            getPassword = extras.getString("password");
            tv_username.setText("Hello\n"+getName);
        }
        course.setOnItemSelectedListener(this);
        sem.setOnItemSelectedListener(this);
       // topic.setOnItemSelectedListener(this);
        ArrayAdapter ca = new ArrayAdapter(this, android.R.layout.simple_spinner_item, coursearray);
        ArrayAdapter sa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, semarray);
        ArrayAdapter ta = new ArrayAdapter(this, android.R.layout.simple_spinner_item, topicarray);

        ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course.setAdapter(ca);
        sem.setAdapter(sa);
        //topic.setAdapter(ta);

        int coursePosition = ca.getPosition(getCourse);
        course.setSelection(coursePosition);

        int semPosition = sa.getPosition(getSem);
        sem.setSelection(semPosition);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.courseSpinLI:
                getCourse = course.getItemAtPosition(i).toString();
                break;

            case R.id.semSpinLI:
                if(i==0) {

                    topic1.setBackgroundResource(R.drawable.introtocs);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[0];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });


                    topic2.setBackgroundResource(R.drawable.python);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[1];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }

                else if(i==1){
                    topic1.setBackgroundResource(R.drawable.dbms);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[2];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });

                    topic2.setBackgroundResource(R.drawable.mysql);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[3];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }

                else if(i==2){
                    topic1.setBackgroundResource(R.drawable.os);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[4];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });

                    topic2.setBackgroundResource(R.drawable.unix);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[5];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }

                else if(i==3){
                    topic1.setBackgroundResource(R.drawable.csa);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[6];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });

                    topic2.setBackgroundResource(R.drawable.php);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[7];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }

                else if(i==4){
                    topic1.setBackgroundResource(R.drawable.java);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[8];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });

                    topic2.setBackgroundResource(R.drawable.sysadmin);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[9];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }

                else if(i==5){
                    topic1.setBackgroundResource(R.drawable.internettech);
                    topic1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[10];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });

                    topic2.setBackgroundResource(R.drawable.android);
                    topic2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String link = video_link[11];
                            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                            startActivity(i);
                        }
                    });
                }



                }


        }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
