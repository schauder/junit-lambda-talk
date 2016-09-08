package de.onsite.ood.datapump2;

import java.io.File;

public class ExampleUseCase {
    public static void main(String[] args) {
        new PredictionService(
                new TextStrategy(
                        new TextStore(
                                new File("somefile")
                        )
                )
        );
    }
}
