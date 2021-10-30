package pankaj.cowin.tracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listitem;
    private Context context;
    private String date;

    public MyAdapter(List<ListItem> listitem, Context context, String date) {
        this.listitem = listitem;
        this.context = context;
        this.date = date;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MyAdapter.ViewHolder holder, int position) {
        ListItem listItem=listitem.get(position);
          //System.out.println("ListITEM"+ listItem);

        holder.textviewhead.setText(listItem.getHead());

        holder.textViewdesc.setText(listItem.getDec());
        holder.textViewadd.setText(listItem.getAdd());
        holder.textViewslot.setText(listItem.getSlot());
        holder.age.setText(listItem.getAge());
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Jan");
        map.put(2, "Feb");
        map.put(3, "Mar");
        map.put(4, "Apr");
        map.put(5, "May");
        map.put(6, "Jun");
        map.put(7, "Jul");
        map.put(8, "Aug");
        map.put(9, "Sep");
        map.put(10, "Oct");
        map.put(11, "Nov");
        map.put(12, "Dec");
        String day,month;
          System.out.println("finalDate"+date);
          if(date.charAt(1)=='/' && date.charAt(3)=='/') {
               day = date.substring(0, 1);
               month = date.substring(2, 3);
          }
      else  if(date.charAt(2)=='/' && date.charAt(4)=='/') {
            day = date.substring(0, 2);
             month = date.substring(3, 4);
        }
      else if(date.charAt(1)=='/' && date.charAt(4)=='/') {
            day = date.substring(0, 1);
            month = date.substring(2, 4);
        }
      else
          {
               day = date.substring(0, 2);
               month = date.substring(3, 5);
          }

          System.out.println("day "+day+"Month"+ month);
        Calendar cal=Calendar.getInstance(); //current moment calendar
       // cal.set(Calendar.DAY_OF_MONTH, 12);
        cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
        cal.set(Calendar.MONTH, Integer.parseInt(month));
        cal.set(Calendar.YEAR,2021); //if you don't care about seconds
        String dt1Str,dt2Str,dt3Str,dt4Str,dt5Str,dt6Str,dt7Str;
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
             dt1Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH))
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
             dt1Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH))
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt1Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH))
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt1Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH))
                    + "-" + cal.get(Calendar.YEAR);
        System.out.println("-->" + cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        System.out.println("text-->" + dt1Str);
        holder.dt1.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt2Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) + 1)
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt2Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1)
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt2Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt2Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1)
                    + "-" + cal.get(Calendar.YEAR);
        System.out.println("-->" + cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        System.out.println("text-->" + dt2Str);
        holder.dt2.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt3Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt3Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt3Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt3Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        holder.dt3.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt4Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt4Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt4Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt4Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        holder.dt4.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt5Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt5Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt5Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt5Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        holder.dt5.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt6Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt6Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt6Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt6Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        holder.dt6.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if(cal.get(Calendar.MONTH)<9 && cal.get(Calendar.DAY_OF_MONTH)<10) {
            dt7Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            dt7Str = "0"+cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else if(cal.get(Calendar.MONTH)<9)
        {
            dt7Str = cal.get(Calendar.DAY_OF_MONTH) + "-0" + (cal.get(Calendar.MONTH) )
                    + "-" + cal.get(Calendar.YEAR);
        }
        else
            dt7Str = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH))
                    + "-" + cal.get(Calendar.YEAR);
        holder.dt7.setText(cal.get(Calendar.DAY_OF_MONTH) +" " + map.get(cal.get(Calendar.MONTH)));

        holder.dt1.setOnClickListener(v -> {

            calculateData(listItem, dt1Str, listItem.getAge(), v);
        });
        holder.dt2.setOnClickListener(v -> {
            calculateData(listItem, dt2Str, listItem.getAge(), v);
        });
        holder.dt3.setOnClickListener(v -> {
            calculateData(listItem, dt3Str, listItem.getAge(), v);
        });
        holder.dt4.setOnClickListener(v -> {
            calculateData(listItem, dt4Str, listItem.getAge(), v);
        });
        holder.dt5.setOnClickListener(v -> {
            calculateData(listItem, dt5Str, listItem.getAge(), v);
        });
        holder.dt6.setOnClickListener(v -> {
            calculateData(listItem, dt6Str, listItem.getAge(), v);
        });
        holder.dt7.setOnClickListener(v -> {
            calculateData(listItem, dt7Str, listItem.getAge(), v);
        });

    }
    public void calculateData(ListItem listItem, String date, String age, View v) {
       System.out.println("New Date"+date);
        try {
            JSONArray arr = listItem.getSessions();
            JSONObject obj;

            if(age.equals("18-44"))
                age="18";
           // System.out.println(arr);
            for (int i = 0; i < arr.length(); i++) {

               obj = arr.getJSONObject(i);
             //  System.out.println(date+" "+ obj.getString("date"));

                if (obj.getString("date").equals(date)) {
                    System.out.println(age+"   "+obj.getString("min_age_limit"));

                     if(age.contains(obj.getString("min_age_limit"))) {
                         System.out.println("True");
                         Intent i1 = new Intent(v.getContext(), CenterDetailActivity.class);
                        // System.out.println("Send Data" + listItem);
                         i1.putExtra("list",listItem);
                         i1.putExtra("message", obj.toString());
                         v.getContext().startActivity(i1);
                         return;
                     }
                 }

            }
            Intent i1 = new Intent(v.getContext(), CenterDetailActivity.class);
            i1.putExtra("list",listItem);
            i1.putExtra("message", "");
            v.getContext().startActivity(i1);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textviewhead;
     //   public  TextView textviewfee;
        public TextView textViewdesc;
        public  TextView textViewadd;
        public  TextView textViewslot;
        public TextView dt1,dt2,dt3,dt4,dt5,dt6,dt7;
        public  TextView age;

        public ViewHolder(View itemView) {
            super(itemView);
            textviewhead=(TextView) itemView.findViewById(R.id.heading);
       //     textviewfee=(TextView)  itemView.findViewById(R.id.fee);
            textViewdesc=(TextView) itemView.findViewById(R.id.dec);
            textViewadd=(TextView) itemView.findViewById(R.id.add);
            textViewslot=(TextView) itemView.findViewById(R.id.slot);
            dt1=(TextView)itemView.findViewById(R.id.dt1);
            dt2=(TextView)itemView.findViewById(R.id.dt2);
            dt3=(TextView)itemView.findViewById(R.id.dt3);
            dt4=(TextView)itemView.findViewById(R.id.dt4);
            dt5=(TextView)itemView.findViewById(R.id.dt5);
            dt6=(TextView)itemView.findViewById(R.id.dt6);
            dt7=(TextView)itemView.findViewById(R.id.dt7);
            age=(TextView)itemView.findViewById(R.id.age);
        }
    }
}