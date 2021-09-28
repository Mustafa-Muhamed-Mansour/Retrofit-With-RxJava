package com.apiwithrx.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apiwithrx.model.PostModel;
import com.apiwithrx.network.PostClient;
import com.apiwithrx.network.PostService;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostRepository
{
    private PostService postService;
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ArrayList<PostModel>> postModelMutableLiveData = new MutableLiveData<>();

    public PostRepository()
    {
        postService = PostClient.getRetrofit().create(PostService.class);
    }

    public LiveData<ArrayList<PostModel>> getPost()
    {

        Observable<ArrayList<PostModel>> observable = postService.getPost().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<ArrayList<PostModel>> observer = new Observer<ArrayList<PostModel>>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
            }

            @Override
            public void onNext(@NonNull ArrayList<PostModel> postModels)
            {
                postModelMutableLiveData.setValue(postModels);
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                stringMutableLiveData.setValue(e.getMessage());
            }

            @Override
            public void onComplete()
            {
            }
        };

        observable.subscribe(observer);

        return postModelMutableLiveData;
    }
}
