package com.rick.racing.core;

import com.rick.racing.model.CarRecordHistory;
import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;
import com.rick.racing.ui.InputView;
import com.rick.racing.ui.ResultView;
import java.util.Random;
import java.util.function.Supplier;

public class CarRacingCore {

    public static final int RANDOM_BOUND = 10;
    public static final int GO_THRESHOLD = 4;
    private final InputView inputView;
    private final Random random;

    public CarRacingCore() {
        inputView = new InputView();
        random = new Random();
    }

    public void start() {
        RacingPlayData racingPlayData = inputView.getGameDataFromUser();
        RacingResult racingResult = doGame(racingPlayData, this::isGo);
        new ResultView(racingPlayData, racingResult).showResult();
    }

    public RacingResult doGame(RacingPlayData racingPlayData, Supplier<Boolean> goOrStopSupplier) {
        RacingResult racingResult = new RacingResult();

        for (int carIndex = 0; carIndex < racingPlayData.carCount(); carIndex++) {
            CarRecordHistory carRecordHistory = playRacing(racingPlayData, goOrStopSupplier);
            racingResult.addRecord(carRecordHistory);
        }

        return racingResult;
    }

    private CarRecordHistory playRacing(RacingPlayData racingPlayData, Supplier<Boolean> goOrStopSupplier) {
        CarRecordHistory carRecordHistory = new CarRecordHistory();

        for (int tryIndex = 0; tryIndex < racingPlayData.tryCount(); tryIndex++) {
            move(carRecordHistory, goOrStopSupplier);
        }

        return carRecordHistory;
    }

    private void move(CarRecordHistory carRecordHistory, Supplier<Boolean> goOrStopSupplier) {
        if(goOrStopSupplier.get()) {
            carRecordHistory.go();
            return;
        }

        carRecordHistory.stop();
    }

    private boolean isGo() {
        return random.nextInt(RANDOM_BOUND) >= GO_THRESHOLD;
    }
}
