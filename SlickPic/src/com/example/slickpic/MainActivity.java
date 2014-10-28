package com.example.slickpic;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	Uri mCapturedImageURI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String fileName = "temp.jpg";  
        ContentValues values = new ContentValues();  
        values.put(MediaStore.Images.Media.TITLE, fileName);  
        mCapturedImageURI = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);  

		
		 // create Intent to take a picture and return control to the calling application
	    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

	    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI); // set the image file name

	    // start the image capture Intent
	    startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	        	
	        	String[] projection = { MediaStore.Images.Media.DATA};
	            Cursor cursor = managedQuery(mCapturedImageURI, projection, null, null, null); 
	            
	            int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA); 
	            cursor.moveToFirst(); 
	            String capturedImageFilePath = cursor.getString(column_index_data);
	            
	            Intent pictureViewIntent = new Intent(MainActivity.this,PictureView.class);
	            pictureViewIntent.putExtra("fileUri", capturedImageFilePath);
			
				startActivity(pictureViewIntent);
				
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the image capture
	        } else {
	        	Toast.makeText(this, "Image capture failed", Toast.LENGTH_LONG).show();
	        }
	    }
	    
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
