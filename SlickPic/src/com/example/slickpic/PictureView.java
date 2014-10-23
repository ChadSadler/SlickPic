package com.example.slickpic;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class PictureView extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.picture_view);
		
		Intent intent = getIntent();
		String fileUri = intent.getExtras().getString("fileUri");
			
		File imgFile = new File(fileUri);
		String path = imgFile.getAbsolutePath();
		Uri pathUri = Uri.parse(path);
		
		Toast.makeText(this, path, Toast.LENGTH_LONG).show();

		//Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

		ImageView myImage = (ImageView) findViewById(R.id.imgView);

		myImage.setImageURI(pathUri);	
	}
}
