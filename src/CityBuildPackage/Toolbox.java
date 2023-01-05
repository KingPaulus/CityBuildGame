package CityBuildPackage;

import java.util.Timer;
import java.util.TimerTask;

public class Toolbox {

	private static int MaxHoheScroll = 0;
	private static int MaxTiefeScroll = 0;
	
	public static void SectorY(int Hohe, boolean Up_Down) {
		if(Up_Down == true) {
			CityPaint.Sector2 = CityPaint.Sector2 - Hohe;
		}
		if(Up_Down == false) {
			CityPaint.Sector2 = CityPaint.Sector2 + Hohe;
		}
		if(CityPaint.FensterGrosse == 1) {
			MaxHoheScroll = 600;
			MaxTiefeScroll = -640;
		} else if(CityPaint.FensterGrosse == 2) {
			MaxHoheScroll = 845;
			MaxTiefeScroll = -880;
		} else if(CityPaint.FensterGrosse == 3) {
			MaxHoheScroll = 960;
			MaxTiefeScroll = -945;
		}
		if(CityPaint.Sector2 >= MaxHoheScroll) {
			CityPaint.Sector2 = MaxHoheScroll;
		}
		if(CityPaint.Sector2 <= MaxTiefeScroll) {
			CityPaint.Sector2 = MaxTiefeScroll;
		}
	}
	
	
	
	
	public static void FensterEinstellungenRechts() {
		if(CityPaint.FensterGrosse == 1) {
			CityPaint.FensterGrosse = 2;
		} else if(CityPaint.FensterGrosse == 2) {
			CityPaint.FensterGrosse = 3;
		} else if(CityPaint.FensterGrosse == 3) {
			CityPaint.FensterGrosse = 1;
		}
	}
	
	public static void FensterEinstellungenLinks() {
		if(CityPaint.FensterGrosse == 1) {
			CityPaint.FensterGrosse = 3;
		} else if(CityPaint.FensterGrosse == 3) {
			CityPaint.FensterGrosse = 2;
		} else if(CityPaint.FensterGrosse == 2) {
			CityPaint.FensterGrosse = 1;
		}
	}
	
	
	
	
	public static void ScrollEinstellungenRechts() {
		if(CityPaint.ScrollSchnell == 20) {
			CityPaint.ScrollSchnell = 25;
		} else if(CityPaint.ScrollSchnell == 25) {
			CityPaint.ScrollSchnell = 30;
		} else if(CityPaint.ScrollSchnell == 30) {
			CityPaint.ScrollSchnell = 35;
		} else if(CityPaint.ScrollSchnell == 35) {
			CityPaint.ScrollSchnell = 20;
		}
	}
	
	public static void ScrollEinstellungenLinks() {
		if(CityPaint.ScrollSchnell == 20) {
			CityPaint.ScrollSchnell = 35;
		} else if(CityPaint.ScrollSchnell == 35) {
			CityPaint.ScrollSchnell = 30;
		} else if(CityPaint.ScrollSchnell == 30) {
			CityPaint.ScrollSchnell = 25;
		} else if(CityPaint.ScrollSchnell == 25) {
			CityPaint.ScrollSchnell = 20;
		}
	}
	
}
