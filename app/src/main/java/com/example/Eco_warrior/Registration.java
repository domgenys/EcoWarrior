package com.example.Eco_warrior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Registration extends AppCompatActivity {

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    EditText nameButton, lnameButton, emailButton, pswButton, repswButton;
    Button signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        nameButton = findViewById(R.id.nameButton);
        lnameButton = findViewById(R.id.lnameButton);
        emailButton = findViewById(R.id.emailButton);
        pswButton = findViewById(R.id.pswButton);
        repswButton = findViewById(R.id.repswButton);
        signupButton = findViewById(R.id.signupButton);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //Validations with if statement for empty registration form gaps

                if (nameButton.getText().toString().isEmpty() || lnameButton.getText().toString().isEmpty() ||
                        emailButton.getText().toString().isEmpty() || pswButton.getText().toString().isEmpty() ||
                        repswButton.getText().toString().isEmpty())
                {
                    Toast.makeText(Registration.this, "Please fill all the empty gaps", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pswButton.getText().toString().trim().equals(repswButton.getText().toString().trim()))
                    {
                        String name = nameButton.getText().toString().trim();
                        String lastname = lnameButton.getText().toString().trim();
                        String email = emailButton.getText().toString().trim();
                        String password = pswButton.getText().toString().trim();


                        // Define the new users
                        BackendlessUser user = new BackendlessUser();
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setProperty("name", name);
                        user.setProperty("lastname", lastname);

                        showProgress(true);
                        tvLoad.setText("Wait a second , registering you");

                        //Set up user in Backendless databsase if not exsist
                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                showProgress(false);
                                Toast.makeText(Registration.this, "Congrats, Succesfully registered", Toast.LENGTH_SHORT).show();
                                Registration.this.finish();
                            }
                            //if user exist , error message will display
                            @Override
                            public void handleFault(BackendlessFault fault) {

                                Toast.makeText(Registration.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();
                                showProgress(false);

                            }
                        });

                    }
                    else{
                        Toast.makeText(Registration.this, "Passwords must match !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
// for very easy animations. If available, use these APIs to fade-in
// the progress spinner.
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
// The ViewPropertyAnimator APIs are not available, so simply show
// and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}