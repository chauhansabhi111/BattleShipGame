package com.thughtworks.battleship.util;

import com.thoghtworks.battleship.pojo.BattleArea;
import com.thoghtworks.battleship.pojo.Point;

public class BattleShipUtil {
	public static Point convertPositionToPoint (String position) {
		Point point = new Point();
		point.setPointX(Character.getNumericValue(position.charAt(0))-Character.getNumericValue('A'));
		point.setPointY(Integer.parseInt(position.substring(1))-1);
		return point;
	}
	
	public static boolean updateTargetArea (BattleArea targetArea, Point targetPoint) {
		return targetArea.updateArea(targetPoint.getPointX(), targetPoint.getPointY());
	}
}
