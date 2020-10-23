package com.example.android_lession03_retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_lession03_retrofit.R;
import com.example.android_lession03_retrofit.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {
    Context context;
    List<Item> items;
    PostItemListener postItemListener;

    public AnswerAdapter(Context context, ArrayList<Item> items, PostItemListener postItemListener) {
        this.context = context;
        this.items = items;
        this.postItemListener = postItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_answer, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, postItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getOwner().getDisplayName() + "");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        PostItemListener postItemListener;

        public ViewHolder(@NonNull View itemView, PostItemListener postItemListener) {
            super(itemView);
            title = itemView.findViewById(R.id.item_answer_title);

            this.postItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.postItemListener.onPostClick(getItem(getAdapterPosition()).getAnswerId());
            notifyDataSetChanged();
        }
    }

    public void updateAnswers(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return items.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
