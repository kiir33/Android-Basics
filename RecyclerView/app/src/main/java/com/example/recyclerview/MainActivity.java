package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mylist);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int[] images = {R.drawable.fb,R.drawable.youtube,R.drawable.twit,R.drawable.insta,
                        R.drawable.link,R.drawable.google,R.drawable.hang,R.drawable.pin,
                        R.drawable.fb,R.drawable.youtube,R.drawable.twit,R.drawable.insta,
                        R.drawable.link,R.drawable.google,R.drawable.hang,R.drawable.pin};

        String[] items = {"Facebook", "Youtube", "Twitter","Instagram","LinkedIn","Google+","HangOut","Pinterest",
                            "Facebook", "Youtube", "Twitter","Instagram","LinkedIn","Google++","HangsOut","Pinterest"};

        String[] dates = {"Feb 03", "Jan 01", "Mar 22", "Jul 14","Feb 03", "Jan 01", "Mar 22", "Jul 14",
                            "Feb 03", "Jan 01", "Mar 22", "Jul 14","Feb 03", "Jan 01", "Mar 22", "Jul 14"};
        recyclerView.setAdapter(new MyListAdapter(items,dates,images));

    }
}
