package com.maverick.LintonDevSpace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class About extends AppCompatActivity
{

    Button back;

    LinearLayout twitter,lk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        twitter=findViewById(R.id.twitter);
        lk=findViewById(R.id.lk);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {
                        Intent intent = null;
                        try {

                            getPackageManager().getPackageInfo("", 0);
                            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        } catch (Exception e) {

                            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                        }
                        startActivity(intent);
            }
        });


        lk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                final PackageManager packageManager = getPackageManager();
                final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                if (list.isEmpty()) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                }
                startActivity(intent);

            }
        });
    }
}