package de.onsite.ood.datapump2;

public class DatabaseStrategyFactory implements StrategyFactory {
    @Override
    public DatabaseStrategy create() {
        return new DatabaseStrategy(
                new DatabaseStore(
                        "user",
                        "password",
                        "jdbc://url"
                )
        );
    }
}
