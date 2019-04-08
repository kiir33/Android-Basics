package com.example.readfromfile;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.text.util.Linkify;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class about extends AppCompatActivity {

    HtmlTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);



        textView = (HtmlTextView)findViewById(R.id.about);
        String text = "";
        try {

            InputStream inputStream = getAssets().open("about.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);

        }catch (IOException e){
            e.printStackTrace();
        }
        textView.setHtml(text,new HtmlAssetsImageGetter(textView));
        Linkify.addLinks(textView,Linkify.ALL);
    }
}
