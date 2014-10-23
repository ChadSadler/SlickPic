package com.example.slickpic;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final String MEDIA_TYPE_IMAGE = null;
	private Uri fileUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 // create Intent to take a picture and return control to the calling application
	    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

	    setFileUri(getOutputMediaFileUri(MEDIA_TYPE_IMAGE)); // create a file to save the image
	    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, getFileUri()); // set the image file name

	    // start the image capture Intent
	    startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Image captured and saved to fileUri specified in the Intent
	        	setFileUri(data.getData());
	            Toast.makeText(this, "Image saved to:\n" + getFileUri(), Toast.LENGTH_LONG).show();
	            
	            Intent pictureViewIntent = new Intent(MainActivity.this,
						PictureView.class);
	            pictureViewIntent.putExtra("fileUri", fileUri.toString());
			
				startActivity(pictureViewIntent);
				
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the image capture
	        } else {
	        	Toast.makeText(this, "Image capture failed", Toast.LENGTH_LONG).show();
	        }
	    }
	    
	}

	private Uri getOutputMediaFileUri(String mediaTypeImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public Uri getFileUri() {
		return fileUri;
	}

	public void setFileUri(Uri fileUri) {
		this.fileUri = fileUri;
	}

}
