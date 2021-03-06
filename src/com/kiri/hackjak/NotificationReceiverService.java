package com.kiri.hackjak;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiverService extends BroadcastReceiver {
	private String mAction;
	private Navigation mNavigation;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		mAction = intent.getAction();
		mNavigation = Navigation.getInstance();
		if(mAction.equals(Navigation.ACTION_PREV)) {
			mNavigation.actionPrev();
			mNavigation.redraw();
		} else if(mAction.equals(Navigation.ACTION_STOP)) {
			mNavigation.actionStop();
		} else if(mAction.equals(Navigation.ACTION_NEXT)) {
			mNavigation.actionNext();
			mNavigation.redraw();
		}
	}
}
