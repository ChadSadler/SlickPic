package com.example.slickpic;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class PictureView extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.picture_view);
		
		Intent intent = getIntent();
		String fileUri = intent.getExtras().getString("fileUri");
			
		File imgFile = new File(fileUri);
		String path = imgFile.getAbsolutePath();
		Uri pathUri = Uri.parse(path);

		ImageView myImage = (ImageView) findViewById(R.id.imgView);

		myImage.setImageURI(pathUri);
		myImage.setRotation(90);
		
		ImageButton noButton = (ImageButton) findViewById(R.id.noButton);
		ImageButton yesButton = (ImageButton) findViewById(R.id.yesButton);
		
		noButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

			}
		});
		
		yesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

			}
		});
		}
	}
