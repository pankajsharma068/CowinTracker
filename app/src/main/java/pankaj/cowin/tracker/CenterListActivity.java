
package pankaj.cowin.tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class CenterListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private List<ListItem> listItems;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String center = bundle.getString("message");
         //Bundle bundle1=getIntent().getExtras();
        date=bundle.getString("date");
       System.out.println("Center"+center);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems=new ArrayList<>();
        loadrecyclerview(center);
    }
    private  void loadrecyclerview(String s) {

        if(s.length()<20)
        {
            Toast.makeText(CenterListActivity.this,"Sorry,No Data Found for This PinCode!",Toast.LENGTH_LONG).show();

        }




    //System.out.println(d);


//            dt2.setText(d++);
//
//        dt3.setText(d++);
//
//        dt4.setText(d++);
//
//        dt5.setText(d++);
//
//        dt6.setText(d++);
//
//        dt7.setText(d++);



            try {
                JSONObject jsonObject = new JSONObject(s);

                JSONArray array = jsonObject.getJSONArray("centers");

               /* if(array.length()==0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry,No Data Found!", Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50);
                    toast.show();
                }*/



                for (int i = 0; i < array.length(); i++) {
                    JSONObject o = array.getJSONObject(i);
                    o.getString("sessions");
                    ListItem item = new ListItem(
                            o.getString("center_id"),
                            o.getString("name"),
                            o.getString("address"),
                            o.getString("block_name"),
                            "Age 18-44",
                            o.getJSONArray("sessions")
                    );
                    listItems.add(item);
                    JSONObject o1 = array.getJSONObject(i);
                    ListItem item1 = new ListItem(
                            o.getString("center_id"),

                            o.getString("name"),
                            o.getString("address"),
                            o.getString("block_name"),
                            "Age 45+",
                            o.getJSONArray("sessions")
                    );
                    listItems.add(item1);
                }
                myAdapter = new MyAdapter(listItems, getApplicationContext(), date);
                recyclerView.setAdapter(myAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}