package com.forbitbd.postdatatofirebase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context context;
    private List<Student> studentList;

    public RecyclerviewAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
        ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Student student = studentList.get(position);
        holder.text1.setText(student.getName());
        holder.text2.setText(student.getRoll());
        holder.text3.setText(student.getCourse());
        holder.text4.setText(student.getDuration());

        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogview = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.dialog_content, null);
                TextView studentname;
                TextView studentroll;
                TextView studentcourse;
                TextView studentduration;
                Button button;

                studentname = dialogview.findViewById(R.id.student_name);
                studentroll = dialogview.findViewById(R.id.student_roll);
                studentcourse = dialogview.findViewById(R.id.student_course);
                studentduration = dialogview.findViewById(R.id.student_duration);
                button = dialogview.findViewById(R.id.update);

                studentname.setText(student.getName());
                studentroll.setText(student.getRoll());
                studentcourse.setText(student.getCourse());
                studentduration.setText(student.getDuration());

                builder.setView(dialogview);
                builder.setCancelable(true);
                builder.show();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = studentname.getText().toString();
                        String roll = studentroll.getText().toString();
                        String course = studentcourse.getText().toString();
                        String duration = studentduration.getText().toString();

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("students").child(roll);
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("name", name);
                        hashMap.put("roll", roll);
                        hashMap.put("course", course);
                        hashMap.put("duration", duration);
                        reference.updateChildren(hashMap);

                        Toast.makeText(context, "Data Updated!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Did you want to delete your data?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("students").child(student.roll);
                        reference.removeValue();
                        Toast.makeText(context, "Data Deleted!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3, text4;
        Button btn1, btn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.roll);
            text3 = itemView.findViewById(R.id.course);
            text4 = itemView.findViewById(R.id.duration);

            btn1 = itemView.findViewById(R.id.edit);
            btn2 = itemView.findViewById(R.id.delete);

//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    DeleteData();
//                }
//            });
        }
    }


}
