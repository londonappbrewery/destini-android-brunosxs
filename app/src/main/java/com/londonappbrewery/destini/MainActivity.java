package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mTextView;

    // State related vars

    String state;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (state == null){
            state = "T1";
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mTextView = (TextView) findViewById(R.id.storyTextView);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == "T1"){
                    changeState("T3");
                }

                else if (state == "T2"){
                    changeState("T3");
                }

                else if (state == "T3"){
                    changeState("T6");

                }

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == "T1"){
                    changeState("T2");
                }

                else if (state == "T2"){
                    changeState("T4");
                }
                else if (state == "T3"){
                    changeState("T5");
                }
            }
        });

    }
    void changeState( String newState){
        state = newState;
        String bTop;
        String bBottom;
        //This line grabs strings dynamically
        String vStory = (String) getResources().getText(getResources().getIdentifier(newState +"_Story","string", getPackageName()));

        if (state == "T6" || state =="T5" || state =="T4"){
            mButtonBottom.setVisibility(View.INVISIBLE);
            mButtonTop.setVisibility(View.INVISIBLE);
        }

        if (state == "T1" || state =="T2" || state =="T3"){
            bTop  = (String) getResources().getText(getResources().getIdentifier(newState +"_Ans1","string", getPackageName()));
            bBottom = (String) getResources().getText(getResources().getIdentifier(newState +"_Ans2","string", getPackageName()));
            mButtonTop.setText(bTop);
            mButtonBottom.setText(bBottom);
        }
        mTextView.setText(vStory);

    }
}
