package circlemenu.com.simpletabview.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import circlemenu.com.simpletabview.db.DbHandler;

public class DbAsyncTask extends AsyncTask<String, String, String> {
    private Context mContext;

    public DbAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        new DbHandler(mContext).getWritableDatabase();
        return null;
    }
}
