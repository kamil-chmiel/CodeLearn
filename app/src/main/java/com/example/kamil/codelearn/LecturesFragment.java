package com.example.kamil.codelearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


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

        lectures.add(new LectureCell("Lekcja nr1", 3));

        ListView listView = (ListView) getView().findViewById(R.id.lectures_list);
        adapter = new CustomAdapter(lectures, getView().getContext());

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

    class CustomAdapter extends ArrayAdapter<LecturesCell> implements View.OnClickListener{

        private ArrayList<LecturesCell> dataSet;
        Context mContext;


        public CustomAdapter(ArrayList<LecturesCell> data, Context context) {
            super(context, R.layout.lecture_section_cell, data);
            this.dataSet = data;
            this.mContext=context;

        }

        @Override
        public void onClick(View v) {


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lecture_section_cell, parent, false);
            return convertView;
        }
    }



}

