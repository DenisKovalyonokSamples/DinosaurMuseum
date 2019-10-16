package com.dk.dinosaurmuseum.loaders;

import android.util.Log;
import android.util.SparseArray;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.dk.dinosaurmuseum.MainActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.CompletableFuture;

import com.dk.dinosaurmuseum.managers.ARManager;

public class ModelLoader {
    private static final String TAG = "ModelLoader";
    private SparseArray<CompletableFuture<ModelRenderable>> _futureSet = new SparseArray<>();
    private final WeakReference<MainActivity> _owner;
    private ARManager _arManager;

    public ModelLoader(MainActivity owner, ARManager arManager) {
        _owner = new WeakReference<>(owner);
        _arManager = arManager;
    }

    public boolean loadModel(int id, int resourceId) {
        MainActivity activity = _owner.get();
        if (activity == null) {
            Log.d(TAG, "Activity is null.  Cannot load model.");
            return false;
        }
        CompletableFuture<ModelRenderable> future =
                ModelRenderable.builder()
                        .setSource(_owner.get().arFragment.getContext(), resourceId)
                        .build()
                        .thenApply(renderable -> this.setRenderable(id, renderable))
                        .exceptionally(throwable -> this.onException(id, throwable));
        if (future != null) {
            _futureSet.put(id, future);
        }
        return future != null;
    }

    public void clearScene() {
        _futureSet.removeAtRange(0, _futureSet.size());
    }

    ModelRenderable onException(int id, Throwable throwable) {
        MainActivity activity = _owner.get();
        if (activity != null) {
            activity.onException(id, throwable);
        }

        _futureSet.remove(id);

        return null;
    }

    ModelRenderable setRenderable(int id, ModelRenderable modelRenderable) {
        if (_arManager != null) {
            _arManager.setRenderable(id, modelRenderable);
        }

        _futureSet.remove(id);

        return modelRenderable;
    }
}
