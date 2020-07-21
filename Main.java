
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

        startRace(participants, obstacles);


    }

    public static void startRace(Participant[] player, Obstacle[] impediment) {
        for (int i = 0; i < player.length; i++) {
            for (int j = 0; j < impediment.length; j++) {
                System.out.println("\nПрепятствие №" + (j + 1));
                if (impediment[j].getTypeObstacle() == "wall") {

                    player[i].jump();
                    if (impediment[j].getObstacleSize() > player[i].getJumpHeight()) {

                        System.out.println("Препятствие не пройдено, участник выбывает");
                        break;
                    } else if (impediment[j].getObstacleSize() <= player[i].getJumpHeight()) {

                        System.out.println("Препятствие пройдено");

                    }

                } else if (impediment[j].getTypeObstacle() == "run") {
                    player[i].run();
                    if (impediment[j].getObstacleSize() > player[i].getRunLength()) {

                        System.out.println("Препятствие не пройдено, участник выбывает");
                        break;
                    } else if (impediment[j].getObstacleSize() <= player[i].getRunLength()) {

                        System.out.println("Препятствие пройдено");

                    }

                }
                if ((j + 1) == impediment.length) {
                    player[i].win();
                }

            }
        }
    }
}



