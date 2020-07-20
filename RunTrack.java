public class RunTrack implements Obstacle {

    protected int trackLength;
    private String runTrack = "run";

    public RunTrack(int trackLength) {

        this.trackLength = trackLength;
    }
@Override
    public int getObstacleSize() {
        return trackLength;
    }
    @Override
    public String getTypeObstacle(){
        return runTrack;
    }
}
