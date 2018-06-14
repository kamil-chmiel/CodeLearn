package com.company.codelearn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
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


        fillList();
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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
        ArrayList<LecturesCell> lectures = new ArrayList<LecturesCell>();

        lectures.add(new LectureSectionCell("Getting started", 15, 50, new Date()));
        lectures.add(new LectureCell(1,"Lesson 1: Quick C++ History", 10, 10));
        ((LectureCell)lectures.get(lectures.size()-1)).unlocked = true;
        lectures.add(new LectureCell(2,"Lesson 2: Environment setup", 5, 10));
        ((LectureCell)lectures.get(lectures.size()-1)).unlocked = true;
        lectures.add(new LectureCell(3,"Lesson 3: Hello World", 0, 30));

        lectures.add(new LectureSectionCell("Basic syntax", 0, 100, new Date()));
        lectures.add(new LectureCell(4,"Lesson 1: Data types", 0, 20));
        lectures.add(new LectureCell(5,"Lesson 2: Variables", 0, 20));
        lectures.add(new LectureCell(6,"Lesson 3: Constants", 0, 20));
        lectures.add(new LectureCell(7,"Lesson 4: Loops", 0, 20));
        lectures.add(new LectureCell(8,"Lesson 5: if statement", 0, 10));
        lectures.add(new LectureCell(9,"Lesson 6: switch", 0, 10));

        lectures.add(new LectureSectionCell("Operators", 0, 200, new Date()));
        lectures.add(new LectureCell(10,"Lesson 1: Assignment operator", 0, 20));
        lectures.add(new LectureCell(11,"Lesson 2: Arithmetic operators", 0, 20));
        lectures.add(new LectureCell(12,"Lesson 3: Increment and decrement", 0, 20));
        lectures.add(new LectureCell(13,"Lesson 4: Comparision operators", 0, 20));
        lectures.add(new LectureCell(14,"Lesson 5: Logical operators", 0, 20));
        lectures.add(new LectureCell(15,"Lesson 6: Conditional Ternary Operator", 0, 25));
        lectures.add(new LectureCell(16,"Lesson 7: Coma operator", 0, 25));
        lectures.add(new LectureCell(17,"Lesson 8: Type casting", 0, 25));
        lectures.add(new LectureCell(18,"Lesson 9: sizeof operator", 0, 25));

        lectures.add(new LectureSectionCell("Object Oriented Programming", 0, 120, new Date()));
        lectures.add(new LectureCell(19,"Lesson 1: Classes", 0, 20));
        lectures.add(new LectureCell(20,"Lesson 2: Constructors and descructors", 0, 20));
        lectures.add(new LectureCell(21,"Lesson 3: Getters and setters", 0, 20));
        lectures.add(new LectureCell(22,"Lesson 4: The “this” keyword", 0, 20));
        lectures.add(new LectureCell(23,"Lesson 5: Inheritance", 0, 20));
        lectures.add(new LectureCell(24,"Lesson 6: Example code", 0, 20));

        lectures.add(new LectureSectionCell("Pointers", 0, 100, new Date()));
        lectures.add(new LectureCell(25,"Lesson 1: Pointer definition", 0, 25));
        lectures.add(new LectureCell(26,"Lesson 2: Standard pointers", 0, 25));
        lectures.add(new LectureCell(27,"Lesson 3: Smart pointers", 0, 25));
        lectures.add(new LectureCell(28,"Lesson 4: Example", 0, 25));

        lectures.add(new LectureSectionCell("Advanced OOP", 0, 150, new Date()));
        lectures.add(new LectureCell(29,"Lesson 1: Polimorphism", 0, 50));
        lectures.add(new LectureCell(30,"Lesson 2: Encapsulation", 0, 50));
        lectures.add(new LectureCell(31,"Lesson 3: Abstract classes", 0, 50));

        lectures.add(new LectureSectionCell("Advanced Data Types", 0, 300, new Date()));
        lectures.add(new LectureCell(32,"Lesson 1: Multidimensional Arrays", 0, 50));
        lectures.add(new LectureCell(33,"Lesson 2: References", 0, 50));
        lectures.add(new LectureCell(34,"Lesson 3: Delete operator", 0, 50));
        lectures.add(new LectureCell(35,"Lesson 4: Struct", 0, 50));
        lectures.add(new LectureCell(36,"Lesson 5: Unions", 0, 50));
        lectures.add(new LectureCell(37,"Lesson 6: Enumerators", 0, 50));

        lectures.add(new LectureSectionCell("Preprocessor", 0, 200, new Date()));
        lectures.add(new LectureCell(38,"Lesson 1: Macro definitions", 0, 50));
        lectures.add(new LectureCell(39,"Lesson 2: Conditional Directives", 0, 50));
        lectures.add(new LectureCell(40,"Lesson 3: Line Directive", 0, 50));
        lectures.add(new LectureCell(41,"Lesson 4: Error Directive", 0, 50));


        ListView listView = (ListView) getView().findViewById(R.id.lectures_list);
        adapter = new CustomAdapter(getActivity(), lectures);

        listView.setAdapter(adapter);
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
            LectureSectionCell section = (LectureSectionCell)data.get(position);vi = inflater.inflate(R.layout.lecture_section_cell, null);

            TextView title = (TextView)vi.findViewById(R.id.section_title);
            TextView stars = (TextView)vi.findViewById(R.id.section_stars_label);
            TextView startDate = (TextView)vi.findViewById(R.id.start_date_label);
            ProgressBar progressBar = (ProgressBar)vi.findViewById(R.id.progressBar);


            title.setText( section.sectionTitle );
            stars.setText(section.progress.toString() + "/" + section.maxPoints.toString());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            startDate.setText("Started: " + formatter.format(section.startDate));
            progressBar.getProgressDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else {
            LectureCell lecture = (LectureCell) data.get(position);

            vi = inflater.inflate(R.layout.lecture_cell, null);


            // TU ON CLICK LECTURE
            vi.setOnClickListener( (View v) -> {

                    Intent lectureViewIntent = new Intent(v.getContext(),LectureViewActivity.class);
                    lectureViewIntent.putExtra("lessonNumber",lecture.lessonNumber);
                    v.getContext().startActivity(lectureViewIntent);

                }
            );

            TextView title = (TextView)vi.findViewById(R.id.lecture_title);
            ImageView tick = (ImageView)vi.findViewById(R.id.tickImage);

            title.setText(lecture.title + "(" + lecture.progress + "/" + lecture.maxPoints + ")");

            if(lecture.progress < lecture.maxPoints) {
                tick.setVisibility(View.INVISIBLE);
                if(!lecture.unlocked)
                    title.setTextColor(Color.GRAY);
            }
        }


        return vi;
    }

}

