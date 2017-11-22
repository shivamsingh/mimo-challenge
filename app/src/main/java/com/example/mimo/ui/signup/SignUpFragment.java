package com.example.mimo.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mimo.R;
import com.example.mimo.ui.InputValidators;
import com.example.mimo.ui.InputValidators.ValidationException;
import com.example.mimo.ui.base.BaseFragment;
import com.example.mimo.ui.login.LoginContract;
import com.example.mimo.utils.SharedPreferenceUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mimo.ui.InputValidators.isNullOrEmpty;
import static com.example.mimo.ui.InputValidators.isValidEmail;
import static com.example.mimo.ui.InputValidators.isValidPassword;

/**
 * Created by shivam on 18/11/17.
 */

public class SignUpFragment extends BaseFragment implements SignUpContract.View {

    @Inject
    SignUpContract.Presenter presenter;
    @Inject
    protected SharedPreferenceUtil sharedPreferenceUtil;

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;

    @Inject
    public SignUpFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.signup_frag, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    @OnClick(R.id.register)
    void register() {
        try {
            validate();
            presenter.signUp(email.getText().toString(), password.getText().toString());
        } catch (ValidationException e) {
            showValidationError(e);
        }
    }

    private void validate() throws ValidationException {
        isNullOrEmpty(email, email.getText().toString(), getString(R.string.validation_email_required));
        isNullOrEmpty(password, password.getText().toString(), getString(R.string.validation_password_required));
        isValidEmail(email, email.getText().toString(), getString(R.string.validation_invalid_email));
        isValidPassword(password, password.getText().toString(), getString(R.string.validation_invalid_password));
    }

    private void showValidationError(ValidationException e) {
        if (e.getSource() instanceof EditText)
            ((EditText) e.getSource()).setError(e.getMessage());
        else
            showSignUpError(e.getMessage());
    }

    @Override
    public void showSignUpSuccessful() {
        getActivity().finish();
        Toast.makeText(getContext(), "Registered successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSignUpError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }
}
