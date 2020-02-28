package com.be_a_hero.app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.be_a_hero.app.R;
import com.be_a_hero.app.data.Constants;
import com.be_a_hero.app.databinding.ItemPostBinding;
import com.be_a_hero.app.models.Posts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Posts> filtered_items;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Posts obj);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;
        ViewHolder(final ItemPostBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PostsAdapter(Context ctx, List<Posts> items) {
        this.ctx = ctx;
        filtered_items = items;
    }

    public void setPostsList(List<Posts> items) {
        // then update the items
        filtered_items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPostBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false);
        return new ViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Posts obj = filtered_items.get(position);

        // set the views

        holder.binding.userNameTextView.setText(obj.getUser().getName());
        holder.binding.userImageView.setImageResource(obj.getUser().getImage());
        holder.binding.postImageView.setImageResource(obj.getPostImage());
        holder.binding.postContentTextView.setText(Html.fromHtml(obj.getPostContent()));
        holder.binding.userLocationTextView.setText(obj.getUser().getLocation());

        // show the time ago
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date datePostCreated = dateFormat.parse(obj.getTimeAgo());
            long milliseconds = datePostCreated.getTime();
            holder.binding.postTimeTextView.setText(Constants.timeAgoTimeDiff(milliseconds));
        } catch (ParseException e) {
            e.printStackTrace();
            holder.binding.postTimeTextView.setText(obj.getTimeAgo());
        }

        // to show and hide the various layouts
        if(position % 2 != 0){
            holder.binding.postImageView.setVisibility(View.VISIBLE);
            holder.binding.userVerifiedImageView.setVisibility(View.GONE);
        }else{
            holder.binding.postImageView.setVisibility(View.GONE);
            holder.binding.userVerifiedImageView.setVisibility(View.VISIBLE);
            holder.binding.actionShareImageView.setVisibility(View.GONE);
        }

        if(position % 3 == 0 && position !=0){
            holder.binding.postContentTextView.setVisibility(View.GONE);
        }

        // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);

        // click listeners
        holder.binding.lytParent.setOnClickListener(view -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, position, obj);
            }
        });
    }

    /**
     * Here is the key method to apply the animation
     */
    private int lastPosition = -1;
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.slide_in_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return filtered_items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
