package circlemenu.com.simpletabview.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.xml.transform.stream.StreamSource;

import circlemenu.com.simpletabview.R;
import circlemenu.com.simpletabview.model.Category;
import circlemenu.com.simpletabview.model.ProductScheme;
import circlemenu.com.simpletabview.model.SchemeDetail;
import circlemenu.com.simpletabview.service.ProductSchemeDbService;
import circlemenu.com.simpletabview.utility.GenerateSchemeData;

public class CustomMainAdapter extends RecyclerView.Adapter<CustomMainAdapter.MyViewHolder> {
    private final String TAG = CustomMainAdapter.class.getSimpleName();

    private AppCompatActivity mActivity;
    private LayoutInflater mInflater;
    private ArrayList<Category> mCategoryList;
    private ArrayList<ProductScheme> mProductSchemeList;
    private ProductSchemeDbService productSchemeDbService;

    private int mFragmentPosition = 0;

    private static final String DECIMAL_POINT = ".";
    private static final String ZERO_DECIMAL = "0";
    private static final String TWO_DIGIIT_DECIMAL_FORMAT = "#.##";

    private Handler handler = new Handler();
    private Runnable runnable;

    public CustomMainAdapter(AppCompatActivity activity, ArrayList<Category> categoryList, int fragmentPosition) {
        mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity);
        this.mCategoryList = categoryList;
        mFragmentPosition = fragmentPosition;

        productSchemeDbService = new ProductSchemeDbService();

