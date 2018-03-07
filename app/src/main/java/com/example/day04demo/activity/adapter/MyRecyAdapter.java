package com.example.day04demo.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day04demo.MyApp;
import com.example.day04demo.R;
import com.example.day04demo.StudentDao;
import com.example.day04demo.activity.been.MyBeen;
import com.example.day04demo.activity.been.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王宇辉 on 2018/3/6.
 */

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder> {
    private List<MyBeen.StudentsBean.StudentBean> myBeen;
    private Context context;
    private OnClickListener listener;


    public MyRecyAdapter(List<MyBeen.StudentsBean.StudentBean> myBeen, Context context) {
        this.myBeen = myBeen;
        this.context = context;
    }

    @Override
    public MyRecyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shou_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyAdapter.MyViewHolder holder, final int position) {
        holder.name.setText(myBeen.get(position).getName());
        holder.cont.setText(myBeen.get(position).getContent());
        Picasso.with(context).load(myBeen.get(position).getImg()).into(holder.img);
        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDao studentDao = MyApp.getMyApp().getDaoSession().getStudentDao();
                Student student1 = new Student();
                student1.setImg(myBeen.get(position).getImg());
                student1.setContent(myBeen.get(position).getContent());
                student1.setName(myBeen.get(position).getName());
                studentDao.insert(student1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView cont;
        private final CheckBox cb;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            cont = itemView.findViewById(R.id.cont);
            cb = itemView.findViewById(R.id.cb);
        }
    }

    public interface OnClickListener{
        void onClickListener(int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener=listener;
    }
}
