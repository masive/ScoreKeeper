package com.example.android.simplecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Person createPerson() {
        EditText inputUserName = (EditText) findViewById(R.id.username_editText_view);
        String username = inputUserName.getText().toString();
        Person person = new Person(username);
        return person;
    }

    private void addUserName() {
        Person currentUser = createPerson();
        setContentView(R.layout.choose_sport);
        TextView messageTextView = (TextView) findViewById(R.id.hello_message_view);
        String message = String.format("Dear %s, please choose one a sport event!", currentUser.getName());
        messageTextView.setText(message);
    }

    public void nextScreen(View view) {
        addUserName();
    }
}
