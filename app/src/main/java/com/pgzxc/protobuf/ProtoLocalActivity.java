package com.pgzxc.protobuf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import proto.StudentOuterClass;

public class ProtoLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proto_local);

        findViewById(R.id.btn_proto_local).setOnClickListener(view -> {

            StudentOuterClass.Student student = StudentOuterClass.Student.newBuilder()
                    .setName("张三")
                    .setAge(18)
                    .build();

            Toast.makeText(this, "Student.Name:"
                    + student.getName() + "Student.age:" + student.getAge(), Toast.LENGTH_SHORT).show();
        });



    }
}
