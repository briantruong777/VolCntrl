package com.truong.brian.volcontrl;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class VolSoundInterceptorService extends Service
{
  private VolSoundIntercept br;
  private IntentFilter intFil;
  
  @Override
  public void onCreate()
  {

    br = new VolSoundIntercept();
    intFil = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
    registerReceiver(br, intFil);
  }
  
  @Override
  public void onDestroy()
  {
    unregisterReceiver(br);
  }

  @Override
  public IBinder onBind(Intent intent)
  {
    return null;
  }

}
