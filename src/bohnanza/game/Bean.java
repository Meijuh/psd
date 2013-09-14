package bohnanza.game;

public abstract class Bean extends Card {

    private final Beanometer beanometer;

    protected Bean(String type, Beanometer beanometer) {
        super(type);
        this.beanometer = beanometer;
    }

    public Beanometer getBeanometer() {
        return beanometer;
    }

}
