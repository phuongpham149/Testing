package com.example.asiantech.testing;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import static com.example.asiantech.testing.DialogEditText.showKeyboardMachine;

public class MainActivity extends AppCompatActivity {
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnClick = (Button) findViewById(R.id.click);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DialogEditText dFragment = new DialogEditText();
                // Show DialogFragment
                //dFragment.show(getSupportFragmentManager(), "DialogEditText Fragment");
                showDialog();
            }
        });
    }

    public void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_fragment);
        dialog.setTitle("Title...");
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(lp);
        final EditText edt1 = (EditText) dialog.findViewById(R.id.etPassCode1);
        final EditText edt2 = (EditText) dialog.findViewById(R.id.etPassCode2);
        final EditText edt3 = (EditText) dialog.findViewById(R.id.etPassCode3);
        final EditText edt4 = (EditText) dialog.findViewById(R.id.etPassCode4);

        final EditText edt = (EditText) dialog.findViewById(R.id.edtHiddenInput);

        showKeyboardMachine(this,edt);

        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.requestFocus();
            }
        });

        edt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.requestFocus();
            }
        });

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                switch (charSequence.length()) {
                    case 0:
                        edt1.setText("");
                        edt2.setText("");
                        edt3.setText("");
                        edt4.setText("");
                        break;
                    case 1:
                        edt1.setText(String.valueOf(charSequence.charAt(0)));
                        edt2.setText("");
                        edt3.setText("");
                        edt4.setText("");
                        break;
                    case 2:
                        edt2.setText(String.valueOf(charSequence.charAt(1)));
                        edt3.setText("");
                        edt4.setText("");
                        break;
                    case 3:
                        edt3.setText(String.valueOf(charSequence.charAt(2)));
                        edt4.setText("");
                        break;
                    case 4:
                        edt4.setText(String.valueOf(charSequence.charAt(3)));
                        Log.d(getClass().getSimpleName(), "ok fine");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }) ;
//        // set the custom dialog components - text, image and button
//        TextView text = (TextView) dialog.findViewById(R.id.text);
//        text.setText("Android custom dialog example!");
//        ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        image.setImageResource(R.drawable.ic_launcher);
//
//        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
//        // if button is clicked, close the custom dialog
//        dialogButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });

        dialog.show();
    }
}
