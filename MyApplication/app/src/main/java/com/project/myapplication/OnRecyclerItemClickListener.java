package com.project.myapplication;

import java.util.List;

/**
 * @author admin
 * @description:
 * @date :2022/1/18 20:43
 */
public interface OnRecyclerItemClickListener {
    void onItemClick(int Position, List<User> userList);
    void onLongItemClick(int Position, List<User> userList);
}
