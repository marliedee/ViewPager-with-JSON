package org.pursuit.viewpager_json;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {
    private final List<ViewFragment> fragmentlist;

    public ViewPageAdapter(FragmentManager fm, List<ViewFragment> fragmentlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
