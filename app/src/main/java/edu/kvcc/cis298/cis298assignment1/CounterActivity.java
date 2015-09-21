// Author: Robert Peck
// Date: 09/21/2015
// Assignment 1

package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    // Private Variables For The Interface
    private Button mAddButton;
    private Button mSubtractButton;
    private TextView mTextOutput;

    // Private Variables For Toast And Counting
    private int mCounter = 0;
    private boolean mCountFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Finds The Add Button, Adds One To The Counter, Outputs The Current Count,
        // Checks To See If The Count Is Over 20 And Displays Toast, Sets The Boolean
        // So The Toast Will Only Go Off Once.
        mAddButton = (Button) findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter++;

                mTextOutput = (TextView) findViewById(R.id.output_Text);
                mTextOutput.setText(mCounter+"");

                if(mCounter >20 && mCountFlag == false)
                {
                    mCountFlag = true;
                    Toast.makeText(CounterActivity.this,
                            "You Have Passed 20 People",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Finds The Subtract Button, Subtracts One From The Counter, Outputs The Current Count,
        // Checks To See If the Count Is Below The Flag Amount And Checks To See If It's Already
        // Been Flagged To Reset The Flag.
        mSubtractButton = (Button) findViewById(R.id.subtract_one);
        mSubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter--;

                mTextOutput = (TextView) findViewById(R.id.output_Text);
                mTextOutput.setText(mCounter+"");

                if (mCounter <21 && mCountFlag == true)
                {
                    mCountFlag = false;
                }
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
