package com.vijay.dialogfragmenttoactivity;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.EditDialogListener {

    String result = "";
    TextView textReturned;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textReturned = (TextView)findViewById(R.id.textreturned);

        Button buttonStartDialog = (Button)findViewById(R.id.startdialog);
        buttonStartDialog.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                DialogFragment newFragment = MyDialogFragment.newInstance();
                newFragment.show(getFragmentManager(), "dialog");

            }});
    }

    public void updateResult(String inputText) {
        result = inputText;
        textReturned.setText(result);

    }

}
