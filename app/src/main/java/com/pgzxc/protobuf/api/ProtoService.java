package com.pgzxc.protobuf.api;

import com.pgzxc.protobuf.BuildConfig;


import io.reactivex.Observable;
import proto.ContactsOuterClass.Contacts;
import retrofit2.http.GET;


/**
 * Api列表
 */
public interface ProtoService {

    //Work信息
    @GET(BuildConfig.BASE_URL)
    Observable<Contacts> getProtoInfo();

}
