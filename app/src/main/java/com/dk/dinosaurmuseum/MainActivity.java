package com.dk.dinosaurmuseum;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dk.dinosaurmuseum.adapters.DinosaursGridViewAdapter;
import com.dk.dinosaurmuseum.adapters.FossilsGridViewAdapter;
import com.dk.dinosaurmuseum.adapters.SkeletonsGridViewAdapter;
import com.dk.dinosaurmuseum.enums.SceneObjectType;
import com.dk.dinosaurmuseum.managers.ARManager;
import com.dk.dinosaurmuseum.managers.AnimationManager;
import com.dk.dinosaurmuseum.managers.PhotoManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Context _context;

    //AR CORE
    private static final double MIN_OPENGL_VERSION = 3.0;

    public ArFragment arFragment;

    private AnimationManager _animationManager;
    private PhotoManager _photoManager;
    private ARManager _arManager;

    //BOTTOM APP BAR
    private BottomAppBar bottomAppBar;
    private FloatingActionButton fabMain;
    private FloatingActionButton fabPhoto;
    private FloatingActionButton fabVideo;
    private FloatingActionButton fabClearScene;
    private FloatingActionButton fabExitFullScreen;

    private ProgressBar spinner;
    private ProgressBar spinnerFullScreen;

    private Menu panelMenu;
    private MenuItem actionFullScreen;
    private MenuItem actionModels;
    private MenuItem actionScenes;
    private MenuItem actionMarket;
    private SceneObjectType selectedObjectType = SceneObjectType.DINOSAURS;

    private GridView dinosaursGridView;
    private GridView skeletonsGridView;
    private GridView fossilsGridView;
    private RelativeLayout layoutSearchPanel;

    private boolean isVideoRecordingActive = false;
    private boolean isFullScreenMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUpBottomAppBar();

        if (!checkIsSupportedDeviceOrFinish(this)) {
            return;
        }

        _context = this;

        fabMain = findViewById(R.id.fabMain);
        fabPhoto = findViewById(R.id.fabPhoto);
        fabVideo = findViewById(R.id.fabVideo);
        fabClearScene = findViewById(R.id.fabClearScene);
        fabExitFullScreen = findViewById(R.id.fabExitFullScreen);

        spinner = findViewById(R.id.spinner);
        spinnerFullScreen = findViewById(R.id.spinnerFullScreen);
        spinner.setVisibility(View.GONE);
        spinnerFullScreen.setVisibility(View.GONE);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);

        _animationManager = new AnimationManager(this);
        _photoManager = new PhotoManager();
        _arManager = new ARManager(this);

        layoutSearchPanel = findViewById(R.id.layoutSearchPanel);

        initModelCollections();
    }

    private void initModelCollections() {
        dinosaursGridView = (GridView) findViewById(R.id.gridViewModels);
        dinosaursGridView.setAdapter(new DinosaursGridViewAdapter());
        dinosaursGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                _arManager.currentSceneObject = i;
                fabMain.performClick();
                fabMain.invalidate();
            }
        });

        skeletonsGridView = (GridView) findViewById(R.id.gridViewScenes);
        skeletonsGridView.setAdapter(new SkeletonsGridViewAdapter());
        skeletonsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                _arManager.currentSceneObject = i + 11;
                fabMain.performClick();
                fabMain.invalidate();
            }
        });

        fossilsGridView = (GridView) findViewById(R.id.gridViewMarket);
        fossilsGridView.setAdapter(new FossilsGridViewAdapter());
        fossilsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                _arManager.currentSceneObject = i + 21;
                fabMain.performClick();
                fabMain.invalidate();
            }
        });
    }

    private void setUpBottomAppBar() {
        //find id
        bottomAppBar = findViewById(R.id.appBar);

        //set bottom bar to Action bar as it is similar like Toolbar
        setSupportActionBar(bottomAppBar);

        //click event over Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_fullscreen:
                        hideSceneButtons(true);
                        hideCollections();
                        _animationManager.slideDown(bottomAppBar);
                        isFullScreenMode = true;
                        break;
                    case R.id.action_models:
                        updateObjectTypeButtons(SceneObjectType.DINOSAURS);
                        updateContentGrid();
                        break;
                    case R.id.action_scenes:
                        updateObjectTypeButtons(SceneObjectType.SKELETONS);
                        updateContentGrid();
                        break;
                    case R.id.action_market:
                        updateObjectTypeButtons(SceneObjectType.FOSSIL);
                        updateContentGrid();
                        break;
                }

                return false;
            }
        });

        //click event over navigation menu like back arrow or hamburger icon
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open bottom sheet
                BottomSheetDialogFragment bottomSheetDialogFragment = NavigationFragment.newInstance();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
            }
        });
    }

    private void updateObjectTypeButtons(SceneObjectType type)
    {
        if (type == SceneObjectType.DINOSAURS) {
            panelMenu.getItem(2).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_scenes_48dp));
            panelMenu.getItem(3).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_masks_48dp));

            panelMenu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.mipmap.fab_models_48dp));
        }
        if (type == SceneObjectType.SKELETONS) {
            panelMenu.getItem(3).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_masks_48dp));
            panelMenu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_models_48dp));

            panelMenu.getItem(2).setIcon(ContextCompat.getDrawable(this, R.mipmap.fab_scenes_48dp));
        }
        if (type == SceneObjectType.FOSSIL) {
            panelMenu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_models_48dp));
            panelMenu.getItem(2).setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_scenes_48dp));

            panelMenu.getItem(3).setIcon(ContextCompat.getDrawable(this, R.mipmap.fab_masks_48dp));
        }
        selectedObjectType = type;
    }

    //Inflate menu to bottom bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        panelMenu = menu;
        actionFullScreen = panelMenu.findItem(R.id.action_fullscreen);
        actionModels = panelMenu.findItem(R.id.action_models);
        actionScenes = panelMenu.findItem(R.id.action_scenes);
        actionMarket = panelMenu.findItem(R.id.action_market);
        updatePanelMenuItems(true);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fullscreen:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearObjectsFromScene(View view){
        _arManager.clearObjectsFromScene(view);
    }

    public void createPhoto(View view){
        Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);

        _photoManager.takePhoto(arFragment.getArSceneView(), _context);

        hideAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                fabPhoto.hide();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);
                showAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        fabFlipAnimation(fabPhoto, R.mipmap.fab_photo_24dp);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                fabPhoto.setImageResource(R.drawable.ic_check_circle_24dp);
                fabPhoto.show();
                fabPhoto.startAnimation(showAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fabPhoto.startAnimation(hideAnim);
    }

    public void createVideo(View view){
        if(isVideoRecordingActive == true) {
            Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);

            //TODO: Add function for saving video to file

            hideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    fabVideo.hide();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);
                    showAnim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            fabFlipAnimation(fabVideo, R.mipmap.fab_start_video_24dp);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    fabVideo.setImageResource(R.drawable.ic_check_circle_24dp);
                    fabVideo.show();
                    fabVideo.startAnimation(showAnim);

                    isVideoRecordingActive = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            fabVideo.startAnimation(hideAnim);
        }
        else {
            Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);

            hideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    fabVideo.hide();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);

                    fabVideo.setImageResource(R.mipmap.fab_stop_video_24dp);
                    fabVideo.show();
                    fabVideo.startAnimation(showAnim);

                    //TODO: Add function for video recording
                    isVideoRecordingActive = true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            fabVideo.startAnimation(hideAnim);
        }
    }

    public void fabFlipAnimation(FloatingActionButton fab, int imageResource) {
        fab.postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(fab, "scaleX", 0.0f).setDuration(100);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        fab.setImageResource(imageResource);
                        ObjectAnimator.ofFloat(fab, "scaleX", 1.0f).setDuration(300).start();
                    }
                });
                animator.start();
            }
        }, 500);
    }

    private void refreshMainFabIcon()
    {
        if (selectedObjectType == SceneObjectType.DINOSAURS) {
            fabMain.setImageResource(R.mipmap.fab_models_48dp);
            _arManager.setScenesCounter(0);
        }
        if (selectedObjectType == SceneObjectType.SKELETONS) {
            fabMain.setImageResource(R.mipmap.fab_scenes_48dp);
            _arManager.setScenesCounter(1);
        }
        if (selectedObjectType == SceneObjectType.FOSSIL) {
            fabMain.setImageResource(R.mipmap.fab_masks_48dp);
            _arManager.setScenesCounter(2);
        }
    }

    public void hideCollections(){
        dinosaursGridView.setVisibility(View.GONE);
        skeletonsGridView.setVisibility(View.GONE);
        fossilsGridView.setVisibility(View.GONE);
    }

    public void toggleFabMode(View view) {
        //check the fab alignment mode and toggle accordingly
        if (bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_END) {
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

            hideCollections();
            layoutSearchPanel.setVisibility(View.GONE);

            showSceneButtons(false);

            fabMain.postDelayed(new Runnable() {
                public void run() {
                    refreshMainFabIcon();
                }
            }, 200);

            fabMain.postDelayed(new Runnable() {
                public void run() {
                    actionFullScreen.setVisible(true);
                }
            }, 250);

            updatePanelMenuItems(true);
        } else {
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            hideSceneButtons(false);

            fabMain.postDelayed(new Runnable() {
                public void run() {
                    fabMain.setImageResource(R.mipmap.fab_back_48dp);
                }
            }, 200);

            fabMain.postDelayed(new Runnable() {
                public void run() {
                    actionModels.setVisible(true);
                    actionScenes.setVisible(true);
                    actionMarket.setVisible(true);

                    updateContentGrid();
                    layoutSearchPanel.setVisibility(View.VISIBLE);
                }
            }, 300);

            updatePanelMenuItems(false);
        }

        fabMain.animate().setDuration(200).scaleY(1).alpha(1).setInterpolator(new LinearOutSlowInInterpolator());
    }

    private void updateContentGrid(){
        hideCollections();

        if (selectedObjectType == SceneObjectType.DINOSAURS) {
            dinosaursGridView.setVisibility(View.VISIBLE);
        }
        if (selectedObjectType == SceneObjectType.SKELETONS) {
            skeletonsGridView.setVisibility(View.VISIBLE);
        }
        if (selectedObjectType == SceneObjectType.FOSSIL) {
            fossilsGridView.setVisibility(View.VISIBLE);
        }
    }

    private void updatePanelMenuItems(boolean isMainScreen){
        if (isMainScreen)
        {
            actionModels.setVisible(false);
            actionScenes.setVisible(false);
            actionMarket.setVisible(false);
        }
        else
        {
            actionFullScreen.setVisible(false);
        }
    }

    public void showSceneButtons(boolean withMainButton) {
        Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);

        fabVideo.show();
        fabPhoto.show();
        fabClearScene.setVisibility(View.VISIBLE);
        if(withMainButton == true) {
            fabMain.show();
        }

        fabVideo.startAnimation(showAnim);
        fabPhoto.startAnimation(showAnim);
        fabClearScene.startAnimation(showAnim);
        if(withMainButton == true) {
            fabMain.startAnimation(showAnim);
        }
    }

    public void hideSceneButtons(boolean withMainButton) {
        Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);
        hideAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                fabVideo.hide();
                fabPhoto.hide();
                fabClearScene.setVisibility(View.INVISIBLE);
                if(withMainButton == true) {
                    fabMain.hide();
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fabVideo.startAnimation(hideAnim);
        fabPhoto.startAnimation(hideAnim);
        fabClearScene.startAnimation(hideAnim);
        if(withMainButton == true) {
            fabMain.startAnimation(hideAnim);
        }
    }

    public void exitFullScreen(View v) {
        Animation hideAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);
        hideAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                fabExitFullScreen.setVisibility(View.INVISIBLE); //.hide();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                _animationManager.slideUp(bottomAppBar);
                showSceneButtons(true);

                isFullScreenMode = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fabExitFullScreen.startAnimation(hideAnim);
    }

    public void refreshControlsAfterObjectLoad()
    {
        if (isFullScreenMode == true) {
            spinnerFullScreen.setVisibility(View.GONE);
            showExitFullScreenFab();
        }
        else
        {
            spinner.setVisibility(View.GONE);
            fabMain.hide();
            if (bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_END) {
                fabMain.setImageResource(R.mipmap.fab_back_48dp);
            }
            else
            {
                refreshMainFabIcon();
            }
            fabMain.show();
        }
    }

    public void refreshControlsAfterObjectLoadIfNeeded() {
        if (spinner.getVisibility() != View.GONE || spinnerFullScreen.getVisibility() != View.GONE) {
            refreshControlsAfterObjectLoad();
        }
    }

    public void initPanelLoadingMode() {
        if (isFullScreenMode == true) {
            fabExitFullScreen.setImageResource(android.R.color.transparent);
            spinnerFullScreen.setVisibility(View.VISIBLE);
        }
        else {
            fabMain.setImageResource(android.R.color.transparent);
            spinner.setVisibility(View.VISIBLE);
        }
    }

    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }

    public void initFullScreenMode(View view) {
        _animationManager.setBottomBarHeight(bottomAppBar.getHeight());

        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = 0;
        view.setLayoutParams(params);

        spinner.setVisibility(View.GONE);
        showExitFullScreenFab();
    }

    private void showExitFullScreenFab(){
        Animation showAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);
        fabExitFullScreen.setImageResource(R.mipmap.fab_full_screen_exit_24dp);
        fabExitFullScreen.setVisibility(View.VISIBLE);
        fabExitFullScreen.startAnimation(showAnim);
    }

    public void onException(int id, Throwable throwable) {
        Toast toast = Toast.makeText(this, "Unable to load renderable: " + id, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Log.e(TAG, "Unable to load andy renderable", throwable);
    }

    public String getTAG(){
        return TAG;
    }
}

