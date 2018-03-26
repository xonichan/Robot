public class RobotStep {
    public class Robot {
        Direction RealDirection;
        int realX;
        int realY;

        public Robot(int rX, int rY, Direction rDirection) {
            RealDirection= rDirection;
             realX = rX;
             realY = rY;
        }

        public Direction getDirection() {
            // текущее направление взгляда
            return RealDirection;
        }

        public int getX() {
            // текущая координата X

            return realX;
        }

        public int getY() {
            // текущая координата Y

            return realY;
        }

        public void turnLeft() {
            // повернуться на 90 градусов против часовой стрелки
            System.out.println("Поворачиваем налево с направления " +RealDirection);
            switch(RealDirection) {
                case UP:
                    RealDirection=Direction.LEFT;
                    break;
                case DOWN:
                    RealDirection=Direction.RIGHT;
                    break;
                case LEFT:
                    RealDirection=Direction.DOWN;
                    break;
                case RIGHT:
                    RealDirection=Direction.UP;
                    break;
                default:
                    break;
            }

        }

        public void turnRight() {
            // повернуться на 90 градусов по часовой стрелке
            System.out.println("Поворачиваем направо с направления " +RealDirection);
            switch(RealDirection) {
                case UP:
                    RealDirection=Direction.RIGHT;
                    System.out.println("Напровление " +RealDirection);
                    break;
                case DOWN:
                    RealDirection=Direction.LEFT;
                    break;
                case LEFT:
                    RealDirection=Direction.UP;
                    break;
                case RIGHT:
                    RealDirection=Direction.DOWN;
                    break;
                default:
                    break;
            }
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
            switch(RealDirection) {
                case UP:
                    realY++;
                    System.out.println("step UP");
                    break;
                case DOWN:
                    realY--;
                    System.out.println("step DOWN");
                    break;
                case LEFT:
                    realX--;
                    System.out.println("step LEFT");
                    break;
                case RIGHT:
                    realX++;
                    System.out.println("step RIGHT");
                    break;
                default:
                    break;
            }
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static   void main(String[] args) {

        System.out.println("i'm alive");

        try
        {
            RobotStep obj = new RobotStep ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }

    }

    public  void run(String[] args){
        RobotStep.moveRobot( new RobotStep.Robot(1, 1, Direction.LEFT), -1, -1);
        RobotStep.moveRobot( new RobotStep.Robot(1, -1, Direction.LEFT), -1, -1);
        RobotStep.moveRobot( new RobotStep.Robot(-1, 1, Direction.LEFT), -1, -1);
        RobotStep.moveRobot( new RobotStep.Robot(-1, -2, Direction.LEFT), -1, -1);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        System.out.print("Где стоим ");
        System.out.print(robot.getDirection());
        System.out.print(" X: "+ robot.getX());
        System.out.println(" Y: "+ robot.getY());
        System.out.print("Куда идем");
        System.out.print(" X: "+ toX);
        System.out.println(" Y: "+ toY);
        System.out.println("Встаем на исходную");
        switch(robot.getDirection()) {
            case UP:
                break;
            case DOWN:
                robot.turnRight();
                robot.turnRight();
                break;
            case LEFT:
                robot.turnRight();
                break;
            case RIGHT:
                robot.turnLeft();
                break;
            default:
                break;
        }
        System.out.println("Встали на исходную");
        System.out.print(robot.getDirection());
        System.out.print(" X: "+robot.getX());
        System.out.println(" Y: "+robot.getY());
        System.out.println("Побежали");
        if (toY > robot.getY()) {
            System.out.println("Вперед");
            for (int i=robot.getY(); i<toY; i++) {
                System.out.println("Шаг "+i);
                robot.stepForward();
            }
        }
        System.out.println("Поворачиваем по Х");
        if (toX!=robot.getX()) {
            if (toX>(robot.getX())){
                robot.turnRight();
                for (int j=robot.getX(); j<toX; j++) {
                    robot.stepForward();
                }
            }
            else {
                robot.turnLeft();
                int StepsX =((toX-robot.getX())*-1);
                System.out.println("k: "+StepsX);
                for (int k=0; k<StepsX; k++) {
                    robot.stepForward();
                }
            }
        }

        if (toY<robot.getY()){
            switch(robot.getDirection()) {
                case UP:{
                    robot.turnRight();
                    robot.turnRight();
                    int StepsY =((toY-robot.getY())*-1);
                    for (int m=0; m<StepsY; m++) {
                        robot.stepForward();
                        }
                    }
                    break;
                case DOWN:
                    for (int m=robot.getY(); m<(toY*-1); m++) {
                        robot.stepForward();
                        }
                    break;
                case LEFT:
                    robot.turnLeft();
                    int StepsY =((toY-robot.getY())*-1);
                    for (int m=0; m<StepsY; m++) {
                        System.out.println("m: "+m);
                        robot.stepForward();
                    }
                    break;
                case RIGHT:
                    robot.turnRight();
                    for (int m=0; m<((toY-robot.getY())*-1); m++) {
                        robot.stepForward();
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("Итого:");
        System.out.println("Смотрим "+robot.getDirection());
        System.out.println("X "+ robot.getX());
        System.out.println("Y "+ robot.getY());
        if ((robot.getX()==toX)&&(robot.getY()==toY)){
            System.out.println("Win!");
            System.out.println("");
        }else
            {System.out.println("Noooooooooooooooooooooooooooooooooooo!!!!!!!!!!");
                System.out.println("");
        }

    }

}

