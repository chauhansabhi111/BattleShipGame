package com.thoughtworks.battleship.util;

import com.thoghtworks.battleship.pojo.ShipPosition;

public class BattleShipUtil {
	public static ShipPosition convertTargetToPosition (String target) {
		ShipPosition position = new ShipPosition();
		position.setPointX(Character.getNumericValue(target.charAt(0))-Character.getNumericValue('A'));
		position.setPointY(Integer.parseInt(target.substring(1))-1);
		return position;
	}
}
