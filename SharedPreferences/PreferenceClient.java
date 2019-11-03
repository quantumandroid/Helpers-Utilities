
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceClient {

    private final String SHARED_PREFERENCE_NAME = "AppPreference";

    private static PreferenceClient mInstance;

    private SharedPreferences sharedPreferences;


    private PreferenceClient(Context mCtx) {

        sharedPreferences = mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

    }

    public static synchronized PreferenceClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new PreferenceClient(mCtx);
        }
        return mInstance;
    }

    public SharedPreferences getPreferences() {
        return sharedPreferences;
    }

    //TODO Storing Data
    @SuppressLint("ApplySharedPref")
    public void put(String key, String val) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, val); // Storing string
        editor.commit(); // commit changes
    }

    @SuppressLint("ApplySharedPref")
    public void put(String key, boolean val) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, val); // Storing boolean - true/false
        editor.commit(); // commit changes
    }

    @SuppressLint("ApplySharedPref")
    public void put(String key, int val) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, val); // Storing integer
        editor.commit(); // commit changes
    }

    @SuppressLint("ApplySharedPref")
    public void put(String key, float val) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, val); // Storing float
        editor.commit(); // commit changes
    }

    @SuppressLint("ApplySharedPref")
    public void put(String key, long val) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, val); // Storing long
        editor.commit(); // commit changes
    }

    //TODO Retrieving Data
    public String get(String key, String def_val) {
        return sharedPreferences.getString(key, def_val); // getting String
    }

    public int get(String key, int def_val) {
        return sharedPreferences.getInt(key, def_val); // getting Integer
    }

    public float get(String key, float def_val) {
        return sharedPreferences.getFloat(key, def_val); // getting Float
    }

    public long get(String key, long def_val) {
        return sharedPreferences.getLong(key, def_val); // getting Long
    }

    public boolean get(String key, boolean def_val) {
        return sharedPreferences.getBoolean(key, def_val); // getting boolean
    }

    //TODO Clearing or Deleting Data
    //remove(“key_name”) is used to delete that particular value.
    //clear() is used to remove all data

    @SuppressLint("ApplySharedPref")
    public void clear(String key) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key); // will delete entry of the key
        editor.commit(); // commit changes
    }

    @SuppressLint("ApplySharedPref")
    public void clearAll() {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); //will delete all data of preference
        editor.commit(); // commit changes
    }

}

/*TODO HOW TO USE
        PreferenceClient.getInstance(context).put("key", "val");
        PreferenceClient.getInstance(context).get("key", "def_val");
        PreferenceClient.getInstance(context).clear("key");
        PreferenceClient.getInstance(context).clearAll();
        SharedPreferences sp = PreferenceClient.getInstance(context).getPreferences();
*/
