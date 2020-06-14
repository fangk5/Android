package edu.fjnu.blogdemo;

public class MoveThread extends Thread {
    private Thread t;
    private CustomDrawableView view;
    MoveThread(CustomDrawableView c){
        view = c;
    }
    public void run() {
        while(true){
            if(Math.sqrt(view.speed_x*view.speed_x+view.speed_y*view.speed_y)>10){
                try{
                    Thread.sleep(10);
                }catch (Exception e){

                }

                view.moveView((int)view.speed_x/10,(int)view.speed_y/10);
            }else {
                try{
                    Thread.sleep(100);
                }catch (Exception e){

                }

                view.moveView((int)view.speed_x,(int)view.speed_y);
            }

        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
