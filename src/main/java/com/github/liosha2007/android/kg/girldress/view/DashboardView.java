package com.github.liosha2007.android.kg.girldress.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.liosha2007.android.kg.girldress.R;
import com.github.liosha2007.android.kg.girldress.common.ComponentPair;
import com.github.liosha2007.android.kg.girldress.common.ComponentType;
import com.github.liosha2007.android.kg.girldress.controller.DashboardController;
import com.github.liosha2007.android.library.activity.view.BaseActivityView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liosha on 29.06.2014.
 */
public class DashboardView extends BaseActivityView<DashboardController> {
    protected ComponentType componentType;
    protected int componentId;

    protected List<Integer> backgrounds = new ArrayList<Integer>(){{
        add(R.drawable.im_background_01);
        add(R.drawable.im_background_02);
    }};
    protected Map<ComponentType, List<ComponentPair>> group2components = new TreeMap<ComponentType, List<ComponentPair>>() {{
        put(ComponentType.DRESS, // Платье
                Arrays.asList(
                        new ComponentPair(R.drawable.im_platye_min_01, R.drawable.im_platye_01),
                        new ComponentPair(R.drawable.im_platye_min_02, R.drawable.im_platye_02),
                        new ComponentPair(R.drawable.im_platye_min_03, R.drawable.im_platye_03),
                        new ComponentPair(R.drawable.im_platye_min_04, R.drawable.im_platye_04),
                        new ComponentPair(R.drawable.im_platye_min_05, R.drawable.im_platye_05),
                        new ComponentPair(R.drawable.im_platye_min_06, R.drawable.im_platye_06),
                        new ComponentPair(R.drawable.im_platye_min_07, R.drawable.im_platye_07),
                        new ComponentPair(R.drawable.im_platye_min_08, R.drawable.im_platye_08),
                        new ComponentPair(R.drawable.im_platye_min_09, R.drawable.im_platye_09),
                        new ComponentPair(R.drawable.im_platye_min_10, R.drawable.im_platye_10),
                        new ComponentPair(R.drawable.im_platye_min_11, R.drawable.im_platye_11),
                        new ComponentPair(R.drawable.im_platye_min_12, R.drawable.im_platye_12)
                )
        );
        put(ComponentType.HEIR, // Волосы
                Arrays.asList(
                        new ComponentPair(R.drawable.im_volosy_min_01, R.drawable.im_volosy_01),
                        new ComponentPair(R.drawable.im_volosy_min_02, R.drawable.im_volosy_02),
                        new ComponentPair(R.drawable.im_volosy_min_03, R.drawable.im_volosy_03),
                        new ComponentPair(R.drawable.im_volosy_min_04, R.drawable.im_volosy_04),
                        new ComponentPair(R.drawable.im_volosy_min_05, R.drawable.im_volosy_05),
                        new ComponentPair(R.drawable.im_volosy_min_06, R.drawable.im_volosy_06),
                        new ComponentPair(R.drawable.im_volosy_min_07, R.drawable.im_volosy_07),
                        new ComponentPair(R.drawable.im_volosy_min_08, R.drawable.im_volosy_08),
                        new ComponentPair(R.drawable.im_volosy_min_09, R.drawable.im_volosy_09),
                        new ComponentPair(R.drawable.im_volosy_min_10, R.drawable.im_volosy_10),
                        new ComponentPair(R.drawable.im_volosy_min_11, R.drawable.im_volosy_11),
                        new ComponentPair(R.drawable.im_volosy_min_12, R.drawable.im_volosy_12),
                        new ComponentPair(R.drawable.im_volosy_min_13, R.drawable.im_volosy_13),
                        new ComponentPair(R.drawable.im_volosy_min_14, R.drawable.im_volosy_14),
                        new ComponentPair(R.drawable.im_volosy_min_15, R.drawable.im_volosy_15),
                        new ComponentPair(R.drawable.im_volosy_min_16, R.drawable.im_volosy_16),
                        new ComponentPair(R.drawable.im_volosy_min_17, R.drawable.im_volosy_17)
                )
        );
        put(ComponentType.SHOES, // Туфли
                Arrays.asList(
                        new ComponentPair(R.drawable.im_tufli_min_01, R.drawable.im_tufli_01),
                        new ComponentPair(R.drawable.im_tufli_min_02, R.drawable.im_tufli_02),
                        new ComponentPair(R.drawable.im_tufli_min_03, R.drawable.im_tufli_03),
                        new ComponentPair(R.drawable.im_tufli_min_04, R.drawable.im_tufli_04),
                        new ComponentPair(R.drawable.im_tufli_min_05, R.drawable.im_tufli_05),
                        new ComponentPair(R.drawable.im_tufli_min_06, R.drawable.im_tufli_06),
                        new ComponentPair(R.drawable.im_tufli_min_07, R.drawable.im_tufli_07)
                )
        );
        put(ComponentType.SKIRT, // Юбка
                Arrays.asList(
                        new ComponentPair(R.drawable.im_skirt_min_01, R.drawable.im_skirt_01),
                        new ComponentPair(R.drawable.im_skirt_min_02, R.drawable.im_skirt_02),
                        new ComponentPair(R.drawable.im_skirt_min_03, R.drawable.im_skirt_03)
                )
        );
        put(ComponentType.BEAD, // Бусы
                Arrays.asList(
                        new ComponentPair(R.drawable.im_bead_min_01, R.drawable.im_bead_01),
                        new ComponentPair(R.drawable.im_bead_min_02, R.drawable.im_bead_02),
                        new ComponentPair(R.drawable.im_bead_min_03, R.drawable.im_bead_03)
                )
        );
        put(ComponentType.EARRING, // Серьги
                Arrays.asList(
                        new ComponentPair(R.drawable.im_earring_min_01, R.drawable.im_earring_01)
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
        view(R.id.group_skirt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.SKIRT);
            }
        });
        view(R.id.group_bead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.BEAD);
            }
        });
        view(R.id.group_earring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onGroupClicked(ComponentType.EARRING);
            }
        });
        view(R.id.next_background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof ImageButton) {
                    controller.onNextBackgroundClicked();
                }
            }
        });
        view(R.id.prew_background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof ImageButton) {
                    controller.onPrewBackgroundClicked();
                }
            }
        });
    }

    public void drawState(Map<ComponentType, Integer> componentsToDraw) {
        Bitmap girlBitmap = BitmapFactory.decodeResource(controller.getResources(), R.drawable.im_girl).copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(girlBitmap);
        for (Map.Entry<ComponentType, Integer> entry : componentsToDraw.entrySet()) {
            Bitmap componentBitmap = BitmapFactory.decodeResource(controller.getResources(), entry.getValue());
            canvas.drawBitmap(componentBitmap, 0, 0, null);
            componentBitmap.recycle();
        }
        this.<ImageView>view(R.id.girl_image).setImageDrawable(new BitmapDrawable(controller.getResources(), girlBitmap));
    }

    public void showGroupComponents(ComponentType componentType) {
        LinearLayout groupLayout = view(R.id.elems_from_group);
        groupLayout.removeAllViews();

        List<ComponentPair> components = group2components.get(componentType);
        for (ComponentPair componentPair : components) {
            ImageView component = createComponent(componentPair, componentType);
            groupLayout.addView(component);
        }
        groupLayout.addView(createEmptyComponent(componentType));
    }

    private ImageView createComponent(ComponentPair componentPair, ComponentType componentType) {
        ImageView component = new ImageView(controller);
        component.setLayoutParams(new LinearLayout.LayoutParams(170, ViewGroup.LayoutParams.MATCH_PARENT));
        component.setImageDrawable(controller.getResources().getDrawable(componentPair.preview));
        component.setScaleType(ImageView.ScaleType.FIT_CENTER);
        component.setTag(componentType);
        component.setId(componentPair.original);
        component.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float x = event.getRawX();
                    float y = event.getRawY();
                    ImageView target = DashboardView.this.view(R.id.girl_image);
                    if (x > target.getX() && y > target.getY() && x < target.getX() + target.getWidth() && y < target.getY() + target.getHeight()) {
                        controller.onComponentClicked(DashboardView.this.componentType, DashboardView.this.componentId);
                    }
                } else if (v instanceof ImageView && event.getAction() == MotionEvent.ACTION_DOWN && v.getTag() != null) {
                    ImageView source = (ImageView) v;
                    DashboardView.this.componentType = (ComponentType) source.getTag();
                    DashboardView.this.componentId = source.getId();
                }
                return false;
            }
        });
        component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onComponentClicked((ComponentType) view.getTag(), view.getId());
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

    public void showNextBackground() {
        LinearLayout linearLayout = view(R.id.background_image);
        Object tag = linearLayout.getTag();
        int nextIndex = 1;
        if (tag != null){
            nextIndex = backgrounds.indexOf(Integer.parseInt((String) tag)) + 1;
            nextIndex = (nextIndex < backgrounds.size() ? nextIndex : 0);
        }
        linearLayout.setBackgroundResource(backgrounds.get(nextIndex));
        linearLayout.setTag(Integer.toString(backgrounds.get(nextIndex)));
    }

    public void showPrewBackground() {
        LinearLayout linearLayout = view(R.id.background_image);
        Object tag = linearLayout.getTag();
        int nextIndex = 1;
        if (tag != null){
            nextIndex = backgrounds.indexOf(Integer.parseInt((String) tag)) - 1;
            nextIndex = (nextIndex < 0 ? backgrounds.size() - 1 : nextIndex);
        }
        linearLayout.setBackgroundResource(backgrounds.get(nextIndex));
        linearLayout.setTag(Integer.toString(backgrounds.get(nextIndex)));
    }
}
