package com.example.slickpic;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class PictureView extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.picture_view);
		
		Intent intent = getIntent();
		String fileUri = intent.getExtras().getString("fileUri");
			
		File imgFile = new File(fileUri);
		String path = imgFile.getAbsolutePath();
		
		Bitmap source = BitmapFactory.decodeFile(path);
		
		ImageView myImage = (ImageView) findViewById(R.id.imgView);
		
		Matrix matrix = new Matrix();
		matrix.postRotate(90);
		Bitmap image = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

		myImage.setImageBitmap(image);

		ImageButton noButton = (ImageButton) findViewById(R.id.noButton);
		ImageButton yesButton = (ImageButton) findViewById(R.id.yesButton);
		
		final Intent mainActivityIntent = new Intent(PictureView.this, MainActivity.class);
		
		noButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				startActivity(mainActivityIntent);
			}
		});
		
		yesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Toast.makeText(PictureView.this, "Image Sent", Toast.LENGTH_LONG).show();
				
				startActivity(mainActivityIntent);
			}
		});
		}
	}
