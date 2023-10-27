package com.virtech.spacez.logic.satellite;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Satellite {
    public final int id;
    public PseudoEulerAngles currentPositionAngle;
    public PseudoEulerAngles startPositionAngle;

    // In angles per minute
    public double currentAngularSpeed;
    public double fovAngle;
    public Orbit orbit;

    public Satellite(PseudoEulerAngles startPositionAngle, double currentAngularSpeed, double fovAngle, int id){
        this.startPositionAngle = startPositionAngle;
        this.currentAngularSpeed = currentAngularSpeed;
        this.fovAngle = fovAngle;
        this.id = id;
    }

    public void updateRotation(double dTime){
        PseudoEulerAngles dAngle = new PseudoEulerAngles(this.currentAngularSpeed * dTime, 0);
//        this.currentPositionAngle.rotateAlongAxis(dAngle, new Vector3());

        this.currentPositionAngle.yRotation += dAngle.yRotation;
    }
    public void canSeeArea(Vector3 point, double radius) throws Exception {
        Vector3 distance = this.currentPositionAngle.toVector3(1, 1, 1).subtract(point);
        System.out.println(distance);

    }
}
