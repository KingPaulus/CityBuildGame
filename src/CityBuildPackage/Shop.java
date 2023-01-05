package CityBuildPackage;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Shop extends JPanel {

	
	private int Timer = 0;
	private int[] TimerAnzeige = new int[4];
	private boolean ShopUnlock = false;			// Ist der Shop schon Freigeschaltet
	private boolean ShopTimerLauft = false;
	private boolean VerkäuferAn = false;		// Läuft der Shop automatisch?
	private int UnlockPreis = 0;				// Der Preis, wie Viel der Shop Zu Freischalten Kostet
	private int ShopUbgradePreis = 0;			// Der Preis, wie Viel es Kostet der Shop zu Verbessern
	private int UpdateGeld = 0;					// Das Geld welches man mehr durch das Verbessern Bekommt
	private int ProzentUbrade = 0;
	private int MinDauer = 0;					// Wird in Sekunden Angegeben
	private int GeldPulss = 0;					// Wie Viel macht der Shop ab Anfang

	private CityPaint p;
	
	public Shop(CityPaint p, int UnlockPreis, int ShopUbgradePreis, int ProzentUbrade, int GeldPlus, int MinDauer) {
		this.p = p;
		this.UnlockPreis = UnlockPreis;
		this.ShopUbgradePreis = ShopUbgradePreis;
		this.ProzentUbrade = ProzentUbrade;
		this.GeldPulss = GeldPlus;
		this.MinDauer = MinDauer;
	}

	public int getTimer() {
		return Timer;
	}

	public void setTimer(int timer) {
		Timer = timer;
	}

	public int getTimerAnzeige(int ziffer) {
		return TimerAnzeige[ziffer];
	}

	public void setTimerAnzeige(int ziffer, int newWert) {
		TimerAnzeige[ziffer] = newWert;
	}

	public boolean getShopUnlock() {
		return ShopUnlock;
	}

	public void setShopUnlock(boolean shopUnlock) {
		ShopUnlock = shopUnlock;
	}

	public boolean getShopTimerLauft() {
		return ShopTimerLauft;
	}

	public void setShopTimerLauft(boolean shopTimerLauft) {
		ShopTimerLauft = shopTimerLauft;
	}
	
	public int getUnlockPreis() {
		return UnlockPreis;
	}

	public void setUnlockPreis(int unlockPreis) {
		UnlockPreis = unlockPreis;
	}

	public int getShopUbgradePreis() {
		return ShopUbgradePreis;
	}

	public void setShopUbgradePreis(int shopUbgradePreis) {
		ShopUbgradePreis = shopUbgradePreis;
	}

	public int getUpdateGeld() {
		return UpdateGeld;
	}

	public void setUpdateGeld(int updateGeld) {
		UpdateGeld = updateGeld;
	}

	public int getProzentUbrade() {
		return ProzentUbrade;
	}

	public void setProzentUbrade(int prozentUbrade) {
		ProzentUbrade = prozentUbrade;
	}
	
	public int getGeldPulss() {
		return GeldPulss;
	}

	public void setGeldPulss(int geldPulss) {
		GeldPulss = geldPulss;
	}
	
	public int getMinDauer() {
		return MinDauer;
	}

	public void setMinDauer(int minDauer) {
		MinDauer = minDauer;
	}

	public void ShopTimer(int ShopNr) {
//		ShopTimerLauft = true;
		p.shop[ShopNr].setShopTimerLauft(true);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
//				Timer++;
				p.shop[ShopNr].setTimer(p.shop[ShopNr].getTimer() + 1);
//				TimerAnzeige[3]++;
				p.shop[ShopNr].setTimerAnzeige(3, p.shop[ShopNr].getTimerAnzeige(3) + 1);
				
				if(p.shop[ShopNr].getTimerAnzeige(3) > 9) {
					p.shop[ShopNr].setTimerAnzeige(3,0);
					p.shop[ShopNr].setTimerAnzeige(2,p.shop[ShopNr].getTimerAnzeige(2) + 1);
				}
				if(p.shop[ShopNr].getTimerAnzeige(2) >= 6) {
					p.shop[ShopNr].setTimerAnzeige(2,0);
					p.shop[ShopNr].setTimerAnzeige(1,p.shop[ShopNr].getTimerAnzeige(1) + 1);
				}
				if(p.shop[ShopNr].getTimerAnzeige(1) > 9) {
					p.shop[ShopNr].setTimerAnzeige(1,0);
					p.shop[ShopNr].setTimerAnzeige(0,p.shop[ShopNr].getTimerAnzeige(0) + 1);
				}
	
				// repaint();
				p.newPaint();
				
				if(p.shop[ShopNr].getTimer() >= p.shop[ShopNr].getMinDauer()) {
					CityPaint.Geld = CityPaint.Geld + (p.shop[ShopNr].getGeldPulss() + UpdateGeld);
//					Timer = 0;
					p.shop[ShopNr].setTimer(0);
					p.shop[ShopNr].setTimerAnzeige(0,0);
					p.shop[ShopNr].setTimerAnzeige(1,0);
					p.shop[ShopNr].setTimerAnzeige(2,0);
					p.shop[ShopNr].setTimerAnzeige(3,0);
					p.shop[ShopNr].setShopTimerLauft(false);
					timer.cancel();
				}
			}
		}, 1*1000, 1*1000);
	}
	
	public void UnlockShop(int Preis, int ShopNr) {
		if(CityPaint.Geld >= Preis) {
			CityPaint.Geld = CityPaint.Geld - Preis;
			p.shop[ShopNr].setShopUnlock(true);
			System.out.println("Neuer Shop Nr." + ShopNr);
		}
	}
	
	public void ShopUpdate(int Preis, int ShopNr) {
		if(p.shop[ShopNr].getShopUnlock() == true) {
			
			if(p.shop[ShopNr].getProzentUbrade() >= 5) {
				p.shop[ShopNr].setVerkäuferAn(true);
			}
			
			if(p.shop[ShopNr].getProzentUbrade() < 10) {
				if(CityPaint.Geld >= Preis) {
					
					// Du bekommst jetzt bei Jedem Neuen Shop Load 20$ mehr an Geld
					int GeldRechnung = p.shop[ShopNr].getGeldPulss() / 2;
					p.shop[ShopNr].setUpdateGeld(p.shop[ShopNr].getUpdateGeld() + GeldRechnung);
					
					// Dein Geld wird Minus das Geld das du für die Vebesserung ausgegeben hast gerrechent
					CityPaint.Geld = CityPaint.Geld - Preis;
					
					p.shop[ShopNr].setProzentUbrade(p.shop[ShopNr].getProzentUbrade() + 1);
					// Levelt die Anzeige wie Weit der Shop ist um + 1 Mehr
					
					// Um die Nächste Verbesserung zu Bezahlen Benötigst du jetzt das Doppelte mehr als Vorher
					p.shop[ShopNr].setShopUbgradePreis(p.shop[ShopNr].getShopUbgradePreis() * 2);
					p.newPaint();
				}
			}
		}
	}

	public boolean getVerkäuferAn() {
		return VerkäuferAn;
	}

	public void setVerkäuferAn(boolean verkäuferAn) {
		VerkäuferAn = verkäuferAn;
	}

}
