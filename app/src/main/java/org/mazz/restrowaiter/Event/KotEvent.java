package org.mazz.restrowaiter.Event;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import android.widget.Toolbar;

import org.mazz.restrowaiter.KotActivity;
import org.mazz.restrowaiter.TableActivity;


public class KotEvent {


    public static void kotNavigation(final Context context, android.support.v7.widget.Toolbar kotToolbar) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            kotToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // back button pressed
                    Intent myIntent = new Intent(context, TableActivity.class);
                    context.startActivity(myIntent);


                }
            });
        }
    }
}
