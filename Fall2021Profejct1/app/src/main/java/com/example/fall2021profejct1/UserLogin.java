package com.example.fall2021profejct1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class UserLogin extends DialogFragment {

    private EditText userUsername;
    private EditText userPassword;
    private UserLoginListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder userBuilder = new AlertDialog.Builder(getActivity());
        userBuilder.setMessage("Sign In");

        LayoutInflater inflator = getActivity().getLayoutInflater();
        View view = inflator.inflate(R.layout.user_dialog, null);
        userBuilder.setView(view);

        userBuilder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = userUsername.getText().toString();
                String password = userPassword.getText().toString();
                listener.userText(username, password);
                Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
            }
        });

        userBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        userUsername = view.findViewById(R.id.userUsername);
        userPassword = view.findViewById(R.id.userPassword);
        return userBuilder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (UserLoginListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface UserLoginListener{
        void userText(String username, String password);
    }
}
