package pankaj.cowin.tracker;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;

public class ListItem implements Parcelable {
    private String head;
    private String dec;
    private String add;
    private String slot;
    private String age;
    //private String feetype;
    private JSONArray sessions;

    public ListItem(String head, String dec, JSONArray sessions) {
        this.head = head;
        this.dec = dec;
        this.sessions = sessions;
    }

    public ListItem(String head, String dec, String add, String slot, String age, JSONArray sessions) {
        this.head = head;
        this.dec = dec;
        this.add = add;
        this.slot = slot;
        this.age = age;
      //  this.feetype = feetype;
        this.sessions = sessions;
    }


//    public ListItem(String head, String dec, String add, String slot, JSONArray sessions) {
//        this.head = head;
//        this.dec = dec;
//        this.add = add;
//        this.slot = slot;
//        this.sessions = sessions;
//    }

//    public String getFeetype() {
//        return feetype;
//    }

    public String getHead() {
        return head;
    }

    public String getDec() {
        return dec;
    }

    public String getAdd() {
        return add;
    }

    public String getAge() {
        return age;
    }

    public String getSlot() {
        return slot;
    }

    public JSONArray getSessions() {
        return sessions;
    }

    @Override
    public String toString() {
        return "{" +
                "'head':'" + head + '\'' +
                ", 'dec':'" + dec + '\'' +
                ", 'add':'" + add + '\'' +
                ", 'slot':'" + slot + '\'' +
                ", 'age':'" + age + '\'' +
                ", 'sessions':" + sessions +
                '}';
    }

    protected ListItem(Parcel in) throws JSONException {
        head = in.readString();
        dec = in.readString();
        add = in.readString();
        slot = in.readString();
      //  feetype=in.readString();
        age = in.readString();
        sessions = in.readByte() == 0x00 ? null : new JSONArray(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(head);
        dest.writeString(dec);
        dest.writeString(add);
        dest.writeString(slot);
        dest.writeString(age);
        if (sessions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeString(sessions.toString());
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ListItem> CREATOR = new Parcelable.Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {

            try {
                return new ListItem(in);
            } catch (JSONException e) {
                e.printStackTrace();
                System.out.println("error in creator");
            }
            return null;
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };
}