package circlemenu.com.simpletabview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import circlemenu.com.simpletabview.R;
import circlemenu.com.simpletabview.model.ProductScheme;

public class ProductSchemeRecyclerAdapter extends RecyclerView.Adapter<ProductSchemeRecyclerAdapter.MyViewHolder> {
    private ArrayList<ProductScheme> mProductSchemes;
    private AppCompatActivity mActivity;
    private LayoutInflater mInflater;

    public ProductSchemeRecyclerAdapter(AppCompatActivity activity, ArrayList<ProductScheme> productSchemes) {
        mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity);
        mProductSchemes = productSchemes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.row_product_scheme, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        ProductScheme productandScheme = mProductSchemes.get(position);

        myViewHolder.cardViewProductScheme.setTag(productandScheme);

        myViewHolder.txtViewProductName.setText(productandScheme.getProductName());
        myViewHolder.txtViewAssetCategory.setText(productandScheme.getAssetCategory());
        myViewHolder.txtViewScheme.setText(productandScheme.getScheme());
        myViewHolder.txtViewTenor.setText(productandScheme.getTenor());
        myViewHolder.txtViewRoi.setText(productandScheme.getRoi());
        myViewHolder.txtViewApproveAmnt.setText(String.valueOf(productandScheme.getApproveAmnt()));
    }

    @Override
    public int getItemCount() {
        return mProductSchemes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewProductScheme;
        TextView txtViewProductName, txtViewAssetCategory, txtViewApproveAmnt, txtViewScheme, txtViewTenor, txtViewRoi;

        public MyViewHolder(View view) {
            super(view);

            cardViewProductScheme = view.findViewById(R.id.cardViewProductScheme);
            txtViewProductName = view.findViewById(R.id.txtViewProductName);
            txtViewAssetCategory = view.findViewById(R.id.txtViewAssetCategory);
            txtViewApproveAmnt = view.findViewById(R.id.txtViewApproveAmnt);
            txtViewScheme = view.findViewById(R.id.txtViewScheme);
            txtViewTenor = view.findViewById(R.id.txtViewTenor);
            txtViewRoi = view.findViewById(R.id.txtViewRoi);
        }
    }
}
