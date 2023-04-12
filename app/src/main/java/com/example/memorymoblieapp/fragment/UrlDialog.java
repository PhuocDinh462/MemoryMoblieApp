package com.example.memorymoblieapp.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.memorymoblieapp.R;
import com.example.memorymoblieapp.main.MainActivity;

public class UrlDialog extends DialogFragment {
    private String url;

    public String getUrl() {
        return url;
    }

    public static String Tag = "URLDialog";
    private EditText edtURL;
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            main = (MainActivity) getActivity();
        }
        catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder urlDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.url_dialog, null);
        urlDialog.setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        url = edtURL.getText().toString();
                        dismiss();
                        main.onMsgFromFragToMain( url);
                    }
                });

        edtURL = (EditText) view.findViewById(R.id.edtURL);
        return urlDialog.create();
    }
}
