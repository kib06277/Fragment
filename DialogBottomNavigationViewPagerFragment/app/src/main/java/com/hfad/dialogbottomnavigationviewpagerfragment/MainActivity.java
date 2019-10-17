package com.hfad.dialogbottomnavigationviewpagerfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    DialogViewTest dialog = new DialogViewTest(MainActivity.this);
                    dialog.show(getSupportFragmentManager(), "MySelfDialog");
                }
                catch (Exception e)
                {
                    Log.i("EE","e = " + e);
                }
            }
        });
    }
}
