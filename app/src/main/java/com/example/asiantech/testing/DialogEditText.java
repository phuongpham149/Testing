package com.example.asiantech.testing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 05/07/2017.
 */
public class DialogEditText extends DialogFragment implements View.OnClickListener{
    private EditText mTv1;
    private EditText mTv2;
    private EditText mTv3;
    private EditText mTv4;
    private EditText mEdt;
    private TextView mTv;



    @Override
    public void onStart() {
        super.onStart();
        android.app.Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_fragment, container,
                false);
        getDialog().setTitle("DialogFragment Tutorial");

        mTv1 = (EditText) rootView.findViewById(R.id.etPassCode1);
        mTv2 = (EditText) rootView.findViewById(R.id.etPassCode2);
        mTv3 = (EditText) rootView.findViewById(R.id.etPassCode3);
        mTv4 = (EditText) rootView.findViewById(R.id.etPassCode4  );
        mEdt = (EditText) rootView.findViewById(R.id.edtHiddenInput);
        mTv = (TextView) rootView.findViewById(R.id.tvPassCodeMessage);
        mEdt.requestFocus();

        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mTv1.clearFocus();
                mTv.setVisibility(View.VISIBLE);
                mEdt.requestFocus();
                Log.d(getClass().getSimpleName(),"string ====");
            }
        });

        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTv.setVisibility(View.VISIBLE);
                mEdt.requestFocus();
            }
        });
        //mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);
        mTv4.setOnClickListener(this);

        mEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switch (s.length()){
                    case 0:
                        mTv1.setText("");
                        mTv2.setText("");
                        mTv3.setText("");
                        mTv4.setText("");
                        break;
                    case 1:
                        mTv1.setText(String.valueOf(s.charAt(0)));
                        mTv2.setText("");
                        mTv3.setText("");
                        mTv4.setText("");
                        break;
                    case 2:
                        mTv2.setText(String.valueOf(s.charAt(1)));
                        mTv3.setText("");
                        mTv4.setText("");
                        break;
                    case 3:
                        mTv3.setText(String.valueOf(s.charAt(2)));
                        mTv4.setText("");
                        break;
                    case 4:
                        mTv4.setText(String.valueOf(s.charAt(3)));
                        Log.d(getClass().getSimpleName(),"ok fine");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Do something else
        return rootView;
    }

    public static void showKeyboardMachine(Context context, View view) {
        if (context != null && view != null) {
            if (view.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        showKeyboardMachine(getContext(),mEdt);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.etPassCode2:
            case R.id.etPassCode3:
            case R.id.etPassCode4:
                mEdt.requestFocus();
                Log.d(getClass().getSimpleName(),"string "+mEdt.getText()+" ==== "+mTv1
                .getText()+" ====1 "+mTv2.getText());
                break;
        }
    }
}
