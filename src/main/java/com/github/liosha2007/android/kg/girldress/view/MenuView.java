package com.github.liosha2007.android.kg.girldress.view;

import android.view.View;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.controller.MenuController;
import com.github.liosha2007.android.library.activity.view.BaseActivityView;

/**
 * Created by liosha on 29.06.2014.
 */
public class MenuView extends BaseActivityView<MenuController> {
    public MenuView() {
        super(R.layout.layout_menu);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        view(R.id.bu_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onPlayClicked();
            }
        });
        view(R.id.bu_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onExitClicked();
            }
        });
    }
}
