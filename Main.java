
public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[6];

        participants[0] = new Human("Jack", 170, 3000);
        participants[1] = new Human("Alex", 140, 600);

        participants[2] = new Cat("Johnny", 210, 400);
        participants[3] = new Cat("Mike", 150, 600);

        participants[4] = new Robot(1, 40, 3000);
        participants[5] = new Robot(2, 60, 2100);


        Obstacle[] obstacles = new Obstacle[6];

        obstacles[0] = new Wall(140);
        obstacles[1] = new RunTrack(400);
        obstacles[2] = new Wall(160);
        obstacles[3] = new RunTrack(2140);
        obstacles[4] = new Wall(50);
        obstacles[5] = new RunTrack(2500);

        boolean result;
        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                System.out.println("\nПрепятствие №" + (j + 1));
                if (obstacles[j].getTypeObstacle() == "wall") {

                    participants[i].jump();
                    if (obstacles[j].getObstacleSize() > participants[i].getJumpHeight())
                    {
                        result = false;
                        System.out.println(result);
                        System.out.println("Препятствие не пройдено, участник выбывает");
                        break;
                    }
                    else if (obstacles[j].getObstacleSize() <= participants[i].getJumpHeight())
                    {
                        result = true;
                        System.out.println(result);

                    }

                }
                else if (obstacles[j].getTypeObstacle() == "run") {
                    participants[i].run();
                    if (obstacles[j].getObstacleSize() > participants[i].getRunLength())
                    {
                        result = false;
                        System.out.println(result);
                        break;
                    }
                    else if (obstacles[j].getObstacleSize() <= participants[i].getRunLength())
                    {
                        result = true;
                        System.out.println(result );

                    }

                }
                if ((j+1) == obstacles.length){
                    participants[i].win();
                }

            }
        }
    }
}










