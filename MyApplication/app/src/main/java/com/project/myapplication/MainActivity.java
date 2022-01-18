package com.project.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    List<String> list;
    UserAdapter myAdapter;
    private String[] nameList = new String[]{"张三","里斯","王五","赵六","李达","朝乾顺","吴敦义"};
    private int [] head = new int[]{R.drawable.one,R.drawable.t,R.drawable.th,R.drawable.f,R.drawable.fi,R.drawable.six,R.drawable.se};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);


         list = new ArrayList<>();
        list.add("有没有听过“大猪说有，小猪说没有”的故事？");
        list.add("人工智能和天然愚蠢无法相提并论——因为我们主张纯天然。");
        list.add("在教堂听讲经的时候我们应该保持肃静，打扰别人睡觉是很不礼貌的。");
        list.add("陪聊，提供夜间上门服务。（一个墓志铭）");
        list.add("人又不聪明，还学人家秃顶！");
        list.add("秀发去无踪，头屑更出众");
        list.add("宁和明白人打一架，不跟SB说句话！");

        binding.viewPager2.setAdapter(new ViewPagerAdapter(this, list,  binding.viewPager2));

        binding.viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

            }
        });


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        binding.recycleView.setLayoutManager(linearLayoutManager);
         myAdapter=new UserAdapter(initData());
        binding.recycleView.setAdapter(myAdapter);
        myAdapter.setRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(int Position,List<User> userList) {
                binding.viewPager2.setCurrentItem(Position);

            }

            @Override
            public void onLongItemClick(int Position, List<User> userList) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("name",nameList[Position]);
                intent.putExtra("content",list.get(Position));
                intent.putExtra("fensi",(Position+1)+"");
                intent.putExtra("head",Position);
                Utils.NUM = Position;
                startActivityForResult(intent,101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Utils.Flag){
            Utils.Flag  =false;
            myAdapter.notifyItemRemoved(Utils.NUM);
            userList.remove(Utils.NUM);
            list.remove(Utils.NUM);
            myAdapter.notifyItemRangeChanged(0, myAdapter.getItemCount());
            myAdapter.notifyDataSetChanged();
        }


    }
    List<User> userList;
    private List<User> initData(){
        userList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            User user = new User();
            user.setName(nameList[i]);
            user.setImage(head[i]);
            user.setFensi("粉丝："+(i+1));
            user.setContent(list.get(i));
            userList.add(user);
        }
        return userList;
    }
}