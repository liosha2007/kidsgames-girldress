package com.github.liosha2007.android.kg.girldress.controller;

import android.media.MediaPlayer;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.common.ComponentType;
import com.github.liosha2007.android.kg.girldress.view.DashboardView;
import com.github.liosha2007.android.library.activity.controller.BaseActivityController;

import java.util.Map;
import java.util.TreeMap;

/**
 * @autored by liosha on 29.06.2014.
 */
public class DashboardController extends BaseActivityController<DashboardView> {
    protected static float PLAYER_VOLUME = 0.08f;
    protected MediaPlayer mPlayer;
    protected Map<ComponentType, Integer> componentsToDraw = new TreeMap<ComponentType, Integer>() {{
        put(ComponentType.HEIR, R.drawable.im_volosy_01);
    }};
    protected int playerPosition;

    public DashboardController() {
        super(new DashboardView());
    }

    @Override
    protected void onCreate() {
        super.onCreate();

        view.drawState(componentsToDraw);
        onGroupClicked(ComponentType.DRESS);
        mPlayer = MediaPlayer.create(this, R.raw.mp_anime_1);
        if (mPlayer != null) {
            mPlayer.setVolume(PLAYER_VOLUME, PLAYER_VOLUME);
            mPlayer.setLooping(true);
            mPlayer.start();
        }
        view.showNextBackground();
    }

    public void onGroupClicked(ComponentType componentType) {
        view.showGroupComponents(componentType);
    }

    public void onEmptyComponentClicked(ComponentType componentType) {
        componentsToDraw.remove(componentType);
        view.drawState(componentsToDraw);
    }

    public void onComponentClicked(ComponentType componentType, int id) {
        componentsToDraw.put(componentType, id);
        switch (componentType){
            case SKIRT:
                componentsToDraw.remove(ComponentType.DRESS);
                break;
            case DRESS:
                componentsToDraw.remove(ComponentType.SKIRT);
                break;
        }
        view.drawState(componentsToDraw);
    }

    @Override
    public void onBackPressed() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
            playerPosition = mPlayer.getCurrentPosition();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (mPlayer != null) {
            mPlayer.seekTo(playerPosition);
            mPlayer.start();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        super.onDestroy();
    }

    public void onNextBackgroundClicked() {
        view.showNextBackground();
    }

    public void onPrewBackgroundClicked() {
        view.showPrewBackground();
    }
}
