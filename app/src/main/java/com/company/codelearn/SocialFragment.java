package com.company.codelearn;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SocialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SocialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private static FriendsListAdapter adapter;

    public SocialFragment() {
        // Required empty public constructor
    }

    public static SocialFragment newInstance() {
        SocialFragment fragment = new SocialFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fillList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void fillList() {
        ArrayList<String> friends = new ArrayList<String>();

        friends.add("Tomasz Mokrzenia");
        friends.add("Adam Niezdamytego");
        friends.add("Robert Górski");
        friends.add("Alicja Plażowa");
        friends.add("Stevie Wonder");
        friends.add("Maria Kalwaria");
        friends.add("Tom Belwer");
        friends.add("John Doe");


        ListView listView = (ListView) getView().findViewById(R.id.friends_list);
        listView.setDivider(null);
        adapter = new FriendsListAdapter(getActivity(), friends);

        listView.setAdapter(adapter);
    }
}

class FriendsListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> data;
    private static LayoutInflater inflater=null;

    public FriendsListAdapter(Activity a, ArrayList<String> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;

        vi = inflater.inflate(R.layout.friend_cell,parent,false);

        TextView name = (TextView)vi.findViewById(R.id.friend_name);

        name.setText(data.get(position));

        return vi;
    }
}