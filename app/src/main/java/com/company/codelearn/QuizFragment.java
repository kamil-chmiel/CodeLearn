package com.company.codelearn;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private static QuizListAdapter adapter;

    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance() {
        QuizFragment fragment = new QuizFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
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
        ArrayList<Quiz> quizes = new ArrayList<Quiz>();

        quizes.add(new Quiz("1","Getting started", 50, 50, true));
        quizes.add(new Quiz("2","Basic syntax", 10, 100, true));
        quizes.add(new Quiz("3","Operators", 0, 100, false));
        quizes.add(new Quiz("4","Object Oriented Programming", 0, 100, false));
        quizes.add(new Quiz("5","Pointers", 0, 200, false));
        quizes.add(new Quiz("6","Advanced OOP", 0, 200, false));
        quizes.add(new Quiz("7","Advanced Data Types", 0, 200, false));
        quizes.add(new Quiz("8","Preprocessor", 0, 200, false));


        ListView listView = (ListView) getView().findViewById(R.id.quiz_list);
        adapter = new QuizListAdapter(getActivity(), quizes);

        listView.setAdapter(adapter);
    }
}

class QuizListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Quiz> data;
    private static LayoutInflater inflater=null;

    public QuizListAdapter(Activity a, ArrayList<Quiz> d) {
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

        vi = inflater.inflate(R.layout.quiz_cell,parent,false);

        TextView title = (TextView)vi.findViewById(R.id.quiz_title);
        TextView number = (TextView)vi.findViewById(R.id.quiz_number);
        TextView result = (TextView)vi.findViewById(R.id.result);
        ImageView tick = (ImageView) vi.findViewById(R.id.quiz_tick_image);

        number.setText("Quiz " + data.get(position).getId());
        title.setText( "'"+ data.get(position).getTitle() + "'");
        result.setText( "("+ data.get(position).getPoints() + "/" + data.get(position).getMaxPoints() + ")");
        if(data.get(position).getUnlocked())
            tick.setImageResource(R.drawable.tick);

        vi.setOnClickListener(view -> {

            if(!data.get(position).getUnlocked())
                Toast.makeText(view.getContext(),"This quiz is not yet unlocked!", Toast.LENGTH_LONG).show();
            else {
                Intent quizViewIntent = new Intent(view.getContext(), QuizViewActivity.class);
                quizViewIntent.putExtra("quizNumber", data.get(position).getId());
                quizViewIntent.putExtra("quizTitle",data.get(position).getTitle());
                view.getContext().startActivity(quizViewIntent);
            }

        });

        return vi;
    }
}