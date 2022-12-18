package com.alphalaneous;

import java.util.ArrayList;
import java.util.Base64;

public class LevelObject {

    protected int id;
    protected float x;
    protected float y;
    protected boolean horizontalFlip;
    protected boolean verticalFlip;
    protected float rotation;
    protected int r;
    protected int g;
    protected int b;
    protected float duration;
    protected boolean touchTriggered;
    protected int secretCoinID;
    protected boolean specialObjectChecked;
    protected boolean tintGround;
    protected boolean setColorToP1;
    protected boolean setColorToP2;
    protected boolean blending;
    protected Object unknown18;
    protected Object unknown19;
    protected boolean EL1;
    protected int mainColor;
    protected int secondaryColor;
    protected int targetColorID;
    protected int ZLayer;
    protected int ZOrder;
    protected Object unknown26;
    protected Object unknown27;
    protected float offsetX;
    protected float offsetY;
    protected Easing easing = Easing.None;
    protected String objectText;
    protected float scaling;
    protected Object unknown33;
    protected boolean groupParent;
    protected float opacity;
    protected Object unknown36;
    protected Object unknown37;
    protected Object unknown38;
    protected Object unknown39;
    protected Object unknown40;
    protected boolean mainColorHSVEnabled;
    protected boolean secondaryColorHSVEnabled;
    protected HSV mainColorHSV = HSV.DEFAULT;
    protected HSV secondaryColorHSV = HSV.DEFAULT;
    protected float fadeIn;
    protected float hold;
    protected float fadeOut;
    protected PulseMode pulseMode = PulseMode.Color;
    protected HSV copiedColorHSV = HSV.DEFAULT;
    protected int copiedColorID;
    protected int targetGroupID;
    protected PulseTargetType pulseTargetType = PulseTargetType.Channel;
    protected Object unknown53;
    protected float yellowTeleportationPortalYOffset;
    protected boolean teleportPortalEase;
    protected boolean activateGroup;
    protected ArrayList<Integer> groupIDs = new ArrayList<>();
    protected boolean lockToPlayerX;
    protected boolean lockToPlayerY;
    protected boolean copyOpacity;
    protected int EL2;
    protected boolean spawnTriggered;
    protected float spawnDelay;
    protected boolean dontFade;
    protected boolean mainOnly;
    protected boolean detailOnly;
    protected boolean dontEnter;
    protected int degrees;
    protected int times360;
    protected boolean lockObjectRotation;
    protected int secondaryGroupID;
    protected float xMod;
    protected float yMod;
    protected Object unknown74;
    protected float strength;
    protected int animationID;
    protected int count;
    protected boolean subtractCount;
    protected PickupMode pickupMode = PickupMode.Pickup;
    protected int itemBlockID;
    protected boolean holdMode;
    protected ToggleMode toggleMode = ToggleMode.NONE;
    protected Object unknown83;
    protected float interval;
    protected float easingRate;
    protected boolean exclusive;
    protected boolean multiTrigger;
    protected Comparison comparison = Comparison.Equals;
    protected boolean dualMode;
    protected float speed;
    protected float followDelay;
    protected float yOffset;
    protected boolean triggerOnExit;
    protected boolean dynamicBlock;
    protected int blockBID;
    protected boolean disableGlow;
    protected float customRotationSpeed;
    protected boolean disableRotation;
    protected boolean multiActivate;
    protected boolean enableUseTarget;
    protected TargetPos targetPosCoordinates = TargetPos.NONE;
    protected boolean editorDisable;
    protected boolean highDetail;
    protected boolean triggerMultiActivate;
    protected float maxSpeed;
    protected boolean randomizeStart;
    protected float animationSpeed;
    protected int linkedGroupID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y - 90;
    }

    public boolean isHorizontalFlip() {
        return horizontalFlip;
    }

    public void setHorizontalFlip(boolean horizontalFlip) {
        this.horizontalFlip = horizontalFlip;
    }

    public boolean isVerticalFlip() {
        return verticalFlip;
    }

    public void setVerticalFlip(boolean verticalFlip) {
        this.verticalFlip = verticalFlip;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isTouchTriggered() {
        return touchTriggered;
    }

    public void setTouchTriggered(boolean touchTriggered) {
        this.touchTriggered = touchTriggered;
    }

    public int getSecretCoinID() {
        return secretCoinID;
    }

    public void setSecretCoinID(int secretCoinID) {
        this.secretCoinID = secretCoinID;
    }

    public boolean isSpecialObjectChecked() {
        return specialObjectChecked;
    }

    public void setSpecialObjectChecked(boolean specialObjectChecked) {
        this.specialObjectChecked = specialObjectChecked;
    }

    public boolean isTintGround() {
        return tintGround;
    }

    public void setTintGround(boolean tintGround) {
        this.tintGround = tintGround;
    }

    public boolean isSetColorToP1() {
        return setColorToP1;
    }

    public void setSetColorToP1(boolean setColorToP1) {
        this.setColorToP1 = setColorToP1;
    }

    public boolean isSetColorToP2() {
        return setColorToP2;
    }

    public void setSetColorToP2(boolean setColorToP2) {
        this.setColorToP2 = setColorToP2;
    }

    public boolean isBlending() {
        return blending;
    }

    public void setBlending(boolean blending) {
        this.blending = blending;
    }

    public Object getUnknown18() {
        return unknown18;
    }

    public void setUnknown18(Object unknown18) {
        this.unknown18 = unknown18;
    }

    public Object getUnknown19() {
        return unknown19;
    }

    public void setUnknown19(Object unknown19) {
        this.unknown19 = unknown19;
    }

    public boolean isEL1() {
        return EL1;
    }

    public void setEL1(boolean EL1) {
        this.EL1 = EL1;
    }

    public int getMainColor() {
        return mainColor;
    }

    public void setMainColor(int mainColor) {
        this.mainColor = mainColor;
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(int secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public int getTargetColorID() {
        return targetColorID;
    }

    public void setTargetColorID(int targetColorID) {
        this.targetColorID = targetColorID;
    }

    public int getZLayer() {
        return ZLayer;
    }

    public void setZLayer(int ZLayer) {
        this.ZLayer = ZLayer;
    }

    public int getZOrder() {
        return ZOrder;
    }

    public void setZOrder(int ZOrder) {
        this.ZOrder = ZOrder;
    }

    public Object getUnknown26() {
        return unknown26;
    }

    public void setUnknown26(Object unknown26) {
        this.unknown26 = unknown26;
    }

    public Object getUnknown27() {
        return unknown27;
    }

    public void setUnknown27(Object unknown27) {
        this.unknown27 = unknown27;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    public Easing getEasing() {
        return easing;
    }

    public void setEasing(Easing easing) {
        this.easing = easing;
    }

    public String getObjectText() {
        return objectText;
    }

    protected void setObjectText(String objectText) {
        this.objectText = objectText;
    }

    protected void setAndEncodeObjectText(String objectText) {
        this.objectText = Base64.getUrlEncoder().encodeToString(objectText.getBytes());
    }

    public float getScaling() {
        return scaling;
    }

    public void setScaling(float scaling) {
        this.scaling = scaling;
    }

    public Object getUnknown33() {
        return unknown33;
    }

    public void setUnknown33(Object unknown33) {
        this.unknown33 = unknown33;
    }

    public boolean isGroupParent() {
        return groupParent;
    }

    public void setGroupParent(boolean groupParent) {
        this.groupParent = groupParent;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public Object getUnknown36() {
        return unknown36;
    }

    public void setUnknown36(Object unknown36) {
        this.unknown36 = unknown36;
    }

    public Object getUnknown37() {
        return unknown37;
    }

    public void setUnknown37(Object unknown37) {
        this.unknown37 = unknown37;
    }

    public Object getUnknown38() {
        return unknown38;
    }

    public void setUnknown38(Object unknown38) {
        this.unknown38 = unknown38;
    }

    public Object getUnknown39() {
        return unknown39;
    }

    public void setUnknown39(Object unknown39) {
        this.unknown39 = unknown39;
    }

    public Object getUnknown40() {
        return unknown40;
    }

    public void setUnknown40(Object unknown40) {
        this.unknown40 = unknown40;
    }

    public boolean isMainColorHSVEnabled() {
        return mainColorHSVEnabled;
    }

    public void setMainColorHSVEnabled(boolean mainColorHSVEnabled) {
        this.mainColorHSVEnabled = mainColorHSVEnabled;
    }

    public boolean isSecondaryColorHSVEnabled() {
        return secondaryColorHSVEnabled;
    }

    public void setSecondaryColorHSVEnabled(boolean secondaryColorHSVEnabled) {
        this.secondaryColorHSVEnabled = secondaryColorHSVEnabled;
    }

    public HSV getMainColorHSV() {
        return mainColorHSV;
    }

    public void setMainColorHSV(HSV mainColorHSV) {
        this.mainColorHSV = mainColorHSV;
    }

    public HSV getSecondaryColorHSV() {
        return secondaryColorHSV;
    }

    public void setSecondaryColorHSV(HSV secondaryColorHSV) {
        this.secondaryColorHSV = secondaryColorHSV;
    }

    public float getFadeIn() {
        return fadeIn;
    }

    public void setFadeIn(float fadeIn) {
        this.fadeIn = fadeIn;
    }

    public float getHold() {
        return hold;
    }

    public void setHold(float hold) {
        this.hold = hold;
    }

    public float getFadeOut() {
        return fadeOut;
    }

    public void setFadeOut(float fadeOut) {
        this.fadeOut = fadeOut;
    }

    public PulseMode getPulseMode() {
        return pulseMode;
    }

    public void setPulseMode(PulseMode pulseMode) {
        this.pulseMode = pulseMode;
    }

    public HSV getCopiedColorHSV() {
        return copiedColorHSV;
    }

    public void setCopiedColorHSV(HSV copiedColorHSV) {
        this.copiedColorHSV = copiedColorHSV;
    }

    public int getCopiedColorID() {
        return copiedColorID;
    }

    public void setCopiedColorID(int copiedColorID) {
        this.copiedColorID = copiedColorID;
    }

    public int getTargetGroupID() {
        return targetGroupID;
    }

    public void setTargetGroupID(int targetGroupID) {
        this.targetGroupID = targetGroupID;
    }

    public PulseTargetType getPulseTargetType() {
        return pulseTargetType;
    }

    public void setPulseTargetType(PulseTargetType pulseTargetType) {
        this.pulseTargetType = pulseTargetType;
    }

    public Object getUnknown53() {
        return unknown53;
    }

    public void setUnknown53(Object unknown53) {
        this.unknown53 = unknown53;
    }

    public float getYellowTeleportationPortalYOffset() {
        return yellowTeleportationPortalYOffset;
    }

    public void setYellowTeleportationPortalYOffset(float yellowTeleportationPortalYOffset) {
        this.yellowTeleportationPortalYOffset = yellowTeleportationPortalYOffset;
    }

    public boolean isTeleportPortalEase() {
        return teleportPortalEase;
    }

    public void setTeleportPortalEase(boolean teleportPortalEase) {
        this.teleportPortalEase = teleportPortalEase;
    }

    public boolean isActivateGroup() {
        return activateGroup;
    }

    public void setActivateGroup(boolean activateGroup) {
        this.activateGroup = activateGroup;
    }

    public ArrayList<Integer> getGroupIDs() {
        return groupIDs;
    }

    public void setGroupIDs(ArrayList<Integer> groupIDs) {
        this.groupIDs = groupIDs;
    }

    public boolean isLockToPlayerX() {
        return lockToPlayerX;
    }

    public void setLockToPlayerX(boolean lockToPlayerX) {
        this.lockToPlayerX = lockToPlayerX;
    }

    public boolean isLockToPlayerY() {
        return lockToPlayerY;
    }

    public void setLockToPlayerY(boolean lockToPlayerY) {
        this.lockToPlayerY = lockToPlayerY;
    }

    public boolean isCopyOpacity() {
        return copyOpacity;
    }

    public void setCopyOpacity(boolean copyOpacity) {
        this.copyOpacity = copyOpacity;
    }

    public int getEL2() {
        return EL2;
    }

    public void setEL2(int EL2) {
        this.EL2 = EL2;
    }

    public boolean isSpawnTriggered() {
        return spawnTriggered;
    }

    public void setSpawnTriggered(boolean spawnTriggered) {
        this.spawnTriggered = spawnTriggered;
    }

    public float getSpawnDelay() {
        return spawnDelay;
    }

    public void setSpawnDelay(float spawnDelay) {
        this.spawnDelay = spawnDelay;
    }

    public boolean isDontFade() {
        return dontFade;
    }

    public void setDontFade(boolean dontFade) {
        this.dontFade = dontFade;
    }

    public boolean isMainOnly() {
        return mainOnly;
    }

    public void setMainOnly(boolean mainOnly) {
        this.mainOnly = mainOnly;
    }

    public boolean isDetailOnly() {
        return detailOnly;
    }

    public void setDetailOnly(boolean detailOnly) {
        this.detailOnly = detailOnly;
    }

    public boolean isDontEnter() {
        return dontEnter;
    }

    public void setDontEnter(boolean dontEnter) {
        this.dontEnter = dontEnter;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getTimes360() {
        return times360;
    }

    public void setTimes360(int times360) {
        this.times360 = times360;
    }

    public boolean isLockObjectRotation() {
        return lockObjectRotation;
    }

    public void setLockObjectRotation(boolean lockObjectRotation) {
        this.lockObjectRotation = lockObjectRotation;
    }

    public int getSecondaryGroupID() {
        return secondaryGroupID;
    }

    public void setSecondaryGroupID(int secondaryGroupID) {
        this.secondaryGroupID = secondaryGroupID;
    }

    public float getxMod() {
        return xMod;
    }

    public void setxMod(float xMod) {
        this.xMod = xMod;
    }

    public float getyMod() {
        return yMod;
    }

    public void setyMod(float yMod) {
        this.yMod = yMod;
    }

    public Object getUnknown74() {
        return unknown74;
    }

    public void setUnknown74(Object unknown74) {
        this.unknown74 = unknown74;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public int getAnimationID() {
        return animationID;
    }

    public void setAnimationID(int animationID) {
        this.animationID = animationID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isSubtractCount() {
        return subtractCount;
    }

    public void setSubtractCount(boolean subtractCount) {
        this.subtractCount = subtractCount;
    }

    public PickupMode getPickupMode() {
        return pickupMode;
    }

    public void setPickupMode(PickupMode pickupMode) {
        this.pickupMode = pickupMode;
    }

    public int getItemBlockID() {
        return itemBlockID;
    }

    public void setItemBlockID(int itemBlockID) {
        this.itemBlockID = itemBlockID;
    }

    public boolean isHoldMode() {
        return holdMode;
    }

    public void setHoldMode(boolean holdMode) {
        this.holdMode = holdMode;
    }

    public ToggleMode getToggleMode() {
        return toggleMode;
    }

    public void setToggleMode(ToggleMode toggleMode) {
        this.toggleMode = toggleMode;
    }

    public Object getUnknown83() {
        return unknown83;
    }

    public void setUnknown83(Object unknown83) {
        this.unknown83 = unknown83;
    }

    public float getInterval() {
        return interval;
    }

    public void setInterval(float interval) {
        this.interval = interval;
    }

    public float getEasingRate() {
        return easingRate;
    }

    public void setEasingRate(float easingRate) {
        this.easingRate = easingRate;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isMultiTrigger() {
        return multiTrigger;
    }

    public void setMultiTrigger(boolean multiTrigger) {
        this.multiTrigger = multiTrigger;
    }

    public Comparison getComparison() {
        return comparison;
    }

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    public boolean isDualMode() {
        return dualMode;
    }

    public void setDualMode(boolean dualMode) {
        this.dualMode = dualMode;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getFollowDelay() {
        return followDelay;
    }

    public void setFollowDelay(float followDelay) {
        this.followDelay = followDelay;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public boolean isTriggerOnExit() {
        return triggerOnExit;
    }

    public void setTriggerOnExit(boolean triggerOnExit) {
        this.triggerOnExit = triggerOnExit;
    }

    public boolean isDynamicBlock() {
        return dynamicBlock;
    }

    public void setDynamicBlock(boolean dynamicBlock) {
        this.dynamicBlock = dynamicBlock;
    }

    public int getBlockBID() {
        return blockBID;
    }

    public void setBlockBID(int blockBID) {
        this.blockBID = blockBID;
    }

    public boolean isDisableGlow() {
        return disableGlow;
    }

    public void setDisableGlow(boolean disableGlow) {
        this.disableGlow = disableGlow;
    }

    public float getCustomRotationSpeed() {
        return customRotationSpeed;
    }

    public void setCustomRotationSpeed(float customRotationSpeed) {
        this.customRotationSpeed = customRotationSpeed;
    }

    public boolean isDisableRotation() {
        return disableRotation;
    }

    public void setDisableRotation(boolean disableRotation) {
        this.disableRotation = disableRotation;
    }

    public boolean isMultiActivate() {
        return multiActivate;
    }

    public void setMultiActivate(boolean multiActivate) {
        this.multiActivate = multiActivate;
    }

    public boolean isEnableUseTarget() {
        return enableUseTarget;
    }

    public void setEnableUseTarget(boolean enableUseTarget) {
        this.enableUseTarget = enableUseTarget;
    }

    public TargetPos getTargetPosCoordinates() {
        return targetPosCoordinates;
    }

    public void setTargetPosCoordinates(TargetPos targetPosCoordinates) {
        this.targetPosCoordinates = targetPosCoordinates;
    }

    public boolean isEditorDisable() {
        return editorDisable;
    }

    public void setEditorDisable(boolean editorDisable) {
        this.editorDisable = editorDisable;
    }

    public boolean isHighDetail() {
        return highDetail;
    }

    public void setHighDetail(boolean highDetail) {
        this.highDetail = highDetail;
    }

    public boolean isTriggerMultiActivate() {
        return triggerMultiActivate;
    }

    public void setTriggerMultiActivate(boolean triggerMultiActivate) {
        this.triggerMultiActivate = triggerMultiActivate;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isRandomizeStart() {
        return randomizeStart;
    }

    public void setRandomizeStart(boolean randomizeStart) {
        this.randomizeStart = randomizeStart;
    }

    public float getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(float animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public int getLinkedGroupID() {
        return linkedGroupID;
    }

    public void setLinkedGroupID(int linkedGroupID) {
        this.linkedGroupID = linkedGroupID;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(Utilities.toPair(String.valueOf(1), id, ','));
        builder.append(Utilities.toPair(String.valueOf(2), x, ','));
        builder.append(Utilities.toPair(String.valueOf(3), y, ','));

        appendIfExists(builder, horizontalFlip, 4);
        appendIfExists(builder, verticalFlip, 5);
        appendIfExists(builder, rotation, 6);
        appendIfExists(builder, r, 7);
        appendIfExists(builder, g, 8);
        appendIfExists(builder, b, 9);
        appendIfExists(builder, duration, 10);
        appendIfExists(builder, touchTriggered, 11);
        appendIfExists(builder, secretCoinID, 12);
        appendIfExists(builder, specialObjectChecked, 13);
        appendIfExists(builder, tintGround, 14);
        appendIfExists(builder, setColorToP1, 15);
        appendIfExists(builder, setColorToP2, 16);
        appendIfExists(builder, blending, 17);
        appendIfExists(builder, unknown18, 18);
        appendIfExists(builder, unknown19, 19);
        appendIfExists(builder, EL1, 20);
        appendIfExists(builder, mainColor, 21);
        appendIfExists(builder, secondaryColor, 22);
        appendIfExists(builder, targetColorID, 23);
        appendIfExists(builder, ZLayer, 24);
        appendIfExists(builder, ZOrder, 25);
        appendIfExists(builder, unknown26, 26);
        appendIfExists(builder, unknown27, 27);
        appendIfExists(builder, offsetX, 28);
        appendIfExists(builder, offsetY, 29);
        appendIfExists(builder, easing.toInt(), 30);
        appendIfExists(builder, objectText, 31);
        appendIfExists(builder, scaling, 32);
        appendIfExists(builder, unknown33, 33);
        appendIfExists(builder, groupParent, 34);
        appendIfExists(builder, opacity, 35);
        appendIfExists(builder, unknown36, 36);
        appendIfExists(builder, unknown37, 37);
        appendIfExists(builder, unknown38, 38);
        appendIfExists(builder, unknown39, 39);
        appendIfExists(builder, unknown40, 40);
        appendIfExists(builder, mainColorHSVEnabled, 41);
        appendIfExists(builder, secondaryColorHSVEnabled, 42);
        appendIfExists(builder, mainColorHSV.toString(), 43);
        appendIfExists(builder, secondaryColorHSV.toString(), 44);
        appendIfExists(builder, fadeIn, 45);
        appendIfExists(builder, hold, 46);
        appendIfExists(builder, fadeOut, 47);
        appendIfExists(builder, pulseMode.toInt(), 48);
        appendIfExists(builder, copiedColorHSV.toString(), 49);
        appendIfExists(builder, copiedColorID, 50);
        appendIfExists(builder, targetGroupID, 51);
        appendIfExists(builder, pulseTargetType.toInt(), 52);
        appendIfExists(builder, unknown53, 53);
        appendIfExists(builder, yellowTeleportationPortalYOffset, 54);
        appendIfExists(builder, teleportPortalEase, 55);
        appendIfExists(builder, activateGroup, 56);
        appendIfExists(builder, groupIDFormat(groupIDs), 57);
        appendIfExists(builder, lockToPlayerX, 58);
        appendIfExists(builder, lockToPlayerY, 59);
        appendIfExists(builder, copyOpacity, 60);
        appendIfExists(builder, EL2, 61);
        appendIfExists(builder, spawnTriggered, 62);
        appendIfExists(builder, spawnDelay, 63);
        appendIfExists(builder, dontFade, 64);
        appendIfExists(builder, mainOnly, 65);
        appendIfExists(builder, detailOnly, 66);
        appendIfExists(builder, dontEnter, 67);
        appendIfExists(builder, degrees, 68);
        appendIfExists(builder, times360, 69);
        appendIfExists(builder, lockObjectRotation, 70);
        appendIfExists(builder, secondaryGroupID, 71);
        appendIfExists(builder, xMod, 72);
        appendIfExists(builder, yMod, 73);
        appendIfExists(builder, unknown74, 74);
        appendIfExists(builder, strength, 75);
        appendIfExists(builder, animationID, 76);
        appendIfExists(builder, count, 77);
        appendIfExists(builder, subtractCount, 78);
        appendIfExists(builder, pickupMode.toInt(), 79);
        appendIfExists(builder, itemBlockID, 80);
        appendIfExists(builder, holdMode, 81);
        appendIfExists(builder, toggleMode.toInt(), 82);
        appendIfExists(builder, interval, 83);
        appendIfExists(builder, easingRate, 84);
        appendIfExists(builder, exclusive, 85);
        appendIfExists(builder, multiTrigger, 87);
        appendIfExists(builder, comparison.toInt(), 88);
        appendIfExists(builder, dualMode, 89);
        appendIfExists(builder, speed, 90);
        appendIfExists(builder, followDelay, 91);
        appendIfExists(builder, yOffset, 92);
        appendIfExists(builder, triggerOnExit, 93);
        appendIfExists(builder, dynamicBlock, 94);
        appendIfExists(builder, blockBID, 95);
        appendIfExists(builder, disableGlow, 96);
        appendIfExists(builder, customRotationSpeed, 97);
        appendIfExists(builder, disableRotation, 98);
        appendIfExists(builder, multiActivate, 99);
        appendIfExists(builder, enableUseTarget, 100);
        appendIfExists(builder, targetPosCoordinates.toInt(), 101);
        appendIfExists(builder, editorDisable, 102);
        appendIfExists(builder, highDetail, 103);
        appendIfExists(builder, triggerMultiActivate, 104);
        appendIfExists(builder, maxSpeed, 105);
        appendIfExists(builder, randomizeStart, 106);
        appendIfExists(builder, animationSpeed, 107);
        appendIfExists(builder, linkedGroupID, 108);

        return builder.substring(0, builder.length()-1);
    }

    protected void appendIfExists(StringBuilder builder, Object value, int key) {
        Utilities.appendIfExists(builder, value, String.valueOf(key), ',');
    }


    public String groupIDFormat(ArrayList<Integer> groupIDs){

        if(groupIDs.isEmpty()) return null;

        StringBuilder builder = new StringBuilder();

        for(int i : groupIDs) builder.append(i).append(".");

        return builder.substring(0, builder.length()-1);
    }
}