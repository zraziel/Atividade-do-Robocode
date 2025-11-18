package meusrobos;
import robocode.*;
import robocode.util.Utils;
import java.awt.*;

public class MacacosSapientes extends AdvancedRobot {

    public void run() {
        setBodyColor(Color.BLACK);
        setGunColor(Color.RED);
        setRadarColor(Color.WHITE);

        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        while (true) {
            turnRadarRight(360);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        double distancia = e.getDistance();
        double anguloDoInimigo = getHeading() + e.getBearing();

        setTurnRight(e.getBearing() + 90);
        setAhead(150);

        if (getX() < 100 || getX() > getBattleFieldWidth() - 100 ||
            getY() < 100 || getY() > getBattleFieldHeight() - 100) {
            setTurnRight(180);
            setAhead(200);
        }

        double anguloDoCanhao = Utils.normalRelativeAngleDegrees(
            anguloDoInimigo - getGunHeading()
        );
        setTurnGunRight(anguloDoCanhao);

        double power;
        if (distancia < 200) power = 3;
        else if (distancia < 400) power = 2;
        else power = 1;

        if (Math.abs(anguloDoCanhao) < 10) {
            fire(power);
        }

        double anguloRadar = Utils.normalRelativeAngleDegrees(
            anguloDoInimigo - getRadarHeading()
        );
        setTurnRadarRight(anguloRadar * 2);
    }
}
