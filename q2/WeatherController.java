package q2.weather;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class WeatherController extends Temps{
    static int year = 2017; // starting year
    static final int YEARS = 6; // the number of years
    static final int MONTHS = 12; // the number of months per year
/*getting data*/
    Temps t = new Temps(YEARS, MONTHS);
    int [][]temps = t.fillTemps();
    @FXML
    private Canvas canvas;

    @FXML
    private Button next;

    public WeatherController(int years, int months) {
        super(years, months);
    }

    @FXML
    void isPressed(ActionEvent event) {
        /*creating a Cartesian coordinate system, x represents months, y represents temperatures*/
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.strokeLine(20, 0, 20, canvas.getHeight());
        gc.strokeLine(0, canvas.getHeight() - 20, canvas.getWidth(), canvas.getHeight() - 20);
        gc.strokeText(String.valueOf(year), 550, 20);
        int interval = 5;
        for (double i = canvas.getHeight() - 50; i > 0; i -= 40) {
            gc.strokeText(String.valueOf(interval), 5, i);
            interval += 5;
        }

        /*filling Graph according to data*/
        for (int i = 1; i <= 12; i++) {
            gc.strokeText(String.valueOf(i), (i * (canvas.getWidth() / MONTHS) - 25), canvas.getHeight() - 10);
            int max = t.findMin(temps[year-2017]);
            int min = t.findMax(temps[year-2017]);
            if(temps[year-2017][i-1] == min)
                gc.setFill(Color.LIGHTBLUE);
            else if (temps[year-2017][i-1] == max)
                gc.setFill(Color.LIGHTCORAL);
            else
                gc.setFill(Color.GRAY);
            gc.fillRect((i * (canvas.getWidth() / MONTHS) - 25), temps[year-2017][i-1], MONTHS, canvas.getHeight()-temps[year-2017][i-1] - 20);
        }
        /*getting relevant next year to present*/
        if(year < 2022)
            year++;
        else
            year = 2017;
    }
}
