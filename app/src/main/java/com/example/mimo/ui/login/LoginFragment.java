package com.example.mimo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mimo.ui.InputValidators;
import com.example.mimo.ui.InputValidators.ValidationException;
import com.example.mimo.ui.base.BaseFragment;
import com.example.mimo.R;
import com.example.mimo.entity.account.AccessToken;
import com.example.mimo.ui.home.HomeActivity;
import com.example.mimo.ui.signup.SignUpActivity;
import com.example.mimo.utils.SharedPreferenceUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mimo.ui.InputValidators.isNullOrEmpty;
import static com.example.mimo.ui.InputValidators.isValidEmail;
import static com.example.mimo.ui.InputValidators.isValidPassword;

public class LoginFragment extends BaseFragment implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;
    @Inject
    protected SharedPreferenceUtil sharedPreferenceUtil;

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;

    @Inject
    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_frag, container, false);
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

    @OnClick(R.id.sign_in)
    void signIn() {
        try {
            validate();
            presenter.login(email.getText().toString(), password.getText().toString());
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
            showLoginError(e.getMessage());
    }

    @OnClick(R.id.register)
    void register() {
        Intent intent = new Intent(getContext(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginSuccessful(AccessToken accessToken) {
        sharedPreferenceUtil.setAuthToken(accessToken.getAccessToken());
        sharedPreferenceUtil.setAuthTokenType(accessToken.getTokenType());

        Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
        startActivity(homeIntent);

        getActivity().finish();
    }

    @Override
    public void showLoginError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }
}
