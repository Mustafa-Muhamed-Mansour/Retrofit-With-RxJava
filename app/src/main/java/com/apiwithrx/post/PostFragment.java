package com.apiwithrx.post;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apiwithrx.R;
import com.apiwithrx.adapter.PostAdapter;
import com.apiwithrx.databinding.PostFragmentBinding;
import com.apiwithrx.model.PostModel;

import java.util.ArrayList;

public class PostFragment extends Fragment
{

    private PostFragmentBinding binding;
    private PostViewModel postViewModel;
    private PostAdapter postAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = PostFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        postViewModel = new ViewModelProvider(requireActivity()).get(PostViewModel.class);

        
    }

    @Override
    public void onStart()
    {
        super.onStart();

        postViewModel.getPosts().observe(getViewLifecycleOwner(), new Observer<ArrayList<PostModel>>()
        {
            @Override
            public void onChanged(ArrayList<PostModel> postModels)
            {
                postAdapter = new PostAdapter(postModels);
                binding.rVPost.setAdapter(postAdapter);
                binding.rVPost.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
                binding.rVPost.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            }
        });
    }
}