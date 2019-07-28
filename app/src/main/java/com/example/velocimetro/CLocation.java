package com.example.velocimetro;

import android.location.Location;

public class CLocation extends Location {
    private boolean useMetricUnit = false;
    public CLocation(Location location){
        this(location, true);
    }
    public CLocation(Location location, boolean useMetricUnit) {
        super(location);
        this.useMetricUnit = useMetricUnit;
    }
    public boolean getUseMetricUnit(){
        return this.useMetricUnit;
    }
    public void setUseMetricUnit(boolean useMetricUnit){
        this.useMetricUnit = useMetricUnit;
    }

    @Override
    public float distanceTo(Location dest) {
        float distance = super.distanceTo(dest);
        if (!this.getUseMetricUnit()){
            distance = distance * 3.28083989501312f;
        }
        return distance;
    }

    @Override
    public float getSpeed() {
        float speed = super.getSpeed() * 3.6f;
        if (this.getUseMetricUnit()){
            speed = speed * 2.23693629f;
        }
        return speed;
    }

    @Override
    public float getAccuracy() {
        float accuracy = super.getAccuracy();
        if (this.getUseMetricUnit()){
            accuracy = accuracy * 3.28083989501312f;
        }
        return accuracy;
    }
}
