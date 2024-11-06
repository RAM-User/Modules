package com.chapter7;
 class SpaceShipController {
    void up(int velocity) {}
    void down(int velocity) {}
    void left(int velocity) {}
    void right(int velocity) {}
    void forward(int velocity) {}
    void back(int velocity) {}
    void turboBoost(int velocity) {}
}

public class SpaceShipDelegation {
   private String name;
   // 代理
   private SpaceShipController spaceShipController = new SpaceShipController();
   public SpaceShipDelegation(String name) {
      this.name = name;
   }
   public void back(int velocity) {
      spaceShipController.back(velocity);
   }
   public void forward(int velocity) {
      spaceShipController.forward(velocity);
   }
   public void turboBoost(int velocity) {
      spaceShipController.turboBoost(velocity);
   }
   public void right(int velocity) {
      spaceShipController.right(velocity);
   }
   public void left(int velocity) {
      spaceShipController.left(velocity);
   }
   public void down(int velocity) {
      spaceShipController.down(velocity);
   }
   public void up(int velocity) {
      spaceShipController.up(velocity);
   }

   public static void main(String[] args) {
      SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
      protector.forward(100);
   }
}
