package circlemenu.com.simpletabview.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import circlemenu.com.simpletabview.R;
import circlemenu.com.simpletabview.adapter.ProductSchemeRecyclerAdapter;
import circlemenu.com.simpletabview.adapter.ViewPagerAdapter;
import circlemenu.com.simpletabview.asynctask.DbAsyncTask;
import circlemenu.com.simpletabview.model.ProductScheme;
import circlemenu.com.simpletabview.service.ProductSchemeDbService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView txtViewTotalAmnt, bottomTxtViewTotalAmnt;
    private LinearLayout  bottomSheet, layoutBottomHeading, layoutBottomFooter, layoutBottomHeader;
    private RecyclerView recyclerViewProductScheme;
    private ArrayList<ProductScheme> mProductSchemeList;
    private ProductSchemeDbService productSchemeDbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        recyclerViewProductScheme = findViewById(R.id.recyclerViewProductScheme);

       // layoutBottomSheet = findViewById(R.id.layoutBottomSheet);
        // layoutBottomSheet = findViewById(R.id.layoutBottomSheet);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        //Db Service Called
        new DbAsyncTask(this).execute();

        productSchemeDbService = new ProductSchemeDbService();

        mProductSchemeList = new ArrayList<>();

        bottomSheet = findViewById(R.id.bottomsheet);
        layoutBottomHeader = findViewById(R.id.layoutBottomHeader);
        layoutBottomHeading = findViewById(R.id.layoutBottomHeading);
        layoutBottomFooter = findViewById(R.id.layoutBottomFooter);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        txtViewTotalAmnt = findViewById(R.id.txtViewTotalAmnt);
        bottomTxtViewTotalAmnt = findViewById(R.id.bottomTxtViewTotalAmnt);


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {

                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        getAllProductScheme();
                        setRecyclerAdapter();
                        setTotal();
                        layoutBottomHeader.setVisibility(View.GONE);
                        layoutBottomHeading.setVisibility(View.VISIBLE);
                        layoutBottomFooter.setVisibility(View.VISIBLE);
                        }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        layoutBottomHeader.setVisibility(View.VISIBLE);
                        layoutBottomHeading.setVisibility(View.GONE);
                        layoutBottomFooter.setVisibility(View.GONE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });


        /*layoutBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    //txtViewPay.setText("Close sheet");
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    // txtViewPay.setText("Expand sheet");
                }
            }
        });*/

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setTotal();

        copyDbSdcard();
    }

    private void copyDbSdcard() {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//circlemenu.com.simpletabview//databases//ProductScheme.db";
                String backupDBPath = "ProductScheme.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
        }
    }


    private void getAllProductScheme() {
        mProductSchemeList = productSchemeDbService.getAll(this);
        Log.e(TAG, "Product Scheme Size ===> " + mProductSchemeList.size());
    }

    private void setRecyclerAdapter() {
        ProductSchemeRecyclerAdapter productSchemeRecyclerAdapter = new ProductSchemeRecyclerAdapter(this, mProductSchemeList);
        recyclerViewProductScheme.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewProductScheme.setHasFixedSize(true);
        recyclerViewProductScheme.setAdapter(productSchemeRecyclerAdapter);
    }

    private void setTotal() {
        float fl = productSchemeDbService.getTotalApproveAmnt(this);
        Log.e("FloatamountValueis ", "" + fl);
      //  txtViewTotalAmnt.setText("1298778");
       txtViewTotalAmnt.setText(String.valueOf(productSchemeDbService.getTotalApproveAmnt(this)));
       bottomTxtViewTotalAmnt.setText(String.valueOf(productSchemeDbService.getTotalApproveAmnt(this)));
    }
}