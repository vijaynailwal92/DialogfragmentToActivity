package com.vijay.dialogfragmenttoactivity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyDialogFragment extends DialogFragment {

    TextView customDialog_TextView;
    EditText customDialog_EditText;
    Button customDialog_Dismiss;

    static MyDialogFragment newInstance() {
        return new MyDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.customlayout, container, false);
        customDialog_TextView = dialogView.findViewById(R.id.dialogtextview);
        customDialog_Dismiss = dialogView.findViewById(R.id.dialogdismiss);
        customDialog_Dismiss.setOnClickListener(customDialog_DismissOnClickListener);
        customDialog_EditText = dialogView.findViewById(R.id.dialogedittext);
        return dialogView;
    }


    private Button.OnClickListener customDialog_DismissOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            EditDialogListener activity = (EditDialogListener) getActivity();
            activity.updateResult(customDialog_EditText.getText().toString());
            dismiss();
        }
    };

    public interface EditDialogListener {
        void updateResult(String inputText);
    }

}
