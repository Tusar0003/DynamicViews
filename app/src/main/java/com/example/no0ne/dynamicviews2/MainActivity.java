package com.example.no0ne.dynamicviews2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveChanges();
                finish();
                return true;
        }
        
        return super.onOptionsItemSelected(item);
    }

    private void saveChanges() {

    }

    public void onAddField(View v) {
        id++;

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        parentLinearLayout.getChildAt(parentLinearLayout.getChildCount() - 1).setId(id);
        int showId = parentLinearLayout.getChildAt(parentLinearLayout.getChildCount() - 1).getId();

        Toast.makeText(this, "ID: " + showId, Toast.LENGTH_LONG).show();
    }

    public void onDelete(View v) {
        id--;
        parentLinearLayout.removeView((View) v.getParent());
    }
}
