package li;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Li_002 extends Robot {
	public void run() {
		while (true) {
			turnGunLeft(10);
		}
	}

	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}

	public void onHitByBullet(HitByBulletEvent event) {
		ahead(100);
	}

	public void onHitWall(HitWallEvent event) {
		back(100);
		turnLeft(125);
	}
}