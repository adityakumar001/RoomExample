package com.emptyfruits.com.roomexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.emptyfruits.com.roomexample.database.User;
import com.emptyfruits.com.roomexample.databinding.RecyclerViewItemBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context mContext;
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.itemBinding.setUser(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewItemBinding itemBinding;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            itemBinding = DataBindingUtil.bind(itemView);
        }
    }
}