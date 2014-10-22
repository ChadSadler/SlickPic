package com.example.slickpic;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class PictureView extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Toast.makeText(this, "Image capture failed", Toast.LENGTH_LONG).show();
		
		MainActivity MainActivity = new MainActivity();
		
		Uri fileUri = MainActivity.getFileUri();
		
		setContentView(R.layout.picture_view);

		ImageView image = new ImageView(MainActivity);
		image.setImageURI(fileUri);
	}
}
