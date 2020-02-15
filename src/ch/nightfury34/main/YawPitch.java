package ch.nightfury34.main;

public class YawPitch {
    private float yaw;
    private float pitch;

    public YawPitch(float yaw, float pitch){
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public boolean isBetween(float pitch1, float pitch2, float yaw1, float yaw2){
        if(yaw>=yaw1 && yaw<=yaw2 && pitch>=pitch1 && pitch<=pitch2){
            return true;
        }else{
            return false;
        }
    }
}
