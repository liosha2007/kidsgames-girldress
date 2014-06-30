package com.github.liosha2007.android.kg.girldress.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.common.ComponentPair;
import com.github.liosha2007.android.kg.girldress.common.ComponentType;
import com.github.liosha2007.android.kg.girldress.controller.DashboardController;
import com.github.liosha2007.android.library.activity.view.BaseActivityView;
import com.github.liosha2007.android.library.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liosha on 29.06.2014.
 */
public class DashboardView extends BaseActivityView<DashboardController> {
    protected Map<ComponentType, List<ComponentPair>> group2components = new TreeMap<ComponentType, List<ComponentPair>>(){{
        put(ComponentType.DRESS,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_platye_1, 0),
                        new ComponentPair(R.drawable.im_platye_2, 0)
                )
        );
        put(ComponentType.HEIR,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_volosy_1, 0),
                        new ComponentPair(R.drawable.im_volosy_2, 0)
                )
        );
        put(ComponentType.SHOES,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_tufli_1, 0),
                        new ComponentPair(R.drawable.im_tufli_2, 0)
                )
        );
    }};

    public DashboardView() {
        super(R.layout.layout_dashboard);
    }

    @Override
    public void onCreate() {
        super.onCreate();


        view(R.id.group_dress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.DRESS);
            }
        });
        view(R.id.group_heir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.HEIR);
            }
        });
        view(R.id.group_shoes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.SHOES);
            }
        });
    }

    public void drawState(Map<ComponentType, Integer> componentsToDraw) {
        Bitmap girlBitmap = BitmapFactory.decodeResource(controller.getResources(), R.drawable.im_girl).copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(girlBitmap);
        for (Map.Entry<ComponentType, Integer> entry : componentsToDraw.entrySet()){
            Bitmap componentBitmap = BitmapFactory.decodeResource(controller.getResources(), entry.getValue());
            canvas.drawBitmap(componentBitmap, 0, 0, null);
        }
        this.<ImageView>view(R.id.girl_image).setImageDrawable(new BitmapDrawable(controller.getResources(), girlBitmap));
    }

    public void showGroupComponents(ComponentType componentType) {
        LinearLayout groupLayout = view(R.id.elems_from_group);
        groupLayout.removeAllViews();
        groupLayout.addView(createEmptyComponent(componentType));

        List<ComponentPair> components = group2components.get(componentType);
        for (ComponentPair componentPair : components) {
            ImageView component = createComponent(componentPair, componentType);
            groupLayout.addView(component);
        }
    }

    private ImageView createComponent(ComponentPair componentPair, ComponentType componentType) {
        ImageView component = new ImageView(controller);
        component.setLayoutParams(new LinearLayout.LayoutParams(170, ViewGroup.LayoutParams.MATCH_PARENT));
        component.setImageDrawable(controller.getResources().getDrawable(componentPair.preview));
        component.setScaleType(ImageView.ScaleType.FIT_CENTER);
        component.setTag(componentType);
        component.setId(componentPair.original);
        component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onComponentClicked((ComponentType)view.getTag(), view.getId());
            }
        });
        return component;
    }

    private View createEmptyComponent(ComponentType componentType) {
        ImageView emptyImageView = createComponent(new ComponentPair(R.drawable.ic_launcher, R.drawable.ic_launcher), componentType);
        emptyImageView.setTag(componentType);
        emptyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onEmptyComponentClicked((ComponentType)view.getTag());
            }
        });
        return emptyImageView;
    }
}
