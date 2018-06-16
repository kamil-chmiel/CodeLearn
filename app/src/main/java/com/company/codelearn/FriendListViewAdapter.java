package com.company.codelearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.company.codelearn.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class FriendListViewAdapter extends BaseAdapter implements ListAdapter {
    private List<UserData> list;
    private Context context;

    public FriendListViewAdapter(List<UserData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos).getName();
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    public void addUser(UserData user) {
        list.add(user);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.friend_list_item, null);
        }

        TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
        listItemText.setText(getItem(position).toString());

        Button deleteBtn = (Button) view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(v -> {
            UserData currentUser = new UserData(FirebaseAuth.getInstance().getCurrentUser());
            new DatabaseHelper(context).deleteFriend(currentUser, list.get(position));
            list.remove(position);
            notifyDataSetChanged();
        });

        return view;
    }
}