package com.example.list_views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView ll;
    String name[] = {"1 Aug","2 Aug","3 Aug","4 Aug","5 Aug","6 Aug","7 Aug"};
    String des[] = {"thursday","friday","saturday","sunday","monday","tuesday","wedmesday"};
   // int images[] =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.l1);

        somesetting s = new somesetting(this,name,des);
        ll.setAdapter(s);

        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i == 0){
                    Toast.makeText(getApplicationContext(),"data",Toast.LENGTH_SHORT).show();
                }

                if(i == 1){
                    Toast.makeText(getApplicationContext(),"data2",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class somesetting extends ArrayAdapter<String>{
        Context con;
        String data1[];
        String data2[];
        somesetting(Context c, String s1[], String s2[]){

            super(c,R.layout.row,R.id.textview1,s1);
            this.con = c;
            this.data1 = s1;
            this.data2 = s2;

        }
        @Override
        public View getView(int position, View convertview, ViewGroup parent){
            LayoutInflater lk = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = (View) lk.inflate(R.layout.row,parent,false);
            TextView t1 = row.findViewById(R.id.textview1);
            TextView t2 = row.findViewById(R.id.textview2);

            t1.setText(data1[position]);
            t2.setText(data2[position]);
            return row;
        }

    }
}
