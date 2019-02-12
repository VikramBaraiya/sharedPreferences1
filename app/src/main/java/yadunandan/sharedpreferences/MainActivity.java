package yadunandan.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.name);
        t2=(EditText)findViewById(R.id.age);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh=getSharedPreferences("profile",MODE_WORLD_READABLE);
        String t11=sh.getString("name","");
        int  t21=sh.getInt("age",0);
        t1.setText(t11);
        t2.setText(t21);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh=getSharedPreferences("profile",MODE_PRIVATE);
        SharedPreferences.Editor edit=sh.edit();
        edit.putString("name",t1.getText().toString());
        edit.putInt("age",Integer.parseInt(t2.getText().toString()));
        edit.commit();
    }
}
