package com.apiwithrx.post;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apiwithrx.model.PostModel;
import com.apiwithrx.network.PostClient;
import com.apiwithrx.network.PostService;
import com.apiwithrx.repositories.PostRepository;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel
{

    private PostRepository postRepository;

    public PostViewModel()
    {
        postRepository = new PostRepository();
    }

    public LiveData<ArrayList<PostModel>> getPosts()
    {
        return postRepository.getPost();
    }


}