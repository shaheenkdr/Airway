package com.devpost.airway.flappybirdgame;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.devpost.airway.framework.Game;
import com.devpost.airway.framework.Graphics;
import com.devpost.airway.framework.Image;
import com.devpost.airway.framework.Screen;
import com.devpost.airway.framework.Input.TouchEvent;


public class ScoreScreen extends Screen {
	// Vi�fangsbreytur
	Paint paint; // �etta er leturger�in � notkun
	
    public ScoreScreen(Game game) {
        super(game);
        
        // Stillum allt sem vi� viljum fyrir font � scores
        paint = new Paint();
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // �egar �tt er einhverssta�ar � skj�inn ver�ur len > 0 og �v� keyrist forlykkjan
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) { 
            	
            	///////////////
              	// BACK takki
              	///////////////
                if (inBounds(event, gameWidth/1.8, gameHeight/1.33, res*230, res*77)) {
                    // Aftur til MainMenuScreen
                    game.setScreen(new MainMenuScreen(game));              
                }
            }
        }
    }


    private boolean inBounds(TouchEvent event, double x, double y, double width, double height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void paint(float deltaTime) {
    	Graphics g = game.getGraphics();
    	
    	////////////////////////////////////////////////////////////////
    	// H�rna h�fum vi� �ll ScoreScreen elementin okkar, takka o.s.frv.
    	////////////////////////////////////////////////////////////////
    	
    	// Skalinn byrjar efst til vinstri � glugganum
        // �.e.a.s. hnitakerfi�. Skalinn er 800 x 1280 � S2
    	
    	g.drawImage(Assets.background, matrix, 0, 0, 0, res*1.04, false);
    	g.drawImage(Assets.backgroundBase, matrix, 0, gameHeight/1.1445, 0, res*1.04*0.9615, false);
    	//g.drawImage(Assets.scoreSmall, matrix, gameWidth/4, gameHeight/1.3, 0, res, false);
        g.drawImage(Assets.flappyBirdLogo, matrix, gameWidth/13.71, gameHeight/16, 0, res, false);
        g.drawImage(Assets.bird2, matrix, gameWidth/1.16, gameHeight/10, 0, res, true);
        //g.drawImage(Assets.back, matrix, gameWidth/1.8, gameHeight/1.33, 0, res, false);
        
        // h�rna setjum vi� inn forlykkju sem setur inn �ll stigin
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {
        //Display "Exit Game?" Box


    }
}
