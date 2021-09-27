package com.apiwithrx.network;

import com.apiwithrx.model.PostModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostService
{

    @GET("posts")
    Observable<ArrayList<PostModel>> getPost();

}
