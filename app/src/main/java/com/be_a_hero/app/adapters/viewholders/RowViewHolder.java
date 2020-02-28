package com.be_a_hero.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;

import com.be_a_hero.app.databinding.ItemDonorsRowBinding;

public class RowViewHolder extends RecyclerView.ViewHolder {

    private ItemDonorsRowBinding binding;

    public RowViewHolder(final ItemDonorsRowBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }
}