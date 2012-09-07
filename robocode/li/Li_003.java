package li;

import robocode.Robot;

public class Li_003 extends Robot {
	public void run() {
		while (true) {
			goCircle();
		}
	}

	public void turnTo(double degrees) {
		double deg = getHeading() - degrees;
		if (deg < 180) {
			turnLeft(deg);
		} else {
			turnRight(360 - deg);
		}
	}

	public void goTo(double x, double y) {
		if (x - getX() > 0) {
			turnTo(90);
			ahead(x - getX());
		} else {
			turnTo(270);
			ahead(getX() - x);
		}
		if (y - getY() > 0) {
			turnTo(0);
			ahead(y - getY());
		} else {
			turnTo(180);
			ahead(getY() - y);
		}
	}

	public void goCircle() {
		goTo(50, 50);
		goTo(getBattleFieldWidth() - 50, 50);
		goTo(getBattleFieldWidth() - 50, getBattleFieldHeight() - 50);
		goTo(50, getBattleFieldHeight() - 50);
	}
}