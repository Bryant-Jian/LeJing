package com.lejing.renshi;

import org.apache.http.protocol.HTTP;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.lejing.renshi.user.LoginActivity;

@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
public class MainActivity extends ActionBarActivity {
	public static MainActivity instanse = null;
	//private static Handler handle = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		instanse = this;
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	public static class PlaceholderFragment extends Fragment {

		private WebView webView;
		private Button btn;
		public PlaceholderFragment() {
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_main, container,
					false);
			webView = (WebView) view.findViewById(R.id.main_webview);
			webView.getSettings().setDefaultTextEncodingName(HTTP.UTF_8);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.addJavascriptInterface(new InJavaScript(), "injs");
			webView.loadUrl("file:///android_asset/www.famibao.cn/view/user/login.html");
			
			btn = (Button) view.findViewById(R.id.butn);
			btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					webView.loadUrl("javascript:funfromjs()");
					Toast.makeText(instanse, "hehe 不错哦!", Toast.LENGTH_LONG).show();
					
					Intent intent = new Intent("huohuo");
					intent.putExtra("name", "fuckyuou");
					intent.putExtra("bb", "xbb");
					instanse.sendBroadcast(intent);
					
					Intent intentA = new Intent();
					intentA.setClass(instanse, MultiScrollActivity.class);
					startActivity(intentA);
				}
			});
			
			//设置WebChromeClient  
			webView.setWebChromeClient(new WebChromeClient(){  
			    //处理javascript中的alert  
			    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {  
			        //构建一个Builder来显示网页中的对话框  
			        Builder builder = new Builder(instanse);  
			        builder.setTitle("Alert");  
			        builder.setMessage(message);  
			        builder.setPositiveButton(android.R.string.ok,  
			            new AlertDialog.OnClickListener() {  
			                public void onClick(DialogInterface dialog, int which) {  
			                    result.confirm();  
			                }  
			            });  
			        builder.setCancelable(false);  
			        builder.create();  
			        builder.show();  
			        return true;  
			    };
			  //处理javascript中的confirm  
			    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {  
			        Builder builder = new Builder(instanse);  
			        builder.setTitle("confirm");  
			        builder.setMessage(message);  
			        builder.setPositiveButton(android.R.string.ok,  
			            new AlertDialog.OnClickListener() {  
			                public void onClick(DialogInterface dialog, int which) {  
			                    result.confirm();  
			                }  
			            });  
			        builder.setNegativeButton(android.R.string.cancel,  
			            new DialogInterface.OnClickListener() {  
			                public void onClick(DialogInterface dialog, int which) {  
			                    result.cancel();  
			                }  
			            });  
			        builder.setCancelable(false);  
			        builder.create();  
			        builder.show();  
			        return true;  
			    };  
			          
			    @Override  
			    //设置网页加载的进度条  
			    public void onProgressChanged(WebView view, int newProgress) {  
			        instanse.getWindow().setFeatureInt(Window.FEATURE_PROGRESS, newProgress * 100);  
			        super.onProgressChanged(view, newProgress);  
			    }  
			  
			    //设置应用程序的标题title  
			    public void onReceivedTitle(WebView view, String title) {  
			    	instanse.setTitle(title);  
			        super.onReceivedTitle(view, title);  
			    }  
			}); 
			return view;
		}
		
		public final static class InJavaScript{
			@JavascriptInterface
			public void runOnAndroidJavaScript(){
				Toast.makeText(instanse, "welcome to android ", Toast.LENGTH_LONG).show();
				Intent intent = new Intent();
				intent.setClass(instanse, LoginActivity.class);
				instanse.startActivity(intent);
			}
		}
		
	}

	
}
