package com.example.shiva.flashtoggle;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=(ToggleButton) findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    try
                    {
                        String cameraid = cm.getCameraIdList()[0];
                        cm.setTorchMode(cameraid, true);
                        b =true;
                        Toast.makeText(MainActivity.this, "Flash On", Toast.LENGTH_SHORT).show();
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
                    else
                    {
                        try
                        {
                            String cameraid=cm.getCameraIdList()[0];
                            cm.setTorchMode(cameraid,false);
                            b=false;
                            Toast.makeText(MainActivity.this, "Flash Off", Toast.LENGTH_SHORT).show();
                        }
                        catch(CameraAccessException e)
                        {

                        }
                    }
                }
            });
                }
            }


