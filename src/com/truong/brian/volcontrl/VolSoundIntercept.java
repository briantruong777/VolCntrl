package com.truong.brian.volcontrl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class VolSoundIntercept extends BroadcastReceiver
{
  private int count = 0;
  
	@Override
	public void onReceive(Context context, Intent intent)
	{
	  int curRing = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
	  int curVal = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
    int prevVal = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);
    Log.i("blah", curRing + " " + curVal + " " + prevVal);
	  if (curRing != -1 && curVal != -1 && prevVal != -1)
    {
      count++;
      Log.i("blah", ""+count);
      if (count <= 1)
      {
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        am.adjustStreamVolume(curRing, AudioManager.ADJUST_SAME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        Log.i("blah", "trigger");
      }
      else
      {
        count = 0;
        Log.i("blah", ""+count);
      }
    }
	}
}
