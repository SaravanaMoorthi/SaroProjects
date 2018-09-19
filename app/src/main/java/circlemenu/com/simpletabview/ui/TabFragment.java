package circlemenu.com.simpletabview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import circlemenu.com.simpletabview.adapter.CustomMainAdapter;
import circlemenu.com.simpletabview.utility.GenerateSchemeData;
import circlemenu.com.simpletabview.R;
import circlemenu.com.simpletabview.model.Category;

public class TabFragment extends Fragment  {
    private static final String TAG = TabFragment.class.getSimpleName();
    private RecyclerView recyclerViewProductScheme;
    private RecyclerView.LayoutManager layoutManager;
    private int fragmentPosition;
    private ArrayList<Category> mCategoryList;
    private static final String KEY_POSITION = "pos";

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POSITION, position);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentPosition = getArguments().getInt(KEY_POSITION);

        Log.e(TAG, "Fragment fragmentPosition == "+ fragmentPosition);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initData();
    }



    private void initData() {
        GenerateSchemeData generateSchemeData = new GenerateSchemeData(fragmentPosition);
        mCategoryList = generateSchemeData.getCategoryList();
        Log.e(TAG, "Category List ===> " + mCategoryList.size());
        setRecyclerAdapter();
    }

    private void initViews(View view) {
        recyclerViewProductScheme = (RecyclerView) view.findViewById(R.id.recyclerViewProductScheme);
    }

    private void setRecyclerAdapter() {
        CustomMainAdapter customMainAdapter = new CustomMainAdapter((AppCompatActivity) getActivity(), mCategoryList,fragmentPosition);
        layoutManager = new LinearLayoutManager((AppCompatActivity) getActivity());
        recyclerViewProductScheme.setLayoutManager(layoutManager);
        recyclerViewProductScheme.setHasFixedSize(true);
        recyclerViewProductScheme.setAdapter(customMainAdapter);
    }
}