        mProductSchemeList = productSchemeDbService.getAll(mActivity);
    }

    @NonNull
    @Override
    public CustomMainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.main_list, viewGroup, false);
        return new CustomMainAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomMainAdapter.MyViewHolder myViewHolder, final int position) {
        try {

            final String assetCategory = mCategoryList.get(position).getCategoryName();

            String productAndCategory = GenerateSchemeData.title[mFragmentPosition] + "_" + assetCategory;

            final ArrayList<SchemeDetail> mSchemeDetails = mCategoryList.get(position).getSchemeDetails();

            myViewHolder.txtViewCategoryName.setText(assetCategory);

            SchemeDetailSpinnerAdapter schemeDetailSpinnerAdapter = new SchemeDetailSpinnerAdapter(mActivity, R.layout.row_item_name, mSchemeDetails);
            myViewHolder.spinnerScheme.setAdapter(schemeDetailSpinnerAdapter);

            for (int i = 0; i < mProductSchemeList.size(); i++) {
                if (mProductSchemeList.get(i).getNameCategory().equalsIgnoreCase(productAndCategory)) {
                    int itemPosition = getItemPosition(mSchemeDetails, mProductSchemeList.get(i));
                    Log.e(TAG, "Position ===> " + itemPosition);

                    myViewHolder.spinnerScheme.setSelection(itemPosition);

                    myViewHolder.editTextApproveAmnt.setText(String.valueOf(mProductSchemeList.get(i).getApproveAmnt()));
                    myViewHolder.editTextEmi.setText(String.valueOf(mProductSchemeList.get(i).getEmiAmnt()));
                }
            }

            myViewHolder.spinnerScheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    if (position != 0) {

                        String mStrTenor = mSchemeDetails.get(position).getTenor().toString();
                        String mStrRoi = mSchemeDetails.get(position).getRoi().toString();

                        myViewHolder.layoutTenorRoi.setVisibility(View.VISIBLE);
                        myViewHolder.editTextApproveAmnt.setEnabled(true);

                        myViewHolder.editTextRoi.setText(mStrRoi);
                        myViewHolder.editTextTenor.setText(mStrTenor);

                    } else {
                        myViewHolder.layoutTenorRoi.setVisibility(View.VISIBLE);
                        myViewHolder.editTextApproveAmnt.setEnabled(false);
                        myViewHolder.editTextApproveAmnt.setText("0.0");
                        myViewHolder.editTextTenor.setText("0");
                        myViewHolder.editTextRoi.setText("0");
                        myViewHolder.editTextEmi.setText("0");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            myViewHolder.editTextApproveAmnt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    handler.removeCallbacks(runnable);

                    String tenor = getValueByAddingZero(myViewHolder.editTextTenor);
                    String roi = getValueByAddingZero(myViewHolder.editTextRoi);
                    String approveAmnt = getValueByAddingZero(myViewHolder.editTextApproveAmnt);

                    if (tenor.length() != 0 && roi.length() != 0 && approveAmnt.length() != 0) {
                        //float total = Float.parseFloat(tenor) * Float.parseFloat(roi);

                        myViewHolder.editTextEmi.setText(String.valueOf
                                (new DecimalFormat(TWO_DIGIIT_DECIMAL_FORMAT)
                                        .format(getEmi(Float.parseFloat(approveAmnt), Integer.parseInt(tenor), Float.parseFloat(roi)))));
//                        txtViewAmount.setText(new DecimalFormat(ProjectConstants.TWO_DIGIIT_DECIMAL_FORMAT).format(total));
                    } else
                        myViewHolder.editTextEmi.setText("");
                }

                @Override
                public void afterTextChanged(Editable editable) {

                    String productName = GenerateSchemeData.title[mFragmentPosition];
                    final String scheme = ((SchemeDetail) myViewHolder.spinnerScheme.getSelectedItem()).getScheme();
                    String tenor = myViewHolder.editTextTenor.getText().toString().trim();
                    String roi = myViewHolder.editTextRoi.getText().toString().trim();

                    float approveAmnt = 0.0f;
                    float emiAmnt = 0.0f;

                    if (myViewHolder.editTextApproveAmnt.getText().toString().trim().equals(""))
                        approveAmnt = 0.0f;
                    else
                        approveAmnt = Float.parseFloat(myViewHolder.editTextApproveAmnt.getText().toString().trim());

                    Log.e("AproveAmnt==========", "" +approveAmnt);

                    if (myViewHolder.editTextEmi.getText().toString().trim().equals(""))
                        emiAmnt = 0.0f;
                    else
                        emiAmnt = Float.parseFloat(myViewHolder.editTextEmi.getText().toString().trim());

                    final ProductScheme productScheme = new ProductScheme();
                    productScheme.setProductName(productName);
                    productScheme.setAssetCategory(assetCategory);
                    productScheme.setNameCategory(productName + "_" + assetCategory);
                    productScheme.setScheme(scheme);
                    productScheme.setTenor(tenor);
                    productScheme.setRoi(roi);
                    productScheme.setApproveAmnt(approveAmnt);
                    productScheme.setEmiAmnt(emiAmnt);

                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            long productId = productSchemeDbService.getProductSchemeBySchemeName(mActivity, productScheme.getNameCategory());
                            Log.e("AproveAmnt//", "" +productScheme.getApproveAmnt());

                            if (productId != 0) {

                                if(productScheme.getApproveAmnt() == 0.0f){
                                    removeProduct(mActivity, productId);
                                }else {
                                    updateProduct(mActivity, productId, productScheme);
                                }
                            } else {
                                if(productScheme.getApproveAmnt() != 0.0f)
                                addProductScheme(productScheme);
                            }
                        }
                    };

                    handler.postDelayed(runnable, 2000);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getItemPosition(ArrayList<SchemeDetail> mSchemeDetails, ProductScheme productScheme) {
        for (int i = 0; i < mSchemeDetails.size(); i++) {
            if (mSchemeDetails.get(i).getScheme().equalsIgnoreCase(productScheme.getScheme()))
                return i;
        }
        return 0;
    }

    private void updateProduct(Context context, long productId, ProductScheme productScheme) {
        productSchemeDbService.updateProduct(context, productId, productScheme);
    }

    private void removeProduct(Context context, long productId) {
        productSchemeDbService.removeProduct(context, productId);
    }

    private void addProductScheme(ProductScheme productScheme) {
        productSchemeDbService.add(mActivity, productScheme);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewProductScheme;
        TextView txtViewCategoryName;
        Spinner spinnerScheme;
        EditText editTextRoi, editTextTenor, editTextApproveAmnt, editTextEmi;
        LinearLayout layoutTenorRoi;

        public MyViewHolder(View view) {
            super(view);

            txtViewCategoryName = view.findViewById(R.id.txtViewCategoryName);

            spinnerScheme = view.findViewById(R.id.spinnerScheme);

            editTextRoi = view.findViewById(R.id.editTextRoi);
            editTextTenor = view.findViewById(R.id.editTextTenor);
            editTextApproveAmnt = view.findViewById(R.id.editTextApproveAmnt);
            editTextEmi = view.findViewById(R.id.editTextEmi);

            layoutTenorRoi = view.findViewById(R.id.layoutTenorRoi);
        }
    }


    public double getEmi(float principal, int time, float rate) {
        double emi = 0.0f;

        //emi = amnt * roi * Math.pow(1 + roi, tenor) / Math.pow(1 + roi, tenor -1);
        rate = rate / (12 * 100);
        time = time * 12;
        emi = (principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);


        Log.e("EmiAmnt", "" + emi);
        return emi;

    }

    private String getValueByAddingZero(EditText editText) {
        String zeroDecimal = null;
        String currentQuantity = editText.getText().toString().trim();
        if (currentQuantity.equals(DECIMAL_POINT))
            zeroDecimal = ZERO_DECIMAL + currentQuantity;
        else
            zeroDecimal = String.valueOf(currentQuantity);
        return zeroDecimal;
    }
}
