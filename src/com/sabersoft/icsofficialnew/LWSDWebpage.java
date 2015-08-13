package com.sabersoft.icsofficialnew;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class LWSDWebpage extends Activity{
	
	protected ProgressBar mProgressBar;
	
	   private static final String TAG = "DialogActivity";
	    private static final int DLG_EXAMPLE1 = 0;
	    private static final int TEXT_ID = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webpage);
		
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
		mProgressBar.setVisibility(View.VISIBLE);
		
		//Assign WebView to individual ID and create navigation button
		final WebView myWebView = (WebView) findViewById(R.id.webview);
		Button previousButton = (Button) findViewById(R.id.previousButton);
		previousButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myWebView.goBack(); } });
		
		//Modify the URL Settings and enable JavaScript 
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.loadUrl("http://www.lwsd.org/Students/Pages/default.aspx");
		myWebView.setWebViewClient(new WebViewClient() {
			
			   @Override
			   public void onPageFinished(WebView view, String url) {
				   //Hide Progress Bar once page has been loaded
				   mProgressBar.setVisibility(View.INVISIBLE);
			    }
			});
} }

