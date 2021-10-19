package com.example.fall2021profejct1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class AdminLogIn extends DialogFragment {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private AdminLogInListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //builder is the name of the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //creates the message
        builder.setMessage("Sign In");

        //Uses the adminlog.xml to create the body of the dialog
        LayoutInflater inflator = getActivity().getLayoutInflater();
        View view = inflator.inflate(R.layout.adminlog, null);
        builder.setView(view);

        //Positive button sends the information to the main activity
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                listener.applyTexts(username, password);
                Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
            }
        });

        //negative button cancels the dialog
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        //The edit texts that the user changes
        editTextUsername = view.findViewById(R.id.adminUsername);
        editTextPassword = view.findViewById(R.id.adminPassword);
        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (AdminLogInListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    //Interface that the main activity implements
    //Send the info to the main activity
    public interface AdminLogInListener{
        void applyTexts(String username, String password);
    }
}
