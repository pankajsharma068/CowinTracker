package pankaj.cowin.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

  ImageView imageView;
  Drawable drawable;
  EditText date;
  EditText pin;
  int year,month,day;

    public void apicall(View view)
    {
       // String key="";
        String key = date.getText().toString();
        String value=pin.getText().toString();
       // System.out.println(key);
        //else
          //  value=day+month+year;
    System.out.println("Key"+key);
   // String url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+value+"&date="+key;
    String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+value+"&date="+key;
    //String request=HttpRequest.newBuilder().Get.uri(URI.create(url)).build();
    RequestQueue queue = Volley.newRequestQueue(this);
    // String url ="https://www.google.com";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    Intent intent = new Intent(MainActivity.this, CenterListActivity.class);
                    intent.putExtra("message", response);
                    intent.putExtra("date",key);
                    startActivity(intent);

                    System.out.println("response"+response);
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("That didn't work!");
        }
    });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date=(EditText)findViewById(R.id.editTextDate);
        pin=(EditText)findViewById(R.id.pin);
        final Calendar cal=Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=cal.get(Calendar.YEAR);
                month=cal.get(Calendar.MONTH);
                day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       /*  if(day<10 && month<10)
                       date.setText("0"+day+"0"+month+year);
                         else if(day<10)
                             date.setText("0"+day+month+year);
                         else if(month<10)
                             date.setText(day+"0"+month+year);
                         else
                             date.setText(day+month+year);*/
                        day=dayOfMonth;
                        month++;
                       date.setText(dayOfMonth+"/"+(month)+"/"+year);
                      //  System.out.println(dayOfMonth);
                        // System.out.println(month);
                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.share:


            Intent intent =new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cowin Tracker");
            intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=pankaj.cowin.tracker ");
            intent.setType("text/plain");
            startActivity(intent);

            return(true);
        case R.id.aboutus:

      Intent intent1=new Intent(MainActivity.this,AboutUsActivity.class);

         startActivity(intent1);

            //add the function to perform here
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }

}