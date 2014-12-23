package com.ind.floatlabeleditext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class MainActivity extends Activity {
FloatLabelEditText userName, passWord, confirmPassword, phoneNumber, address;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userName  = (FloatLabelEditText)findViewById(R.id.username);
		passWord = (FloatLabelEditText)findViewById(R.id.password);
		confirmPassword  = (FloatLabelEditText)findViewById(R.id.confpassword);
		phoneNumber = (FloatLabelEditText)findViewById(R.id.phone);
		address = (FloatLabelEditText)findViewById(R.id.address);
		setAnimator();
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
	public void setAnimator(){
		userName.setLabelAnimator(new CustomLabelAnimator());
		passWord.setLabelAnimator(new CustomLabelAnimator());
		confirmPassword.setLabelAnimator(new CustomLabelAnimator());
		phoneNumber.setLabelAnimator(new CustomLabelAnimator());
		address.setLabelAnimator(new CustomLabelAnimator());
		address.setMultiLine();
	}
    private static class CustomLabelAnimator implements FloatLabelEditText.LabelAnimator {
        /*package*/ static final float SCALE_X_SHOWN = 1f;
        /*package*/ static final float SCALE_X_HIDDEN = 2f;
        /*package*/ static final float SCALE_Y_SHOWN = 1f;
        /*package*/ static final float SCALE_Y_HIDDEN = 0f;

        @Override
        public void onDisplayLabel(View label) {
            final float shift = label.getWidth() / 2;
            ViewHelper.setScaleX(label,SCALE_X_HIDDEN);
            ViewHelper.setScaleY(label,SCALE_Y_HIDDEN);
            ViewHelper.setX(label, shift);
            ViewPropertyAnimator.animate(label).alpha(1).scaleX(SCALE_X_SHOWN).scaleY(SCALE_Y_SHOWN).x(0f);
        }

        @Override
        public void onHideLabel(View label) {
            final float shift = label.getWidth() / 2;
            ViewHelper.setScaleX(label,SCALE_X_SHOWN);
            ViewHelper.setScaleY(label,SCALE_Y_SHOWN);
            ViewHelper.setX(label,0f);
            ViewPropertyAnimator.animate(label).alpha(0).scaleX(SCALE_X_HIDDEN).scaleY(SCALE_Y_HIDDEN).x(shift);
        }
    }

}
