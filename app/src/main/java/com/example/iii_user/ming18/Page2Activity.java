package com.example.iii_user.ming18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class Page2Activity extends AppCompatActivity {      //測試用
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_p2); //直接對應到p2
        //res > new > Folder >  res Folder > 命名anim
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
    }
}
