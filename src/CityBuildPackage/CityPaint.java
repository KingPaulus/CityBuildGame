package CityBuildPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CityPaint extends JPanel implements MouseListener, KeyListener{
	
	public JFrame jf;
//	public static CityPaint p = new CityPaint();
	public  Shop[] shop = new Shop[9];
	
	public static int Breite = 400;
	public static int Hohe = 600;
	public static int Sector = 0;
	public static int Sector2 = 0;
	public static int FeldGroﬂeX;
	public static int FeldGroﬂeY;
	
	public boolean Einstellungen = false;
	public boolean EinstellungenSicherung = true;
	public static int FensterGrosse = 1;
	public int FensterSpeicher = FensterGrosse;
	public static int ScrollSchnell = 20;
	public int ScrollSpeicher = ScrollSchnell;
	public boolean HotBar = false;
	private int abstand = 200;
	
	public static int Geld = 0;
	
	public boolean Start = true;
	public boolean GameOver = false;
	
	public boolean GameStart = false;
	public boolean Tutorial = true;
	public int[] TutorialFortschritt = new int[10];
	
	ImageIcon imagePic1 = null;
	Image image1 = null;
	ImageIcon imagePic2 = null;
	Image image2 = null;
	ImageIcon imagePic3 = null;
	Image image3 = null;
	ImageIcon imagePic4 = null;
	Image image4 = null;
	ImageIcon imagePic5 = null;
	Image image5 = null;
	ImageIcon imagePic6 = null;
	Image image6 = null;
	ImageIcon imagePic7 = null;
	Image image7 = null;
	ImageIcon imagePic8 = null;
	Image image8 = null;
	ImageIcon imagePic9 = null;
	Image image9 = null;
	ImageIcon imagePic10 = null;
	Image image10 = null;
	ImageIcon imagePic11 = null;
	Image image11 = null;
	ImageIcon imagePic12 = null;
	Image image12 = null;
	ImageIcon imagePic13 = null;
	Image image13 = null;
	
	// Hotbar Hintergrund
	ImageIcon imagePic14 = null;
	Image image14 = null;
	ImageIcon imagePic15 = null;
	Image image15 = null;
	ImageIcon imagePic16 = null;
	Image image16 = null;
	ImageIcon imagePic17 = null;
	Image image17 = null;
	ImageIcon imagePic18 = null;
	Image image18 = null;
	ImageIcon imagePic19 = null;
	Image image19 = null;
	ImageIcon imagePic20 = null;
	Image image20 = null;
	ImageIcon imagePic21 = null;
	Image image21 = null;
	ImageIcon imagePic22 = null;
	Image image22 = null;
	
	ImageIcon imagePic23 = null;
	Image image23 = null;
	ImageIcon imagePic24 = null;
	Image image24 = null;
	ImageIcon imagePic25 = null;
	Image image25 = null;
	
	ImageIcon imagePic26 = null;
	Image image26 = null;
	
	// TODO
	
	public CityPaint() {
		//CityPaint CP = new CityPaint();
		jf = new JFrame();

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle(CityBuildMain.GameName);
		jf.addMouseListener(this);
		jf.addKeyListener(this);
		jf.setResizable(false);
		jf.setSize(Breite, Hohe);
		jf.setLocationRelativeTo(null);
		jf.add(this);
		
//		Tutorial();
//		Level1();
	}
	
	public void Tutorial() {
		shop[0] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[1] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[2] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[3] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[4] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[5] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[6] = new Shop(this,100000,0,0,0,50);			//	 |
		shop[7] = new Shop(this,20,1000,0,40,10);			//	 |
		shop[8] = new Shop(this,0,20,0,20,2);				//	\|/
		
		TutorialFortschritt[0] = 1;
	}
	
	public void Level1() {
		
		// new Shop(UnlockPreis / ShopUbgradePreis / ProzentUbrade / GeldPlus / MinDauer)
		
		shop[0] = new Shop(this,10000,5120,0,600,120);		//	 |			// 1000 / 500
		shop[1] = new Shop(this,5000,2560,0,400,80);		//	 |			// 800 / 760
		shop[2] = new Shop(this,2000,1280,0,320,60);		//	 |			// 500 / 460
		shop[3] = new Shop(this,800,640,0,240,40);			//	 |			// 440 / 300
		shop[4] = new Shop(this,380,320,0,160,25);			//	 |			// 360 / 200
		shop[5] = new Shop(this,220,160,0,120,17);			//	 |			// 220 / 120
		shop[6] = new Shop(this,100,80,0,80,10);			//	 |			// 100 / 80
		shop[7] = new Shop(this,60,40,0,60,5);				//	 |			// 60 / 40
		shop[8] = new Shop(this,0,20,0,20,2);				//	\|/			// 20 / 20
	}
	
	public void neuStart () {
		jf.setVisible(false);
		jf.dispose();
		Sector = 0;
		Sector2 = 0;
		Start = false;
	}
	
	public void newWindowSize() {
		jf.setVisible(false);
		jf.dispose();
		if(FensterGrosse == 1) {
			Breite = 400;
			Hohe = 600;
		} else if(FensterGrosse == 2) {
			Breite = 560;
			Hohe = 840;
		} else if(FensterGrosse == 3) {
			// 600 / 900
			Breite = 640;
			Hohe = 1000;
		}
		setzeWerte();
		jf.setSize(Breite, Hohe);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	
	public void setzeWerte () {
		if(FensterGrosse == 1) {
			FeldGroﬂeX = Breite-15;
			FeldGroﬂeY = 200;
		} else if(FensterGrosse == 2) {
			FeldGroﬂeX = Breite-15;
			FeldGroﬂeY = 280;
		} else if(FensterGrosse == 3) {
			FeldGroﬂeX = Breite-15;
			FeldGroﬂeY = 320;
		}
	}
	
	public void setImage() {
		imagePic1 = new ImageIcon("image/ShopClosed.png");
		image1 = imagePic1.getImage();
		
		imagePic2 = new ImageIcon("image/ShopClosed.png");
		image2 = imagePic2.getImage();
		
		imagePic3 = new ImageIcon("image/ShopClosed.png");
		image3 = imagePic3.getImage();
		
		imagePic4 = new ImageIcon("image/ShopClosed.png");
		image4 = imagePic4.getImage();
		
		imagePic5 = new ImageIcon("image/ShopClosed.png");
		image5 = imagePic5.getImage();
		
		imagePic6 = new ImageIcon("image/ShopClosed.png");
		image6 = imagePic6.getImage();
		
		imagePic7 = new ImageIcon("image/ShopClosed.png");
		image7 = imagePic7.getImage();
		
		imagePic8 = new ImageIcon("image/ShopClosed.png");
		image8 = imagePic8.getImage();
		
		imagePic9 = new ImageIcon("image/ShopClosed.png");
		image9 = imagePic9.getImage();
		
//		imagePic10 = new ImageIcon("image/ShopClosed.png");
//		image10 = imagePic10.getImage();
		
		imagePic11 = new ImageIcon("image/Tastature.png");
		image11 = imagePic11.getImage();
		
		imagePic12 = new ImageIcon("image/EinstellungenIcon.png");
		image12 = imagePic12.getImage();
		
		imagePic13 = new ImageIcon("image/ProzentAnzeige1.png");
		image13 = imagePic13.getImage();
		
		imagePic14 = new ImageIcon("image/Shop9Hotbar.png");
		image14 = imagePic14.getImage();
		imagePic15 = new ImageIcon("image/Shop8Hotbar.png");
		image15 = imagePic15.getImage();
		imagePic16 = new ImageIcon("image/Shop7Hotbar.png");
		image16 = imagePic16.getImage();
		imagePic17 = new ImageIcon("image/Shop6Hotbar.png");
		image17 = imagePic17.getImage();
		imagePic18 = new ImageIcon("image/Shop5Hotbar.png");
		image18 = imagePic18.getImage();
		imagePic19 = new ImageIcon("image/Shop4Hotbar.png");
		image19 = imagePic19.getImage();
		imagePic20 = new ImageIcon("image/Shop3Hotbar.png");
		image20 = imagePic20.getImage();
		imagePic21 = new ImageIcon("image/Shop2Hotbar.png");
		image21 = imagePic21.getImage();
		imagePic22 = new ImageIcon("image/Shop1Hotbar.png");
		image22 = imagePic22.getImage();
		
		imagePic23 = new ImageIcon("image/Tutorial.png");
		image23 = imagePic23.getImage();
		imagePic24 = new ImageIcon("image/Tutorial Yes.png");
		image24 = imagePic24.getImage();
		imagePic25 = new ImageIcon("image/Tutorial No.png");
		image25 = imagePic25.getImage();
		
		imagePic26 = new ImageIcon("image/StartSceen.png");
		image26 = imagePic26.getImage();
	}

	
	public void paint(Graphics g) {
		if(Start) {
			setzeWerte();
			setImage();
			Start = false;
		}
		super.paintComponent(g);

		if(GameStart == true) {
			// Hintergrund
			// Sobald ein Shop Freigeschaltet wurde
			// Wird das Bild von Gesperrt zum Normalen Shop Bild ge‰ndert
			g.setColor(Color.BLACK);
			g.fillRect(0,0,jf.getWidth(),jf.getHeight());
			
			
			if(shop[0].getShopUnlock() == true) {
				imagePic1 = new ImageIcon("image/Shop1.png");
				image1 = imagePic1.getImage();
			}
			if(shop[1].getShopUnlock() == true) {
				imagePic2 = new ImageIcon("image/Shop2.png");
				image2 = imagePic2.getImage();
			}
			if(shop[2].getShopUnlock() == true) {
				imagePic3 = new ImageIcon("image/Shop3.png");
				image3 = imagePic3.getImage();
			}
			if(shop[3].getShopUnlock() == true) {
				imagePic4 = new ImageIcon("image/Shop4.png");
				image4 = imagePic4.getImage();
			}
			if(shop[4].getShopUnlock() == true) {
				imagePic5 = new ImageIcon("image/Shop5.png");
				image5 = imagePic5.getImage();
			}
			if(shop[5].getShopUnlock() == true) {
				imagePic6 = new ImageIcon("image/Shop6.png");
				image6 = imagePic6.getImage();
			}
			if(shop[6].getShopUnlock() == true) {
				imagePic7 = new ImageIcon("image/Shop7.png");
				image7 = imagePic7.getImage();
			}
			if(shop[7].getShopUnlock() == true) {
				imagePic8 = new ImageIcon("image/Shop8.png");
				image8 = imagePic8.getImage();
			}
			if(shop[8].getShopUnlock() == true) {
				imagePic9 = new ImageIcon("image/Shop9.png");
				image9 = imagePic9.getImage();
			}
			
			
			
			
			
			
			
			//TODO
			// Zeit die Bilder der Shops an
			// Bilder m¸ssen Immer neu geladen werden da Man auf der Y-Achse Hoch und Runter kann
			g.fillRect(Sector, Sector2-(FeldGroﬂeY*3), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image1,Sector, Sector2-(FeldGroﬂeY*3), FeldGroﬂeX, FeldGroﬂeY, null);
			
			
			g.fillRect(Sector, Sector2-(FeldGroﬂeY*2), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image2,Sector, Sector2-(FeldGroﬂeY*2), FeldGroﬂeX, FeldGroﬂeY, null);
			
			
			g.fillRect(Sector, Sector2-(FeldGroﬂeY*1), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image3,Sector, Sector2-(FeldGroﬂeY*1), FeldGroﬂeX, FeldGroﬂeY, null);
			
			
			g.fillRect(Sector, Sector2, FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image4,Sector, Sector2, FeldGroﬂeX, FeldGroﬂeY, null);
			
	
			g.fillRect(Sector, Sector2+(FeldGroﬂeY*1), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image5,Sector, Sector2+(FeldGroﬂeY*1), FeldGroﬂeX, FeldGroﬂeY, null);
			
	
			g.fillRect(Sector, Sector2+(FeldGroﬂeY*2), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image6,Sector, Sector2+(FeldGroﬂeY*2), FeldGroﬂeX, FeldGroﬂeY, null);
			
	
			g.fillRect(Sector, Sector2+(FeldGroﬂeY*3), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image7,Sector, Sector2+(FeldGroﬂeY*3), FeldGroﬂeX, FeldGroﬂeY, null);
			
	
			g.fillRect(Sector, Sector2+(FeldGroﬂeY*4), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image8,Sector, Sector2+(FeldGroﬂeY*4), FeldGroﬂeX, FeldGroﬂeY, null);
			
			
			g.fillRect(Sector, Sector2+(FeldGroﬂeY*5), FeldGroﬂeX, FeldGroﬂeY);
			g.drawImage(image9,Sector, Sector2+(FeldGroﬂeY*5), FeldGroﬂeX, FeldGroﬂeY, null);
	
			g.setColor(Color.WHITE);
			
			
			
			
			
			
			
			
			
			
			
			
			// TODO
			// Timer Anzeigen
			// Zeigt den Timer an Wenn der Shop Freigeschalt 
			// Zeigt den Preis des Shop zum Freischalten an wenn der Shop Gesperrt ist
			
			
			// Zeigt dein Geld Menge an
			int BreiteAnbstand = 180;
			if(Geld >= 000) {
				BreiteAnbstand = BreiteAnbstand-30;
			}
			if(Geld >= 1000) {
				BreiteAnbstand = BreiteAnbstand-40;
			}
			if(Geld >= 10000) {
				BreiteAnbstand = BreiteAnbstand-10;
			}
			if(Geld >= 100000) {
				BreiteAnbstand = BreiteAnbstand-20;
			}
			if(FensterGrosse == 1) {
				g.setFont(new Font("Franklin Gothic Demi Italic", 4, 60));
				g.drawString("" + Geld + "$", BreiteAnbstand, 50);
			 }else if(FensterGrosse == 2) {
				g.setFont(new Font("Franklin Gothic Demi Italic", 4, 80));
				g.drawString("" + Geld + "$", (BreiteAnbstand + 90), 70);
			} else if(FensterGrosse == 3) {
				g.setFont(new Font("Franklin Gothic Demi Italic", 4, 100));
				g.drawString("" + Geld + "$", (BreiteAnbstand + 100), 80);
			}
			
			// Einstellungen f¸r die Verschiedenen Fenster Grˆﬂen
			// Timer Anziegen der Shops & Unlock Preise
			g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
			if(FensterGrosse == 1) {
				abstand = 200;
			} else if(FensterGrosse == 2) {
				abstand = 280;
			} else if(FensterGrosse == 3) {
				abstand = 300;
			}
			
			if(shop[0].getShopUnlock() == true) {
				g.drawString("" + shop[0].getTimerAnzeige(0) + shop[0].getTimerAnzeige(1) + ":" + shop[0].getTimerAnzeige(2) + shop[0].getTimerAnzeige(3), Sector+10, (Sector2-(FeldGroﬂeY*3))+abstand);
			} else if(shop[0].getShopUnlock() == false) {
				g.drawString("" + shop[0].getUnlockPreis() + "$", Sector+10, (Sector2-(FeldGroﬂeY*3))+abstand);
			}
			
			if(shop[1].getShopUnlock() == true) {
				g.drawString("" + shop[1].getTimerAnzeige(0) + shop[1].getTimerAnzeige(1) + ":" + shop[1].getTimerAnzeige(2) + shop[1].getTimerAnzeige(3), Sector+10, (Sector2-(FeldGroﬂeY*2))+abstand);
			} else if(shop[1].getShopUnlock() == false) {
				g.drawString("" + shop[1].getUnlockPreis() + "$", Sector+10, (Sector2-(FeldGroﬂeY*2))+abstand);
			}
			
			if(shop[2].getShopUnlock() == true) {
				g.drawString("" + shop[2].getTimerAnzeige(0) + shop[2].getTimerAnzeige(1) + ":" + shop[2].getTimerAnzeige(2) + shop[2].getTimerAnzeige(3), Sector+10, (Sector2-(FeldGroﬂeY*1))+abstand);
			} else if(shop[2].getShopUnlock() == false) {
				g.drawString("" + shop[2].getUnlockPreis() + "$", Sector+10, (Sector2-(FeldGroﬂeY*1))+abstand);
			}
			
			if(shop[3].getShopUnlock() == true) {
				g.drawString("" + shop[3].getTimerAnzeige(0) + shop[3].getTimerAnzeige(1) + ":" + shop[3].getTimerAnzeige(2) + shop[3].getTimerAnzeige(3), Sector+10, (Sector2)+abstand);
			} else if(shop[3].getShopUnlock() == false) {
				g.drawString("" + shop[3].getUnlockPreis() + "$", Sector+10, (Sector2)+abstand);
			}
			
			if(shop[4].getShopUnlock() == true) {
				g.drawString("" + shop[4].getTimerAnzeige(0) + shop[4].getTimerAnzeige(1) + ":" + shop[4].getTimerAnzeige(2) + shop[4].getTimerAnzeige(3), Sector+10, (Sector2+(FeldGroﬂeY*1))+abstand);
			} else if(shop[4].getShopUnlock() == false) {
				g.drawString("" + shop[4].getUnlockPreis() + "$", Sector+10, (Sector2+(FeldGroﬂeY*1))+abstand);
			}
			
			if(shop[5].getShopUnlock() == true) {
				g.drawString("" + shop[5].getTimerAnzeige(0) + shop[5].getTimerAnzeige(1) + ":" + shop[5].getTimerAnzeige(2) + shop[5].getTimerAnzeige(3), Sector+10, (Sector2+(FeldGroﬂeY*2))+abstand);
			} else if(shop[5].getShopUnlock() == false) {
				g.drawString("" + shop[5].getUnlockPreis() + "$", Sector+10, (Sector2+(FeldGroﬂeY*2))+abstand);
			}
			
			if(shop[6].getShopUnlock() == true) {
				g.drawString("" + shop[6].getTimerAnzeige(0) + shop[6].getTimerAnzeige(1) + ":" + shop[6].getTimerAnzeige(2) + shop[6].getTimerAnzeige(3), Sector+10, (Sector2+(FeldGroﬂeY*3))+abstand);
			} else if(shop[6].getShopUnlock() == false) {
				g.drawString("" + shop[6].getUnlockPreis() + "$", Sector+10, (Sector2+(FeldGroﬂeY*3))+abstand);
			}
			
			if(shop[7].getShopUnlock() == true) {
				g.drawString("" + shop[7].getTimerAnzeige(0) + shop[7].getTimerAnzeige(1) + ":" + shop[7].getTimerAnzeige(2) + shop[7].getTimerAnzeige(3), Sector+10, (Sector2+(FeldGroﬂeY*4))+abstand);
			} else if(shop[7].getShopUnlock() == false) {
				g.drawString("" + shop[7].getUnlockPreis() + "$", Sector+10, (Sector2+(FeldGroﬂeY*4))+abstand);
			}
			
			if(shop[8].getShopUnlock() == true) {
				g.drawString("" + shop[8].getTimerAnzeige(0) + shop[8].getTimerAnzeige(1) + ":" + shop[8].getTimerAnzeige(2) + shop[8].getTimerAnzeige(3), Sector+10, (Sector2+(FeldGroﬂeY*5))+abstand);
			} else if(shop[8].getShopUnlock() == false) {
				g.drawString("" + shop[8].getUnlockPreis() + "$", Sector+10, (Sector2+(FeldGroﬂeY*5))+abstand);
			}
	
			
			
			// Tutorial
			//
			//
			//
			if(Tutorial == true) {
				// Sector = y
				// Sector2 = X
				// 0 = keine Action
				// 1 = Action
				// 2 = Action abgeschlossen;
				
				
				if(TutorialFortschritt[0] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 50));
					g.setColor(Color.BLACK);
					g.drawString("Use W / S", Sector+50, Hohe/2);
					System.out.println(Sector2);
					if(Sector2 == -340 || Sector2 == 60) {
						TutorialFortschritt[0] = 2;
						TutorialFortschritt[1] = 1;
						repaint();
					}
				}
				
				// Sage den Nutzer er soll den Shop kaufen
				if(TutorialFortschritt[1] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
					g.setColor(Color.BLACK);
					g.drawString("Unlocke the Shop", Sector+30, (Sector2+(FeldGroﬂeY*5))+abstand-60);
					if(shop[8].getShopUnlock() == true) {
						TutorialFortschritt[1] = 2;
						TutorialFortschritt[2] = 1;
						repaint();
					}
				}
				
				if(TutorialFortschritt[2] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
					g.setColor(Color.BLACK);
					g.drawString("Click on the shop", Sector+30, (Sector2+(FeldGroﬂeY*5))+abstand-80);
					g.drawString("& Produce money", Sector+30, (Sector2+(FeldGroﬂeY*5))+abstand-50);
					if(shop[8].getShopTimerLauft() == true) {
						TutorialFortschritt[2] = 2;
						TutorialFortschritt[3] = 1;
						repaint();
					}
				}
				
				if(TutorialFortschritt[3] == 1) {
					
					if(Geld >= 20) {
						g.setFont(new Font("Franklin Gothic Demi Italic", 4, 30));
						g.setColor(Color.BLACK);
						g.drawString("You now have enough", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-80);
						g.drawString("To Unlock Shop 2", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-50);
					}
					if(shop[7].getShopUnlock() == true) {
						TutorialFortschritt[3] = 2;
						TutorialFortschritt[4] = 1;
						repaint();
					}
				}
				
				if(TutorialFortschritt[4] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
					g.setColor(Color.WHITE);
					g.drawString("You can Run", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-110);
					g.drawString("more shops", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-80);
					g.drawString("At the same time", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-50);
					if(shop[8].getShopTimerLauft() == true && shop[7].getShopTimerLauft() == true) {
						TutorialFortschritt[4] = 2;
						TutorialFortschritt[5] = 1;
						repaint();
					}
				}
				
				if(TutorialFortschritt[5] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
					g.setColor(Color.WHITE);
					if(shop[7].getTimer() >= 3 && shop[7].getTimer() < 8) {
						g.drawString("Every shop", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-80);
						g.drawString("needs more time", Sector+30, (Sector2+(FeldGroﬂeY*4))+abstand-50);
					}
					if(shop[7].getTimer() == 8) {
						TutorialFortschritt[5] = 2;
						TutorialFortschritt[6] = 1;
						repaint();
					}
				}
				
				if(TutorialFortschritt[6] == 1) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
					g.setColor(Color.WHITE);
					g.drawString("Press Space", Sector+50, Hohe/2);
					if(shop[7].getTimer() == 8) {
						TutorialFortschritt[6] = 2;
						TutorialFortschritt[7] = 1;
						repaint();
					}
				}
			}
			
			
			
			
			
			
			
			// TODO
			// Zeit die Hotbar an wenn sie eingeschaltet ist
			// Listet alle 9 Shop Updates auf
			// Listet unten die Leist zu denn Einstellungen auf
			
			if(HotBar == true && Einstellungen == false) {
				
				int HotbarHohe = 0;
				int AnzeigenHohe = 0;
				if(FensterGrosse == 1) {
					HotbarHohe = 200;
					AnzeigenHohe = 0;
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 15));
				} else if(FensterGrosse == 2) {
					HotbarHohe = 240;
					AnzeigenHohe = 10;
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 20));
				} else if(FensterGrosse == 3) {
					HotbarHohe = 240;
					AnzeigenHohe = 10;
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 20));
				}
				g.setColor(Color.MAGENTA);
				g.fillRect(0, jf.getHeight()-HotbarHohe, FeldGroﬂeX, 200);
				
				
				// Von Links ->> Nach Rechts
				
				// Hintergund der Shop in der Hotrbar
				if(shop[8].getShopUnlock() == true) {
					g.drawImage(image14,FeldGroﬂeX/9 * 0, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[7].getShopUnlock() == true) {
					g.drawImage(image15,FeldGroﬂeX/9 * 1, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[6].getShopUnlock() == true) {
					g.drawImage(image16,FeldGroﬂeX/9 * 2, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[5].getShopUnlock() == true) {
					g.drawImage(image17,FeldGroﬂeX/9 * 3, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[4].getShopUnlock() == true) {
					g.drawImage(image18,FeldGroﬂeX/9 * 4, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[3].getShopUnlock() == true) {
					g.drawImage(image19,FeldGroﬂeX/9 * 5, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[2].getShopUnlock() == true) {
					g.drawImage(image20,FeldGroﬂeX/9 * 6, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[1].getShopUnlock() == true) {
					g.drawImage(image21,FeldGroﬂeX/9 * 7, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				if(shop[0].getShopUnlock() == true) {
					g.drawImage(image22,FeldGroﬂeX/9 * 8, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				}
				
				// Die Prozent Anzeige der Shop Ubgrads
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 0, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[8].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 1, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[7].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 2, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[6].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 3, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[5].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 4, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[4].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 5, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[3].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 6, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[2].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 7, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[1].getProzentUbrade());
				g.setColor(Color.BLUE);
				g.fillRect(FeldGroﬂeX/9 * 8, (jf.getHeight()-HotbarHohe)+55, FeldGroﬂeX/9, ((HotbarHohe-105)/10)*shop[0].getProzentUbrade());
				
				// Die Rahmen der Hotbar Anzeigen
				g.drawImage(image13,FeldGroﬂeX/9 * 0, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 1, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 2, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 3, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 4, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 5, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 6, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 7, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.drawImage(image13,FeldGroﬂeX/9 * 8, (jf.getHeight()-HotbarHohe)-AnzeigenHohe, FeldGroﬂeX/9, HotbarHohe-50, null);
				g.setColor(Color.black);
				g.fillRect(FeldGroﬂeX/9 * 9, jf.getHeight()-HotbarHohe, FeldGroﬂeX/9, HotbarHohe-50);
				
				
				// Geld Anzeige der Preise zu Verbesseren
				g.setColor(Color.WHITE);
				if(shop[8].getShopUnlock() == true) {
					g.drawString("" + shop[8].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 0, (jf.getHeight()-HotbarHohe)+30);
				}
				if(shop[7].getShopUnlock() == true) {
					g.drawString("" + shop[7].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 1, (jf.getHeight()-HotbarHohe)+50);
				}
				if(shop[6].getShopUnlock() == true) {
					g.drawString("" + shop[6].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 2, (jf.getHeight()-HotbarHohe)+30);
				}
				if(shop[5].getShopUnlock() == true) {
					g.drawString("" + shop[5].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 3, (jf.getHeight()-HotbarHohe)+50);
				}
				if(shop[4].getShopUnlock() == true) {
					g.drawString("" + shop[4].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 4, (jf.getHeight()-HotbarHohe)+30);
				}
				if(shop[3].getShopUnlock() == true) {
					g.drawString("" + shop[3].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 5, (jf.getHeight()-HotbarHohe)+50);
				}
				if(shop[2].getShopUnlock() == true) {
					g.drawString("" + shop[2].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 6, (jf.getHeight()-HotbarHohe)+30);
				}
				if(shop[1].getShopUnlock() == true) {
					g.drawString("" + shop[1].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 7, (jf.getHeight()-HotbarHohe)+50);
				}
				if(shop[0].getShopUnlock() == true) {
					g.drawString("" + shop[0].getShopUbgradePreis() + "$", (FeldGroﬂeX/9) * 8, (jf.getHeight()-HotbarHohe)+30);
				}
				
				g.setColor(Color.GRAY);
				g.fillRect(0, jf.getHeight()-60, FeldGroﬂeX, 30);
				g.drawImage(image12,0, jf.getHeight()-60, 30, 30, null);
					
			} else if(HotBar == false) {
				
				if(FensterGrosse == 1) {
					g.drawImage(image11,jf.getWidth()-50, jf.getHeight()-80, 50, 50, null);
				} else if(FensterGrosse == 2) {
					g.drawImage(image11,jf.getWidth()-80, jf.getHeight()-110, 80, 80, null);
				} else if(FensterGrosse == 3) {
					g.drawImage(image11,jf.getWidth()-80, jf.getHeight()-110, 80, 80, null);
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			// TODO
			// Fenster einstellung
			// Die Einstellungen f¸r Das Spiel
			
			if(Einstellungen == true) {
				if(Breite == 400 && Hohe == 600) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
				}
				
				if(Breite == 560 && Hohe == 840) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
				}
				
				if(Breite == 640 && Hohe == 1000) {
					g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
				}
				
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, jf.getWidth(), jf.getHeight());
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, jf.getWidth(), 50);
				
				// Grˆﬂe
				g.setColor(Color.BLACK);
				g.fillRect(20, 100, 50, 50);
				g.fillRect(80, 100, (getWidth()-80)-80, 50);
				g.fillRect(jf.getWidth()-80, 100, 50, 50);
				
				g.setColor(Color.WHITE);
				g.fillRect(25, 105, 40, 40);		// Links
				g.fillRect(85, 105, (getWidth()-80)-90, 40);	// Mitte
				g.fillRect(jf.getWidth()-75, 105, 40, 40);	// Rechts
				
				
				// Schnelligkeit
				g.setColor(Color.BLACK);
				g.fillRect(20, 170, 50, 50);
				g.fillRect(80, 170, (getWidth()-80)-80, 50);
				g.fillRect(jf.getWidth()-80, 170, 50, 50);
				
				g.setColor(Color.WHITE);
				g.fillRect(25, 175, 40, 40);		// Links
				g.fillRect(85, 175, (getWidth()-80)-90, 40);	// Mitte
				g.fillRect(jf.getWidth()-75, 175, 40, 40);	// Rechts
				
				if(FensterGrosse == 1) {
					g.setColor(Color.BLACK);
					g.drawString("Settings", 80, 85);
					g.drawString("400/600", 100, 135);
				} else if(FensterGrosse == 2) {
					g.setColor(Color.BLACK);
					g.drawString("Settings", 80, 85);
					g.drawString("560/840", 100, 135);	
				} else if(FensterGrosse == 3) {
					g.setColor(Color.BLACK);
					g.drawString("Settings", 80, 85);
					g.drawString("640/1000", 100, 135);
				}
				
				if(ScrollSchnell == 20) {
					g.drawString("25%", 150, 205);
				} else if(ScrollSchnell == 25) {
					g.drawString("50%", 150, 205);
				} else if(ScrollSchnell == 30) {
					g.drawString("75%", 150, 205);
				} else if(ScrollSchnell == 35) {
					g.drawString("100%", 150, 205);
				}
				
				// abrrechen
				g.setColor(Color.BLACK);
				g.fillRect(jf.getWidth()-70, jf.getHeight()-100, 50, 50);
				g.setColor(Color.RED);
				g.fillRect(jf.getWidth()-65, jf.getHeight()-95, 40, 40);
				
				// best‰tigen
				g.setColor(Color.BLACK);
				g.fillRect(jf.getWidth()-150, jf.getHeight()-100, 50, 50);
				g.setColor(Color.GREEN);
				g.fillRect(jf.getWidth()-145, jf.getHeight()-95, 40, 40);
			}
			
			ShopAuto();
		}
		if(GameStart == false) {
			g.drawImage(image26,0, 0, jf.getWidth(), jf.getHeight(), null);
			g.setFont(new Font("Franklin Gothic Demi Italic", 4, 40));
			g.drawImage(image23,jf.getWidth()-340, jf.getHeight()-350, 280, 160, null);
			g.drawImage(image24,jf.getWidth()-320, jf.getHeight()-250, 100, 40, null);
			g.drawImage(image25,jf.getWidth()-180, jf.getHeight()-250, 100, 40, null);
			g.setColor(Color.BLACK);
			g.drawString("Do you Want a", 70, 305);
			g.drawString("Tutorial?", 70, 335);
		}
		
		// ENDE PAINT
	}
	
	public void newPaint() {
		repaint();
//		System.out.println("New Paint");
	}
	
	public void ShopAuto() {
		
		if(shop[0].getShopUnlock() == true) {
			if(shop[0].getShopTimerLauft() == false && shop[0].getVerk‰uferAn() == true) {
				shop[0].ShopTimer(0);
			}
		}
		
		if(shop[1].getShopUnlock() == true) {
			if(shop[1].getShopTimerLauft() == false && shop[1].getVerk‰uferAn() == true) {
				shop[1].ShopTimer(1);
			}
		}
		
		if(shop[2].getShopUnlock() == true) {
			if(shop[2].getShopTimerLauft() == false && shop[2].getVerk‰uferAn() == true) {
				shop[2].ShopTimer(2);
			}
		}
		
		if(shop[3].getShopUnlock() == true) {
			if(shop[3].getShopTimerLauft() == false && shop[3].getVerk‰uferAn() == true) {
				shop[3].ShopTimer(3);
			}
		}
		if(shop[4].getShopUnlock() == true) {
			if(shop[4].getShopTimerLauft() == false && shop[4].getVerk‰uferAn() == true) {
				shop[4].ShopTimer(4);
			}
		}
		
		if(shop[5].getShopUnlock() == true) {
			if(shop[5].getShopTimerLauft() == false && shop[5].getVerk‰uferAn() == true) {
				shop[5].ShopTimer(5);
			}
		}
		
		if(shop[6].getShopUnlock() == true) {
			if(shop[6].getShopTimerLauft() == false && shop[6].getVerk‰uferAn() == true) {
				shop[6].ShopTimer(6);
			}
		}
		
		if(shop[7].getShopUnlock() == true) {
			if(shop[7].getShopTimerLauft() == false && shop[7].getVerk‰uferAn() == true) {
				shop[7].ShopTimer(7);
			}
		}
		if(shop[8].getShopUnlock() == true) {
			if(shop[8].getShopTimerLauft() == false && shop[8].getVerk‰uferAn() == true) {
				shop[8].ShopTimer(8);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(GameStart== true) {
			int key = e.getKeyCode();
			if(Einstellungen == false) {
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					Toolbox.SectorY(ScrollSchnell,false);
					repaint();
				} else if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					Toolbox.SectorY(ScrollSchnell,true);
					repaint();
				} else if(key == KeyEvent.VK_SPACE && HotBar == false) {
					HotBar = true;
					repaint();
				} else if(key == KeyEvent.VK_SPACE && HotBar == true) {
					HotBar = false;
					repaint();
				} else if(key == KeyEvent.VK_ESCAPE) {
					neuStart();	
				}
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("X = " + x + " | " + "Y = " + y);
		if(GameStart== true) {
			
			boolean MouseOnHotBar = false;
			if(HotBar == true) {
				int zzzt = 0;
				if(FensterGrosse == 1) {
					zzzt = 180;
				} else if(FensterGrosse == 2) {
					zzzt = 230;
				} else if(FensterGrosse == 3) {
					zzzt = 230;
				}
				if(x>= 0 && x <= FeldGroﬂeX && y >= jf.getHeight()-zzzt) {
					MouseOnHotBar = true;
					System.out.println("HotBar Klick");
				} else {
					MouseOnHotBar = false;
				}
			} else {
				MouseOnHotBar = false;
			}
			
			
			if(Einstellungen == false) {
				if(y>=Sector2-(FeldGroﬂeY*3) && y<=((Sector2-(FeldGroﬂeY*3))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
					
					if(shop[0].getShopUnlock() == true) {
						if(shop[0].getShopTimerLauft() == false) {
							shop[0].ShopTimer(0);
						}
		
					} else if(shop[0].getShopUnlock() == false && shop[1].getShopUnlock() == true) {
						shop[0].UnlockShop(shop[0].getUnlockPreis(),0);
						repaint();
					}
					
				} else if(y>=Sector2-(FeldGroﬂeY*2) && y<=((Sector2-(FeldGroﬂeY*2))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[1].getShopUnlock() == true) {
						if(shop[1].getShopTimerLauft() == false) {
							shop[1].ShopTimer(1);
						}
						
					} else if(shop[1].getShopUnlock() == false && shop[2].getShopUnlock() == true) {
						shop[1].UnlockShop(shop[1].getUnlockPreis(),1);
						repaint();
					}
					
				} else if(y>=Sector2-(FeldGroﬂeY*1) && y<=((Sector2-(FeldGroﬂeY*1))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[2].getShopUnlock() == true) {
						if(shop[2].getShopTimerLauft() == false) {
							shop[2].ShopTimer(2);
						}
						
					} else if(shop[2].getShopUnlock() == false && shop[3].getShopUnlock() == true) {
						shop[2].UnlockShop(shop[2].getUnlockPreis(),2);
						repaint();
					}
					
				} else if(y>=Sector2 && y<=(Sector2+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[3].getShopUnlock() == true) {
						if(shop[3].getShopTimerLauft() == false) {
							shop[3].ShopTimer(3);
						}
						
					} else if(shop[3].getShopUnlock() == false && shop[4].getShopUnlock() == true) {
						shop[3].UnlockShop(shop[3].getUnlockPreis(),3);
						repaint();
					}
					
				} else if(y>=Sector2+(FeldGroﬂeY*1) && y<=((Sector2+(FeldGroﬂeY*1))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[4].getShopUnlock() == true) {
						if(shop[4].getShopTimerLauft() == false) {
							shop[4].ShopTimer(4);
						}
						
					} else if(shop[4].getShopUnlock() == false && shop[5].getShopUnlock() == true) {
						shop[4].UnlockShop(shop[4].getUnlockPreis(),4);
						repaint();
					}
					
				} else if(y>=Sector2+(FeldGroﬂeY*2) && y<=((Sector2+(FeldGroﬂeY*2))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[5].getShopUnlock() == true) {
						if(shop[5].getShopTimerLauft() == false) {
							shop[5].ShopTimer(5);
						}
						
					} else if(shop[5].getShopUnlock() == false && shop[6].getShopUnlock() == true) {
						shop[5].UnlockShop(shop[5].getUnlockPreis(),5);
						repaint();
					}
					
				} else if(y>=Sector2+(FeldGroﬂeY*3) && y<=((Sector2+(FeldGroﬂeY*3))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[6].getShopUnlock() == true) {
						if(shop[6].getShopTimerLauft() == false) {
							shop[6].ShopTimer(6);
						}
						
					} else if(shop[6].getShopUnlock() == false && shop[7].getShopUnlock() == true) {
						shop[6].UnlockShop(shop[6].getUnlockPreis(),6);
						repaint();
					}
					
				} else if(y>=Sector2+(FeldGroﬂeY*4) && y<=((Sector2+(FeldGroﬂeY*4))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[7].getShopUnlock() == true) {
						if(shop[7].getShopTimerLauft() == false) {
							shop[7].ShopTimer(7);
						}
						
					} else if(shop[7].getShopUnlock() == false && shop[8].getShopUnlock() == true) {
						shop[7].UnlockShop(shop[7].getUnlockPreis(),7);
						repaint();
					}
					
				} else if(y>=Sector2+(FeldGroﬂeY*5) && y<=((Sector2+(FeldGroﬂeY*5))+FeldGroﬂeY)+20 && MouseOnHotBar == false) {
		
					if(shop[8].getShopUnlock() == true) {														// Ist der Shop schon Freigeschaltet?
						if(shop[8].getShopTimerLauft() == false && shop[8].getVerk‰uferAn() == false) {			// Arbeit der Shop Schon ? Oder ist er Automatisch?
							shop[8].ShopTimer(8);
						}
					} else if(shop[8].getShopUnlock() == false) {												// Ist der Shop noch gesperrt?
						shop[8].UnlockShop(shop[8].getUnlockPreis(),8);											// Kaufe den Shop Frei
						repaint();
					}
				}
			}
			
			
		
			
			
			
			// TODO
			// Hotbar Klicks
			
			if(HotBar == true && MouseOnHotBar == true) {
				
				int YGroﬂe1 = 0;
				int YGroﬂe2 = 0;
				if(FensterGrosse == 1) {
					YGroﬂe1 = 430;
					YGroﬂe2 = 560;
				} else if(FensterGrosse == 2) {
					YGroﬂe1 = 620;
					YGroﬂe2 = 800;
				} else if(FensterGrosse == 3) {
					YGroﬂe1 = 720;
					YGroﬂe2 = 860;
				}
				if(x >= 0 && x <= FeldGroﬂeX && y >= jf.getHeight()-30 && y <= (jf.getHeight())+30) {
					Einstellungen = true;
					HotBar = false;
					repaint();
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*1 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 1 upgrade");
					shop[8].ShopUpdate(shop[8].getShopUbgradePreis(), 8);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*2 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 2 upgrade");
					shop[8].ShopUpdate(shop[7].getShopUbgradePreis(), 7);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*3 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 3 upgrade");
					shop[8].ShopUpdate(shop[6].getShopUbgradePreis(), 6);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*4 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 4 upgrade");
					shop[8].ShopUpdate(shop[5].getShopUbgradePreis(), 5);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*5 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 5 upgrade");
					shop[8].ShopUpdate(shop[4].getShopUbgradePreis(), 4);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*6 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 6 upgrade");
					shop[8].ShopUpdate(shop[3].getShopUbgradePreis(), 3);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*7 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 7 upgrade");
					shop[8].ShopUpdate(shop[2].getShopUbgradePreis(), 2);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*8 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop 8 upgrade");
					shop[8].ShopUpdate(shop[1].getShopUbgradePreis(), 1);
				} else if(x >= 0 && x <= (FeldGroﬂeX/9)*9 && y >= YGroﬂe1 && y <= YGroﬂe2) {
					System.out.println("Shop9 upgrade");
					shop[8].ShopUpdate(shop[0].getShopUbgradePreis(), 0);
				}
				
			} else if(Einstellungen == true && MouseOnHotBar == false) {
				
				
				
				if(EinstellungenSicherung == true ) {
					FensterSpeicher = FensterGrosse;
					ScrollSpeicher = ScrollSchnell;
					EinstellungenSicherung = false;
					HotBar = false;
				}
				// Speichern
				if(x>= jf.getWidth()-150 && x <= (jf.getWidth()-150) + 100 && y >= jf.getHeight()-100 && y <= (jf.getHeight()-100) + 100) {
					System.out.println("Best‰tigten");
					newWindowSize();
					EinstellungenSicherung = true;
					Einstellungen = false;
					repaint();
				} // Abbrechen
				else if(x>= jf.getWidth()-70 && x <= (jf.getWidth()-70) + 100 && y >= jf.getHeight()-100 && y <= (jf.getHeight()-100) + 100) {
					System.out.println("Abbrechen");
					FensterGrosse = FensterSpeicher;
					ScrollSchnell = ScrollSpeicher;
					EinstellungenSicherung = true;
					Einstellungen = false;
					repaint();
				} // Links Fenster
				if(x>= 25 && x <= 25+80 && y >= 105 && y <= 105+80) {
					Toolbox.FensterEinstellungenLinks();
					System.out.println("Links");
					System.out.println(": " + FensterGrosse);
					repaint();
				} // Rechts Fenster
				else if(x>= jf.getWidth()-75 && x <= (jf.getWidth()-75)+80 && y >= 105 && y <= 105+80) {
					Toolbox.FensterEinstellungenRechts();
					System.out.println("Rechts");
					System.out.println(": " + FensterGrosse);
					repaint();
				}
				
				if(x>= 25 && x <= 25+80 && y >= 200 && y <= 200+80) {
					Toolbox.ScrollEinstellungenLinks();
					System.out.println("Links Scroll");
					System.out.println(": " + ScrollSchnell);
					repaint();
				} // Rechts Fenster
				else if(x>= jf.getWidth()-75 && x <= (jf.getWidth()-75)+80 && y >= 200 && y <= 200+80) {
					Toolbox.ScrollEinstellungenRechts();
					System.out.println("Rechts Scroll");
					System.out.println(": " + ScrollSchnell);
					repaint();
				}
				
				
	//			ScrollEinstellungenRechts
			}
		} else if(GameStart== false) {
			
			if (y>=375 && y<= 415 && x >= 80 && x <= 180) {
				System.out.println("Ja");
				GameStart = true;
				Tutorial = true;
				Tutorial();
				repaint();
			}
			if (y>=375 && y<= 415 && x >= 220 && x <= 320) {
				System.out.println("Nein");
				GameStart = true;
				Tutorial = false;
				Level1();
				repaint();
			}
		}

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
