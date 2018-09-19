package circlemenu.com.simpletabview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import circlemenu.com.simpletabview.utility.GenerateSchemeData;
import circlemenu.com.simpletabview.ui.TabFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return GenerateSchemeData.title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return GenerateSchemeData.title[position];
    }
}