package li;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Li_001 extends Robot {
	public void run() {
		while (true) {
			turnGunLeft(5);
		}
	}

	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}
}