package com.be_a_hero.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;

import com.be_a_hero.app.databinding.ItemDonorsHeaderBinding;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public ItemDonorsHeaderBinding binding;

    public HeaderViewHolder(final ItemDonorsHeaderBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }
}