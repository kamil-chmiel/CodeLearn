package com.company.codelearn;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_profile, container, false);
        Button editProfileButton = (Button) inflatedView.findViewById(R.id.editProfileButton);

        updateUserInfo(inflatedView);

        editProfileButton.setOnClickListener(view -> {
            Intent intentEditProfile = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intentEditProfile);
        });

        return inflatedView;
    }

    private void updateUserInfo(View inflatedView) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView profileEmail = inflatedView.findViewById(R.id.profile_email);
        profileEmail.setText(user.getEmail());

        TextView profileLevel = inflatedView.findViewById(R.id.profile_level);
        profileLevel.setText("666");

        TextView profileLogin = inflatedView.findViewById(R.id.profile_login);
        profileLogin.setText(user.getDisplayName());

        TextView profilePoints = inflatedView.findViewById(R.id.profile_points);
        profilePoints.setText("666");

        TextView profileCompleted = inflatedView.findViewById(R.id.profile_cop);
        profileCompleted.setText("666");
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
