package kz.telp.easywidget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;

import android.os.UserHandle;
import android.os.UserManager;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ToggleButton;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Locale;
import android.view.Menu;

import kz.telp.easywidget.R;

public class MainActivity extends Activity implements OnClickListener {

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == tbWiFi.getId()) {
			wifi.setWifiEnabled(tbWiFi.isChecked());
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		initButton();
	}
	
	private void initButton() {
		if
		(isConnected(this, ConnectivityManager.TYPE_WIFI)) {
			tbWiFi.setChecked(true);
		}
	}
	
	private static ConnectivityManager connectivityManager;
	private ToggleButton tbWiFi;
	private WifiManager wifi;
	
	private static boolean 
	isConnected(Context context, int networkType) {
		NetworkInfo networkInfo = null;
		if (connectivityManager != null) {
			networkInfo = connectivityManager.getNetworkInfo(networkType);
		}
		return networkInfo == null ? false
				: networkInfo.isConnected();
	}
	

}
