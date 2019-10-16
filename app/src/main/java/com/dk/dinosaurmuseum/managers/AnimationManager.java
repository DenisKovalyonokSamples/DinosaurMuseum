package com.dk.dinosaurmuseum.managers;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.dk.dinosaurmuseum.MainActivity;

public class AnimationManager {
    private MainActivity _ownerActivity;
    private int _bottomBarHeight = 0;

    public AnimationManager(MainActivity owner) {
        _ownerActivity = owner;
    }

    // slide the view from below itself to the current position
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);

        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                   // toXDelta
                _bottomBarHeight,             // fromYDelta
                0);                   // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);

        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = _bottomBarHeight;
        view.setLayoutParams(params);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                   // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);

        animate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                _ownerActivity.initFullScreenMode(view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animate);
    }

    public void rotateFabForward(FloatingActionButton fab) {
        ViewCompat.animate(fab)
                .rotation(135.0F)
                .withLayer()
                .setDuration(300L)
                .setInterpolator(new OvershootInterpolator(10.0F))
                .start();
    }

    public void rotateFabBackward(FloatingActionButton fab) {
        ViewCompat.animate(fab)
                .rotation(0.0F)
                .withLayer()
                .setDuration(300L)
                .setInterpolator(new OvershootInterpolator(10.0F))
                .start();
    }

    public void setBottomBarHeight(int value) {
        _bottomBarHeight = value;
    }
}

