package meusrobos;

import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

public class Aizen extends AdvancedRobot {

    private double ultimoHeadingInimigo = 0;

    public void run() {

        // ======== CORES ROXO + PRETO ========
        setBodyColor(new Color(40, 0, 60));        // Preto arroxeado (corpo)
        setGunColor(new Color(90, 0, 130));        // Roxo mais forte
        setRadarColor(new Color(20, 0, 30));       // Quase preto
        setBulletColor(new Color(180, 0, 255));    // Bala roxo neon
        setScanColor(new Color(255, 120, 255));    // Scanner em lilás vibrante
        // =====================================

        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        turnRadarRight(Double.POSITIVE_INFINITY);

        while (true) {
            execute();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {

        double distancia = e.getDistance();
        double anguloAbsoluto = getHeading() + e.getBearing();

        double ajusteRadar =
            Utils.normalRelativeAngleDegrees(anguloAbsoluto - getRadarHeading());
        setTurnRadarRight(ajusteRadar * 2);

        double direcao = ((getTime() % 40) < 20) ? 1 : -1;

        setTurnRight(e.getBearing() + 90 * direcao);

        if (distancia < 250) {
            setBack(120);
        } else if (distancia > 450) {
            setAhead(120);
        } else {
            setAhead(80 * direcao);
        }

        double variacaoHeading = e.getHeading() - ultimoHeadingInimigo;
        ultimoHeadingInimigo = e.getHeading();

        double anguloPrevisto = anguloAbsoluto + variacaoHeading * (distancia / 150);

        double ajusteGun =
            Utils.normalRelativeAngleDegrees(anguloPrevisto - getGunHeading());
        setTurnGunRight(ajusteGun);

        double power;
        if (distancia < 200) power = 3;
        else if (distancia < 400) power = 2.2;
        else power = 1.4;

        if (Math.abs(ajusteGun) < 8) {
            fire(power);
        }
    }

    @Override
    public void onHitWall(HitWallEvent e) {
        setBack(150);
        setTurnRight(60);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        setTurnRight(30);
        setAhead(150);
    }
}
