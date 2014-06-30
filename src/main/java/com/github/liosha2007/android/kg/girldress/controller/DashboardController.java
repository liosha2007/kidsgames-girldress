package com.github.liosha2007.android.kg.girldress.controller;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.common.ComponentType;
import com.github.liosha2007.android.kg.girldress.view.DashboardView;
import com.github.liosha2007.android.library.activity.controller.BaseActivityController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @autored by liosha on 29.06.2014.
 */
public class DashboardController extends BaseActivityController<DashboardView> {
    protected Map<ComponentType, Integer> componentsToDraw = new TreeMap<ComponentType, Integer>(){{
        put(ComponentType.HEIR, R.drawable.im_volosy_1);
    }};

    public DashboardController() {
        super(new DashboardView());
    }

    @Override
    protected void onCreate() {
        super.onCreate();

        view.drawState(componentsToDraw);
        onGroupClicked(ComponentType.DRESS);
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
        view.drawState(componentsToDraw);
    }
}
