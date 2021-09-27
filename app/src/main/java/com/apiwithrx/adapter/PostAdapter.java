package com.apiwithrx.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apiwithrx.databinding.ItemPostBinding;
import com.apiwithrx.model.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>
{

    ArrayList<PostModel> postModels;

    public PostAdapter(ArrayList<PostModel> postModels)
    {
        this.postModels = postModels;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new PostViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position)
    {
        PostModel model = postModels.get(position);
        holder.binding.itemTxtUserId.setText("User ID: " + model.getUserID());
        holder.binding.itemTxtId.setText("ID: " + model.getID());
        holder.binding.itemTxtTitle.setText(model.getTitle());
        holder.binding.itemTxtBody.setText(model.getBody());
    }

    @Override
    public int getItemCount()
    {
        return postModels.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder
    {

        private ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
