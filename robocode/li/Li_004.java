package li;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Li_004 extends Robot {
	public void run() {
		while (true) {
			goCircle();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		goCircle();
	}

	public void onHitByBullet(HitByBulletEvent e) {
		goCircle();
	}

	public void onHitWall(HitWallEvent e) {
		goCircle();
	}

	private void turnTo(double degrees) {
		turnLeft(getHeading() - degrees);
	}

	private void goCircle() {
		double distance;
		while (true) {
			turnTo(0);// 向上
			distance = getHeight() - getY();
			ahead(distance);

			turnTo(90);// 向右
			distance = getWidth() - getX();
			ahead(distance);

			turnTo(180);// 向下
			distance = getHeight() - getY();
			ahead(distance);

			turnTo(270);// 向左
			distance = getWidth() - getX();
			ahead(distance);
		}
	}
}