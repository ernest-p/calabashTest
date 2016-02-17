package com.example.mycalabash;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    public TestAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iconTest.setImageResource(R.mipmap.ic_launcher);
        holder.iconTest.setTag(position);
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconTest;

        public ViewHolder(View itemView) {
            super(itemView);
            iconTest = (ImageView) itemView.findViewById(R.id.iconTest);
        }
    }
}