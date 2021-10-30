package pankaj.cowin.tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Slide;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;

public class CenterDetailActivity extends AppCompatActivity {

    TextView Tv1,Tv2,Tv3,Tv4,Tv5,Tv6,sl1,sl2,sl3,sl4;

      public  void cowingo(View view)
      {
          Intent viewIntent =
                  new Intent("android.intent.action.VIEW",
                          Uri.parse("https://selfregistration.cowin.gov.in/"));
          startActivity(viewIntent);
      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_center_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = getIntent().getExtras();
        ListItem centerDetail = bundle.getParcelable("list");
        String details=bundle.getString("message");
        System.out.println("details_center"+details);



        Tv1=(TextView)findViewById(R.id.tv1);
        Tv2=(TextView)findViewById(R.id.tv2);
        Tv3=(TextView)findViewById(R.id.tv3);
        Tv4=(TextView)findViewById(R.id.tv4);
        Tv5=(TextView)findViewById(R.id.tv5);
        Tv6=(TextView)findViewById(R.id.tv6);
        sl1=(TextView)findViewById(R.id.slot1);
        sl2=(TextView)findViewById(R.id.slot2);
        sl3=(TextView)findViewById(R.id.slot3);
        sl4=(TextView)findViewById(R.id.slot4);

        try {
            //JSONObject jsonObject = new JSONObject(centerDetail);

//           String head = centerDetail.getHead();
//              System.out.println("head");
//                Tv.setText(head);

            String dec = centerDetail.getDec();
            Tv1.setText("Center : " + dec);
            String add = centerDetail.getAdd();
            Tv3.setText("Address : " + add);
            String slot = centerDetail.getSlot();
            Tv4.setText("Slot : " + slot);
            if (details.length() == 0)
                Toast.makeText(CenterDetailActivity.this, "No Slots Available For This Date!", Toast.LENGTH_LONG).show();


            JSONObject jsonObject1 = new JSONObject(details);
            String vac = jsonObject1.getString("vaccine");
            Tv2.setText("Vaccine: " + vac);
            String cap1 = jsonObject1.getString("available_capacity_dose1");
            Tv5.setText("Dose 1 : " + cap1);
            String cap = jsonObject1.getString("available_capacity_dose2");
            Tv6.setText("Dose 2 : " + cap);
            String slot1 = jsonObject1.getString("slots");
            String slot11, slot12, slot13, slot14;
            if (slot1.length() >= 17) {
                slot11 = slot1.substring(2, 17);
                sl1.setText(slot11);
            }
            if (slot1.length() >= 35)
            {
                slot12 = slot1.substring(20, 35);
            sl2.setText(slot12);
        }
            if (slot1.length() >= 53) {
                slot13 = slot1.substring(38, 53);
                sl3.setText(slot13);
            }
              if (slot1.length() >= 71) {
                  slot14 = slot1.substring(56, 71);
                  sl4.setText(slot14);
              }
             //JSONArray array = jsonObject.getJSONArray("sessions");
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject obj = array.getJSONObject(i);
//
//            }

        } catch (Exception e) {
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