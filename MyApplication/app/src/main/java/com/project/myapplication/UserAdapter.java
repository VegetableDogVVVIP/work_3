package com.project.myapplication;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.myapplication.databinding.UserItemBinding;

import java.util.List;

/**
 * @author admin
 * @description:
 * @date :2022/1/18 20:00
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User>  userList;

    //声明自定义的监听接口
    private OnRecyclerItemClickListener monItemClickListener;


    //提供set方法供Activity或Fragment调用
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }



    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.user_item, parent, false);
        final ViewHolder holder = new ViewHolder( view );

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        User user = userList.get(position);
        holder.bind(user);

        holder.userItemBinding.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (monItemClickListener != null){
                    monItemClickListener.onItemClick(position,userList);
                }
            }
        });

        holder.userItemBinding.ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (monItemClickListener != null){
                    monItemClickListener.onLongItemClick(position,userList);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImageResource(ImageView imageResource,int resource){
        imageResource.setImageResource(resource);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private UserItemBinding userItemBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userItemBinding = DataBindingUtil.bind(itemView);
        }
        public void bind(@NonNull User user){
            userItemBinding.setUserInfo(user);
        }
    }
}
