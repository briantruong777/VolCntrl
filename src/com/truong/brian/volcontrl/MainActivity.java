package com.truong.brian.volcontrl;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
  private Button button;
  private VolSoundIntercept br;
  private IntentFilter intFil;
  private Context thisActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    thisActivity = this;
    button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v)
      {
        startService(new Intent(thisActivity, VolSoundInterceptorService.class));
      }
    });
    br = new VolSoundIntercept();
//    intFil = new IntentFilter(AudioManager.VOLUME_CHANGED_ACTION);
    intFil = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
  }
  
  @Override
  public void onResume()
  {
    super.onResume();
    registerReceiver(br, intFil);
  }
  
  @Override
  public void onPause()
  {
    super.onPause();
    unregisterReceiver(br);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

}
