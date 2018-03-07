package com.example.day04demo.activity.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.day04demo.R;
import com.example.day04demo.activity.adapter.MyRecyAdapter;
import com.example.day04demo.activity.been.MyBeen;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoucangFragment extends Fragment implements View.OnClickListener {

    private MyRecyAdapter adapter;
    private RecyclerView recy;
    private List<MyBeen.StudentsBean.StudentBean> myBeen;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Gson gson = new Gson();
            myBeen = gson.fromJson(obj, MyBeen.class).getStudents().getStudent();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

            adapter = new MyRecyAdapter(myBeen, getActivity());
            recy.setAdapter(adapter);
            recy.setLayoutManager(linearLayoutManager);
        }
    };
    private Button liebiao;
    private Button shoucang;
    private SetData data;

    public ShoucangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shoucang, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request build = new Request.Builder().url("http://172.16.54.13:8080/String/data.json.txt").build();
                    Response execute = okHttpClient.newCall(build).execute();
                    String string = execute.body().string();
                    Message message = new Message();
                    message.obj = string;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initView(View inflate) {
        recy = (RecyclerView) inflate.findViewById(R.id.recy);
        liebiao = (Button) inflate.findViewById(R.id.liebiao);
        liebiao.setOnClickListener(this);
        shoucang = (Button) inflate.findViewById(R.id.shoucang);
        shoucang.setOnClickListener(this);
    }
    private void initListener() {
        adapter.setOnClickListener(new MyRecyAdapter.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                data.onSetData(myBeen.get(position).getImg(),myBeen.get(position).getName(),myBeen.get(position).getContent());
            }
        });
    }



    public interface SetData{
        void onSetData(String image,String name,String content);
    }

    public void getData(SetData data){
        this.data=data;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.liebiao:

                break;
            case R.id.shoucang:

                break;
        }
    }
}
