package com.example.aimtracker;

import net.fabricmc.api.ClientModInitializer;

/** Entrypoint. Registration order matters: input -> target selection -> camera. */
public class AimTrackerClient implements ClientModInitializer {
    public static final String MOD_ID = "aimtracker";

    @Override
    public void onInitializeClient() {
        ModConfig.load();
        KeybindRegistry.register();
        InputHandler.register();    // client tick: reads key, updates active flag
        TargetSelector.register();  // client tick: picks the target
        CameraHandler.register();   // every frame: rotates the camera
    }
}
