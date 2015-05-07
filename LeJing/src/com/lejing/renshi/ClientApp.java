package com.lejing.renshi;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

import com.lejing.renshi.common.Constant;
import com.lejing.renshi.common.SessionManager;
import com.lejing.renshi.util.LogUtil;

//应用程序入口
public class ClientApp extends Application {
	private SessionManager sm;

	private static ClientApp mInstance = null;
	public boolean m_bKeyRight = true;
	
	public void onCreate() {
		
		super.onCreate();
		
		mInstance = this;
		
		
		//初始化session。
		sm = SessionManager.getInstance();

		initSystemInfo();
		SharedPreferences settings = getSharedPreferences(Constant.PREFS_NAME,
				MODE_PRIVATE);
		
		sm.setToken(settings.getString(Constant.TOKEN,""));
		sm.setUsername(settings.getString(Constant.USER_NAME, ""));
		
	}
	
	
	public static ClientApp getInstance() {
		return mInstance;
	}
	
	
	
	private void initSystemInfo() {
		String versionName = "";
		try {
			PackageInfo info = getPackageManager().getPackageInfo(
					getPackageName(), 0);
			versionName = info.versionCode + ";" + info.versionName;
		} catch (Exception e) {
			LogUtil.e(e.getMessage(), e);
		}

		sm.setAppVersion(versionName);
	}

	//获取手机的系统信息
	@SuppressWarnings("deprecation")
	public String getSystemData() {
		String sysInfo = "";
		try {
			TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

			sysInfo = Build.BRAND + "," + Build.MODEL + "," + Build.VERSION.SDK
					+ "," + manager.getLine1Number() + ","
					+ manager.getDeviceId() + ","
					+ manager.getDeviceSoftwareVersion() + ","
					+ manager.getNetworkOperator() + ","
					+ manager.getNetworkCountryIso() + ","
					+ manager.getSimSerialNumber() + ","
					+ manager.getSimOperator() + ","
					+ manager.getSubscriberId() + "," + getBaseInfo(manager);
		} catch (Exception e) {
			LogUtil.e(e.getMessage(), e);
		}

		return sysInfo;
	}

	public String getBaseInfo(TelephonyManager manager) {
		if (manager == null) {
			manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		}
		int bid1 = 0, bid2 = 0;

		if (manager.getPhoneType() == TelephonyManager.PHONE_TYPE_GSM) {
			GsmCellLocation gsm = (GsmCellLocation) manager.getCellLocation();
			if (gsm != null) {
				bid1 = gsm.getCid();
				bid2 = gsm.getLac();
			}
		}

		return bid1 + "," + bid2;
	}

	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	public void onLowMemory() {
		super.onLowMemory();
	}
	
	public void onTerminate() {
		super.onTerminate();
		
    }

}
