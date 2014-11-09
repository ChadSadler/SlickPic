package com.example.slickpic.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.slickpic.PictureView;
import com.example.slickpic.R;
import com.robotium.solo.Solo;

public class SlickPicTest extends ActivityInstrumentationTestCase2 <PictureView>{
	private Solo solo;
	
	public SlickPicTest() {
		super(PictureView.class);
	}
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	
	public void testXButton() throws Exception {
		solo.assertCurrentActivity("right activity", PictureView.class);
		solo.clickOnButton("noButton");
		assertTrue(solo.waitForActivity("MainActivity"));
	}
	
	public void testCheckButton() throws Exception {
		solo.assertCurrentActivity("right activity", PictureView.class);
		solo.clickOnButton("yesButton");
		assertTrue(solo.waitForText("Picture Sent"));
	}
}
