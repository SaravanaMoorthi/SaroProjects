package circlemenu.com.simpletabview.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import circlemenu.com.simpletabview.model.ProductScheme;
import circlemenu.com.simpletabview.db.DbHandler;

public class ProductSchemeDbService {
    public void add(Context context, ProductScheme productScheme) {
        try {
            ContentValues values = new ContentValues();
            values.put(DbHandler.PRODUCT_NAME, productScheme.getProductName());
            values.put(DbHandler.PRODUCT_ASSET_CATEGORY, productScheme.getAssetCategory());
            values.put(DbHandler.PRODUCT_NAME_AND_ASSET_CATEGORY, productScheme.getNameCategory());
            values.put(DbHandler.PRODUCT_SCHEME, productScheme.getScheme());
            values.put(DbHandler.PRODUCT_TENOR, productScheme.getTenor());
            values.put(DbHandler.PRODUCT_ROI, productScheme.getRoi());
            values.put(DbHandler.PRODUCT_TYPE, productScheme.getType());
            values.put(DbHandler.APPROVE_AMNT, productScheme.getApproveAmnt());
            values.put(DbHandler.APPROVE_EMI, productScheme.getEmiAmnt());

            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();

            sqLiteDatabase.insert(DbHandler.TABLE_PRODUCT_SCHEME, null, values);

            dbHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProductScheme> getAll(Context context) {
        ArrayList<ProductScheme> productSchemes = new ArrayList<>();

        try {
            String getAllQuery = new StringBuilder()
                    .append("SELECT * FROM ").append(DbHandler.TABLE_PRODUCT_SCHEME)
//                .append(" WHERE ")
//                .append(DbHandler.PRODUCT_TYPE).append("=").append(position)
                    .toString();

            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(getAllQuery, null);

            if (cursor != null & cursor.moveToFirst()) {
                do {
                    ProductScheme productScheme = new ProductScheme();
                    productScheme.setId(cursor.getInt(cursor.getColumnIndex(DbHandler.PRODUCT_ID)));
                    productScheme.setProductName(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_NAME)));
                    productScheme.setAssetCategory(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_ASSET_CATEGORY)));
                    productScheme.setNameCategory(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_NAME_AND_ASSET_CATEGORY)));
                    productScheme.setScheme(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_SCHEME)));
                    productScheme.setTenor(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_TENOR)));
                    productScheme.setRoi(cursor.getString(cursor.getColumnIndex(DbHandler.PRODUCT_ROI)));
                    productScheme.setType(cursor.getInt(cursor.getColumnIndex(DbHandler.PRODUCT_TYPE)));
                    productScheme.setEmiAmnt(cursor.getFloat(cursor.getColumnIndex(DbHandler.APPROVE_EMI)));
                    productScheme.setApproveAmnt(cursor.getFloat(cursor.getColumnIndex(DbHandler.APPROVE_AMNT)));

                    productSchemes.add(productScheme);
                } while (cursor.moveToNext());
            }

            cursor.close();
            dbHandler.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productSchemes;
    }

    public float getTotalApproveAmnt(Context context) {
        float total = 0.0f;
        try {
            String getTotalAmnt = new StringBuilder()
                    .append("SELECT ")
                    .append("SUM(").append(DbHandler.APPROVE_AMNT).append(")").append(" AS ").append(DbHandler.TOTAL)
                    .append(" FROM ")
                    .append(DbHandler.TABLE_PRODUCT_SCHEME)
                    .toString();

            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(getTotalAmnt, null);

            if (cursor != null & cursor.moveToFirst()) {
                total = cursor.getFloat(cursor.getColumnIndex(DbHandler.TOTAL));
            }

            cursor.close();
            dbHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public long getProductSchemeBySchemeName(Context context, String nameCategory) {
        long id = 0;

        try {
            String getProductSchemeBySchemeNameQuery = new StringBuilder()
                    .append("SELECT * FROM ")
                    .append(DbHandler.TABLE_PRODUCT_SCHEME)
                    .append(" WHERE ")
                    .append(DbHandler.PRODUCT_NAME_AND_ASSET_CATEGORY).append("='").append(nameCategory).append("'")
                    .toString();
            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(getProductSchemeBySchemeNameQuery, null);

            if (cursor != null & cursor.moveToFirst()) {
                id = cursor.getInt(cursor.getColumnIndex(DbHandler.PRODUCT_ID));
            }

            cursor.close();
            dbHandler.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void updateProduct(Context context, long productId, ProductScheme productScheme) {
        try {
            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DbHandler.PRODUCT_NAME, productScheme.getProductName());
            values.put(DbHandler.PRODUCT_ASSET_CATEGORY, productScheme.getAssetCategory());
            values.put(DbHandler.PRODUCT_NAME_AND_ASSET_CATEGORY, productScheme.getNameCategory());
            values.put(DbHandler.PRODUCT_SCHEME, productScheme.getScheme());
            values.put(DbHandler.PRODUCT_TENOR, productScheme.getTenor());
            values.put(DbHandler.PRODUCT_ROI, productScheme.getRoi());
            values.put(DbHandler.PRODUCT_TYPE, productScheme.getType());
            values.put(DbHandler.APPROVE_AMNT, productScheme.getApproveAmnt());
            values.put(DbHandler.APPROVE_EMI, productScheme.getEmiAmnt());

            sqLiteDatabase.update(DbHandler.TABLE_PRODUCT_SCHEME, values, DbHandler.PRODUCT_ID + "=?", new String[]{String.valueOf(productId)});

            dbHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Context context, long productId){
        try{
            DbHandler dbHandler = new DbHandler(context);
            SQLiteDatabase sqLiteDatabase = dbHandler.getWritableDatabase();

            int i = sqLiteDatabase.delete(DbHandler.TABLE_PRODUCT_SCHEME, DbHandler.PRODUCT_ID + "=?", new String[]{String.valueOf(productId)});
            dbHandler.close();

            Toast.makeText(context, "" + i + "deleted" , Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
