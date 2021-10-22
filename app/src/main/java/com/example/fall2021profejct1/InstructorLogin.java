package com.example.fall2021profejct1;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class InstructorLogin extends DialogFragment {

    private EditText instructorUsername;
    private EditText instructorPassword;
    private InstructorLoginListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder instructorBuilder = new AlertDialog.Builder(getActivity());
        instructorBuilder.setMessage("Sign in");

        LayoutInflater inflator = getActivity().getLayoutInflater();
        View view = inflator.inflate(R.layout.instructor_dialog, null);
        instructorBuilder.setView(view);

        instructorBuilder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = instructorUsername.getText().toString();
                String password = instructorPassword.getText().toString();
                listener.instructorText(username, password);
            }
        });

        instructorBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        instructorUsername = view.findViewById(R.id.instructorUsername);
        instructorPassword = view.findViewById(R.id.instructorPassword);
        return instructorBuilder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (InstructorLoginListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface InstructorLoginListener{
        void instructorText(String username, String password);
    }
}
