package de.onsite.ood.datapump2;

public class LoggingPredictionListener implements PredictionServiceListener {
    @Override
    public void predictionHandled(LotteryPrediction prediction) {
        System.out.println(prediction);
    }
}
