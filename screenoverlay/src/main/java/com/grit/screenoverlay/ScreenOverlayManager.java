package com.grit.screenoverlay;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by vinaywadhwa on 04/06/15.
 */
public class ScreenOverlayManager {

    private static boolean isInit;

    /**
     * Initialises the ScreenOverlayManager's background service and sets the view.
     * The service dies with the app using this library.
     * @param overlayView View to be overlayed.
     * @param context the current context
     */
    public static void init(View overlayView,Context context){
        isInit=true;
        ScreenOverlayService.overlayView=overlayView;
        context.startService(new Intent(context, ScreenOverlayService.class));
    }

    /**
     * Get access to the Overlay View. Must call this after {@link ScreenOverlayManager#init(View, Context)}
     * @return
     */
    public static View getOverlayView(){
        if(!isInit){
            throw new RuntimeException("Must call ScreenOverlayManager.getOverlayView after ScreenOverlayManager.init()");
        }
        return ScreenOverlayService.getOverlayView();
    }

    /**
     * Set a view to be overlayed on the screen.
     * This view will remain on top of all applications until your app is alive.
     * Must call this after {@link ScreenOverlayManager#init(View, Context)}
     * @param v
     */
    public static void setOverlayView(View v){
        if(!isInit){
            throw new RuntimeException("Must call ScreenOverlayManager.setOverlayView after ScreenOverlayManager.init()");
        }
        ScreenOverlayService.setOverlayView(v);
    }

}
