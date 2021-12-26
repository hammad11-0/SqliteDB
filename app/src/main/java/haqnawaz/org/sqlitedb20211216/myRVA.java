package haqnawaz.org.sqlitedb20211216;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRVA extends RecyclerView.Adapter<myRVA.MyViewHolder>{
    List<StudentModel> StudentList;
    Activity mAct;

    public myRVA(List<StudentModel> s,Activity a)
    {
        this.StudentList=s;
        this.mAct=a;
    }



    @NonNull
    @Override
    public myRVA.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.studentview, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull myRVA.MyViewHolder holder, int position) {

        holder.data=StudentList.get(position);
        holder.textViewName.setText(holder.data.getName());
        holder.textViewAge.setText(String.valueOf(holder.data.getAge()));
        //holder.imageViewFriend.setImageResource(R.drawable.airplane);
        //holder.textViewStatus.setText(holder.data.setActive());

    }

    @Override
    public int getItemCount() {
        return StudentList.size();

            }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAge;
        TextView textViewStatus;
        StudentModel data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView2);
            textViewAge = itemView.findViewById(R.id.textView4);
            textViewStatus = itemView.findViewById(R.id.textView6);

        }

    }
}
