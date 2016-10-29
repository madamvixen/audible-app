package com.example.malabika.closeencounters;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Malabika on 10/29/2016.
 */

public class EmojiSliderActivity extends Activity implements SlidingPaneLayout.PanelSlideListener{

    @Bind(R.id.emoji_grid_view)
    GridView emojiGridView;

    public static EmojiSliderActivity newInstance() {
        return new EmojiSliderActivity();
    }
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) inflater.inflate(R.layout.emoji_layout, null);
//        slidingPaneLayout.openPane();
//
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emoji_layout);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    // references to our images
    private int[] mThumbIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    public ArrayList<Integer> getData(int[] resids) {
        ArrayList<Integer> data = new ArrayList<>();
        for(int id: resids) {
            data.add(id);
        }
        return data;
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

    }

    @Override
    public void onPanelOpened(View panel) {
            GridView emojiGridView = (GridView) panel.findViewById(R.id.emoji_grid_view);
            EmojiAdapter emojiAdapter = new EmojiAdapter(getContext(), R.layout.grid_item_layout, getData(mThumbIds));
            emojiGridView.setAdapter(emojiAdapter);
    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
