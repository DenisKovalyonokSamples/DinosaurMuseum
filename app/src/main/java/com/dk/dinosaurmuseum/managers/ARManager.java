package com.dk.dinosaurmuseum.managers;

import com.dk.dinosaurmuseum.MainActivity;
import com.dk.dinosaurmuseum.loaders.ModelLoader;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.Texture;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.dk.dinosaurmuseum.R;
import com.dk.dinosaurmuseum.loaders.ModelLoader;

public class ARManager {

    private MainActivity _ownerActivity;
    private ArFragment _arFragment;
    private ModelLoader _modelLoader;

    private TransformableNode zeroNode;
    private TransformableNode firstNode;
    private TransformableNode secondNode;
    private TransformableNode thirdNode;
    private TransformableNode fourNode;
    private TransformableNode fiveNode;
    private TransformableNode sixNode;
    private TransformableNode sevenNode;
    private TransformableNode elevenNode;
    private TransformableNode twelveNode;
    private TransformableNode thirteenNode;
    private TransformableNode fourteenNode;
    private TransformableNode twentyoneNode;
    private TransformableNode twentytwoNode;
    private TransformableNode twentythreeNode;
    private TransformableNode twentyfourNode;

    private AnchorNode zeroAnchorNode;
    private AnchorNode firstAnchorNode;
    private AnchorNode secondAnchorNode;
    private AnchorNode thirdAnchorNode;
    private AnchorNode fourAnchorNode;
    private AnchorNode fiveAnchorNode;
    private AnchorNode sixAnchorNode;
    private AnchorNode sevenAnchorNode;
    private AnchorNode elevenAnchorNode;
    private AnchorNode twelveAnchorNode;
    private AnchorNode thirteenAnchorNode;
    private AnchorNode fourteenAnchorNode;
    private AnchorNode twentyoneAnchorNode;
    private AnchorNode twentytwoAnchorNode;
    private AnchorNode twentythreeAnchorNode;
    private AnchorNode twentyfourAnchorNode;

    private static final int zero_RENDERABLE = 0;
    private static final int one_RENDERABLE = 1;
    private static final int two_RENDERABLE = 2;
    private static final int three_RENDERABLE = 3;
    private static final int four_RENDERABLE = 4;
    private static final int five_RENDERABLE = 5;
    private static final int six_RENDERABLE = 6;
    private static final int seven_RENDERABLE = 7;
    private static final int eleven_RENDERABLE = 11;
    private static final int twelve_RENDERABLE = 12;
    private static final int thirteen_RENDERABLE = 13;
    private static final int fourteen_RENDERABLE = 14;
    private static final int twentyone_RENDERABLE = 21;
    private static final int twentytwo_RENDERABLE = 22;
    private static final int twentythree_RENDERABLE = 23;
    private static final int twentyfour_RENDERABLE = 24;

    private ModelRenderable zeroRenderable;
    private ModelRenderable oneRenderable;
    private ModelRenderable twoRenderable;
    private ModelRenderable threeRenderable;
    private ModelRenderable fourRenderable;
    private ModelRenderable fiveRenderable;
    private ModelRenderable sixRenderable;
    private ModelRenderable sevenRenderable;
    private ModelRenderable elevenRenderable;
    private ModelRenderable twelveRenderable;
    private ModelRenderable thirteenRenderable;
    private ModelRenderable fourteenRenderable;
    private ModelRenderable twentyoneRenderable;
    private ModelRenderable twentytwoRenderable;
    private ModelRenderable twentythreeRenderable;
    private ModelRenderable twentyfourRenderable;

    public int currentSceneObject = 0;
    private int scenesCounter = 0;

    public ARManager(MainActivity owner) {
        _ownerActivity = owner;
        _arFragment = owner.arFragment;
        _modelLoader = new ModelLoader(_ownerActivity, this);

        initARFragment();
    }

