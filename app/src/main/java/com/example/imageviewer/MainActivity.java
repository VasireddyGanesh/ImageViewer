package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int image[]={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12
    };

    ArrayList <ImageModel> arrayList;
    GridView mgridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();
        mgridView=findViewById(R.id.gridView);
        for(int i=0;i<image.length;i++){
            ImageModel im=new ImageModel();
            im.setImageID(image[i]);
            arrayList.add(im);
        }

        ImageAdapter imageAdapter=new ImageAdapter(getApplicationContext(),arrayList);
        mgridView.setAdapter(imageAdapter);

        mgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ImageListActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}