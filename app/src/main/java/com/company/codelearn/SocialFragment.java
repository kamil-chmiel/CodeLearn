package com.company.codelearn;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.company.codelearn.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
        Button shareButton = view.findViewById(R.id.share_button);
        shareButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Check out my score in CodeLearn app! Download it for free from Google Play and try to beat me!";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Learn new skills with CodeLearn");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
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
        List<Friend> friends = new ArrayList<Friend>();

        UserData currentUser = new UserData(FirebaseAuth.getInstance().getCurrentUser());
        // get friend ids
        List<UserData> friendsData =  new DatabaseHelper(getActivity()).getFriendList(currentUser);

        // for - get friends names with ids
        for(UserData friend : friendsData) {
            friends.add(new Friend(friend.getName(), new DatabaseHelper(getActivity()).getUserPoints(friend)));
        }

        Collections.sort(friends, new PointsComparator());


        ListView listView = (ListView) getView().findViewById(R.id.friends_list);
        listView.setDivider(null);
        adapter = new FriendsListAdapter(getActivity(), friends);

        listView.setAdapter(adapter);
    }
}

class FriendsListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Friend> data;
    private static LayoutInflater inflater=null;

    public FriendsListAdapter(Activity a, List<Friend> d) {
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
        TextView points = (TextView)vi.findViewById(R.id.friend_points);

        name.setText(data.get(position).name);
        points.setText(Integer.toString(data.get(position).points));

        return vi;
    }
}

class Friend {
    String name;
    Integer points;

    public Friend(String name, Integer points) {
        this.name = name;
        this.points = points;
    }
}

class PointsComparator implements Comparator<Friend> {
    @Override
    public int compare(Friend a, Friend b) {
        return a.points < b.points ? 1 : a.points.equals(b.points) ? 0 : -1;
    }
}