package com.github.liosha2007.android.kg.girldress.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.common.ComponentPair;
import com.github.liosha2007.android.kg.girldress.common.ComponentType;
import com.github.liosha2007.android.kg.girldress.controller.DashboardController;
import com.github.liosha2007.android.library.activity.view.BaseActivityView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liosha on 29.06.2014.
 */
public class DashboardView extends BaseActivityView<DashboardController> {
    protected ComponentType componentType;
    protected int componentId;

    protected Map<ComponentType, List<ComponentPair>> group2components = new TreeMap<ComponentType, List<ComponentPair>>() {{
        put(ComponentType.DRESS,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_platye_1_min, R.drawable.im_platye_1),
                        new ComponentPair(R.drawable.im_platye_2_min, R.drawable.im_platye_2),
                        new ComponentPair(R.drawable.im_platye_3_min, R.drawable.im_platye_3)
                )
        );
        put(ComponentType.HEIR,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_volosy_1_min, R.drawable.im_volosy_1),
                        new ComponentPair(R.drawable.im_volosy_2_min, R.drawable.im_volosy_2)
                )
        );
        put(ComponentType.SHOES,
                Arrays.asList(
                        new ComponentPair(R.drawable.im_tufli_1_min, R.drawable.im_tufli_1),
                        new ComponentPair(R.drawable.im_tufli_2_min, R.drawable.im_tufli_2)
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
        for (Map.Entry<ComponentType, Integer> entry : componentsToDraw.entrySet()) {
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
                controller.onComponentClicked((ComponentType) view.getTag(), view.getId());
            }
        });
        component.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float x = event.getRawX();
                    float y = event.getRawY();
                    ImageView target = DashboardView.this.view(R.id.girl_image);
                    if (x > target.getX() && y > target.getY() && x < target.getX() + target.getWidth() && y < target.getY() + target.getHeight()) {
                        controller.onComponentClicked(DashboardView.this.componentType, DashboardView.this.componentId);
                        return true;
                    }
                    return true;
                } else if (v instanceof ImageView && event.getAction() == MotionEvent.ACTION_DOWN && v.getTag() != null) {
                    ImageView source = (ImageView) v;
                    DashboardView.this.componentType = (ComponentType) source.getTag();
                    DashboardView.this.componentId = source.getId();
                    return true;
                }
                return false;
            }
        });
        return component;
    }

    private View createEmptyComponent(ComponentType componentType) {
        ImageView emptyImageView = createComponent(new ComponentPair(R.drawable.im_empty, R.drawable.im_empty), componentType);
        emptyImageView.setTag(componentType);
        emptyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onEmptyComponentClicked((ComponentType) view.getTag());
            }
        });
        return emptyImageView;
    }
}
