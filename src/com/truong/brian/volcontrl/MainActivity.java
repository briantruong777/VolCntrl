package com.truong.brian.volcontrl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
  private Button button1;
  private Button button2;
  private Context thisActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    thisActivity = this;
    button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v)
      {
        startService(new Intent(thisActivity, VolSoundInterceptorService.class));
      }
    });
    button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v)
      {
        stopService(new Intent(thisActivity, VolSoundInterceptorService.class));
      }
    });
  }
  
  @Override
  public void onResume()
  {
    super.onResume();
  }
  
  @Override
  public void onPause()
  {
    super.onPause();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

}
