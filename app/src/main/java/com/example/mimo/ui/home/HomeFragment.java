package com.example.mimo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mimo.R;
import com.example.mimo.entity.profile.User;
import com.example.mimo.ui.base.BaseFragment;
import com.example.mimo.ui.login.LoginActivity;
import com.example.mimo.utils.SharedPreferenceUtil;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    Picasso picasso;
    @Inject
    SharedPreferenceUtil sharedPreferenceUtil;

    @BindView(R.id.picture)
    ImageView picture;
    @BindView(R.id.name)
    TextView name;

    @Inject
    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, root);
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_frag_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                presenter.logout();
                break;
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
        presenter.loadProfile();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    @Override
    public void showProfile(User user) {
        picasso.load(user.getPicture()).into(picture);
        name.setText(user.getName());
    }

    @Override
    public void showLoadProfileError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void logout() {
        sharedPreferenceUtil.reset();
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
