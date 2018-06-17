package com.company.codelearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ContactActivity extends AppCompatActivity {
    private Button sendBtn;
    private Spinner requestType;
    private EditText chapterName, contactDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        sendBtn = findViewById(R.id.btn_send_contact_request);
        sendBtn.setOnClickListener(v -> {
            Snackbar.make(v, "We've received your message. Thank you for the contact!", Snackbar.LENGTH_LONG)
                    .show();

        });
        requestType = findViewById(R.id.spinner_types);
        chapterName = findViewById(R.id.contact_chapter_name);
        contactDesc = findViewById(R.id.conctac_desc);

    }
}
