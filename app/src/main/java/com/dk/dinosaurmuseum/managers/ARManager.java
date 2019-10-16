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
    private TransformableNode eightNode;
    private TransformableNode nineNode;
    private TransformableNode tenNode;
    private TransformableNode elevenNode;
    private TransformableNode twelveNode;
    private TransformableNode thirteenNode;
    private TransformableNode fourteenNode;
    private TransformableNode fifteenNode;
    private TransformableNode sixteenNode;

    private AnchorNode zeroAnchorNode;
    private AnchorNode firstAnchorNode;
    private AnchorNode secondAnchorNode;
    private AnchorNode thirdAnchorNode;
    private AnchorNode fourAnchorNode;
    private AnchorNode fiveAnchorNode;
    private AnchorNode sixAnchorNode;
    private AnchorNode sevenAnchorNode;
    private AnchorNode eightAnchorNode;
    private AnchorNode nineAnchorNode;
    private AnchorNode tenAnchorNode;
    private AnchorNode elevenAnchorNode;
    private AnchorNode twelveAnchorNode;
    private AnchorNode thirteenAnchorNode;
    private AnchorNode fourteenAnchorNode;
    private AnchorNode fifteenAnchorNode;
    private AnchorNode sixteenAnchorNode;

    private static final int zero_RENDERABLE = 0;
    private static final int one_RENDERABLE = 1;
    private static final int two_RENDERABLE = 2;
    private static final int three_RENDERABLE = 3;
    private static final int four_RENDERABLE = 4;
    private static final int five_RENDERABLE = 5;
    private static final int six_RENDERABLE = 6;
    private static final int seven_RENDERABLE = 7;
    private static final int eight_RENDERABLE = 8;
    private static final int nine_RENDERABLE = 9;
    private static final int ten_RENDERABLE = 10;
    private static final int eleven_RENDERABLE = 11;
    private static final int twelve_RENDERABLE = 12;
    private static final int thirteen_RENDERABLE = 13;
    private static final int fourteen_RENDERABLE = 14;
    private static final int fifteen_RENDERABLE = 15;
    private static final int sixteen_RENDERABLE = 16;
    private static final int fone_RENDERABLE = 17;
    private static final int ftwo_RENDERABLE = 18;
    private static final int fthree_RENDERABLE = 19;
    private static final int ffour_RENDERABLE = 20;
    private static final int ffive_RENDERABLE = 21;
    private static final int fsix_RENDERABLE = 22;

    private ModelRenderable zeroRenderable;
    private ModelRenderable oneRenderable;
    private ModelRenderable twoRenderable;
    private ModelRenderable threeRenderable;
    private ModelRenderable fourRenderable;
    private ModelRenderable fiveRenderable;
    private ModelRenderable sixRenderable;
    private ModelRenderable sevenRenderable;
    private ModelRenderable eightRenderable;
    private ModelRenderable nineRenderable;
    private ModelRenderable tenRenderable;
    private ModelRenderable elevenRenderable;
    private ModelRenderable twelveRenderable;
    private ModelRenderable thirteenRenderable;
    private ModelRenderable fourteenRenderable;
    private ModelRenderable fifteenRenderable;
    private ModelRenderable sixteenRenderable;
    private ModelRenderable foneRenderable;
    private ModelRenderable ftwoRenderable;
    private ModelRenderable fthreeRenderable;
    private ModelRenderable ffourRenderable;
    private ModelRenderable ffiveRenderable;
    private ModelRenderable fsixRenderable;

    public int currentSceneObject = 0;
    private int scenesCounter = 0;

    public ARManager(MainActivity owner) {
        _ownerActivity = owner;
        _arFragment = owner.arFragment;
        _modelLoader = new ModelLoader(_ownerActivity, this);

        initARFragment();
    }

    private void initARFragment()
    {
        _arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    _ownerActivity.initPanelLoadingMode();

                    // Create the Anchor.
                    Anchor anchor = hitResult.createAnchor();

                    //EGYPT
                    /*if (scenesCounter == 0) {*/
                    if (currentSceneObject == 0) {
                        if (zeroAnchorNode == null) {
                            _modelLoader.loadModel(zero_RENDERABLE, R.raw.allosaurus);
                            zeroAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 1) {
                        if (firstAnchorNode == null) {
                            _modelLoader.loadModel(one_RENDERABLE, R.raw.ceratosaurus);
                            firstAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 2) {
                        if (secondAnchorNode == null) {
                            _modelLoader.loadModel(two_RENDERABLE, R.raw.cryolophosaurus);
                            secondAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 3) {
                        if (thirdAnchorNode == null) {
                            _modelLoader.loadModel(three_RENDERABLE, R.raw.diabloceratops);

                            thirdAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    /*if (currentSceneObject == 4) {
                        if (fourAnchorNode == null) {
                            _modelLoader.loadModel(four_RENDERABLE, R.raw.barque_of_mersou);

                            fourAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 5) {
                        if (fiveAnchorNode == null) {
                            _modelLoader.loadModel(five_RENDERABLE, R.raw.boat_egyptian);
                            fiveAnchorNode = new AnchorNode(anchor);
                        }
                    }
                    if (currentSceneObject == 6) {
                        if (sixAnchorNode == null) {
                            _modelLoader.loadModel(six_RENDERABLE, R.raw.chest_of_tutankhamen);
                            sixAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 7) {
                        if (sevenAnchorNode == null) {
                            _modelLoader.loadModel(seven_RENDERABLE, R.raw.chest_of_tutankhamen_second);
                            sevenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 8) {
                        if (eightAnchorNode == null) {
                            _modelLoader.loadModel(eight_RENDERABLE, R.raw.anthropoid_2);
                            eightAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 9) {
                        if (nineAnchorNode == null) {
                            _modelLoader.loadModel(nine_RENDERABLE, R.raw.akhenaten);
                            nineAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 10) {
                        if (tenAnchorNode == null) {
                            _modelLoader.loadModel(ten_RENDERABLE, R.raw.khonsutemple_chapel_12);
                            tenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 11) {
                        if (elevenAnchorNode == null) {
                            _modelLoader.loadModel(eleven_RENDERABLE, R.raw.khonsutemple_chapel_6);
                            elevenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 12) {
                        if (twelveAnchorNode == null) {
                            _modelLoader.loadModel(twelve_RENDERABLE, R.raw.dosiris);
                            twelveAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 13) {
                        if (thirteenAnchorNode == null) {
                            _modelLoader.loadModel(thirteen_RENDERABLE, R.raw.papyrus_column);
                            thirteenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 14) {
                        if (fourteenAnchorNode == null) {
                            _modelLoader.loadModel(fourteen_RENDERABLE, R.raw.funerary_mask);
                            fourteenAnchorNode = new AnchorNode(anchor);
                        }
                    }

                    if (currentSceneObject == 15) {
                        if (fifteenAnchorNode == null) {
                            _modelLoader.loadModel(fifteen_RENDERABLE, R.raw.mask_nefertiti);
                            fifteenAnchorNode = new AnchorNode(anchor);
                        }
                    }*/
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

        if (id == eight_RENDERABLE) {
            this.eightRenderable = renderable;

            eightNode = new TransformableNode(_arFragment.getTransformationSystem());
            eightNode.setRenderable(renderable);
            eightNode.setParent(eightAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(eightAnchorNode);
            eightNode.select();
        }

        if (id == nine_RENDERABLE) {
            this.nineRenderable = renderable;

            nineNode = new TransformableNode(_arFragment.getTransformationSystem());
            nineNode.setRenderable(renderable);
            nineNode.setParent(nineAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(nineAnchorNode);
            nineNode.select();
        }

        if (id == ten_RENDERABLE) {
            this.tenRenderable = renderable;

            tenNode = new TransformableNode(_arFragment.getTransformationSystem());
            tenNode.setRenderable(renderable);
            tenNode.setParent(tenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(tenAnchorNode);
            tenNode.select();
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


        if (id == fifteen_RENDERABLE) {
            this.fifteenRenderable = renderable;

            fifteenNode = new TransformableNode(_arFragment.getTransformationSystem());
            fifteenNode.setRenderable(renderable);
            fifteenNode.setParent(fifteenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(fifteenAnchorNode);
            fifteenNode.select();
        }

        if (id == sixteen_RENDERABLE) {
            this.sixteenRenderable = renderable;

            sixteenNode = new TransformableNode(_arFragment.getTransformationSystem());
            sixteenNode.setRenderable(renderable);
            sixteenNode.setParent(sixteenAnchorNode);
            _arFragment.getArSceneView().getScene().addChild(sixteenAnchorNode);
            sixteenNode.select();
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

        if (eightNode != null && eightAnchorNode != null) {
            eightNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(eightAnchorNode);
            eightAnchorNode.getAnchor().detach();
            eightNode.setParent(null);
            eightNode = null;

            eightAnchorNode = null;
            this.eightRenderable = null;
        }
        if (nineNode != null && nineAnchorNode != null) {
            nineNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(nineAnchorNode);
            nineAnchorNode.getAnchor().detach();
            nineNode.setParent(null);
            nineNode = null;

            nineAnchorNode = null;
            this.nineRenderable = null;
        }
        if (tenNode != null && tenAnchorNode != null) {
            tenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(tenAnchorNode);
            tenAnchorNode.getAnchor().detach();
            tenNode.setParent(null);
            tenNode = null;

            tenAnchorNode = null;
            this.tenRenderable = null;
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
        if (fifteenNode != null && fifteenAnchorNode != null) {
            fifteenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(fifteenAnchorNode);
            fifteenAnchorNode.getAnchor().detach();
            fifteenNode.setParent(null);
            fifteenNode = null;

            fifteenAnchorNode = null;
            this.fifteenRenderable = null;
        }
        if (sixteenNode != null && sixteenAnchorNode != null) {
            sixteenNode.setRenderable(null);
            _arFragment.getArSceneView().getScene().removeChild(sixteenAnchorNode);
            sixteenAnchorNode.getAnchor().detach();
            sixteenNode.setParent(null);
            sixteenNode = null;

            sixteenAnchorNode = null;
            this.sixteenRenderable = null;
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
