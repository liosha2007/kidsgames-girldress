package com.github.liosha2007.android.kg.girldress.controller;

import com.github.liosha2007.android.kg.girldress.view.MenuView;
import com.github.liosha2007.android.library.activity.controller.BaseActivityController;

/**
 * Created by liosha on 29.06.2014.
 */
public class MenuController extends BaseActivityController<MenuView> {
    public MenuController() {
        super(new MenuView());
    }

    public void onPlayClicked() {
        run(DashboardController.class);
    }

    public void onExitClicked() {
        finish();
    }
}
