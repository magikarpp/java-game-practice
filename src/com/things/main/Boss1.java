package com.things.main;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Boss1 extends GameObject {
  Handler handler;
  Random r = new Random();

  private int timer = 75;
  private int timer2 = 50;

  public Boss1(float x, float y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    velX = 0;
    velY = 2;
  }

  public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 96, 96);
  }

  @Override
  public void tick(){
    x += velX;
    y += velY;

    if(timer <= 0){
      velY = 0;
    } else if(!(timer2 < 0)){
      timer--;
    } else{

    }
    if(timer <= 0 && timer2 >= -10){
      timer2--;
    }
    if(timer2 <=0){
      if(velX == 0) velX = 3;
      int spawn = r.nextInt(10);
      if(spawn == 0) handler.addObject(new BossBullet((int)x, (int)y, ID.BasicEnemy, handler));
    }

    if(x <= 0 || x >= Game.width - 96){
      velX *= -1;
    }
  }

  @Override
  public void render(Graphics g){
    g.setColor(Color.red);
    g.fillRect((int)x, (int)y, 96, 96);
  }

}