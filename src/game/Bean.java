package game;

public abstract class Bean extends Card {

    private final Beanometer beanometer;

    protected Bean(int amount) {
        super(amount);
        beanometer = new Beanometer();
        initializeBeanometer();
    }

    protected abstract void initializeBeanometer();

    /**
     * @return the beanometer
     */
    protected Beanometer getBeanometer() {
        return beanometer;
    }

}
