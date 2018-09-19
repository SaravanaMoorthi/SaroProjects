package circlemenu.com.simpletabview.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import circlemenu.com.simpletabview.R;
import circlemenu.com.simpletabview.model.Category;

public class CategorySpinnerAdapter extends ArrayAdapter<Category> {
    private AppCompatActivity mActivity;
    private int resLayoutId;
    private ArrayList<Category> mMonthList;

    public CategorySpinnerAdapter(AppCompatActivity activity, int resource, ArrayList<Category> monthList) {
        super(activity, resource, monthList);
        mActivity = activity;
        resLayoutId = resource;
        mMonthList = monthList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, parent);
    }

    private View getCustomView(int position, ViewGroup parent) {
        LayoutInflater layoutInflater = mActivity.getLayoutInflater();

        View view = layoutInflater.inflate(resLayoutId, parent, false);

        TextView txtViewMonth = (TextView) view.findViewById(R.id.txtViewItemName);

        txtViewMonth.setText(mMonthList.get(position).getCategoryName());

        return view;
    }
}
