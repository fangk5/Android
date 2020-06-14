package edu.fjnu.blogdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class CustomDrawableView extends View {
    Ball ball;
    double speed_x;
    double speed_y;
    int window_width;
    int window_height;
    public CustomDrawableView(Context context , int width,int height) {
        super(context);
        window_width = width-50;
        window_height = height-150;

        ball = new Ball();
        // If the color isn't set, the shape uses black as the default.
        //ball.getPaint().setColor(0xff74AC23);
        // If the bounds aren't set, the shape can't be drawn.
        ball.setBounds(10, 10, 50, 50);
    }
    public void moveView(int x,int y){
        if(this.getTranslationX()+x<0){
            this.setTranslationX(0);
            if(this.speed_x<0){
                this.speed_x=0;
            }
        }else if(this.getTranslationX()+x>window_width){
            this.setTranslationX(window_width);
            if(this.speed_x>0){
                this.speed_x=0;
            }
        }else{
            this.setTranslationX(this.getTranslationX()+x);
        }
        if(this.getTranslationY()+y<0){
            this.setTranslationY(0);
            if(this.speed_y<0){
                this.speed_y=0;
            }
        }else if(this.getTranslationY()+y>window_height){
            this.setTranslationY(window_height);
            if(this.speed_y>0){
                this.speed_y=0;
            }
        }else{
            this.setTranslationY(this.getTranslationY()+y);
        }
    }
    protected void onDraw(Canvas canvas) {
        ball.draw(canvas);
    }
}