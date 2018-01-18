package com.oc.rss.oc_rss;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    Context myContext;
    TextView textViewHtmlContent;
    WebView webViewHtmlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = this;
        setContentView(R.layout.activity_main);
        setTitle("Tuto Appli OpenClassRoom");
        myButton = (Button)findViewById(R.id.btnClickHere);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, "CA MARCHE !", Toast.LENGTH_SHORT).show();
                Log.i("haja", "Ca marche !!!");
                Intent myIntent = new Intent(myContext, NextActivity.class);
                startActivity(myIntent);
                MainActivity.this.finish(); // we closed this activity after launch the new one
            }
        });

        //textViewHtmlContent = (TextView)findViewById(R.id.tvHTMLText);
        //loadHtmlText();
        webViewHtmlContent = (WebView)findViewById(R.id.wvHTMLText);

        // Ouvre les pages dans le même webview
        webViewHtmlContent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return false;
            }
        });

        // active javascript sur la webview
        webViewHtmlContent.getSettings().setJavaScriptEnabled(true);

        loadHtmlWebView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(MainActivity.this, "ADD !", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_edit:
                Toast.makeText(MainActivity.this, "EDIT !", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(MainActivity.this, "DELETE !", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadHtmlText(){
        final InputStream stream = getResources().openRawResource(R.raw.content);
        final String text;
        try {
            text = IOUtils.toString(stream);
            textViewHtmlContent.setText(Html.fromHtml(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHtmlWebView(){
        webViewHtmlContent.loadUrl("file:///android_asset/page.html");
    }

}
