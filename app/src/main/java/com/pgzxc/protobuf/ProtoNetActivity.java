package com.pgzxc.protobuf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.pgzxc.protobuf.api.ProtoClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import proto.ContactsOuterClass;


public class ProtoNetActivity extends AppCompatActivity {
    private TextView textView;
    private Button bunProtoNet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proto_net);
        textView = findViewById(R.id.textView);
        bunProtoNet = findViewById(R.id.btn_proto_net);
        bunProtoNet.setOnClickListener(view -> getProtoInfo());

    }

    private void getProtoInfo() {
        ProtoClient.getApiService().getProtoInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ContactsOuterClass.Contacts>() {
                    @Override
                    public void accept(ContactsOuterClass.Contacts contacts) throws Exception {
                        textView.setText(contacts.toString());
                    }
                });
    }
}
