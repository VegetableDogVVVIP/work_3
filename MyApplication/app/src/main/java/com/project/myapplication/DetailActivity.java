package com.project.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.myapplication.databinding.ActivityDetailBinding;

/**
 * @author admin
 * @description:
 * @date :2022/1/18 19:52
 */
public class DetailActivity extends AppCompatActivity {
    private int [] heads = new int[]{R.drawable.one,R.drawable.t,R.drawable.th,R.drawable.f,R.drawable.fi,R.drawable.six,R.drawable.se};
    private ActivityDetailBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);
        String name = getIntent().getStringExtra("name");
        String content = getIntent().getStringExtra("content");
        String fensi = getIntent().getStringExtra("fensi");
        int head = getIntent().getIntExtra("head",0);
        binding.image.setImageResource(heads[head]);
        binding.tvName.setText(name);
        binding.tvContent.setText(content);
        binding.tvFensi.setText(fensi);
        binding.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.Flag  =true;
                Toast.makeText(getApplicationContext(),"取消关注成功",Toast.LENGTH_SHORT).show();
                DetailActivity.this.finish();
            }
        });
    }
}
