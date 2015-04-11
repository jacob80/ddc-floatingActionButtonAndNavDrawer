package com.example.jacob.materialtest;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import static com.example.jacob.materialtest.R.*;
import static com.example.jacob.materialtest.R.id.*;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main_appbar);

        toolbar = (Toolbar) findViewById(app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        // Floating Action Button
        ImageView imageView = new ImageView(this); // Create an icon
        imageView.setImageResource(drawable.target);

        ImageView iconAddGauge = new ImageView(this);
        iconAddGauge.setImageResource(drawable.plus);

        ImageView iconDeleteAllGauges = new ImageView(this);
        iconDeleteAllGauges.setImageResource(drawable.delete);

        ImageView iconSettings = new ImageView(this);
        iconSettings.setImageResource(drawable.process);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(imageView)
                .setBackgroundDrawable(drawable.delete)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        SubActionButton buttonAddGauge = itemBuilder.setContentView(iconAddGauge).build();
        SubActionButton buttonDeleteAllGauges = itemBuilder.setContentView(iconDeleteAllGauges).build();
        SubActionButton buttonSettings = itemBuilder.setContentView(iconSettings).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonAddGauge)
                .addSubActionView(buttonDeleteAllGauges)
                .addSubActionView(buttonSettings)
                .attachTo(actionButton)
                .build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == action_settings) {
            Toast.makeText(this, "You pushed " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == navigate) {
            startActivity(new Intent(this, SubActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
