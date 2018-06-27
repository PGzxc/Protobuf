package com.pgzxc.protobuf;


import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxPermissions rxPermissions = new RxPermissions(this);
        checkPermission(rxPermissions);
        findViewById(R.id.btn_proto_local).setOnClickListener(view ->
                startActivity(new Intent(this, ProtoLocalActivity.class))

        );
        findViewById(R.id.btn_proto_net).setOnClickListener(view -> startActivity(new Intent(this, ProtoNetActivity.class)));
    }

    /**
     * @param rxPermissions
     * @description:动态监测权限
     */
    private void checkPermission(RxPermissions rxPermissions) {

        rxPermissions.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET
        )
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted

                    } else {
                        // At least one permission is denied
                    }
                });
    }
}
