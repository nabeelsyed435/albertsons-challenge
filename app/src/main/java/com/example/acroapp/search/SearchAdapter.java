package com.example.acroapp.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acroapp.R;
import com.example.acroapp.service.to.Lf;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Lf> acronyms;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lf acronymExpanded = acronyms.get(position);
        holder.resultTV.setText(acronymExpanded.getLf());
    }

    public void updateAcronyms(List<Lf> acronyms) {
        this.acronyms = acronyms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return acronyms == null? 0 : acronyms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvResult)
        TextView resultTV;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
