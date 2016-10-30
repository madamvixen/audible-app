package com.example.malabika.closeencounters;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Malabika on 10/29/2016.
 */

public class EmojiSliderActivity extends Activity implements SlidingPaneLayout.PanelSlideListener{

//    @Bind(R.id.emoji_grid_view)
//    GridView emojiGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emoji_layout);
        ButterKnife.bind(this);

        GridView emojiGridView = (GridView) findViewById(R.id.emoji_grid_view);
        EmojiAdapter emojiAdapter = new EmojiAdapter(this, R.layout.grid_item_layout, getData(mThumbIds));
        emojiGridView.setAdapter(emojiAdapter);
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        //TODO: Add some animation
    }

    @Override
    public void onPanelOpened(View panel) {
    }

    @Override
    public void onPanelClosed(View panel) {

    }

    @OnClick(R.id.close_button)
    public void closePane() {
        finish();
        //Add animation
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.normal_angry, R.drawable.normal_censor,
            R.drawable.normal_confused, R.drawable.normal_eggplant,
            R.drawable.normal_funny, R.drawable.normal_love,
            R.drawable.normal_peach, R.drawable.normal_rip,
            R.drawable.normal_sad, R.drawable.normal_happy,
            R.drawable.normal_shock, R.drawable.normal_wtf
    };

    public ArrayList<Integer> getData(Integer[] resids) {
        ArrayList<Integer> data = new ArrayList<>();
        for(int id: resids) {
            data.add(id);
        }
        return data;
    }

}
