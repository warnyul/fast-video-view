package com.warnyul.android.widget;

import android.media.MediaPlayer;
import android.text.TextUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Balazs Varga
 */
class MetadataUtils {

    public static final boolean METADATA_ALL = false;
    public static final boolean BYPASS_METADATA_FILTER = false;

    // Playback capabilities.
    /**
     * Indicate whether the media can be paused
     */
    public static final int PAUSE_AVAILABLE = 1; // Boolean
    /**
     * Indicate whether the media can be backward seeked
     */
    public static final int SEEK_BACKWARD_AVAILABLE = 2; // Boolean
    /**
     * Indicate whether the media can be forward seeked
     */
    public static final int SEEK_FORWARD_AVAILABLE = 3; // Boolean
    /**
     * Indicate whether the media can be seeked
     */
    public static final int SEEK_AVAILABLE = 4; // Boolean


    private static Object data;

    private MetadataUtils() {
        throw new RuntimeException("Not allowed instances");
    }

    public static void init(MediaPlayer mp) {
        Method method = getMediadataMethod();
        method.setAccessible(true);
        try {
            data = method.invoke(mp, METADATA_ALL, BYPASS_METADATA_FILTER);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            data = null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            data = null;
        }
    }

    public static boolean isInitialized() {
        return data != null;
    }

    public static boolean has(int key) {
        Method method = getHasMethod(data.getClass());
        try {
            return (Boolean) method.invoke(data, key);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean getBoolean(int key) {
        Method method = getBooleanMethod(data.getClass());
        try {
            return (Boolean) method.invoke(data, key);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static Method getBooleanMethod(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (TextUtils.equals(method.getName(), "getBoolean")) {
                return method;
            }
        }
        return null;
    }

    private static Method getHasMethod(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (TextUtils.equals(method.getName(), "has")) {
                return method;
            }
        }
        return null;
    }

    private static Method getMediadataMethod() {
        Method[] methods = MediaPlayer.class.getDeclaredMethods();
        for (Method method : methods) {
            if (TextUtils.equals(method.getName(), "getMetadata")) {
                return method;
            }
        }
        return null;
    }
}
