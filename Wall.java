public class Wall implements Obstacle {

    protected int barrierHeight;
    private String wall = "wall";

    public Wall(int barrierHeight) {

        this.barrierHeight = barrierHeight;
    }
@Override
    public int getObstacleSize() {
        return barrierHeight;
    }

    @Override
    public String getTypeObstacle(){
        return wall;
    }

}
