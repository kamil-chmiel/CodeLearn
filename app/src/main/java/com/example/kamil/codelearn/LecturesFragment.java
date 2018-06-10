package com.example.kamil.codelearn;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LecturesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LecturesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LecturesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private OnFragmentInteractionListener mListener;
    private static CustomAdapter adapter;

    public LecturesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LecturesFragment newInstance() {
        LecturesFragment fragment = new LecturesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList lectures = new ArrayList<LecturesCell>();

        lectures.add(new LectureSectionCell("Basic syntax", 0, 100, new Date()));
        lectures.add(new LectureCell("Lekcja nr1", 0, 10));
        lectures.add(new LectureCell("Lekcja nr2", 0, 20));

        ListView listView = (ListView) getView().findViewById(R.id.lectures_list);
        adapter = new CustomAdapter(getActivity(), lectures);

        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lectures, container, false);
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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


}

class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<LecturesCell> data;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Activity a, ArrayList<LecturesCell> d) {
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

        if(data.get(position).type == CellType.section) {
            if(convertView==null)
                vi = inflater.inflate(R.layout.lecture_section_cell, null);
        }
        else {
            if(convertView==null)
                vi = inflater.inflate(R.layout.lecture_cell, null);
        }


//        TextView title = (TextView)vi.findViewById(R.id.title); // title
//        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
//        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
//        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
//
//        HashMap&lt;String, String&gt; song = new HashMap&lt;String, String&gt;();
//        song = data.get(position);
//
//        // Setting all values in listview
//        title.setText(song.get(CustomizedListView.KEY_TITLE));
//        artist.setText(song.get(CustomizedListView.KEY_ARTIST));
//        duration.setText(song.get(CustomizedListView.KEY_DURATION));
//        imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}