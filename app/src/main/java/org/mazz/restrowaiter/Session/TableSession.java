package org.mazz.restrowaiter.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.mazz.restrowaiter.Modal.WaiterModal;

public class TableSession {

    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "TableSession";



    // User name (make variable public to access from outside)
    public static final String WAITER_CODE = "waiterCode";

    // Email address (make variable public to access from outside)
    public static final String WAITER_NAME = "waiterName";

    // Constructor
    public TableSession(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createWaiter (String waiterCode, String WaiterName){

        // Storing Waiter Code in pref
        editor.putString(WAITER_CODE, waiterCode);

        // Storing Waiter Name in pref
        editor.putString(WAITER_NAME, WaiterName);

        // commit changes
        editor.commit();
    }
    public static final String WAITER_LIST = "waiterList";


    public void saveWaiter(WaiterModal waiterModal){

        editor.putString(WAITER_LIST, ""+waiterModal);
        editor.commit();     // This line is IMPORTANT !!!
    }

    public String getWaiterCode() {
        String waiterCode = pref.getString("WAITER_CODE","");
        return waiterCode;
    }

}
