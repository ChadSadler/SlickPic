package com.example.slickpic;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureView extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		
		if(extras == null) {
			return;
		}
		
		String fileUrl = extras.getString(Intent.EXTRA_TEXT);
		
		if(fileUrl != null) {
			
			setContentView(R.layout.picture_view);
			
			File imgFile = new File(fileUrl);

			Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

			ImageView myImage = (ImageView) findViewById(R.id.imgView);

			myImage.setImageBitmap(myBitmap);	
		}
	}
}