    //INFO: this hardcode will be replaced with database entities and data access layer (under development now).
    private void initARFragment()
    {
        _arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    _ownerActivity.initPanelLoadingMode();

                    // Create the Anchor.
                    Anchor anchor = hitResult.createAnchor();

                    if (currentSceneObject == 0) {
                        if (zeroAnchorNode == null) {
                            _modelLoader.loadModel(zero_RENDERABLE, R.raw.allosaurus);
                            zeroAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 1) {
                        if (firstAnchorNode == null) {
                            _modelLoader.loadModel(one_RENDERABLE, R.raw.carnotaurus);
                            firstAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 2) {
                        if (secondAnchorNode == null) {
                            _modelLoader.loadModel(two_RENDERABLE, R.raw.diabloceratops);
                            secondAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 3) {
                        if (thirdAnchorNode == null) {
                            _modelLoader.loadModel(three_RENDERABLE, R.raw.diplodocus);

                            thirdAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 4) {
                        if (fourAnchorNode == null) {
                            _modelLoader.loadModel(four_RENDERABLE, R.raw.spinosaurus);

                            fourAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 5) {
                        if (fiveAnchorNode == null) {
                            _modelLoader.loadModel(five_RENDERABLE, R.raw.gorgosaurus);

                            fiveAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 6) {
                        if (sixAnchorNode == null) {
                            _modelLoader.loadModel(six_RENDERABLE, R.raw.ceratosaurus);

                            sixAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 7) {
                        if (sevenAnchorNode == null) {
                            _modelLoader.loadModel(seven_RENDERABLE, R.raw.cryolophosaurus);

                            sevenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    //Skeletons
                    if (currentSceneObject == 11) {
                        if (elevenAnchorNode == null) {
                            _modelLoader.loadModel(eleven_RENDERABLE, R.raw.skeletontriceratopsskull);

                            elevenAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 12) {
                        if (twelveAnchorNode == null) {
                            _modelLoader.loadModel(twelve_RENDERABLE, R.raw.skeletongomphothereskull);

                            twelveAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 13) {
                        if (thirteenAnchorNode == null) {
                            _modelLoader.loadModel(thirteen_RENDERABLE, R.raw.skeletonteratophoneus);

                            thirteenAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 14) {
                        if (fourteenAnchorNode == null) {
                            _modelLoader.loadModel(four_RENDERABLE, R.raw.skeletonutahraptor);

                            fourAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    //Fossils
                    if (currentSceneObject == 21) {
                        if (twentyoneAnchorNode == null) {
                            _modelLoader.loadModel(twentyone_RENDERABLE, R.raw.skeletondiplodocus);

                            twentyoneAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 22) {
                        if (twentytwoAnchorNode == null) {
                            _modelLoader.loadModel(twentytwo_RENDERABLE, R.raw.fossilstegosaurus);

                            twentytwoAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 23) {
                        if (twentythreeAnchorNode == null) {
                            _modelLoader.loadModel(twentythree_RENDERABLE, R.raw.fossilcoelophysissecond);

                            twentythreeAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 24) {
                        if (twentyfourAnchorNode == null) {
                            _modelLoader.loadModel(twentyfour_RENDERABLE, R.raw.fossilcoelophysis);

                            twentyfourAnchorNode = new AnchorNode(anchor);
                        }
                    }
                });
    }

    public void setRenderable(int id, ModelRenderable renderable) {

        if (id == zero_RENDERABLE) {
            this.zeroRenderable = renderable;

            zeroNode = new TransformableNode(_arFragment.getTransformationSystem());
            zeroNode.setRenderable(renderable);
            zeroNode.setParent(zeroAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(zeroAnchorNode);
            zeroNode.select();
        }
        if (id == one_RENDERABLE) {
            this.oneRenderable = renderable;

            firstNode = new TransformableNode(_arFragment.getTransformationSystem());
            firstNode.setRenderable(renderable);
            firstNode.setParent(firstAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(firstAnchorNode);
            firstNode.select();
        }


        if (id == two_RENDERABLE) {
            this.twoRenderable = renderable;

            secondNode = new TransformableNode(_arFragment.getTransformationSystem());
            secondNode.setRenderable(renderable);
            secondNode.setParent(secondAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(secondAnchorNode);
            secondNode.select();
        }
        if (id == three_RENDERABLE) {
            this.threeRenderable = renderable;

            thirdNode = new TransformableNode(_arFragment.getTransformationSystem());
            thirdNode.setRenderable(renderable);
            thirdNode.setParent(thirdAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(thirdAnchorNode);
            thirdNode.select();
        }
        if (id == four_RENDERABLE) {
            this.fourRenderable = renderable;

            fourNode = new TransformableNode(_arFragment.getTransformationSystem());
            fourNode.setRenderable(renderable);
            fourNode.setParent(fourAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(fourAnchorNode);
            fourNode.select();
        }
        if (id == five_RENDERABLE) {
            this.fiveRenderable = renderable;

            fiveNode = new TransformableNode(_arFragment.getTransformationSystem());
            fiveNode.setRenderable(renderable);
            fiveNode.setParent(fiveAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(fiveAnchorNode);
            fiveNode.select();
        }
        if (id == six_RENDERABLE) {
            this.sixRenderable = renderable;

            sixNode = new TransformableNode(_arFragment.getTransformationSystem());
            sixNode.setRenderable(renderable);
            sixNode.setParent(sixAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(sixAnchorNode);
            sixNode.select();
        }

        if (id == seven_RENDERABLE) {
            this.sevenRenderable = renderable;

            sevenNode = new TransformableNode(_arFragment.getTransformationSystem());
            sevenNode.setRenderable(renderable);
            sevenNode.setParent(sevenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(sevenAnchorNode);
            sevenNode.select();
        }

        if (id == eleven_RENDERABLE) {
            this.elevenRenderable = renderable;

            elevenNode = new TransformableNode(_arFragment.getTransformationSystem());
            elevenNode.setRenderable(renderable);
            elevenNode.setParent(elevenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(elevenAnchorNode);
            elevenNode.select();
        }

        if (id == twelve_RENDERABLE) {
            this.twelveRenderable = renderable;

            twelveNode = new TransformableNode(_arFragment.getTransformationSystem());
            twelveNode.setRenderable(renderable);
            twelveNode.setParent(twelveAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(twelveAnchorNode);
            twelveNode.select();
        }

        if (id == thirteen_RENDERABLE) {
            this.thirteenRenderable = renderable;

            thirteenNode = new TransformableNode(_arFragment.getTransformationSystem());
            thirteenNode.setRenderable(renderable);
            thirteenNode.setParent(thirteenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(thirteenAnchorNode);
            thirteenNode.select();
        }

        if (id == fourteen_RENDERABLE) {
            this.fourteenRenderable = renderable;

            fourteenNode = new TransformableNode(_arFragment.getTransformationSystem());
            fourteenNode.setRenderable(renderable);
            fourteenNode.setParent(fourteenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(fourteenAnchorNode);
            fourteenNode.select();
        }

        if (id == twentyone_RENDERABLE) {
            this.twentyoneRenderable = renderable;

            twentyoneNode = new TransformableNode(_arFragment.getTransformationSystem());
            twentyoneNode.setRenderable(renderable);
            twentyoneNode.setParent(twentyoneAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(twentyoneAnchorNode);
            twentyoneNode.select();
        }

        if (id == twentytwo_RENDERABLE) {
            this.twentytwoRenderable = renderable;

            twentytwoNode = new TransformableNode(_arFragment.getTransformationSystem());
            twentytwoNode.setRenderable(renderable);
            twentytwoNode.setParent(twentytwoAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(twentytwoAnchorNode);
            twentytwoNode.select();
        }

        if (id == twentythree_RENDERABLE) {
            this.twentythreeRenderable = renderable;

            twentythreeNode = new TransformableNode(_arFragment.getTransformationSystem());
            twentythreeNode.setRenderable(renderable);
            twentythreeNode.setParent(twentythreeAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(twentythreeAnchorNode);
            twentythreeNode.select();
        }

        if (id == twentyfour_RENDERABLE) {
            this.twentyfourRenderable = renderable;

            twentyfourNode = new TransformableNode(_arFragment.getTransformationSystem());
            twentyfourNode.setRenderable(renderable);
            twentyfourNode.setParent(twentyfourAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(twentyfourAnchorNode);
            twentyfourNode.select();
        }

        _ownerActivity.refreshControlsAfterObjectLoad();
    }

    public void clearObjectsFromScene(View view) {
        if (zeroNode != null && zeroAnchorNode != null) {
            zeroNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(zeroAnchorNode);
            zeroAnchorNode.getAnchor().detach();
            zeroNode.setParent(null);
            zeroNode = null;

            zeroAnchorNode = null;
            this.zeroRenderable = null;
        }

        if (firstNode != null && firstAnchorNode != null) {
            firstNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(firstAnchorNode);
            firstAnchorNode.getAnchor().detach();
            firstNode.setParent(null);
            firstNode = null;

            firstAnchorNode = null;
            this.oneRenderable = null;
        }

        if (secondNode != null && secondAnchorNode != null) {
            secondNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(secondAnchorNode);
            secondAnchorNode.getAnchor().detach();
            secondNode.setParent(null);
            secondNode = null;

            secondAnchorNode = null;
            this.twoRenderable = null;
        }

        if (thirdNode != null && thirdAnchorNode != null) {
            thirdNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(thirdAnchorNode);
            thirdAnchorNode.getAnchor().detach();
            thirdNode.setParent(null);
            thirdNode = null;

            thirdAnchorNode = null;
            this.threeRenderable = null;
        }

        if (fourNode != null && fourAnchorNode != null) {
            fourNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(fourAnchorNode);
            fourAnchorNode.getAnchor().detach();
            fourNode.setParent(null);
            fourNode = null;

            fourAnchorNode = null;
            this.fourRenderable = null;
        }

        if (fiveNode != null && fiveAnchorNode != null) {
            fiveNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(fiveAnchorNode);
            fiveAnchorNode.getAnchor().detach();
            fiveNode.setParent(null);
            fiveNode = null;

            fiveAnchorNode = null;
            this.fiveRenderable = null;
        }

        if (sixNode != null && sixAnchorNode != null) {
            sixNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(sixAnchorNode);
            sixAnchorNode.getAnchor().detach();
            sixNode.setParent(null);
            sixNode = null;

            sixAnchorNode = null;
            this.sixRenderable = null;
        }

        if (sevenNode != null && sevenAnchorNode != null) {
            sevenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(sevenAnchorNode);
            sevenAnchorNode.getAnchor().detach();
            sevenNode.setParent(null);
            sevenNode = null;

            sevenAnchorNode = null;
            this.sevenRenderable = null;
        }

        if (elevenNode != null && elevenAnchorNode != null) {
            elevenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(elevenAnchorNode);
            elevenAnchorNode.getAnchor().detach();
            elevenNode.setParent(null);
            elevenNode = null;

            elevenAnchorNode = null;
            this.elevenRenderable = null;
        }
        if (twelveNode != null && twelveAnchorNode != null) {
            twelveNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(twelveAnchorNode);
            twelveAnchorNode.getAnchor().detach();
            twelveNode.setParent(null);
            twelveNode = null;

            twelveAnchorNode = null;
            this.twelveRenderable = null;
        }
        if (thirteenNode != null && thirteenAnchorNode != null) {
            thirteenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(thirteenAnchorNode);
            thirteenAnchorNode.getAnchor().detach();
            thirteenNode.setParent(null);
            thirteenNode = null;

            thirteenAnchorNode = null;
            this.thirteenRenderable = null;
        }
        if (fourteenNode != null && fourteenAnchorNode != null) {
            fourteenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(fourteenAnchorNode);
            fourteenAnchorNode.getAnchor().detach();
            fourteenNode.setParent(null);
            fourteenNode = null;

            fourteenAnchorNode = null;
            this.fourteenRenderable = null;
        }
        if (twentyoneNode != null && twentyoneAnchorNode != null) {
            twentyoneNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(twentyoneAnchorNode);
            twentyoneAnchorNode.getAnchor().detach();
            twentyoneNode.setParent(null);
            twentyoneNode = null;

            twentyoneAnchorNode = null;
            this.twentyoneRenderable = null;
        }
        if (twentytwoNode != null && twentytwoAnchorNode != null) {
            twentytwoNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(twentytwoAnchorNode);
            twentytwoAnchorNode.getAnchor().detach();
            twentytwoNode.setParent(null);
            twentytwoNode = null;

            twentytwoAnchorNode = null;
            this.twentytwoRenderable = null;
        }
        if (twentythreeNode != null && twentythreeAnchorNode != null) {
            twentythreeNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(twentythreeAnchorNode);
            twentythreeAnchorNode.getAnchor().detach();
            twentythreeNode.setParent(null);
            twentythreeNode = null;

            twentythreeAnchorNode = null;
            this.twentythreeRenderable = null;
        }
        if (twentyfourNode != null && twentyfourAnchorNode != null) {
            twentyfourNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(twentyfourAnchorNode);
            twentyfourAnchorNode.getAnchor().detach();
            twentyfourNode.setParent(null);
            twentyfourNode = null;

            twentyfourAnchorNode = null;
            this.twentyfourRenderable = null;
        }


        _modelLoader.clearScene();
        _ownerActivity.refreshControlsAfterObjectLoadIfNeeded();
    }

    public void setScenesCounter(int value)
    {
        scenesCounter = value;
    }

    public void placeObjectToScene(Anchor anchor, int model) {
        ModelRenderable.builder()
                .setSource(_arFragment.getContext(), model)
                .build()
                .thenAccept(modelRenderable -> addNodeToScene(anchor, modelRenderable))
                .exceptionally(throwable -> {
                            Toast.makeText(_arFragment.getContext(), "Error:" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                            return null;
                        }
                );
    }

    private void addNodeToScene(Anchor anchor, Renderable renderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode node = new TransformableNode(_arFragment.getTransformationSystem());
        node.setRenderable(renderable);
        node.setParent(anchorNode);
        _arFragment.getArSceneView().getScene().addChild(anchorNode);
        node.select();

        _ownerActivity.refreshControlsAfterObjectLoad();
    }

    private void setPlaneTexture(String texturePath) {
        Texture.Sampler sampler = Texture.Sampler.builder()
                .setMinFilter(Texture.Sampler.MinFilter.LINEAR_MIPMAP_LINEAR)
                .setMagFilter(Texture.Sampler.MagFilter.LINEAR)
                .setWrapModeR(Texture.Sampler.WrapMode.REPEAT)
                .setWrapModeS(Texture.Sampler.WrapMode.REPEAT)
                .setWrapModeT(Texture.Sampler.WrapMode.REPEAT)
                .build();

        Texture.builder().setSource(() -> _ownerActivity.getAssets().open(texturePath))
                .setSampler(sampler)
                .build().thenAccept((texture) -> {
            _arFragment.getArSceneView().getPlaneRenderer().getMaterial()
                    .thenAccept((material) -> {
                        material.setTexture(com.google.ar.sceneform.rendering.PlaneRenderer.MATERIAL_TEXTURE, texture);
                    });
        }).exceptionally(ex ->{ Log.e(_ownerActivity.getTAG(), "Failed to read an asset file", ex);
            return null;} );
    }
}
