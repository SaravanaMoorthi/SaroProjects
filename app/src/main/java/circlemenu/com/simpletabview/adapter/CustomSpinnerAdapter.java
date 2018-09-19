//package circlemenu.com.simpletabview;
//
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class CustomSpinnerAdapter extends ArrayAdapter<String> {
//    private AppCompatActivity mActivity;
//    private int resLayoutId;
//    private ArrayList<String> mAssetCategoryList;
//
//    public CustomSpinnerAdapter(AppCompatActivity activity, int resource, ArrayList<String> assetCategoryList) {
//        super(activity, resource, assetCategoryList);
//        mActivity = activity;
//        resLayoutId = resource;
//        mAssetCategoryList = assetCategoryList;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return getCustomView(position, parent);
//    }
//
//    @Override
//    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return getCustomView(position, parent);
//    }
//
//    private View getCustomView(int position, ViewGroup parent) {
//        LayoutInflater layoutInflater = mActivity.getLayoutInflater();
//
//        View view = layoutInflater.inflate(resLayoutId, parent, false);
//
//        TextView txtViewSpinnerItemName = (TextView) view.findViewById(R.id.txtViewSpinnerItemName);
//
//        txtViewSpinnerItemName.setText(mAssetCategoryList.get(position));
//
//        return view;
//    }
//}
