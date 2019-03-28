package com.example.android.webbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  Intent main = new Intent(Splash.this, MainActivity.class);
                  Splash.this.startActivity(main);
                  Splash.this.finish();
              }
          }, 1000);
    }
}
