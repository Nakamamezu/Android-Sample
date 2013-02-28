package com.oukasoft.ServiceSample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT; 

	LinearLayout ll;
    Button btnStart;
    Button btnStop;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        ll = new LinearLayout(this);
        ll.setGravity( Gravity.CENTER_VERTICAL);
        ll.setOrientation( LinearLayout.VERTICAL );
        
        btnStart = new Button(this);
        btnStop  = new Button(this);
        
        btnStart.setOnClickListener( new ServiceOnClickListener() );
        btnStop.setOnClickListener( new ServiceOnClickListener() );
        btnStart.setText("Service Start");
        btnStop.setText("Service Stop");
        ll.addView( btnStart,  WC );
        ll.addView( btnStop ,  WC );
        setContentView(ll);
    }

    class ServiceOnClickListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			Log.i("MainActivity", "onClick");
			if( view == btnStart ){
				Log.i("MainActivity", "btnStart");
				startService( new Intent( MainActivity.this, TestService.class ) );
			}else if( view == btnStop ){
				Log.i("MainActivity", "btnStop");
				stopService( new Intent( MainActivity.this, TestService.class ) );
			}
		}

    }

    
}
