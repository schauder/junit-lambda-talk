package de.onsite.ood.datapump2;

import java.io.File;

public class TextStrategyFactory implements StrategyFactory {
    @Override
    public TextStrategy create(){
        return new TextStrategy(
                new TextStore(
                        new File("some-file-name")
                )
        );
    }
}
