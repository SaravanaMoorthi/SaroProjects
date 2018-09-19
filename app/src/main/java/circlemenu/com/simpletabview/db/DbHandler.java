package circlemenu.com.simpletabview.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHandler extends SQLiteOpenHelper {
    private final String TAG = DbHandler.class.getSimpleName();

    private static final String DB_NAME = "ProductScheme.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_PRODUCT_SCHEME = "Product";
    public static final String PRODUCT_ID = "ProductId";
    public static final String PRODUCT_NAME = "ProductName";
    public static final String PRODUCT_ASSET_CATEGORY = "AssetCategory";
    public static final String PRODUCT_NAME_AND_ASSET_CATEGORY = "Name_AssetCategory";
    public static final String PRODUCT_SCHEME = "Scheme";
    public static final String PRODUCT_TENOR = "Tenor";
    public static final String PRODUCT_ROI = "Roi";
    public static final String PRODUCT_TYPE = "Type";
    public static final String APPROVE_AMNT = "ApproveAmnt";
    public static final String APPROVE_EMI = "EmiAmnt";
    public static final String TOTAL = "Total";

    private static final String CREATE_PRODUCT_SCHEME = new StringBuilder()
            .append("CREATE TABLE ").append(TABLE_PRODUCT_SCHEME)
            .append("(")
            .append(PRODUCT_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT,")
            .append(PRODUCT_NAME).append(" TEXT ,")
            .append(PRODUCT_ASSET_CATEGORY).append(" TEXT,")
            .append(PRODUCT_NAME_AND_ASSET_CATEGORY).append(" TEXT UNIQUE,")
            .append(PRODUCT_SCHEME).append(" TEXT,")
            .append(PRODUCT_TENOR).append(" TEXT,")
            .append(PRODUCT_ROI).append(" TEXT,")
            .append(APPROVE_AMNT).append(" FLOAT,")
            .append(APPROVE_EMI).append(" FLOAT,")
            .append(PRODUCT_TYPE).append(" INTEGER")
            .append(")")
            .toString();

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db, TABLE_PRODUCT_SCHEME, CREATE_PRODUCT_SCHEME);
    }

    private void createTable(SQLiteDatabase db, String tableName, String createQuery) {
        try {
            db.execSQL(createQuery);
            Log.e(TAG, "Query ===> " + createQuery);
            Log.e(TAG, tableName + " table created!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
